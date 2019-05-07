package kr.or.ddit.basic.g_messenger;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.mail.imap.MessageCache;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kr.or.ddit.basic.a_layout.layout_Controller;
import kr.or.ddit.basic.a_layout.layout_admin_Controller;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Detail_Controller implements Initializable{

	public static String resend_id;
	
	@FXML TextArea detail_contents;		// 내용
	@FXML Button detail_back;			// 뒤로가기
	@FXML Button detail_close;			// 닫기
	@FXML Button detail_delete;			// 삭제
	@FXML Button detail_send;			// 답장보내기
	@FXML Label detail_date;			// 날짜
	@FXML Label detail_id;				// 아이디

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		System.out.println("Load Data In List");
		detail_id.setText(Message_Controller.detail_id);
		detail_contents.setText(Message_Controller.detail_contents);
		detail_date.setText(Message_Controller.detail_date);
		
		
		// 뒤로가기
		detail_back.setOnAction(e->{
			try {
				Parent mReceive = FXMLLoader.load(getClass().getResource("locker_message.fxml"));
				Scene sc = new Scene(mReceive);
				Stage primaryStage = (Stage) detail_back.getScene().getWindow();
				primaryStage.setScene(sc);
			
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("Err!! Fail to changed Scene");
			}
			
		});
		
		detail_send.setOnAction(e->{
			try {
				Parent mReceive = FXMLLoader.load(getClass().getResource("send_message.fxml"));
				
				Scene sc = new Scene(mReceive);
				Stage primaryStage = (Stage) detail_back.getScene().getWindow();
				primaryStage.setScene(sc);
			
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("Err!! Fail to changed Scene");
			}
		});
		
		
		detail_delete.setOnAction(e->{
			try {
				int cnt = Global.messageBoxService.delete_MessageInfo(Message_Controller.detail_no);
			
				if(cnt > 0 ) {
					ShinYS.infoMsg("Delete Message", "선택한 메세지가 삭제 되었습니다.");
					
					Parent mReceive = FXMLLoader.load(getClass().getResource("locker_message.fxml"));
					Scene sc = new Scene(mReceive);
					Stage primaryStage = (Stage) detail_delete.getScene().getWindow();
					primaryStage.setScene(sc);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		
		detail_close.setOnAction(e-> {
			List<MemberVO> right;
			try {
				right = Global.memberService.selectOne(ShinYS.query_id);
				if(right.get(0).getRight_code().equals("1")) {
					layout_admin_Controller.message.close();
				}else {
					layout_Controller.message.close();
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
	}

}
