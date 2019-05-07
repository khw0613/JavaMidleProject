package kr.or.ddit.basic.b_board.job;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Board_typeVO;
import library.Global;
import library.ShinYS;

public class Job_BoardController implements Initializable {
	
	Class<? extends Job_BoardController> B_class = getClass();

	@FXML
	TableView<BoardVO> table_view;
	@FXML
	TableColumn<BoardVO, String> col_b_no;
	@FXML
	TableColumn<BoardVO, String>  col_b_title;
	@FXML
	TableColumn<BoardVO, String>  col_b_writer;
	@FXML
	TableColumn<BoardVO, String>  col_b_date;
	@FXML
	TableColumn<BoardVO, String>  col_b_view;
	@FXML
	TextField search_fd;
	@FXML
	Button search_btn;
	@FXML
	Button write_btn;
	@FXML
	ComboBox<Scombo> select_combo;
	@FXML
	Pagination pages;
	
	
	

	ObservableList<BoardVO> data;
	List<BoardVO> list = null;

	int from, to, itemsForPage;
	ObservableList<BoardVO> currentPageData;
	List<Board_typeVO> board_type = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		

		try {
			board_type = Global.boarderService.select_OneBoardType(ShinYS.select_Board);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 테이블 뷰 컬럼연결

		col_b_no.setCellValueFactory(new PropertyValueFactory<>("board_no"));
		col_b_title.setCellValueFactory(new PropertyValueFactory<>("board_title"));
		col_b_writer.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		col_b_date.setCellValueFactory(new PropertyValueFactory<>("board_date"));
		col_b_view.setCellValueFactory(new PropertyValueFactory<>("board_view"));
		// 테이블 뷰 데이터베이스 연동
		// 취업게시판 타입 '4'번

		try {
			if(board_type.get(0).getBoard_level().equals("공통")) {
				list = Global.boarderService.select_boardList(board_type.get(0).getBoard_type());
				
			}else if(board_type.get(0).getBoard_type().equals("1")) {
				
				
				list = Global.boarderService.select_notice_post(ShinYS.query_Degree);	
				
			}
			else {
				list = Global.boarderService.select_boardList_degree(board_type.get(0).getBoard_type(), ShinYS.query_Degree);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	

		data = FXCollections.observableArrayList(list);
//		for (BoardVO a : data) {
//
//			
//			System.out.println(a.getBoard_date());
//			System.out.println(a.getBoard_view());
//		}

		table_view.setItems(data);

		// 페이징 셋팅
		itemsForPage = 10; // 한페이지 보여줄 항목 수 설정
		// 나머지가 0이면 몫의 값을 페이지로 사용 ,, 0이 아니면 몫값 + 1 페이지로 사용
		int totPageCount = data.size() % itemsForPage == 0 ? data.size() / itemsForPage
				: data.size() / itemsForPage + 1;
		pages.setPageCount(totPageCount); // 전체 페이지 수 설정

		// 방법3(메서드 참조)
		// =>하나의 메서드만 호출하는 람다식은
		// '클래스이름::메서드이름' 또는 '참조변수::메서드이름' 으로 바꿀 수 있다.
		 pages.setPageFactory(this::createPage); // 메서드 참조

		// 콤보박스 아이템 초기화

		ObservableList<Scombo> list_combo = FXCollections.observableArrayList(new Scombo("작성자", 1),
				new Scombo("글번호", 2), new Scombo("제목", 3), new Scombo("제목+내용", 4));

		select_combo.setItems(list_combo);
		select_combo.setValue(list_combo.get(0));

		// 검색버튼 이벤트
		search_btn.setOnMouseClicked(e -> {

			search_method();

		});

		// 검색어 작성 후 엔터 이벤트
		search_fd.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {

				search_method();

			}
		});

		// 테이블리스트 더블클릭 이벤트
		table_view.setOnMouseClicked(e -> {
			if (e.getClickCount() == 2) {

				try {
					BoardVO mem = (BoardVO) table_view.getSelectionModel().getSelectedItem();

					ShinYS.mem = mem;

					Global.boarderService.update_viewCount(mem.getBoard_no());

					// ShinYS.<AnchorPane>ChangePage(getClass(), "basic/b_board/Detail.fxml",
					// "#contents");
					ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "b_board/Detail.fxml", "#contents");

				} catch (Exception e2) {

				}
			}
		});

		// 작성창 불러오기
		if(board_type.get(0).getBoard_type().equals("1")) {
			
		if(ShinYS.login_memVO.getRight_code().equals("1") || ShinYS.login_memVO.getRight_code().equals("2")) {
			write_btn.setDisable(false);
			write_btn.setVisible(true);
		}else {
			write_btn.setDisable(true);
			write_btn.setVisible(false);
			
		}
		}
		write_btn.setOnAction(e -> {
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "b_board/Write.fxml", "#contents");
		});

	}// initialize 메서드 끝

	List<BoardVO> list_search = null;
	// 검색기능 메서드
	public void search_method() {

		BoardVO vo = new BoardVO();

		String search = search_fd.getText();

		// 작성자로 검색

		int select = select_combo.getSelectionModel().getSelectedItem().getValue();

		switch (select) {
		case 1:
			vo.setMem_id(search);
			vo.setBoard_type(board_type.get(0).getBoard_type());
			try {
				list_search = Global.boarderService.search_post_to_id(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("서치내용 :" + list_search.get(0).getBoard_contents());
			data.clear();
			data.addAll(list_search);
			break;
		case 2:
			vo.setBoard_no(search);
			try {
				list_search = Global.boarderService.search_post_to_no(vo.getBoard_no());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("서치내용 :" + list_search.get(0).getBoard_contents());
			data.clear();
			data.addAll(list_search);

			break;
		case 3:
			vo.setBoard_title(search);
			vo.setBoard_type(board_type.get(0).getBoard_type());
			try {
				list_search = Global.boarderService.search_post_to_title(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("서치내용 :" + list_search.get(0).getBoard_contents());
			data.clear();
			data.addAll(list_search);

			break;
		case 4:
			vo.setBoard_title(search);
			vo.setBoard_type(board_type.get(0).getBoard_type());
			try {
				list_search = Global.boarderService.search_post_to_title(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vo.setBoard_contents(search);
			try {
				list_search = Global.boarderService.search_post_to_titleAndcontents(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("서치내용 :" + list_search.get(0).getBoard_contents());
			data.clear();
			data.addAll(list_search);
			break;
		}

		
	

	

	itemsForPage = 7; // 한페이지 보여줄 항목 수 설정
	// 나머지가 0이면 몫의 값을 페이지로 사용 ,, 0이 아니면 몫값 + 1 페이지로 사용
	int totPageCount = list_search.size()%itemsForPage == 0 ? list_search.size()/itemsForPage : list_search.size()/itemsForPage + 1;
	
	 
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
	private ObservableList<BoardVO> getTableViewData(int from, int to) {

		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = data.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData.add(data.get(i));
		}

		return currentPageData;
	}

	private ObservableList<BoardVO> getTableViewData2(int from, int to, List<BoardVO> listvo) {

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
