package kr.or.ddit.basic.e_cash;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kr.or.ddit.ibatis.vo.hilightVO.PayVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;
import javafx.scene.control.ComboBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class HighlighterCardpay_Controller implements Initializable{
	@FXML TextField txt_pay;				//결제 금액
	@FXML ComboBox<String> cmb_card_list;	//카드 종류
	@FXML ComboBox<String> cmb_year;		//유효기간 년
	@FXML ComboBox<String> cmb_mon;			//유효기간 월
	@FXML ComboBox<String> cmb_mon_day;		//할부 개월
	@FXML Button btn_pay;					//결제하기
	@FXML Button btn_can;					//취소하기

	
	List<MemberVO> list = new ArrayList<>();
	Pen_managementVO manage = new Pen_managementVO();
	
	//카드 결제
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PayVO vo = new PayVO();
		txt_pay.setText((Integer.parseInt(ShinYS.pay_vo.getPay_cnt()) * 110)+ "");
		
		cmb_card_list.getItems().addAll("삼성", "엘지", "국민", "신한", "우리");
		cmb_card_list.setValue("엘지");
		cmb_year.getItems().addAll("2014","2015","2016","2017","2018","2019","2020","2021","2022");
		cmb_year.setValue("2019");
		cmb_mon.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
		cmb_mon.setValue("1");
		cmb_mon_day.getItems().addAll("1개월","2개월","3개월","4개월","5개월","6개월","7개월",
										"8개월","9개월","10개월","11개월","12개월");
		cmb_mon_day.setValue("3개월");
		btn_pay.setOnAction(e -> {
			try {
				list = Global.memberService.selectOne(ShinYS.query_id);
			
				String member = list.get(0).getMem_id();
			
				vo.setMem_id(member);
				vo.setPay_cnt((Integer.parseInt(txt_pay.getText()) / 110) + "");
				vo.setPay_type_no("1");
				vo.setPen_code("1");
				
				Global.payService.insert_PayInfo(vo);
				
				List<PayVO> myinfo = Global.payService.select_myPayInfo(member);
				int indx = myinfo.size() - 1;
				String pay_no = myinfo.get(indx).getPay_no();
				myinfo = Global.payService.select_PayDetailInfo(pay_no);
				String pen_type = myinfo.get(0).getPen_code();
				String pen_cnt  = myinfo.get(0).getPay_cnt();
				String use_date = myinfo.get(0).getPay_date();
				
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
		btn_can.setOnAction(e-> {
			txt_pay.setText("");
			Parent transfer;
			try {
				transfer = FXMLLoader.load(getClass().getResource("highlighter_paytype.fxml"));
				
				Scene sc = new Scene(transfer);
				Stage primaryStage = (Stage) btn_can.getScene().getWindow();
				primaryStage.setScene(sc);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
	}

}
