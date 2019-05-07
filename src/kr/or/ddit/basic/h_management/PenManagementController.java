package kr.or.ddit.basic.h_management;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;

public class PenManagementController implements Initializable{

	@FXML TableView<Pen_managementVO> manage_tableview;
	@FXML TableColumn<Pen_managementVO, String> col_manage_no;
	@FXML TableColumn<Pen_managementVO, String> col_mem_id;
	@FXML TableColumn<Pen_managementVO, String> col_use_name;
	@FXML TableColumn<Pen_managementVO, String> col_pen_name;
	@FXML TableColumn<Pen_managementVO, String> col_pen_cnt;
	@FXML TableColumn<Pen_managementVO, String> col_receive_id;
	@FXML TableColumn<Pen_managementVO, String> col_use_date;
	@FXML Pagination view_paging;
	@FXML JFXComboBox<combolist> select_usetype;
	@FXML JFXTextField txt_search_id;
	@FXML JFXButton btn_search;
	
	
	ObservableList<Pen_managementVO> data = null;
	List<Pen_managementVO> user_PenUse_Info = null;
	List<Pen_managementVO> penUse_list = null;
	List<MemberVO> user = null;
	
	int from, to, itemsForPage;
	ObservableList<Pen_managementVO> currentPageData;

	Pen_managementVO manage = new Pen_managementVO();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("[관리자 페이지] 형광펜 이용내역 관리 페이지");
		
		
		col_manage_no.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("management_no"));
		col_mem_id.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("mem_id"));
		col_use_name.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("use_name"));
		col_pen_name.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("pen_name"));
		col_pen_cnt.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("pen_cnt"));
		col_receive_id.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("receive_id"));
		col_use_date.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("use_date"));
		
		
		try {
			penUse_list = Global.pen_managementService.select_UsePenList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		data = FXCollections.observableArrayList(penUse_list);
		manage_tableview.setItems(data);
		
		itemsForPage = 10;
		int totPageCount = data.size() % itemsForPage == 0 ? data.size() / itemsForPage : data.size() / itemsForPage + 1;
		view_paging.setPageCount(totPageCount);
		view_paging.setPageFactory(this::createPage);
		
		ObservableList<combolist> select_cmb = FXCollections.observableArrayList(new combolist("전 체", 1), new combolist("충 전", 2), new combolist("환 전", 3),
				 new combolist("형광펜 후원", 4), new combolist("받은 후원", 5));
		
		select_usetype.setItems(select_cmb);
		select_usetype.setValue(select_cmb.get(0));
		
		btn_search.setOnMouseClicked(e->{
			System.out.println("button clicked");
			if(txt_search_id.getText().equals("")) {
				search_all();
			} else if(!txt_search_id.getText().equals("")) {
				search_all_usetype();
			}
		});
	}
	
	public void search_all() {
		
		System.out.println("유형별 전체회원의 이용내역 출력");
		String mem_id = txt_search_id.getText();
		System.out.println(mem_id);
		
		int select = select_usetype.getSelectionModel().getSelectedItem().getValue();
		
		switch (select) {
		case 1:
			
			try {
				penUse_list = Global.pen_managementService.select_UsePenList();
				data.clear();
				data.addAll(penUse_list);
				manage_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			break;

		case 2:
			
			try {
				penUse_list = Global.pen_managementService.select_PayPenList();
				data.clear();
				data.addAll(penUse_list);
				manage_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			break;

		case 3:
			
			try {
				penUse_list = Global.pen_managementService.select_ExchangePenList();
				data.clear();
				data.addAll(penUse_list);
				manage_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			break;
			
		case 4:
			try {
				penUse_list = Global.pen_managementService.select_SupportPenList();
				data.clear();
				data.addAll(penUse_list);
				manage_tableview.setItems(data);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
			
		case 5:
			try {
				penUse_list = Global.pen_managementService.select_ReceivePenList();
				data.clear();
				data.addAll(penUse_list);
				manage_tableview.setItems(data);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		}
		
		itemsForPage = 12; 
		int totPageCount = penUse_list.size()%itemsForPage == 0 ? penUse_list.size()/itemsForPage : penUse_list.size()/itemsForPage + 1;
		
		if (penUse_list.size() < 1) {
		totPageCount = 1;
		}
		
		view_paging.setPageCount(totPageCount); 
		
		view_paging.setPageFactory((Integer pageIndex) -> {
		
			from = pageIndex * itemsForPage;
			to = from + itemsForPage - 1; 
			manage_tableview.setItems(getTableViewData2(from, to, penUse_list));
			
			return manage_tableview;
		 
		});
	}
	
	public void search_all_usetype() {
		
		String mem_id = txt_search_id.getText();
		int select = select_usetype.getSelectionModel().getSelectedItem().getValue();
		manage.setMem_id(mem_id);
		manage.setReceive_id(mem_id);
		
		
		switch (select) {
		case 1:
			
			try {
				user_PenUse_Info = Global.pen_managementService.select_MemberUsePenList(manage);
				data.clear();
				data.addAll(user_PenUse_Info);
				manage_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			break;

		case 2:
			
			try {
				user_PenUse_Info = Global.pen_managementService.search_PayPenList(mem_id);
				data.clear();
				data.addAll(user_PenUse_Info);
				manage_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			break;
		
		case 3:
			
			try {
				user_PenUse_Info = Global.pen_managementService.search_ExchangePenList(mem_id);
				data.clear();
				data.addAll(user_PenUse_Info);
				manage_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			break;
			
		case 4:
			
			try {
				user_PenUse_Info = Global.pen_managementService.search_SupportPenList(mem_id);
				data.clear();
				data.addAll(user_PenUse_Info);
				manage_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			break;
			
		case 5:
			
			try {
				user_PenUse_Info = Global.pen_managementService.search_ReceivePenList(mem_id);
				data.clear();
				data.addAll(user_PenUse_Info);
				manage_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			break;
		default:
			break;
		}
		
		itemsForPage = 10; 
		int totPageCount = user_PenUse_Info.size()%itemsForPage == 0 ? user_PenUse_Info.size()/itemsForPage : user_PenUse_Info.size()/itemsForPage + 1;
		
		if (user_PenUse_Info.size() < 1) {
		totPageCount = 1;
		}
		
		view_paging.setPageCount(totPageCount); 
		
		view_paging.setPageFactory((Integer pageIndex) -> {
		
			from = pageIndex * itemsForPage;
			to = from + itemsForPage - 1; 
			manage_tableview.setItems(getTableViewData3(from, to, user_PenUse_Info));
			
			return manage_tableview;
		 
		});
	}
	
	private Node createPage(int pageIndex) {

		from = pageIndex * itemsForPage;
		to = from + itemsForPage - 1;

		manage_tableview.setItems(getTableViewData(from, to));
			
		return manage_tableview;
	}
	
	private ObservableList<Pen_managementVO> getTableViewData(int from, int to) {

		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = data.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData.add(data.get(i));
		}

		return currentPageData;
	}
	
	private ObservableList<Pen_managementVO> getTableViewData2(int from, int to, List<Pen_managementVO> listvo) {

		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = listvo.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData.add(listvo.get(i));
		}

		return currentPageData;
	}

	private ObservableList<Pen_managementVO> getTableViewData3(int from, int to, List<Pen_managementVO> listvo) {
		
		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = listvo.size();
		for (int i = from; i <= to && i < totSize; i++) {
			
			currentPageData.add(listvo.get(i));
		}
		
		return currentPageData;
	}
	
	
	public class combolist {
		private String name;
		private int value;
		
		public String toString() {
			return name;
		}
		
		public combolist(String name, int value) {
			super();
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	}
}
