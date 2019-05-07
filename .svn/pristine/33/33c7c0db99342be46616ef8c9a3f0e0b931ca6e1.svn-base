package kr.or.ddit.basic.e_cash;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.basic.Main;
import library.Global;
import library.ShinYS;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import com.jfoenix.controls.JFXButton;

public class highlighterPaytype_Controller implements Initializable {

	@FXML JFXButton btn_transfer;		//실시간 계좌 이체
	@FXML JFXButton btn_bank_payment; 	//무통장 입금
	@FXML JFXButton btn_mobilepay;		//휴대폰 결제
	@FXML JFXButton btn_cardpay;		//카드 결제
	public static Stage primaryStge;

	public void setPrimaryStge(Stage primaryStge) {
		this.primaryStge = primaryStge;
	}
	@FXML AnchorPane bon;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 
		Stage paytype = new Stage(StageStyle.DECORATED);
		paytype.initModality(Modality.APPLICATION_MODAL); 
		paytype.initOwner(Main.StageHome);
		
		btn_transfer.setOnAction(e -> {
			try {
				
				Parent transfer = FXMLLoader.load(getClass().getResource("bank_transfer.fxml"));
				Scene sc = new Scene(transfer);
				Stage primaryStage = (Stage) btn_transfer.getScene().getWindow();
				primaryStage.setScene(sc);
				
			
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("Err!! Fail to changed Scene");
			}
		});
		
		btn_bank_payment.setOnAction(e -> {
			try {
				Parent payment = FXMLLoader.load(getClass().getResource("bank_payment.fxml"));
				Scene sc = new Scene(payment);
				Stage primaryStage = (Stage) btn_transfer.getScene().getWindow();
				primaryStage.setScene(sc);
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("Err!! Fail to changed Scene");
			}
		});
		
		btn_mobilepay.setOnAction(e -> {
			try {
				Parent mobilepay = FXMLLoader.load(getClass().getResource("highlighter_mobilepay.fxml"));
				Scene sc = new Scene(mobilepay);
				Stage primaryStage = (Stage) btn_transfer.getScene().getWindow();
				primaryStage.setScene(sc);
			
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("Err!! Fail to changed Scene");
			}
		});
		
		btn_cardpay.setOnAction(e -> {
			try {
				Parent cardpay = FXMLLoader.load(getClass().getResource("highlighter_cardpay.fxml"));
				Scene sc = new Scene(cardpay);
				Stage primaryStage = (Stage) btn_transfer.getScene().getWindow();
				primaryStage.setScene(sc);
			
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("Err!! Fail to changed Scene");
			}
		});
	}

}
