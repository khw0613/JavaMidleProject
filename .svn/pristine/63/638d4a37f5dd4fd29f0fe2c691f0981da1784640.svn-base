package kr.or.ddit.basic.h_management;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;
	
public class MemberShip_Controller implements Initializable {

	Class<? extends MemberShip_Controller> B_class = getClass();

	@FXML
	ComboBox<Scombo> select_search;
	@FXML
	ComboBox<Scombo> select_rightcode;
	
	@FXML TextField txt_degree;

	@FXML TextField txt_class;

	
	
	@FXML Button btn_right;
	@FXML Button btn_degree;
	@FXML Button btn_class;
	@FXML Button search_btn;
	        
	
	
	

	
	
	@FXML
	TextField txt_search;
	@FXML
	Pagination pages;

	@FXML
	TableView<MemberVO> table_view;

	// 컬럼
	@FXML
	TableColumn<MemberVO, String> col_signup;
	@FXML
	TableColumn<MemberVO, String> col_id;
	@FXML
	TableColumn<MemberVO, String> col_class;
	@FXML
	TableColumn<MemberVO, String> col_degree;
	@FXML
	TableColumn<MemberVO, String> col_name;
	@FXML
	TableColumn<MemberVO, String> col_phone;
	@FXML
	TableColumn<MemberVO, String> col_email;
	@FXML
	TableColumn<MemberVO, String> col_rightcode;
	
	@FXML 
	JFXButton exile_btn;			// 회원 탈퇴시키기 버튼

	
	List<MemberVO> list = null;
	List<MemberVO> list_rightname = null; //등급코드네임
	ObservableList<MemberVO> data = null;

	// 페이징
	ObservableList<MemberVO> currentPageData;
	int from, to, itemsForPage;
	
	List<MemberVO> list_search = null;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("회원관리 페이지");

