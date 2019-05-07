package kr.or.ddit.basic.e_cash;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import kr.or.ddit.basic.Main;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;

public class Highlight_Controller implements Initializable{

	//여기 테이블뷰에 회원이 쓴 모든 형광펜이용내역 출력
	//콤보박스에는 (충전/선물/후원/도시락결제) 가 담기게 로직
	// 검색 버튼을 클릭하면 콤보박스에 선택한 내용의 정보가 테이블뷰에 담기게 로직
	// 닫기 버튼을 클릭하면 메인화면으로 가게 설정

	@FXML JFXTextField txt_myPencnt;
	@FXML TableView<Pen_managementVO> list_tableview;
	@FXML TableColumn<Pen_managementVO, String> col_no;
	@FXML TableColumn<Pen_managementVO, String> col_usename;
	@FXML TableColumn<Pen_managementVO, String> col_penname;
	@FXML TableColumn<Pen_managementVO, String> col_cnt;
	@FXML TableColumn<Pen_managementVO, String> col_receive;
	@FXML TableColumn<Pen_managementVO, String> col_date;
	@FXML Pagination paging;
	@FXML JFXComboBox<combolist> cmb_usetype;
	@FXML JFXButton btn_search;
	
	ObservableList<Pen_managementVO> data = null;
	List<Pen_managementVO> get_useInfo = null;
	
	List<Pen_managementVO> uselist;
	List<MemberVO> user;
	
	int from, to, itemsForPage;
	ObservableList<Pen_managementVO> currentPageData;
	Pen_managementVO useVO = new Pen_managementVO();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
Platform.runLater(new Runnable() {
			
			HBox getCateMenus = (HBox) Main.StageHome.getScene().getRoot().lookup("#dash_cate_item");
			
			@Override
			public void run() {
				// 충전하기
				getCateMenus.getChildren().get(0).setOnMouseClicked(e-> {
					ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir+ "e_cash/highligter_buy_pen.fxml", "#contents");
				});
				
				// 환전하기
				getCateMenus.getChildren().get(1).setOnMouseClicked(e-> {
					ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir+ "e_cash/highlighter_exchange.fxml", "#contents");
				});
				
				// 선물하기
				getCateMenus.getChildren().get(2).setOnMouseClicked(e-> {
					ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "e_cash/highlighter_gift.fxml", "#contents");
				});
				
				
			}
		});



		System.out.println("형관펜 활용목록 페이지");

		try {
			user = Global.memberService.selectOne(ShinYS.query_id);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String my_penQty = user.get(0).getPen_quantity();
		
		txt_myPencnt.setText("    " + my_penQty + " 개");
		
		
		col_no.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("management_no"));
		col_usename.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("use_name"));
		col_penname.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("pen_name"));
		col_cnt.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("pen_cnt"));
		col_receive.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("receive_id"));
		col_date.setCellValueFactory(new PropertyValueFactory<Pen_managementVO, String>("use_date"));
		
		
		try {
			
			useVO.setReceive_id(ShinYS.query_id);
			useVO.setMem_id(ShinYS.query_id);
			
			
			uselist = Global.pen_managementService.select_MemberUsePenList(useVO);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		data = FXCollections.observableArrayList(uselist);
		
		list_tableview.setItems(data);
		
		itemsForPage = 10;
		int totPageCount = data.size() % itemsForPage == 0 ? data.size() / itemsForPage : data.size() / itemsForPage + 1;
		paging.setPageCount(totPageCount);
		
		paging.setPageFactory(this::createPage);
		
		ObservableList<combolist> list_combo = FXCollections.observableArrayList(new combolist("전체", 1), new combolist("충전", 2), new combolist("환전", 3),
				new combolist("보낸 형광펜", 4), new combolist("받은 형광펜", 5));
		
		cmb_usetype.setItems(list_combo);
		cmb_usetype.setValue(list_combo.get(0));
		
		btn_search.setOnMouseClicked(e->{
			search_method();
		});
		
		
	}
	
	
	
	
	
	public void search_method() {
		try {
			user = Global.memberService.selectOne(ShinYS.query_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		String mem_id = user.get(0).getMem_id();
		int select = cmb_usetype.getSelectionModel().getSelectedItem().getValue();
		
		switch (select) {
		case 1:
			
			try {
				get_useInfo = Global.pen_managementService.select_MemberUsePenList(useVO);
				
				data.clear();
				data.addAll(get_useInfo);
				list_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		
		case 2:
			
			try {
				get_useInfo = Global.pen_managementService.select_MemberPayPenList(mem_id);
				
				System.out.println(get_useInfo.get(0).getManagement_no());
				
				data.clear();
				data.setAll(get_useInfo);
				list_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
			
		case 3:
			
			try {
				get_useInfo = Global.pen_managementService.select_MemberExchangePenList(mem_id);
				System.out.println(get_useInfo.get(0).getManagement_no());
				System.out.println(get_useInfo.size());
				
				data.clear();
				data.addAll(get_useInfo);
				list_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
			
		case 4:
			
			try {
				get_useInfo = Global.pen_managementService.select_MemberSupportPenList(mem_id);
				
				data.clear();
				data.addAll(get_useInfo);
				list_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
			
		case 5:
			
			try {
				get_useInfo = Global.pen_managementService.select_MemberReceivePenList(mem_id);
				
				data.clear();
				data.addAll(get_useInfo);
				list_tableview.setItems(data);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
			
		default:
			break;
		}
		
		itemsForPage = 10; // 한페이지 보여줄 항목 수 설정
		// 나머지가 0이면 몫의 값을 페이지로 사용 ,, 0이 아니면 몫값 + 1 페이지로 사용
		int totPageCount = get_useInfo.size()%itemsForPage == 0 ? get_useInfo.size()/itemsForPage : get_useInfo.size()/itemsForPage + 1;
		
		 
		 if (get_useInfo.size() < 1) {
		 totPageCount = 1;
		 }
		
		 paging.setPageCount(totPageCount); // 전체 페이지 수 설정
		 paging.setPageFactory(this::createPage);
			
			
		
//		 // 방법2(람다식)
//		 paging.setPageFactory((Integer pageIndex) -> {
//		
//		 from = pageIndex * itemsForPage;
//		 to = from + itemsForPage - 1;
////		 list_tableview.setItems(getTableViewData2(from, to, get_useInfo));
//		
//		 return list_tableview;
//		 });
		
	}
	
	private Node createPage(int pageIndex) {

		from = pageIndex * itemsForPage;
		to = from + itemsForPage - 1;

		list_tableview.setItems(getTableViewData(from, to));
			
		return list_tableview;
	}
	
	
	
	private ObservableList<Pen_managementVO> getTableViewData(int from, int to) {

		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = data.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData.add(data.get(i));
		}

		return currentPageData;
	}

	private ObservableList<BoardVO> getTableViewData2(int from, int to, List<Pen_managementVO> listvo) {
		
		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = listvo.size();
		for (int i = from; i <= to && i < totSize; i++) {
			
			currentPageData.add(listvo.get(i));
		}
		
		return null; // currentPageData;
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














