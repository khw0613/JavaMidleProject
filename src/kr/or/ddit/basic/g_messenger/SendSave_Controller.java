package kr.or.ddit.basic.g_messenger;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import kr.or.ddit.basic.a_layout.layout_Controller;
import kr.or.ddit.basic.a_layout.layout_admin_Controller;
import kr.or.ddit.ibatis.vo.communityVO.MessageBoxVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SendSave_Controller implements Initializable{
	public static String ss_id;
	
	
	@FXML Button ss_close;									// 닫기버튼
	@FXML Button ss_back;									// 쪽지함으로
	@FXML TableColumn<MessageBoxVO, String> ss_contents;	// 내용
	@FXML TableColumn<MessageBoxVO, String> ss_target;		// 수신자
	@FXML TableColumn<MessageBoxVO, String> ss_date;		// 날짜


	@FXML TableView ss_view;								// 테이블 뷰
	
	ObservableList<MessageBoxVO> data;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ss_id = ShinYS.query_id;
		
		// ========================================== 데이터 셋팅 =============================================
			List<MessageBoxVO> list = new ArrayList<>();
			try {
				list = Global.messageBoxService.select_sendMessageInfo(ss_id);
				System.out.println(list.size());
			} catch (RemoteException e2) {
				e2.printStackTrace();
			}
			
			data = FXCollections.observableArrayList(list);
			

			
			ss_contents.	setCellValueFactory	(new PropertyValueFactory<>("msg_contents"));
			ss_target.		setCellValueFactory	(new PropertyValueFactory<>("receive_id"));
			ss_date.		setCellValueFactory	(new PropertyValueFactory<>("msg_date"));
			
			
			ss_view.setItems(data);
			
			
			ss_back.setOnAction(e->{
				try {
					Parent mReceive = FXMLLoader.load(getClass().getResource("locker_message.fxml"));
					Scene sc = new Scene(mReceive);
					Stage primaryStage = (Stage) ss_back.getScene().getWindow();
					primaryStage.setScene(sc);
				
				} catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("Err!! Fail to changed Scene");
				}
				
				
			});
			
			
			ss_view.setOnMouseClicked(e-> {
				if (e.getClickCount() == 2) {

					System.out.println("Test Double Click with Mouse");
					try {
						MessageBoxVO mVO = (MessageBoxVO) ss_view.getSelectionModel().getSelectedItem();
						
						Message_Controller.detail_id 		= mVO.getMem_id();
						Message_Controller.detail_contents 	= mVO.getMsg_contents();
						Message_Controller.detail_date		= mVO.getMsg_date();
						Message_Controller.detail_no		= mVO.getMsg_no();
						
						
						Parent mReceive = FXMLLoader.load(getClass().getResource("detail_message.fxml"));
						Scene sc = new Scene(mReceive);
						Stage primaryStage = (Stage) ss_view.getScene().getWindow();
						primaryStage.setScene(sc);

					} catch (Exception e2) {
						System.out.println("Err!");
						e2.printStackTrace();
					}
				}
				
				
				
			});
			
			
			
			ss_close.setOnAction(e-> {
				List<MemberVO> right;
				try {
					right = Global.memberService.selectOne(ShinYS.query_id);
					if(right.get(0).getRight_code().equals("1")) {
						layout_admin_Controller.message.close();
					}else {
						layout_Controller.message.close();
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			
	
	}

}