		try {
			list = Global.memberService.select_MemberList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		// 회원 탈퇴시키기
		
		exile_btn.setOnAction(e-> {
			try {
				Global.DbConnect();
				
				// 선택한 데이터 값 vo에 저장
				MemberVO vo = (MemberVO) table_view.getSelectionModel().getSelectedItem();
				
				
				String mem_id 		= vo.getMem_id();
				String degree		= vo.getDegree();
				String mem_name 	= vo.getMem_name();
				
				
				// 대화창 생성
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("관리자 모드");
				alert.setHeaderText("회원 강제탈퇴 확인");
				alert.setContentText("회원 ID : " + mem_id + " 기수 : "+degree + "  회원 NAME : "+ mem_name + " 님을 탈퇴시키시겠습니까?");

				Optional<ButtonType> result = alert.showAndWait();
				ButtonType button = result.orElse(ButtonType.CANCEL);

				if (button == ButtonType.OK) {
					System.out.println(mem_id);
					vo.setRight_name("탈퇴회원");
					try {
						Global.memberService.update_member_right(vo);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table_view.refresh();
					table_view.refresh();
				} else {
				    System.out.println("canceled");
				}
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		
		
		

		// 테이블 뷰 컬럼연결

		col_id.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		col_class.setCellValueFactory(new PropertyValueFactory<>("mem_class"));
		col_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
		col_phone.setCellValueFactory(new PropertyValueFactory<>("telno"));
		col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		col_rightcode.setCellValueFactory(new PropertyValueFactory<>("right_name"));
		col_signup.setCellValueFactory(new PropertyValueFactory<>("mem_join_date"));

		data = FXCollections.observableArrayList(list);

		table_view.setItems(data);

		// 페이징 셋팅
		itemsForPage = 11; // 한페이지 보여줄 항목 수 설정
		// 나머지가 0이면 몫의 값을 페이지로 사용 ,, 0이 아니면 몫값 + 1 페이지로 사용
		int totPageCount = data.size() % itemsForPage == 0 ? data.size() / itemsForPage
				: data.size() / itemsForPage + 1;
		pages.setPageCount(totPageCount); // 전체 페이지 수 설정

		// 방법3(메서드 참조)
		// =>하나의 메서드만 호출하는 람다식은
		// '클래스이름::메서드이름' 또는 '참조변수::메서드이름' 으로 바꿀 수 있다.
		pages.setPageFactory(this::createPage); // 메서드 참조

		// 콤보박스 아이템 초기화 서치

		ObservableList<Scombo> list_combo1 = FXCollections.observableArrayList(new Scombo("아이디", 1),
				new Scombo("호수", 2), new Scombo("기수", 3), new Scombo("등급", 4));

		select_search.setItems(list_combo1);
		select_search.setValue(list_combo1.get(0));

		// 콤보박스 아이템 초기화 서치

		ObservableList<Scombo> list_combo2 = FXCollections.observableArrayList(new Scombo("관리자", 1),
				new Scombo("반장", 2), new Scombo("활동정지", 3),
				new Scombo("회원", 4), new Scombo("가입대기", 5),
				new Scombo("탈퇴회원", 6), new Scombo("도시락반장", 7),
				new Scombo("수료생", 8)
				);

		select_rightcode.setItems(list_combo2);
		select_rightcode.setValue(list_combo2.get(0));

		// 검색버튼 이벤트
		search_btn.setOnMouseClicked(e -> {

			search_method();

		});

		// 검색어 작성 후 엔터 이벤트
		txt_search.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {

				search_method();

			}
		});

		// 등급버튼 확인이벤트
		btn_right.setOnMouseClicked(e -> {

			rightcode();

		});

		
		// 기수변경 이벤트
		btn_degree.setOnMouseClicked(e ->{
			MemberVO member = (MemberVO) table_view.getSelectionModel().getSelectedItem();
			MemberVO vo = member;
			
			
			vo.setMem_id(member.getMem_id());
			vo.setMem_class(member.getMem_class());
			vo.setRight_code(member.getRight_code());
			
			
			
			vo.setDegree(txt_degree.getText());


			try {
				  Global.memberService.update_member_right(vo);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ShinYS.infoMsg("기수변경", "정상적으로 변경되었습니다");
			table_view.refresh();
			
		});
		
		
		// 호수변경 이벤트
		btn_class.setOnMouseClicked(e ->{
			MemberVO member = (MemberVO) table_view.getSelectionModel().getSelectedItem();
			MemberVO vo = member;
			
			
			
			vo.setMem_id(member.getMem_id());
			vo.setDegree(member.getDegree());
			vo.setRight_code(member.getRight_code());
			
			
			
			vo.setMem_class(txt_class.getText());


			try {
				  Global.memberService.update_member_right(vo);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ShinYS.infoMsg("호수변경", "정상적으로 변경되었습니다");
			table_view.refresh();
			
			
			
			
			
			
			
		});
		
		
		
		
		
		
		
		
		
		
		
	}// initialize 메서드 끝

	

	
	
	



	// 권한 기능
	public void rightcode() {

		MemberVO member = (MemberVO) table_view.getSelectionModel().getSelectedItem();

		MemberVO vo = member;

		String search = txt_search.getText();

		int select = select_rightcode.getSelectionModel().getSelectedItem().getValue();
		int parameter = 0;
		switch (select) {

		
		
		case 1: //관리자
			vo.setMem_id(member.getMem_id());
			vo.setRight_name("관리자");
			vo.setRight_code("1");

			try {
				parameter = Global.memberService.update_member_right(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table_view.refresh();
			break;
		case 2: //반장
			vo.setMem_id(member.getMem_id());
			vo.setRight_name("반장");
			vo.setRight_code("2");


			try {
				parameter = Global.memberService.update_member_right(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table_view.refresh();
			System.out.println(parameter);
			break;
		case 3: //활동정지
			vo.setMem_id(member.getMem_id());
			vo.setRight_name("활동정지회원");
			vo.setRight_code("3");

			try {
				parameter = Global.memberService.update_member_right(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table_view.refresh();
			System.out.println(parameter);
			break;
		case 4: //회원
			vo.setMem_id(member.getMem_id());
			vo.setRight_name("일반회원");
			vo.setRight_code("4");

			try {
				parameter = Global.memberService.update_member_right(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table_view.refresh();
			System.out.println(parameter);
			break;
		case 5: //가입대기
			vo.setMem_id(member.getMem_id());
			vo.setRight_name("가입대기자");
			vo.setRight_code("5");

			try {
				parameter = Global.memberService.update_member_right(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table_view.refresh();
			System.out.println(parameter);
			break;
		case 6: //탈퇴회원
			vo.setMem_id(member.getMem_id());
			vo.setRight_name("탈퇴회원");
			vo.setRight_code("6");
			
			try {
				parameter = Global.memberService.update_member_right(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table_view.refresh();
			System.out.println(parameter);
			break;
		case 7: //도시락반장
			vo.setMem_id(member.getMem_id());
			vo.setRight_name("도시락반장");
			vo.setRight_code("7");
			
			try {
				parameter = Global.memberService.update_member_right(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table_view.refresh();
			System.out.println(parameter);
			break;
		case 8: //수료생
			vo.setMem_id(member.getMem_id());
			vo.setRight_name("수료생");
			vo.setRight_code("8");
			
			try {
				parameter = Global.memberService.update_member_right(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table_view.refresh();
			System.out.println(parameter);
			break;
		}
		ShinYS.infoMsg("권한부여", "등급 변경 완료되었습니다");
		try {
			list = Global.memberService.select_MemberList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		

		
		try {
			list_search = Global.memberService.selectOne(search);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	// 검색기능 메서드
	public void search_method() {

		MemberVO vo = new MemberVO();

		String search = txt_search.getText();

		// 작성자로 검색

		int select = select_search.getSelectionModel().getSelectedItem().getValue();

		switch (select) {

		case 1:
			if(search.equals("")) {
				list_search = list;
				list_search = list_rightname;
			}else {
				try {
				list_search = Global.memberService.selectOne(search);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("서치내용 :" + list_search.get(0).getMem_id());
			data.clear();
			data.addAll(list_search);
			break;
		case 2:
			if(search.equals("")) {
				list_search = list;
				list_search = list_rightname;
			}else {
			try {
				list_search = Global.memberService.search_member_to_class(search);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			System.out.println("서치내용 :" + list_search.get(0).getMem_class());
			data.clear();
			data.addAll(list_search);

			break;
		case 3:
			if(search.equals("")) {
				list_search = list;
				list_search = list_rightname;
			}else {
			try {
				list_search = Global.memberService.search_member_to_degree(search);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			System.out.println("서치내용 :" + list_search.get(0).getDegree());
			data.clear();
			data.addAll(list_search);

			break;
		case 4:
			//관리자용 회원검색(회원 등급명으로 검색)
			if(search.equals("")) {
				list_search = list;
				list_search = list_rightname;
			}else {
			try {
				list_search = Global.memberService.search_adminUse_memberRight(search);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			System.out.println("list_search" + list_search.get(0).getRight_name());

			data.clear();
			data.addAll(list_search);
			break;
		}

		itemsForPage = 11; // 한페이지 보여줄 항목 수 설정
		// 나머지가 0이면 몫의 값을 페이지로 사용 ,, 0이 아니면 몫값 + 1 페이지로 사용
		int totPageCount = list_search.size() % itemsForPage == 0 ? list_search.size() / itemsForPage
				: list_search.size() / itemsForPage + 1;

		if (list_search.size() < 1) {
			totPageCount = 1;
		}

		pages.setPageCount(totPageCount); // 전체 페이지 수 설정

		// 방법2(람다식)
		pages.setPageFactory((Integer pageIndex) -> {

			from = pageIndex * itemsForPage;
			to = from + itemsForPage - 1;
			table_view.setItems(getTableViewData2(from, to, list_search));

			return table_view;
		}); // 페이징처리를 위한 팩토리 메서드 설정

	}

	/**
	 * 페이징 처리를 위한 팩토리 메서드(메서드 참조용)
	 * 
	 * @param pageIndex
	 * @return
	 */
	private Node createPage(int pageIndex) {

		from = pageIndex * itemsForPage;
		to = from + itemsForPage - 1;

		table_view.setItems(getTableViewData(from, to));

		return table_view;
	}

	/**
	 * TableView에 채워줄 데이터를 가져오는 함수
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private ObservableList<MemberVO> getTableViewData(int from, int to) {

		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = data.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData.add(data.get(i));
		}

		return currentPageData;
	}

	private ObservableList<MemberVO> getTableViewData2(int from, int to, List<MemberVO> listvo) {

		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = listvo.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData.add(listvo.get(i));
		}

		return currentPageData;
	}

	// 검색 콤보박스 vo형식으로 만들어서 키값과 벨류값 연습
	public class Scombo {
		private String vis;
		private int value;

		public String toString() {
			return vis;
		}

		public Scombo(String vis, int value) {
			super();
			this.vis = vis;
			this.value = value;
		}

		public String getVis() {
			return vis;
		}

		public void setVis(String vis) {
			this.vis = vis;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
	

}
