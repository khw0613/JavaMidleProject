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
import javafx.scene.control.ToggleGroup;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.ibatis.vo.hilightVO.PayVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;
import javafx.scene.control.PasswordField;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;

public class HighlighterMobilepay_Controller implements Initializable {
	
	@FXML Button btn_can;			//취소
	@FXML Button btn_accept;		//결제하기
	@FXML Button btn_req;			//승인번호 요청
	@FXML JFXRadioButton radio_lg;	//lg
	@FXML JFXRadioButton radio_kt;	//kt
	@FXML JFXRadioButton radio_skt;	//skt
	@FXML TextField txt_tel;		//휴대폰 번호
	@FXML TextField txt_name;		//이름
	@FXML TextField txt_pay;		//결제금액
	@FXML TextField txt_pen;		//형광펜 갯수
	@FXML TextField txt_email;		//이메일
	
	
	
	List<MemberVO> list = new ArrayList<>();
	Pen_managementVO manage = new Pen_managementVO();
	ToggleGroup toggle = new ToggleGroup();
	//모바일 결제
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PayVO vo = new PayVO();
		radio_lg.setToggleGroup(toggle);
		radio_kt.setToggleGroup(toggle);
		radio_skt.setToggleGroup(toggle);
		
		try {
			list = Global.memberService.selectOne(ShinYS.query_id);
			String mem_name = list.get(0).getMem_name();
			String mem_tel = list.get(0).getTelno();
			String mem_email = list.get(0).getEmail();
			
			txt_pay.setText((Integer.parseInt(ShinYS.pay_vo.getPay_cnt())*110) + "");
			txt_name.setText(mem_name);
			txt_tel.setText(mem_tel);
			txt_pen.setText(ShinYS.pay_vo.getPay_cnt());
			txt_email.setText(mem_email);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//결제하기 버튼
		btn_accept.setOnAction(e->{
			try {
				list = Global.memberService.selectOne(ShinYS.query_id);
			
				String member = list.get(0).getMem_id();
			
				vo.setMem_id(member);
				vo.setPay_cnt((Integer.parseInt(txt_pay.getText()) / 110) + "");
				vo.setPay_type_no("4");
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
		
		
		//취소하기 버튼
		btn_can.setOnAction( e-> {
			Parent transfer;
			try {
				transfer = FXMLLoader.load(getClass().getResource("highlighter_paytype.fxml"));
				
				Scene sc = new Scene(transfer);
				Stage primaryStage = (Stage) btn_can.getScene().getWindow();
				primaryStage.setScene(sc);
				txt_pay.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		//승인번호 요청
		btn_req.setOnAction( e-> {
			ShinYS.infoMsg("성공", "승인이 완료 되었습니다.");
		});
	}

}
