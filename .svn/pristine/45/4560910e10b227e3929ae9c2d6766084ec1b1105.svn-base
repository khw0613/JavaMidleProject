package kr.or.ddit.basic.h_management;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.ibatis.vo.boarderVO.FaqVO;
import library.Global;
import library.ShinYS;

public class ManagerFaq_updateController implements Initializable{

	/* 수정하기 화면 */
	@FXML
	JFXButton update_page_insert_faq; 	// 등록하기 버튼
	@FXML
	JFXButton update_page_update_faq; 	// 수정하기 버튼
	@FXML
	JFXButton update_page_delete_faq; 	// 삭제하기 버튼
	@FXML
	Label update_page_back; 			// 뒤로가기 버튼
	@FXML
	Button update_page_ok_btn;			// 수정확인 버튼
	
	
	@FXML
	JFXComboBox<String> update_page_writeQuestion;	// 질문 입력
	@FXML
	JFXTextField update_page_writeAnswer;			// 답변 입력
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/* 수정화면 컨트롤 */

		// 수정화면_뒤로가기 라벨
		update_page_back.setOnMouseClicked(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "manager_faq.fxml", "#contents");
		});

		// 수정화면_등록하기 버튼
		update_page_insert_faq.setOnAction(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "insert_faq_page.fxml", "#contents");
		});

		// 수정하기_수정하기 버튼
		update_page_update_faq.setOnAction(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "update_faq_page.fxml", "#contents");
		});
		
		// 수정화면_수정하기 버튼
		update_page_delete_faq.setOnAction(e-> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "delete_faq_page.fxml", "#contents");
		});
		
		
		// 질문 셋팅
		List<String> comboValue = new ArrayList<>();
		try {
			Global.DbConnect();
			List<FaqVO> list = Global.faqService.selectAll();
			for(int i = 0; i < list.size(); i++){
				comboValue.add(list.get(i).getFaq_question());
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		ObservableList<String> comboValue2 = FXCollections.observableArrayList(comboValue);
		update_page_writeQuestion.setItems(comboValue2);
		
		
		
		
		// 수정화면 _ 수정완료 버튼
		update_page_ok_btn.setOnAction(e-> {
			

			try {
				Global.DbConnect();
				if (update_page_writeAnswer.getText().length() < 1) {
					ShinYS.errMsg("FAQ 수정", "답변을 입력해주세요.");
				} else {
					
					String question 	= update_page_writeQuestion.getValue();
					String answer		= update_page_writeAnswer.getText();
					
					
					int cnt = Global.faqService.updateFAQData(question, answer);
					ShinYS.infoMsg("FAQ 수정", "정상적으로 수정 되었습니다.");
					ShinYS.<AnchorPane>ChangePage(getClass(), "manager_faq.fxml", "#contents");
					

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});
	}
}
