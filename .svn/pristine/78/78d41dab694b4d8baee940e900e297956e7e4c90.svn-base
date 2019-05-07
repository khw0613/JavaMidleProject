package kr.or.ddit.basic.c_dashboard;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import kr.or.ddit.basic.Main;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_boardVO;
import kr.or.ddit.ibatis.vo.memberVO.AttendanceVO;
import kr.or.ddit.ibatis.vo.restaurantVO.Resmenu_daysVO;
import library.Global;
import library.ShinYS;

public class member_homepage_Controller implements Initializable {

	// 간편 도시락
	@FXML
	Button btn_apply;

	// 대전도시락
	@FXML
	Label lb_d1;
	@FXML
	Label lb_d2;
	@FXML
	Label lb_d3;
	@FXML
	Label lb_d4;
	@FXML
	Label lb_d5;
	@FXML
	Label lb_d0;

	// 토마토
	@FXML
	Label lb_t5;
	@FXML
	Label lb_t4;
	@FXML
	Label lb_t3;
	@FXML
	Label lb_t2;
	@FXML
	Label lb_t1;
	@FXML
	Label lb_t0;
	@FXML
	Label lb_time;

	// 방명록 쓰는 테이블과 구성요소들
	@FXML
	TableView<Persnal_boardVO> tb_visitdiary; // 방명록리스트 나오는 테이블
	@FXML
	TableColumn<Persnal_boardVO, String> tbc_no; // 게시번호
	@FXML
	TableColumn<Persnal_boardVO, String> tbc_writer; // 작성자
	@FXML
	TableColumn<Persnal_boardVO, String> tbc_contents; // 내용
	@FXML
	TableColumn<Persnal_boardVO, String> tbc_date; // 날짜
	@FXML
	Pagination fx_page; // 페이지 설정
	@FXML
	TextField txt_contents; // 방명록에 쓸 내용 쓰는곳
	@FXML
	Button btn_write; // 클릭시 내용이 업로드
	@FXML
	Button btn_delete; // 게시글 클릭후 삭제시 삭제

	// 개인 게시판 구성요소
	@FXML
	TableView<Persnal_boardVO> tb_p_board; // 개인 게시판 테이블
	@FXML
	TableColumn<Persnal_boardVO, String> tbc_p_no; // 게시판 번호
	@FXML
	TableColumn<Persnal_boardVO, String> tbc_p_writer;// 게시판 작성자
	@FXML
	TableColumn<Persnal_boardVO, String> tbc_p_title; // 게시판 제목
	@FXML
	TableColumn<Persnal_boardVO, String> tbc_p_date; // 게시판 날짜
	@FXML
	TableColumn<Persnal_boardVO, String> tbc_p_views; // 게시판 조회수
	@FXML
	Pagination p_board_page; // 페이지 설정
	@FXML
	Button btn_writeboard; // 클릭시 글작성 화면 띄우기
	@FXML
	Button tbc_p_write;
	@FXML
	AnchorPane p_board; // 개인 게시판글작성 화면 띄우고싶은데 안됨...ㄷㄷ

	ObservableList<Map<String, String>> data;
	ObservableList<Persnal_boardVO> data1; // 방명록 데이터 저장
	ObservableList<Persnal_boardVO> data2; // 개인 게시판 데이터 저장
	List<Resmenu_daysVO> res_list = null;

	List<Persnal_boardVO> list = null;

	int from, to, itemsForPage, itemsForPage1, totPageCount, totPageCount1;
	ObservableList<Persnal_boardVO> currentPageData;
	ObservableList<Persnal_boardVO> currentPageData1;

	// 출석 메인보드 부분
	@FXML
	HBox attendance_hbox;

	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	String day = "";

	Button[] btn = new Button[7];

	Scene scene = null;
	Label label = null;
	List<AttendanceVO> attendance_list = new ArrayList<>();
	List<String> attenList = new ArrayList<>();

	AnchorPane[] hbox = new AnchorPane[7];

	String[] date = new String[7];

	// =================================
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// 도시락==============================================================
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		Date currentTime = new Date();
		String mTime = mSimpleDateFormat.format(currentTime);

		// System.out.println(mTime.replaceAll("[.]", ""));

		lb_time.setText(mTime);

		// 대전 도시락 출력
		Resmenu_daysVO res_vo = new Resmenu_daysVO();
		res_vo.setRes_order_date(mTime.replaceAll("[.]", ""));
		res_vo.setRes_no("a001");

