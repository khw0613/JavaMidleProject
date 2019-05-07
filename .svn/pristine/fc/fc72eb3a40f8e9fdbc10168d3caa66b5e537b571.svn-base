package kr.or.ddit.basic.d_member.mypage;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.jfoenix.controls.JFXPasswordField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import kr.or.ddit.basic.Main;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;

public class change_pwd_Controller implements Initializable{
	
	//비밀번호 변경fxml id 값
		@FXML JFXPasswordField txt_currentpwd;
		@FXML JFXPasswordField txt_changepwd;
		@FXML JFXPasswordField txt_checkchangepwd;
		@FXML Button btn_changepwd;
		
	
		MemberVO vo = new MemberVO();
		List<MemberVO> list = null;
		
		String encText = null;
	 	String decText = null;
	 	
	 	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ShinYS.visBack(true).setOnMouseClicked(e->{
			ShinYS.visBack(false);
			ShinYS.<AnchorPane>ChangePage(getClass(), "showMyinfo.fxml", "#contents");
		});;
		
		
		// 변경하기 버튼누르면 비밀번호가 저장된다.
		
		// 비밀번호 변경을 못하겠어욘!@@@@@@
		
		// 60. 비밀번호 변경
				/*
				MemberVO vo = new MemberVO();
				vo.setMem_id("goo8455");		// 키 값
				vo.setMem_pwd("123123");		// 변경할 비밀번호
				Global.memberService.updateMemberInfoPwd(vo);
				*/
				
		try {
			list = Global.memberService.selectOne(ShinYS.query_id);
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		
		
		//암호화, 복호화 API사용
	 	
		try {
			//encText = ShinYS.aes256.aesEncode(txt_pwd.getText());	//암호화
			decText = ShinYS.aes256.aesDecode(list.get(0).getMem_pwd());	//복호화
		        
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
				| NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//======================
		
		
		
		btn_changepwd.setOnAction(e->{
			
				
			if(ShinYS.query_id.equals(list.get(0).getMem_id())) {	
				if(decText.equals(txt_currentpwd.getText())) {
					if(txt_changepwd.getText().equals(txt_checkchangepwd.getText())) {
						if(Pattern.matches("^[A-za-z0-9]{8,20}$", txt_changepwd.getText())) {
							try {
								//암호화, 복호화 API사용
								try {
									encText = ShinYS.aes256.aesEncode(txt_checkchangepwd.getText());	//암호화
									//decText = ShinYS.aes256.aesDecode(list.get(0).getMem_pwd());	//복호화
									
								} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
										| NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
										| BadPaddingException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								//======================
								MemberVO vo1 = new MemberVO();
								vo1.setMem_id(ShinYS.query_id);
								vo1.setMem_pwd(encText);
								Global.memberService.updateMemberInfoPwd(vo1);
								
							} catch (RemoteException e1) {
								e1.printStackTrace();
							}
							ShinYS.<AnchorPane>ChangePage(getClass(), "showMyinfo.fxml", "#contents");
						} else {
							ShinYS.infoMsg("변경 비밀번호 오류", "8자 이상, 20자 이하로 입력하세요.");
							return;
						}
					}else {
						ShinYS.errMsg("비밀번호 확인", "비밀번호가 불일치합니다.");
						return;
					}
				}else {
					ShinYS.errMsg("비밀번호 확인", "현재 비밀번호가 틀립니다.");
					return;
				}
			
			ShinYS.infoMsg("비밀번호 변경확인", "비밀번호 변경 성공");
			}
			
		});
		
		
	}

}
