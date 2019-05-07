package kr.or.ddit.basic.h_management;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kr.or.ddit.ibatis.vo.boarderVO.FaqVO;
import library.Global;
import library.ShinYS;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.TextArea;

public class ManagerFaq_Controller implements Initializable {

	@FXML
	JFXButton insert_faq; // 등록버튼
	@FXML
	JFXButton update_faq; // 수정버튼
	@FXML
	JFXButton delete_faq; // 삭제버튼
	
	@FXML JFXComboBox sel_member;
	@FXML Button faq_ok1;
	@FXML JFXComboBox sel_board;
	@FXML Button faq_ok2;
	@FXML JFXComboBox sel_pay;
	@FXML Button faq_ok3;
	@FXML JFXComboBox sel_pen;
	@FXML Button faq_ok4;
	@FXML TextArea faq_text;
	@FXML TextArea faq_text2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// 등록버튼 입력
		insert_faq.setOnAction(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "insert_faq_page.fxml", "#contents");
		});

		// 수정버튼 입력
		update_faq.setOnAction(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "update_faq_page.fxml", "#contents");
		});

		// 삭제버튼 입력
		delete_faq.setOnAction(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), "delete_faq_page.fxml", "#contents");
		});
		
		
		
		
		
		
		
		faq_text2.setWrapText(true);

		List<String> combo = new ArrayList<>();
		try {
			List<FaqVO> list = Global.faqService.selBox("회원");
			for (int i = 0; i < list.size(); i++) {
				combo.add(list.get(i).getFaq_question());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ObservableList<String> comboList = FXCollections.observableArrayList(combo);
		sel_member.setItems(comboList);

		faq_ok1.setOnAction(e -> {
				String text1_question = sel_member.getValue().toString();
				String text2_answer = "";
				faq_text.setText("Q. " + text1_question);
				try {
					List<FaqVO> answer = Global.faqService.sel_answer(text1_question);
					text2_answer = answer.get(0).getFaq_answer();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				faq_text2.setText("A. " + text2_answer);
				sel_member.setValue("");
				sel_board.setValue("");
				sel_pay.setValue("");
				sel_pen.setValue("");
		});

		// ================================

		List<String> combo2 = new ArrayList<>();
		try {
			List<FaqVO> list = Global.faqService.selBox("게시판");
			for (int i = 0; i < list.size(); i++) {
				combo2.add(list.get(i).getFaq_question());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ObservableList<String> comboList2 = FXCollections.observableArrayList(combo2);
		sel_board.setItems(comboList2);

		faq_ok2.setOnAction(e -> {
			String text1_question = sel_board.getValue().toString();
			String text2_answer = "";
			faq_text.setText("Q. " + text1_question);
			try {
				List<FaqVO> answer = Global.faqService.sel_answer(text1_question);
				text2_answer = answer.get(0).getFaq_answer();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			faq_text2.setText("A. " + text2_answer);
			sel_member.setValue("");
			sel_board.setValue("");
			sel_pay.setValue("");
			sel_pen.setValue("");
		});

		// ================================

		List<String> combo3 = new ArrayList<>();
		try {
			List<FaqVO> list = Global.faqService.selBox("결제");
			for (int i = 0; i < list.size(); i++) {
				combo3.add(list.get(i).getFaq_question());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ObservableList<String> comboList3 = FXCollections.observableArrayList(combo3);
		sel_pay.setItems(comboList3);

		faq_ok3.setOnAction(e -> {
			String text1_question = sel_pay.getValue().toString();
			String text2_answer = "";
			faq_text.setText("Q. " + text1_question);
			try {
				List<FaqVO> answer = Global.faqService.sel_answer(text1_question);
				text2_answer = answer.get(0).getFaq_answer();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			faq_text2.setText("A. " + text2_answer);
			sel_member.setValue("");
			sel_board.setValue("");
			sel_pay.setValue("");
			sel_pen.setValue("");
		});

		// ================================
		List<String> combo4 = new ArrayList<>();
		try {
			List<FaqVO> list = Global.faqService.selBox("형광");
			for (int i = 0; i < list.size(); i++) {
				combo4.add(list.get(i).getFaq_question());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ObservableList<String> comboList4 = FXCollections.observableArrayList(combo4);
		sel_pen.setItems(comboList4);

		faq_ok4.setOnAction(e -> {
			String text1_question = sel_pen.getValue().toString();
			String text2_answer = "";
			faq_text.setText("Q. " + text1_question);
			try {
				List<FaqVO> answer = Global.faqService.sel_answer(text1_question);
				text2_answer = answer.get(0).getFaq_answer();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			faq_text2.setText("A. " + text2_answer);
			sel_member.setValue("");
			sel_board.setValue("");
			sel_pay.setValue("");
			sel_pen.setValue("");
		});

		

	}

}