		try {
			res_list = Global.resMenuService.select_RestaurantmenuList_day(res_vo);
		} catch (RemoteException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		if (res_list.size() != 0) {
			lb_d0.setText(res_list.get(0).getMenu_soup());
			lb_d1.setText(res_list.get(0).getMenu_1());
			lb_d2.setText(res_list.get(0).getMenu_2());
			lb_d3.setText(res_list.get(0).getMenu_3());
			lb_d4.setText(res_list.get(0).getMenu_4());
			lb_d5.setText(res_list.get(0).getMenu_5());
		}
		// 토마토 도시락 출력

		Resmenu_daysVO res_vo1 = new Resmenu_daysVO();
		res_vo1.setRes_order_date(mTime.replaceAll("[.]", ""));
		res_vo1.setRes_no("a002");

		try {
			res_list = Global.resMenuService.select_RestaurantmenuList_day(res_vo1);

		} catch (RemoteException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		if (res_list.size() != 0) {
			lb_t0.setText(res_list.get(0).getMenu_soup());
			lb_t1.setText(res_list.get(0).getMenu_1());
			lb_t2.setText(res_list.get(0).getMenu_2());
			lb_t3.setText(res_list.get(0).getMenu_3());
			lb_t4.setText(res_list.get(0).getMenu_4());
			lb_t5.setText(res_list.get(0).getMenu_5());
		}

		// 신청하기버튼
		btn_apply.setOnMouseClicked(e -> {
			Label setTitle = (Label) Main.StageHome.getScene().getRoot().lookup("#dash_title_txt");
			setTitle.setText("도시락 주문");
			
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "f_lunchbox/Lunchbox_date.fxml", "#contents");

			// 카테고리 추가
			List<Button> catels = new ArrayList<>();
			Button test1 = new Button("주문하기");
			Button test2 = new Button("환불하기");

			catels.add(test1);
			catels.add(test2);
			ShinYS.categoryOpen(catels);
						
		});

		// 재우형 여기서 간편출석로직 짜시면되요

		GridPane gridPane = new GridPane();

		gridPane.setPrefSize(427, 60);
		gridPane.setLayoutX(0);
		gridPane.setLayoutY(0);

		//회원 월별 출석 가져오기
		//List<AttendanceVO> ;
		try {
			//attendance_list = Global.attendanceService.select_AttendanceInfo(ShinYS.query_id);
			
			AttendanceVO vo = new AttendanceVO();
			vo.setDays_date(mTime.replaceAll("[.]", "").substring(0, 6));
			vo.setMem_id(ShinYS.query_id);
			attendance_list = Global.attendanceService.select_MonthAttendanceInfo(vo);
			
			

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int k = 0; k < attendance_list.size(); k++) {
			String sub = attendance_list.get(k).getDays_date();

			attenList.add(sub.substring(8, 10));

		}

		for (int i = 0; i < btn.length; i++) {

			
			hbox[i] = new AnchorPane();

			btn[i] = new Button();
			btn[i].setAlignment(Pos.TOP_LEFT);
			btn[i].setStyle("-fx-border-color:#515663;");
			btn[i].getStyleClass().add("dashAtten");
			gridPane.setStyle("-fx-border-color:#515663; -fx-border-weight:1");
			btn[i].setPrefSize(61, 60);
			hbox[i].setPrefSize(61, 60);

			hbox[i].getChildren().add(btn[i]);
			gridPane.add(hbox[i], i, 1);
			

		}
		displayDate();

		attendance_hbox.getChildren().add(gridPane);

		// =================================

		tb_visitdiary.refresh();
		try {
			list = Global.persnalBoardService.select_guestBook(ShinYS.query_id);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try {
			list = Global.persnalBoardService.select_guestBook(ShinYS.query_id);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

		tbc_no.setCellValueFactory(new PropertyValueFactory<Persnal_boardVO, String>("pb_guestbook_no"));
		tbc_writer.setCellValueFactory(new PropertyValueFactory<Persnal_boardVO, String>("mem_id"));
		tbc_contents.setCellValueFactory(new PropertyValueFactory<Persnal_boardVO, String>("pb_contents"));
		tbc_date.setCellValueFactory(new PropertyValueFactory<Persnal_boardVO, String>("pb_date"));

		data1 = FXCollections.observableArrayList(list);

		tb_visitdiary.setItems(data1);

		itemsForPage = 4; // 한페이지 보여줄 항목 수 설정
		p_visit_paging();

		btn_write.setDisable(true);
		txt_contents.setDisable(true);

		// 삭제하기
		btn_delete.setOnAction(e -> {

			int p_gb = 0;
			try {

				p_gb = Global.persnalBoardService
						.delete_PersnalBoard_post((tb_visitdiary.getSelectionModel().getSelectedItem().getPb_no()));
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			tb_visitdiary.getItems().removeAll(tb_visitdiary.getSelectionModel().getSelectedItems());

			System.out.println(p_gb);

			tb_visitdiary.refresh();

		});

		// 개인 게시판 테이블
		tb_p_board.refresh();
		try {

			list = Global.persnalBoardService.select_PersnalBoardList(ShinYS.query_id);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

		tbc_p_no.setCellValueFactory(new PropertyValueFactory<Persnal_boardVO, String>("pb_post_no"));
		tbc_p_writer.setCellValueFactory(new PropertyValueFactory<Persnal_boardVO, String>("mem_id"));
		tbc_p_title.setCellValueFactory(new PropertyValueFactory<Persnal_boardVO, String>("pb_title"));
		tbc_p_date.setCellValueFactory(new PropertyValueFactory<Persnal_boardVO, String>("pb_date"));
		tbc_p_views.setCellValueFactory(new PropertyValueFactory<Persnal_boardVO, String>("pb_view"));

		data2 = FXCollections.observableArrayList(list);

		tb_p_board.setItems(data2);

		// 페이징 셋팅
		itemsForPage1 = 5; // 한페이지 보여줄 항목 수 설정
		p_board_paging();

		// 더블클릭시 상세보기화면

		tb_p_board.setOnMouseClicked(e1 -> {
			if (e1.getClickCount() == 2) {
				// ShinYS.ChangePage(getClass(), "/b_board/Detail.fxml", "#p_board");
				Persnal_boardVO pVo = tb_p_board.getSelectionModel().getSelectedItem();
				ShinYS.p_vo = pVo;

				// 조회수 들어가는 로직
				try {
					Global.persnalBoardService.update_PostViewCount(pVo.getPb_no());
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				ShinYS.ChangePage(getClass(), Global.RootDir + "c_dashboard/c_Detail.fxml", "#contents");

				// list.add(tb_p_board.getSelectionModel().getSelectedItem());

				// ShinYS.infoMsg("18", "msg");

				System.out.println("더블클릭시");
			}
		});

		// 글작성 버튼
		tbc_p_write.setOnAction(e -> {

			ShinYS.ChangePage(getClass(), Global.RootDir + "/c_dashboard/c_Write.fxml", "#contents");

		});

	}

	private ObservableList<Persnal_boardVO> getTableViewData(int from, int to) {

		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = data1.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData.add(data1.get(i));
		}

		return currentPageData;
	}

	private ObservableList<Persnal_boardVO> getTableViewData1(int from, int to) {

		currentPageData1 = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = data2.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData1.add(data2.get(i));
		}

		return currentPageData1;
	}

	private void p_visit_paging() {
		totPageCount = data1.size() % itemsForPage == 0 ? data1.size() / itemsForPage : data1.size() / itemsForPage + 1;

		fx_page.setPageCount(totPageCount); // 전체 페이지 수 설정

		fx_page.setPageFactory((Integer pageIndex) -> {

			from = pageIndex * itemsForPage;
			to = from + itemsForPage - 1;
			tb_visitdiary.setItems(getTableViewData(from, to));

			return tb_visitdiary;
		});
	}

	private void p_board_paging() {
		totPageCount1 = data2.size() % itemsForPage1 == 0 ? data2.size() / itemsForPage1
				: data2.size() / itemsForPage1 + 1;

		p_board_page.setPageCount(totPageCount1); // 전체 페이지 수 설정

		p_board_page.setPageFactory((Integer pageIndex) -> {

			from = pageIndex * itemsForPage1;
			to = from + itemsForPage1 - 1;
			tb_p_board.setItems(getTableViewData1(from, to));

			return tb_p_board;
		});
	}

	public void displayDate() {

		// 오늘 날짜 고정 최근7일계산하기

		int t_year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		int t_month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
		int t_day = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH);

		for (int i = 6; i >= 0; i--) {

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.set(t_year, t_month, t_day);

			t_day--;

			date[i] = sdf.format(cal.getTime()).replaceAll("[.]", "").substring(6, 8);

			btn[i].setText(date[i]);
			btn[i].setAccessibleText(date[i]);


			
			
			
			
//			FontAwesomeIcon font = new FontAwesomeIcon();
//			font.setIconName("FLAG");
//			font.setSize("3em");

			String temp_day = btn[i].getText();

			for (String ss : attenList) {

				if (temp_day.length() == 1) {
					temp_day = "0" + temp_day;
				}
				

				if (ss.equals(temp_day)) {

					
					
					/* 도장찍기 */
					ImageView imb = new ImageView("image/check.png");
					imb.setMouseTransparent(true);
					imb.setFitWidth(35);
					imb.setFitHeight(35);
					imb.setTranslateY(19);
					imb.setTranslateX(19);
					imb.setId("ddsz");
					imb.setAccessibleText("order_cell");
			
					
					
					////////////////
					
					
					ShinYS.temp = btn[i].getAccessibleText().toString();

//					Label label = new Label("", font);
//					label.setScaleX(0);
//					label.setScaleY(0);

//					ScaleTransition ggg = new ScaleTransition(Duration.millis(5000), label);
//					ggg.setFromX(0);
//					ggg.setFromY(0);
//					ggg.setToX(1);
//					ggg.setToY(1);
//					ggg.setDelay(Duration.millis(1500));
					// label.setLayoutX(30);
					// label.setLayoutY(30);


					hbox[i].getChildren().add(imb);
					//ggg.play();

				}
			}

			btn[i].setOnMouseClicked(e -> {
				Button btn_select_get = (Button) e.getSource();


					ShinYS.attendance_day = btn_select_get.getText();
					
					
					ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "i_attendance/Attendance.fxml",
							"#contents");



			});

		}

	}

}
