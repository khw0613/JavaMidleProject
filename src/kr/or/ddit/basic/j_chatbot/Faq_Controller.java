package kr.or.ddit.basic.j_chatbot;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import kr.or.ddit.ibatis.vo.boarderVO.FaqVO;
import library.Global;

public class Faq_Controller implements Initializable {

	@FXML
	JFXComboBox<String> sel_member;
	@FXML
	JFXComboBox<String> sel_board;
	@FXML
	JFXComboBox<String> sel_pay;
	@FXML
	JFXComboBox<String> sel_pen;

	@FXML
	Button faq_ok1;
	@FXML
	Button faq_ok2;
	@FXML
	Button faq_ok3;
	@FXML
	Button faq_ok4;
	@FXML
	TextArea faq_text; // 질문 창
	@FXML
	TextArea faq_text2; // 답변 창

	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
