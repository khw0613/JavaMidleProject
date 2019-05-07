package kr.or.ddit.basic.h_management;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

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

public class ManagerFaq_deleteController implements Initializable{

	
	
	@FXML JFXButton delete_page_insert_faq;			// 등록하기 버튼
	@FXML JFXButton delete_page_update_faq;			// 수정하기 버튼
	@FXML JFXButton delete_page_delete_faq;			// 삭제하기 버튼
	@FXML Label delete_page_back;					// 뒤로가기 버튼
	
	@FXML Button delete_page_ok_btn;				// 삭제완료 버튼
	@FXML JFXComboBox<String> delete_page_writeQuestion;	// 삭제창 콤보박스

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//삭제화면_뒤로가기 라벨
		delete_page_back.setOnMouseClicked(e->{
			ShinYS.<AnchorPane>ChangePage(getClass(), "manager_faq.fxml", "#contents");
		});
		
		//삭제화면_등록하기 버튼
		delete_page_insert_faq.setOnAction(e->{
			ShinYS.<AnchorPane>ChangePage(getClass(), "insert_faq_page.fxml", "#contents");
		});
		
		
		//삭제화면_수정하기 버튼
		delete_page_update_faq.setOnAction(e->{
			ShinYS.<AnchorPane>ChangePage(getClass(), "update_faq_page.fxml", "#contents");
		});
		
		
		//삭제화면_삭제하기 버튼
		delete_page_delete_faq.setOnAction(e-> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "delete_faq_page.fxml", "#contents");
		});
		
		
		// 질문 셋팅
		List<String> comboValue = new ArrayList<>();
		try {
			Global.DbConnect();
			List<FaqVO> list = Global.faqService.selectAll();
			for (int i = 0; i < list.size(); i++) {
				comboValue.add(list.get(i).getFaq_question());
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		ObservableList<String> comboValue2 = FXCollections.observableArrayList(comboValue);
		delete_page_writeQuestion.setItems(comboValue2);
		
		
		
		//삭제화면_삭제완료 버튼
		delete_page_ok_btn.setOnAction(e-> {
			
			try {
				Global.DbConnect();
				if(delete_page_writeQuestion.getValue().length() < 1) {
					ShinYS.errMsg("FAQ 삭제", "질문을 입력해주세요.");
				} else {
					
					String question = delete_page_writeQuestion.getValue();
					
					int cnt = Global.faqService.deleteFAQdata(question);
					ShinYS.infoMsg("FAQ 삭제", "정상적으로 삭제 되었습니다.");
					ShinYS.<AnchorPane>ChangePage(getClass(), "manager_faq.fxml", "#contents");
				}
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		
	}

}
