package kr.or.ddit.basic.d_member.login;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import library.Global;
import library.ShinYS;

public class Find_id_Controller implements Initializable{

	@FXML JFXTextField txt_name;
	@FXML JFXTextField txt_mail;
	@FXML Button btn_find;
	@FXML Button btn_cancle;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btn_find.setOnAction(e ->{
			List<String> id = null;
			
			
			try {
				 id = Global.memberService.select_findId(txt_name.getText(), 
						txt_mail.getText());
				
				System.out.println(id);
			 } catch (RemoteException e1) {
				e1.printStackTrace();
			}
			 
				if(id.size() == 0) {
					ShinYS.infoMsg("아이디 찾기", "이름과 이메일을 다시 확인하세요");
					
				}else if (id.size() != 0) {
					ShinYS.infoMsg("아이디 찾기 :", id + "입니다");
				}
			
			
			
		});
		
		
		btn_cancle.setOnAction(e->{
			
			//ShinYS.ChangeView(getClass(),"../login/login.fxml",true);
			ShinYS.ChangeView(getClass(), "../login/login.fxml");
		});
		
		
		
		
		
	}

}
