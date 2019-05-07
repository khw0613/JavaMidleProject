package kr.or.ddit.basic.e_cash;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kr.or.ddit.ibatis.vo.hilightVO.PayVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;

public class BankPayment_Controller implements Initializable {
	@FXML
	JFXTextField txt_pay; // 입금금액
	@FXML
	JFXTextField txt_id; // 입금자명
	@FXML
	JFXTextField txt_tel; // 전화번호
	@FXML
	JFXButton btn_payment; // 신청하기
	@FXML
	JFXButton btn_cancel; // 취소하기

	List<MemberVO> list = new ArrayList<>();
	Pen_managementVO manage = new Pen_managementVO();
	
	// 무통장 입금
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PayVO vo = new PayVO();
		try {
			list = Global.memberService.selectOne(ShinYS.query_id);
			String mem_id = list.get(0).getMem_name();
			String tel = list.get(0).getTelno();
			txt_id.setText(mem_id);
			txt_tel.setText(tel);
			txt_pay.setText((Integer.parseInt(ShinYS.pay_vo.getPay_cnt()) * 110) + "");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//신청하기
		btn_payment.setOnAction(e -> {
			String member = list.get(0).getMem_id();
			try {
				
				vo.setMem_id(member);
				vo.setPay_cnt((Integer.parseInt(txt_pay.getText()) / 110) + "");
				vo.setPay_type_no("3");
				vo.setPen_code("1");
				
				Global.payService.insert_PayInfo(vo);
				
				
				List<PayVO> my_list = Global.payService.select_myPayInfo(member);
				int idx = my_list.size() - 1;
				String pay_no = my_list.get(idx).getPay_no();
				
				List<PayVO> get_payInfo = Global.payService.select_PayDetailInfo(pay_no);
				
				String pen_type = get_payInfo.get(0).getPen_code();
				String pen_cnt  = get_payInfo.get(0).getPay_cnt();
				String use_date = get_payInfo.get(0).getPay_date();
				
				
				manage.setMem_id(member);
				manage.setPen_type(pen_type);
				manage.setPen_cnt(pen_cnt);
				manage.setUse_date(use_date);
				
				
				Global.payService.addition_myPen_Quantity(member, pen_cnt);
				Global.pen_managementService.insert_UsetypePay(manage);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ShinYS.infoMsg("성공", "정상적으로 처리 되었습니다.");
			//화면닫기
			HighlightBuy_Controller.buy_pen.close();
			
			//화면이동
			ShinYS.gotoHightlight();
		});
		
		//취소하기
		btn_cancel.setOnAction(e-> {
			Parent transfer;
			try {
				transfer = FXMLLoader.load(getClass().getResource("highlighter_paytype.fxml"));
				
				Scene sc = new Scene(transfer);
				Stage primaryStage = (Stage) btn_cancel.getScene().getWindow();
				primaryStage.setScene(sc);
				txt_pay.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}// 초기화 종료

}
