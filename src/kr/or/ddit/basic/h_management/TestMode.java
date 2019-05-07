package kr.or.ddit.basic.h_management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestMode extends Application{
	
	public static Stage TestMode;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TestMode = primaryStage;
		
		Parent root = FXMLLoader.load(getClass().getResource("boardmanager.fxml"));
		Scene scene = new Scene(root);

		TestMode.setScene(scene);
		TestMode.setTitle("Test Mode");
		TestMode.show();
		
		
	}

	
	public static void main(String[] args) throws Exception{
		launch(args);
		
	}
}
