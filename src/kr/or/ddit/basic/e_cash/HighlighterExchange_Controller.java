package kr.or.ddit.basic.e_cash;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import kr.or.ddit.ibatis.vo.hilightVO.ExchangeVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;

public class HighlighterExchange_Controller implements Initializable {

	@FXML
	JFXTextField txt_ex_pen_cnt; // 환전할 개수
	@FXML
	JFXTextField txt_total_pen_cnt; // 현재 가지고있는 총개수
	@FXML
	JFXTextField txt_after_total; // 환전후 보유하고있는 총개수
	@FXML
	JFXTextField txt_ex_money; // 환전된 개수에 맞는 금액
	@FXML
	JFXTextField txt_acnt_owner; // 예금주
	@FXML
	JFXTextField txt_bank; // 은행
	@FXML
	JFXTextField txt_account; // 계좌번호
	@FXML
	JFXButton btn_exchange; // 환전하기 버튼
	@FXML
	JFXButton qty_check; // 확인하기

	List<ExchangeVO> ex_list;
	List<MemberVO> pen_list;
	boolean flag = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ShinYS.visBack(true).setOnMouseClicked(e->{
			ShinYS.visBack(false);
			ShinYS.gotoHightlight();
		});
		
		
		ExchangeVO vo = new ExchangeVO();
		try {
			pen_list = Global.memberService.selectOne(ShinYS.query_id);
			String pen_qty = pen_list.get(0).getPen_quantity();
			String mem_name = pen_list.get(0).getMem_name();
			String bank = pen_list.get(0).getBank();
			String acc = pen_list.get(0).getAccount();
			txt_total_pen_cnt.setText(pen_qty);
			txt_acnt_owner.setText(mem_name);
			txt_bank.setText(bank);
			txt_account.setText(acc);
			txt_ex_pen_cnt.setText("");
		} catch (Exception e) {
			e.printStackTrace();
		} {
		
		
		//확인 하기
		qty_check.setOnMouseClicked(e-> {
			
			txt_after_total.setText(Integer.parseInt(txt_total_pen_cnt.getText()) - Integer.parseInt(txt_ex_pen_cnt.getText())+"");
			txt_ex_money.setText((Integer.parseInt(txt_ex_pen_cnt.getText()) * 90) + "");
			
			try {
				Global.exchangeService.select_ExchangeInfo(ShinYS.query_id);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			flag = true;
		});
		
		
		//환전버튼
		btn_exchange.setOnMouseClicked(e->{
			if(!flag) {
				ShinYS.errMsg("에러", "환전할 수량을 적어주세요");
			}else {
			vo.setMem_id(ShinYS.query_id);
			vo.setExchange_cnt(txt_ex_pen_cnt.getText());
			vo.setPen_code("1");

			try {
				
				Global.exchangeService.insert_ExchangeInfo(vo);
				
				String get_mem_id = pen_list.get(0).getMem_id();
				
				ex_list = Global.exchangeService.select_ExchangeInfo(ShinYS.query_id);

				int index = ex_list.size() - 1;
				String ex_no = ex_list.get(index).getExchange_no();

				ex_list = Global.exchangeService.select_ExchangeDetailInfo(ex_no);

				String pen_type = ex_list.get(0).getPen_code();
				String pen_cnt = ex_list.get(0).getExchange_cnt();
				String mem_id = ex_list.get(0).getMem_id();
				String date = ex_list.get(0).getExchange_date();

				Pen_managementVO manageVO = new Pen_managementVO();

				manageVO.setMem_id(mem_id);
				manageVO.setPen_cnt(pen_cnt);
				manageVO.setPen_type(pen_type);
				manageVO.setUse_date(date);

				Global.pen_managementService.insert_UsetypeExchange(manageVO);

				Global.exchangeService.subtration_myPen_Quantity3(txt_ex_pen_cnt.getText(), ShinYS.query_id);
				ShinYS.infoMsg("성공", "정상적으로 처리 되었습니다.");
				ShinYS.gotoHightlight();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
	

		}
	}
}
