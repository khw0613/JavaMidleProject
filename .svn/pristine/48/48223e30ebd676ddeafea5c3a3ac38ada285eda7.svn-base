package kr.or.ddit.basic.h_management;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import kr.or.ddit.ibatis.vo.restaurantVO.OrderVO;
import library.Global;
import library.ShinYS;

public class OrderManager_Controller implements Initializable {

	@FXML
	TableView<Map> o_tableView;


	@FXML
	JFXComboBox<String> o_degree;
	@FXML
	JFXComboBox<String> o_class;
	@FXML
	Button manager_view;
	@FXML 
	JFXComboBox<String> o_date;
	
	
	List<String> boardTypeCombo;
	List<String> classTypeCombo;
	List<String> dateTypeCombo;


	@FXML TableColumn<Map, String> ot_no;
	@FXML TableColumn<Map, String> ot_date;
	@FXML TableColumn<Map, String> ot_res;
	@FXML TableColumn<Map, String> ot_id;
	@FXML TableColumn<Map, String> ot_resname;

	@FXML Label o_sum;

	ObservableList<Map> orderdData;


	@FXML Label o_price;


	@FXML Label res_name;


	




	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// 콤보박스 셋팅
		HashSet<String> degreeCombo = new HashSet<>();
		boardTypeCombo = new ArrayList<>();

		try {
			Global.DbConnect();
			List<MemberVO> list = Global.memberService.select_MemberList();
			for (int i = 0; i < list.size(); i++) {
				degreeCombo.add(list.get(i).getDegree());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ObservableList<String> degreeCombo2 = FXCollections.observableArrayList(degreeCombo);
		o_degree.setItems(degreeCombo2);

		// 콤보박스 셋팅2
		HashSet<String> classCombo = new HashSet<>();
		classTypeCombo = new ArrayList<>();

		try {
			Global.DbConnect();
			List<MemberVO> list = Global.memberService.select_MemberList();
			for (int i = 0; i < list.size(); i++) {
				classCombo.add(list.get(i).getMem_class());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ObservableList<String> classCombo2 = FXCollections.observableArrayList(classCombo);
		o_class.setItems(classCombo2);
		
		

		// 콤보박스 셋팅3
//		HashSet<String> dateCombo = new HashSet<>();
//		dateTypeCombo = new ArrayList<>();
//		
//		try {
//			Global.DbConnect();
//			List<OrderVO> list = Global.orderService.select_order();
//			for (int i = 0; i < list.size(); i++) {
//				dateCombo.add(list.get(i).getRes_order_date());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		List<String> dateCombo1 = new ArrayList<>(dateCombo);
//		Collections.sort(dateCombo1);
		
//		ObservableList<String> dateCombo2 = FXCollections.observableArrayList(dateCombo1);
//		o_date.setItems(dateCombo2);
//		
//		
//		o_degree.setValue("---선택---");
//		o_class.setValue("---선택---");
//		o_date.setValue("---선택---");
		
		List<String> order_date_combo = new ArrayList<>();
		try {
			Global.DbConnect();
			List<OrderVO> order_list = Global.orderService.select_order();
			for(int i=0; i<order_list.size(); i++) {
				order_date_combo.add(order_list.get(i).getRes_order_date());
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		List<String> order_date_combo2 = new ArrayList<>(order_date_combo);
		Collections.reverse(order_date_combo2);
		
		System.out.println(order_date_combo2.toString());
		
		ObservableList<String> dateCombo2 = FXCollections.observableArrayList(order_date_combo2);
		o_date.setItems(dateCombo2);
		
		o_degree.setValue("---선택---");
		o_class.setValue("---선택---");
		o_date.setValue("---선택---");
		
		

		// 조회하기 버튼
		manager_view.setOnAction(e -> {
			if (o_degree.getValue().equals("---선택---") || o_class.getValue().equals("---선택---") || o_date.getValue().equals("---선택---")) {
				ShinYS.errMsg("검색 불가", "정확한 검색조건을 입력해주세요.");
				return;
			}
			
			o_sum.setText("");
			o_price.setText("");
			
			String degree = o_degree.getValue();
			String memClass	 = o_class.getValue();
			String res_order_date = o_date.getValue();
			
			
			ot_no.setCellValueFactory(new MapValueFactory<>("ORDER_CODE"));
			ot_id.setCellValueFactory(new MapValueFactory<>("MEM_ID"));
			ot_res.setCellValueFactory(new MapValueFactory<>("RES_NO"));
			ot_date.setCellValueFactory(new MapValueFactory<>("RES_ORDER_DATE"));
			ot_resname.setCellValueFactory(new MapValueFactory<>("RES_NAME"));
			
			
			try {
				List<Map> orderList = Global.orderService.select_order2(degree, memClass, res_order_date);
				if(orderList.size() == 0) {
					ShinYS.errMsg("관리자모드", "조건에 해당하는 주문 결과가 없습니다.");
					o_tableView.setItems(null);
					return;
				}
				
				
				orderdData = FXCollections.observableArrayList(orderList);
				
				o_tableView.setItems(orderdData);
				
				String qn = orderList.size() + "" ;
				String pr = (orderList.size() * 3500) + "";
				
				o_sum.setText(qn);
				o_price.setText(pr);
				
				
			
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			
			
		});

	}

}
