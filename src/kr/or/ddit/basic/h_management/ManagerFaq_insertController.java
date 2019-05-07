package kr.or.ddit.basic.h_management;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import library.Global;
import library.ShinYS;

public class ManagerFaq_insertController implements Initializable {
	


	/* 등록 화면 */
	@FXML
	JFXButton insert_page_insert_faq;		// 등록하기 버튼
	@FXML	
	JFXButton insert_page_update_faq; 		// 수정하기 버튼
	@FXML
	JFXButton insert_page_delete_faq;		// 삭제하기 버튼
	@FXML
	Label insert_page_back; 				// 뒤로가기 버튼
	@FXML
	Button insert_page_okbtn;				// 등록확인 버튼
	
	@FXML
	JFXTextArea insert_page_writeQuestion;	// 질문 등록 에리어
	@FXML
	JFXTextField insert_page_writeAnswer;	// 답변 등록 에리어

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/* 등록화면 컨트롤 */
		// 등록화면_뒤로가기 라벨
		insert_page_back.setOnMouseClicked(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "manager_faq.fxml", "#contents");
		});

		// 등록화면_등록하기 버튼
		insert_page_insert_faq.setOnAction(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "insert_faq_page.fxml", "#contents");
		});

		// 등록화면_수정하기 버튼
		insert_page_update_faq.setOnAction(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "update_faq_page.fxml", "#contents");
		});

		
		// 등록화면_삭제하기 버튼
		insert_page_delete_faq.setOnAction(e-> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "delete_faq_page.fxml", "#contents");
		});
		
		// 등록화면_등록확인 버튼
		insert_page_okbtn.setOnAction(e-> {
			
			
			try {
				Global.DbConnect();
			
			
			
			if(insert_page_writeQuestion.getText().length() < 1) {
				ShinYS.errMsg("FAQ 등록", "질문을 입력해주세요.");
			} else if(insert_page_writeAnswer.getText().length() < 1) {
				ShinYS.errMsg("FAQ 등록", "답변을 입력해주세요.");
			} else {
				
				String question 	= insert_page_writeQuestion.getText();
				String answer		= insert_page_writeAnswer.getText();
				
				try {
					int cnt = Global.faqService.insertFAQ(question, answer);
					if(cnt == 1) {
						ShinYS.infoMsg("FAQ 등록", "정상적으로 등록 되었습니다.");
						ShinYS.<AnchorPane>ChangePage(getClass(), "manager_faq.fxml", "#contents");
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		});
		
		
		
		
		
		

	}

}
