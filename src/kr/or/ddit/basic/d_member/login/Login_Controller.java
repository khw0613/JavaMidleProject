package kr.or.ddit.basic.d_member.login;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.sun.webkit.network.data.Handler;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import kr.or.ddit.basic.g_messenger.ChatSystemClient;
import kr.or.ddit.ibatis.vo.memberVO.AttendanceVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import kr.or.ddit.ibatis.vo.memberVO.RightVO;
import library.Global;
import library.ShinYS;

public class Login_Controller implements Initializable {

	@FXML
	Button signup;
	@FXML
	Button btn_login;
	@FXML
	TextField txt_id;
	@FXML
	PasswordField txt_password;
	@FXML
	Button btn_findpwd;
	@FXML
	Button btn_findid;
	@FXML
	AnchorPane layout_module;
	@FXML
	AnchorPane login_module;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// 회원가입 버튼
		signup.setOnAction(e -> {

//			ShinYS.ChangeView(getClass(), "../signup/join.fxml", true);
			ShinYS.ChangeView(getClass(), "../signup/join.fxml");
		});

		// 로그인 버튼
		btn_login.setOnAction(e -> {
			login_method();
			
		});

		// 로그인 패스워트 텍스트에서 엔터키 입력
		txt_password.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				login_method();
			}
		});

		// 아이디 찾기
		btn_findid.setOnAction(e -> {
			//ShinYS.ChangeView(getClass(), "ID_find.fxml", true);
			ShinYS.ChangeView(getClass(), "ID_find.fxml");

		});

		// 패스워드 찾기
		btn_findpwd.setOnAction(e -> {
			//ShinYS.ChangeView(getClass(), "pwd_find.fxml", true);
			ShinYS.ChangeView(getClass(), "pwd_find.fxml");
		});

	}// 초기화 종료

	// 로그인 메소드
	void login_method() {
		try {

			if (txt_id.getText().equals("")) {
				ShinYS.errMsg("아이디 오류", "아이디를 입력해주세요.");
				txt_id.requestFocus();
				return;
			} else if (txt_password.getText().equals("")) {
				ShinYS.errMsg("비밀번호 오류", "비밀번호를 입력해주세요.");
				txt_password.requestFocus();
				return;
			}

			if (Global.memberService.idCheck(txt_id.getText()) == 0) {
				ShinYS.errMsg("아이디 오류", "해당 아이디가 존재하지 않습니다.");
				return;
			}

			List<MemberVO> list = Global.memberService.selectOne(txt_id.getText());

			String log_pwd = list.get(0).getMem_pwd();
			
			//암호화, 복호화 API사용
		 	//String encText = null;
		 	String decText = null;
			try {
				//encText = ShinYS.aes256.aesEncode(txt_pwd.getText());	//암호화
				decText = ShinYS.aes256.aesDecode(log_pwd);	//복호화
			        
			} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
					| NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
					| BadPaddingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			//======================
			
			int right = Integer.parseInt(list.get(0).getRight_code());

			if (right == 3) {
				ShinYS.errMsg("로그인 불가", "활동정지 회원 입니다. 관리자에게 문의하세요.");
				return;
			} else if (right == 6) {
				ShinYS.errMsg("로그인 불가", "이미 탈퇴한 회원입니다.");
				return;
			} else if (right == 5) {
				ShinYS.errMsg("로그인 불가", "가입대기 상태 입니다.관리자에게 문의하세요.");
				return;
			}

			if (decText.equals(txt_password.getText())) {
				
				
				

				// 로그인 회원정보가져오기
				list = Global.memberService.selectOne(txt_id.getText());
				// 로그 윈도우 추가
				ShinYS.query_id = txt_id.getText();
				ShinYS.query_Degree = list.get(0).getDegree();
				ShinYS.query_Password = txt_password.getText();
				ShinYS.login_memVO = list.get(0);
				
				
				//회원등급 가져오기
				List<RightVO> getRightVOList = Global.memberService.select_Right();
				
				for(int i=0; i<getRightVOList.size(); i++) {
					if(getRightVOList.get(i).getRight_code().equals(list.get(0).getRight_code())) {
						ShinYS.login_right_name = getRightVOList.get(i).getRight_name();
					}
				}
			

				Global.logWindowService.insert_LogInfo(ShinYS.query_id);

				
				
				
				// 로그인 순간 자동출석체크
				attendance_Check();
					
				
				
				// 에니메이션 시작	
				AnchorPane board = null;
				try {
					if(list.get(0).getRight_code().equals("1")) {
						board = FXMLLoader.load(getClass().getResource(Global.RootDir + "a_layout/layout_admin.fxml"));
					}else {
						board = FXMLLoader.load(getClass().getResource(Global.RootDir + "a_layout/layout1.fxml"));
					}
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				layout_module.getChildren().clear();
				layout_module.getChildren().setAll(board);

					

					// ShinYS.ChangeView(getClass(), Global.RootDir + "a_layout/layout1.fxml",
					// false);

					layout_module.setStyle("-fx-background-color : transparent;");
					// -fx-focus-color: transparent;
					// -fx-faint-focus-color: transparent;

					FadeTransition login_animate = new FadeTransition(Duration.millis(800), login_module);
					login_animate.setFromValue(1.0);
					login_animate.setToValue(0);
					login_animate.setOnFinished(e -> {
						login_module.toBack();
					});
					login_animate.play();
					
					
					

	

			} else {
				ShinYS.errMsg("비밀번호 오류", "비밀번호가 틀렸습니다.");
				return;
			}

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// id.id_param(txt_id.getText());

	}

	
	
	

	public void attendance_Check() {

		System.out.println("자동출석체크시작!");
		AttendanceVO vo = new AttendanceVO();

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		Date currentTime = new Date();
		String mTime = mSimpleDateFormat.format(currentTime);

		// System.out.println(mTime.replaceAll("[.]", ""));

		List<AttendanceVO> list_day = null;

		try {
			list_day = Global.attendanceService.select_TodayAttendanceList(mTime.replaceAll("[.]", ""));
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		if (list_day.size() == 0) {
			System.out.println("자료없음");
					try {
						vo.setMem_id(ShinYS.query_id);
						Global.attendanceService.insert_AttendanceInfo(vo);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

		} else if (list_day.size() != 0) {
			System.out.println("자료있음");
			boolean atten_chek = false;
			for (int i = 0; i < list_day.size(); i++) {
				if (list_day.get(i).getMem_id().equals(ShinYS.query_id)) {
					System.out.println("일치");
					atten_chek=true;
					break;
				}
			}
			
			if(!atten_chek) {
				try {
					vo.setMem_id(ShinYS.query_id);
					Global.attendanceService.insert_AttendanceInfo(vo);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			

		}
		
		

	}
}
