package kr.or.ddit.basic.e_cash;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.basic.Main;
import library.Global;
import library.ShinYS;

public class HighlightBuy_Controller implements Initializable {

	@FXML Button btn_h_pay;				//결제하기
	@FXML JFXRadioButton radio_btn30;	//형광펜 30개
	@FXML JFXRadioButton radio_btn50;	//형광펜 50개
	@FXML JFXRadioButton radio_btn100;	//형광펜 100개
	@FXML JFXRadioButton radio_btn150;	//형광펜 150개
	@FXML JFXRadioButton radio_btn200;	//형광펜 200개
	@FXML JFXTextField   txt_etc;		//형광펜 200개
	
	public static Stage primaryStge;
	ToggleGroup toggleGroup = new ToggleGroup();
	public static Stage buy_pen;
	public void setPrimaryStge(Stage primaryStge) {
		this.primaryStge = primaryStge;
	}

	Parent parent = null;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ShinYS.visBack(true).setOnMouseClicked(e->{
			ShinYS.visBack(false);
			ShinYS.gotoHightlight();
		});
		
		radio_btn30.setToggleGroup(toggleGroup);
		radio_btn30.setUserData("30");
		radio_btn50.setToggleGroup(toggleGroup);
		radio_btn50.setUserData("50");
		radio_btn100.setToggleGroup(toggleGroup);
		radio_btn100.setUserData("100");
		radio_btn150.setToggleGroup(toggleGroup);
		radio_btn150.setUserData("150");
		radio_btn200.setToggleGroup(toggleGroup);
		radio_btn200.setUserData("200");
		txt_etc.setText("");
		
		buy_pen = new Stage(StageStyle.DECORATED);
		 
		buy_pen.initModality(Modality.APPLICATION_MODAL); 
		 
		buy_pen.initOwner(Main.StageHome);
		//결제하기 이벤트
		btn_h_pay.setOnAction(e -> {
			
			
			//입력된 값이 있으면
			if(!txt_etc.getText().equals("")) {
				ShinYS.pay_vo.setPay_cnt(txt_etc.getText()+"");
			}else if(toggleGroup.getSelectedToggle() != null) {
				ShinYS.pay_vo.setPay_cnt(toggleGroup.getSelectedToggle().getUserData()+"");
			}else {
				ShinYS.infoMsg("결제에러", "결제 갯수를 입력해주세요");
				return;
			}
			
			//라디오 버튼 클릭
			 try {
				parent = FXMLLoader.load(getClass().getResource("highlighter_paytype.fxml"));	
				Scene scene = new Scene(parent);
				buy_pen.setScene(scene);
				buy_pen.show();		
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
			
		}// 초기화 종료
	


}
