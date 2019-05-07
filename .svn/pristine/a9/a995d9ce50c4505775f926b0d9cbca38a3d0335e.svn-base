package kr.or.ddit.basic.f_lunchbox;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import kr.or.ddit.ibatis.vo.restaurantVO.OrderVO;
import library.Global;
import library.ShinYS;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;

public class OrderList_Controller implements Initializable{
	

	@FXML TableView<OrderVO> order_tableView;		// 테이블 뷰
	
	@FXML TableColumn<OrderVO, String> order_no;
	@FXML TableColumn<OrderVO, String> order_id;
	@FXML TableColumn<OrderVO, String> order_date;
	@FXML TableColumn<OrderVO, String> order_res;

	@FXML JFXComboBox<String> select_date;			// 날짜 선택 콤보박스
	@FXML JFXComboBox<String> select_res;			// 업체 선택 콤보박스
	
	
	@FXML Button btn_select;						// 조회하기 버튼
	@FXML Button btn_back;							// 뒤로가기 버튼
	

	ObservableList<OrderVO> orderdData;

	@FXML Label text_qn;
	@FXML Label text_price;
	
	
	//페이징 처리
	int from, to, itemsForPage;

	@FXML Pagination pages;
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// 콤보박스 셋팅 (날짜)
//		HashSet<String> dateCombo = new HashSet<>();
		List<String> order_dateCombo = new ArrayList<>();
		try {
			List<OrderVO> order_list = Global.orderService.select_order();
			for(int i = 0; i < order_list.size(); i++) {
				order_dateCombo.add(order_list.get(i).getRes_order_date());
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		List<String> order_dateCombo2 = new ArrayList<>(order_dateCombo);
		Collections.reverse(order_dateCombo2);
		
		ObservableList<String> dataCombo2 = FXCollections.observableArrayList(order_dateCombo2);
		select_date.setItems(dataCombo2);
		
		
		
		
		
		// 콤보박스 셋팅 (업체)
		HashSet<String> resCombo = new HashSet<>();

		try {
			List<OrderVO> list = Global.orderService.select_order();
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getRes_no().equals("a001")) {
					resCombo.add(list.get(i).getRes_no() + "[대전도시락]");
				} else if (list.get(i).getRes_no().equals("a002")) {
					resCombo.add(list.get(i).getRes_no() + "[툼레이러도시락]");
				} else {
					resCombo.add(list.get(i).getRes_no() + "이름미정");
				}
				
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}

		ObservableList<String> resCombo2 = FXCollections.observableArrayList(resCombo);
		select_res.setItems(resCombo2);
		
		
		
		select_date.setValue("선택");
		select_res.setValue("선택");
		
		// 조회하기 버튼
		btn_select.setOnAction(e-> {
			if(select_date.getValue().equals("선택") || select_res.getValue().equals("선택")) {
				ShinYS.errMsg("검색 불가", "정확한 검색조건을 입력해주세요.");
				return;
			}
			
			text_qn.setText("");
			text_price.setText("");
			
			
			String res_order_date 	= select_date.getValue();
			String res_no 			= select_res.getValue().substring(0,4);
			String memDegree		= ShinYS.login_memVO.getDegree();
			String memClass			= ShinYS.login_memVO.getMem_class();
			
			

		order_no.setCellValueFactory(new PropertyValueFactory<>("order_code"));
		order_id.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		order_date.setCellValueFactory(new PropertyValueFactory<>("res_order_date"));
		order_res.setCellValueFactory(new PropertyValueFactory<>("res_no"));
		
		try {
			List<OrderVO> orderList = Global.orderService.select_adminlist2(memDegree, memClass, res_order_date, res_no);
			System.out.println(orderList.size());
			if(orderList.size() == 0) {
				ShinYS.errMsg("관리자모드", "조건에 해당하는 주문 결과가 없습니다.");
				order_tableView.setItems(null);
				return;
			}
			
			orderdData = FXCollections.observableArrayList(orderList);
			
			order_tableView.setItems(orderdData);
			
			// 페이징 셋팅
			itemsForPage = 10; // 한페이지 보여줄 항목 수 설정
			// 나머지가 0이면 몫의 값을 페이지로 사용 ,, 0이 아니면 몫값 + 1 페이지로 사용
			int totPageCount = orderdData.size() % itemsForPage == 0 ? orderdData.size() / itemsForPage
					: orderdData.size() / itemsForPage + 1;
			pages.setPageCount(totPageCount); // 전체 페이지 수 설정

			// 방법3(메서드 참조)
			// =>하나의 메서드만 호출하는 람다식은
			// '클래스이름::메서드이름' 또는 '참조변수::메서드이름' 으로 바꿀 수 있다.
//			 pages.setPageFactory(this::createPage); // 메서드 참조
			
			
			
			String qn = orderList.size() + "" ;
			String pr = (orderList.size() * 3500) + "";
			
			text_qn.setText(qn);
			text_price.setText(pr);
			order_tableView.refresh();
			
			
		} catch (RemoteException e1) {
				e1.printStackTrace();
			}

		});

		btn_back.setOnAction(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "f_lunchbox/Lunchbox_date.fxml", "#contents");

			// 카테고리 추가
			List<Button> catels = new ArrayList<>();
			Button test1 = new Button("주문하기");
			Button test2 = new Button("환불하기");

			catels.add(test1);
			catels.add(test2);
			ShinYS.categoryOpen(catels);
		});
	}

}
