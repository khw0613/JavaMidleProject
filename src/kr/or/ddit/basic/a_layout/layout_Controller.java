package kr.or.ddit.basic.a_layout;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.GenericStyledArea;
import org.fxmisc.richtext.StyledTextArea;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import kr.or.ddit.basic.Main;
import kr.or.ddit.basic.g_messenger.ChatSystemClient;
import kr.or.ddit.ibatis.vo.communityVO.MessageBoxVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;

public class layout_Controller implements Initializable {

	String myLogId = "";

	// 위쪽 부분 fx id
	@FXML
	JFXButton btn_logo; // 로고 클릭시 메인으로
	@FXML
	JFXButton btn_jobboard; // 클릭시 취업게시판으로
	@FXML
	JFXButton btn_freeboard; // 클릭시 자유게시판으로
	@FXML
	JFXButton btn_sourceboard; // 클릭시 오픈소스 게시판으로
	@FXML
	JFXButton btn_faqboard; // 클릭시 FAQ게시판으로
	@FXML
	JFXButton btn_openchat; // 클릭시 메신저창 오픈

	// 왼쪽 메뉴 fx id

	@FXML
	ImageView fx_imgageView; // 이미지뷰에 프로필 사진 삽입
	@FXML
	TextField txt_degreeNclass; // 기수/호수 출력
	@FXML
	JFXButton btn_showMyinfo; // 내정보 보기 버튼
	@FXML
	JFXButton btn_dashboard; // 대시보드 보기 버튼
	@FXML
	JFXButton btn_notice; // 공지사항 버튼
	@FXML
	JFXButton btn_woori; // 우리들 게시판
	@FXML
	JFXButton btn_studyboard; // 스터디게시판 버튼
	@FXML
	JFXButton btn_lunchbox; // 도시락주문 버튼
	@FXML
	JFXButton btn_highligherManage; // 형광펜관리 버튼
	@FXML
	JFXButton btn_logout; // 로그아웃 버튼

	@FXML
	AnchorPane dashmain; // 화면 바뀌는 pane (애니메이션용)
	@FXML
	AnchorPane open_chatpane; // 메신져창 열리는 pane

	// 레이아웃
	@FXML
	AnchorPane left_menu;
	@FXML
	AnchorPane main2;
	@FXML
	AnchorPane background;
	@FXML
	AnchorPane top;
	@FXML
	AnchorPane contents; // 컨텐츠 영역
	@FXML
	ScrollPane con_scroll;

	double cnt = 2.0; // 화면전환변수
	Double d_left_width; // 좌측 메뉴 사이즈 저장

	// // 오픈채팅방
	@FXML
	ComboBox<String> cmb_search; // 콤보박스에 이름,기수, 호수로 검색할꺼임
	@FXML
	TextField txt_searchField; // 검색할 내용 적는곳
	@FXML
	Button btn_search; // 검색 버튼
	// @FXML TextArea area_memlist; // 회원목록 나오는 곳
	@FXML
	AnchorPane area_chat; // 채팅내용 나오는 곳
	@FXML
	TextField txt_chat; // 채팅내용 적는곳
	@FXML
	Button btn_send; // 보내기 버튼
	@FXML
	ScrollPane log_window; // 로그 윈도우
	@FXML
	AnchorPane log_window_list; // 로그 윈도우 리스트

	// 쪽지함

	@FXML
	FontAwesomeIcon btn_message; // 쪽지함 버튼

	@FXML
	JFXButton btn_Attendance; // 출석현황

	@FXML
	AnchorPane main_avator; // 아바타
	@FXML
	ImageView avator_img;

	@FXML
	AnchorPane dash_title; // 메뉴 타이틀 판
	@FXML
	Label dash_title_txt; // 메뉴 타이틀
	@FXML
	AnchorPane dash_cate; // 카테고리 판
	@FXML
	HBox dash_cate_item; // 카테고리 메뉴 놓을 박스

	@FXML
	Label btn_highligherTop; // 형광펜버튼 상단

	@FXML
	Label profile_id; // 프로필 - 아이디
	@FXML
	Label profile_name; // 프로필 - 이름 (등급)
	@FXML
	Label profile_num; // 프로필 - 기수 (호수)

	ObservableList<MemberVO> mem_list; // 검색창에 넣을 기수, 호수, 이름
	MemberVO vo;
	// 쪽지함 객체 스택틱 선언
	public static Stage message = null;

	// 메신저 기본 좌표설정
	int default_x;
	@FXML
	AnchorPane anchor_message;

	@FXML
	ImageView img_message;

	@FXML ImageView btn_left_img;

	@FXML TextArea refresh_chat;

	// public boolean cate_test = false;

	// int after_y = (int) anchor_message.getTranslateY();//메시지알림 이동

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		CodeArea ca = new CodeArea();
		ca.getStyleClass().add("area_chat0");
		ca.setPrefSize(310, 319);
		ca.setWrapText(true);
		
		ca.replaceText(0,0,"#채팅방에 입장하였습니다.\n");	//기본 텍스트
		ca.setStyleClass(0, 13, "sys_yellow");

		VirtualizedScrollPane<CodeArea> dsds = new VirtualizedScrollPane<CodeArea>(ca);
		dsds.getStyleClass().add("gogogo");
		area_chat.getChildren().add(dsds);
		
		
		//회원접속 나갈시 회원목록 새로고침
		refresh_chat.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				log_window_list.getChildren().clear();
				log_window_chat();
			}
		});
		 
		
		
		btn_left_img.setVisible(false); //뒤로가기 버튼 감추기
		//area_chat.setWrapText(true);

		// 프로필 초기화
		profile_id.setText(ShinYS.login_memVO.getMem_id());
		profile_name.setText(ShinYS.login_memVO.getMem_name() + " (" + ShinYS.login_right_name + ")");
		profile_num.setText(ShinYS.login_memVO.getDegree() + " (" + ShinYS.login_memVO.getMem_class() + ")");

		// 화면전환 - 체인지리스트 생성
		ListChangeListener<Node> childrenChanged = new ListChangeListener<Node>() {

			@Override
			public void onChanged(Change<? extends Node> c) {
				c.next();
				if (c.getTo() == 0) {
					ShinYS.categoryClose();
				}

			}
		};

		// 컨텐츠 부분 체인지리스너 추가
		contents.getChildren().addListener(childrenChanged);

		// 카테고리 숨기기
		dash_cate.setVisible(false);

		// 아바타 삐져나오는 부분 자르기
		Circle cc = new Circle(35, 35, 35);
		avator_img.setClip(cc);

		// 아바타 배경색 지정
		main_avator.setStyle(main_avator.getStyle());
		System.out.println(main_avator.getStyle());
		main_avator.setStyle("-fx-background-color:" + ShinYS.avator_map.get(ShinYS.login_memVO.getAvatar())
				+ "; -fx-background-radius:50;");

		// 아바타에 사진 넣기
		if (ShinYS.login_memVO.getMem_image() != null) {

			Image user_image = new Image(ShinYS.login_memVO.getMem_image(), 100, 100, false, false);

			avator_img.setImage(user_image);
			// avator_img.setPreserveRatio(true);

		} else {
			Image user_image = new Image("image/avator.png");

			avator_img.setImage(user_image);
		}

		// main_avator.setClip(new Rectangle(400,277));
		// ==============윤상호==================
		// 검색에 "상호" 검색

		// =====================================

		// ===============한상호=================
		// 검색에 "hsh" 검색

		cmb_search.getItems().addAll("기수", "호수", "이름");
		cmb_search.setValue("기수");

		btn_search.setOnMouseClicked(e -> {

			try {
				mem_list = (ObservableList<MemberVO>) Global.memberService.select_MemberList();
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			if (txt_searchField.getText().equals(mem_list.get(0).getDegree())) {

			}

		});

		// =====================================

		d_left_width = left_menu.getPrefWidth();
		init_setup();
		init_animate();

		// 출석현황
		btn_Attendance.setOnMouseClicked(e -> {

			 set_Title(e);

			/*
			 * contents.getChildren().clear(); Attendance_Controller aa = new
			 * Attendance_Controller(); AnchorPane test = aa.start();
			 * contents.getChildren().add(test);
			 */
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "i_attendance/Attendance.fxml", "#contents");

		});

		// 쪽지 알람창 시작~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		// 로고
		btn_logo.setOnMouseClicked(e -> {
			
			ShinYS.visBack(false);
			
			Button click_btn = (Button) e.getSource();
			dash_title_txt.setText("대시보드");
			init_main(0);

			try {
				if (Global.messageBoxService.select_allUnreadMessage(ShinYS.query_id).size() > 0) {

					Timeline tl = new Timeline();
					tl.setAutoReverse(true);
					tl.setCycleCount(2);

					KeyFrame key_a1 = new KeyFrame(new Duration(0),
							new KeyValue(anchor_message.translateYProperty(), 0));
					KeyFrame key_a2 = new KeyFrame(new Duration(4000),
							new KeyValue(anchor_message.translateYProperty(), -250));

					tl.getKeyFrames().add(key_a1);
					tl.getKeyFrames().add(key_a2);
					tl.play();

					img_message.setOnMouseClicked(e1 -> {
						String pramId = "";
						try {
							pramId = ShinYS.query_id;
							message_box(pramId);
						} catch (Exception e11) {
							e11.printStackTrace();
						}

					});

				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		// 취업게시판
		btn_jobboard.setOnMouseClicked(e -> {
			set_Title(e);
			board_list(btn_jobboard);
		});

		// 자유게시판
		btn_freeboard.setOnMouseClicked(e -> {
			set_Title(e);
			board_list(btn_freeboard);

		});

		// 소스게시판
		btn_sourceboard.setOnMouseClicked(e -> {
			set_Title(e);
			board_list(btn_sourceboard);
		});

		// faq게시판
		btn_faqboard.setOnMouseClicked(e -> {
			set_Title(e);
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "j_chatbot/faq_layout.fxml", "#contents");
		});

		// 공지사항
		btn_notice.setOnMouseClicked(e -> {
			set_Title(e);
			board_list(btn_notice);
		});

		// 우리들 게시판
		btn_woori.setOnMouseClicked(e -> {
			set_Title(e);
			board_list(btn_woori);
		});

		// 스터디게시판
		btn_studyboard.setOnMouseClicked(e -> {
			set_Title(e);
			board_list(btn_studyboard);
		});

		// 도시락
		btn_lunchbox.setOnMouseClicked(e -> {

			set_Title(e);
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "f_lunchbox/Lunchbox_date.fxml", "#contents");

			// 카테고리 추가
			List<Button> catels = new ArrayList<>();
			Button test1 = new Button("주문하기");
			Button test2 = new Button("환불하기");

			catels.add(test1);
			catels.add(test2);
			ShinYS.categoryOpen(catels);

		});

		// 상단 형관펜 버튼 클릭이벤트
		btn_highligherTop.setOnMouseClicked(e -> {
			//Label click_btn = (Label) e.getSource();
			dash_title_txt.setText("형광펜 관리");
			highlighter_method(e);
		});

		// 형광펜
		btn_highligherManage.setOnMouseClicked(e -> {
			//Button click_btn = (Button) e.getSource();
			dash_title_txt.setText("형광펜 관리");
			highlighter_method(e);
		});

		// 내정보 보기 버튼 액션 만들기
		btn_showMyinfo.setOnAction(e -> {

			ShinYS.visBack(false);
			
			// set_Title(e);

			Button click_btn = (Button) e.getSource();
			dash_title_txt.setText(click_btn.getText());

			try {
				AnchorPane board;
				board = FXMLLoader.load(getClass().getResource("../d_member/mypage/showMyinfo.fxml"));

				// 회원탈퇴 후 화면전환시키기
				Button testbutton = (Button) board.lookup("#btn_outjoin");
				testbutton.textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						init_animate();
					}
				});

				contents.getChildren().clear();
				contents.getChildren().setAll(board);

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});

		btn_logout.setOnAction(e -> {
			init_animate();
			// 밑으로 옮겨놓음
			// try {
			// Global.logWindowService.delete_LogInfo(ShinYS.query_id);
			// } catch (RemoteException e1) {
			//
			// e1.printStackTrace();
			// }
		});

		// 쪽지함 열기 [Yun.SH]
		btn_message.setOnMouseClicked(e -> {
			String pramId = "";
			try {
				pramId = ShinYS.query_id;
				message_box(pramId);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		default_x = (int) open_chatpane.getTranslateX();

		// 메신저 버튼
		btn_openchat.setOnAction(e -> {
			openchat_method();
		});

	}// 초기화 종료

	// 메신저 메소드
	public void openchat_method() {

		int after_width = (int) open_chatpane.getWidth();
		int after_x = (int) open_chatpane.getTranslateX();

		Timeline timeline = new Timeline();

		Duration duration = Duration.millis(200);

		KeyValue kv;
		if (default_x == after_x) {
			kv = new KeyValue(open_chatpane.translateXProperty(), after_x - after_width);
		} else {
			kv = new KeyValue(open_chatpane.translateXProperty(), after_x + after_width);
		}

		KeyFrame kf = new KeyFrame(duration, kv);

		timeline.getKeyFrames().add(kf);

		timeline.setOnFinished(j -> {
			System.out.println("이동완료");
		});

		timeline.play();
	}

	// 형광펜 버튼이벤트 메소드화
	public void highlighter_method(MouseEvent e) {
		// set_Title(e);
		ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "e_cash/highlighter_management.fxml", "#contents");

		// 카테고리 추가
		List<Button> catels = new ArrayList<>();
		Button test1 = new Button("형광펜 충전");
		Button test2 = new Button("형광펜 환전");
		Button test3 = new Button("형광펜 선물");

		catels.add(test1);
		catels.add(test2);
		catels.add(test3);
		ShinYS.categoryOpen(catels);
	}

	// 타이틀 셋팅
	public void set_Title(MouseEvent e) {
		Button click_btn = (Button) e.getSource();
		dash_title_txt.setText(click_btn.getText());

	}

	// (메신저) 로그인 리스트 출력 - 유수
		public void log_window_chat() {
			myLogId = ShinYS.query_Degree + "_" + ShinYS.login_memVO.getMem_name() + "(" + ShinYS.login_memVO.getMem_id()
					+ ")";

			List<MemberVO> idList = new ArrayList<MemberVO>();
			try {
				idList = Global.logWindowService.select_LogInfo();
			} catch (RemoteException e2) {
				e2.printStackTrace();
			}

			Label myLId = new Label();
			Label point = new Label();

			myLId.setText("나의 ID : " + myLogId);
			point.setText("===========현재 접속자==========");
			log_window_list.getChildren().add(myLId);
			point.setTranslateY(20);
			log_window_list.getChildren().add(point);

			double tY = 50;
			for (int i = 0; i < idList.size(); i++) {
				Label id = new Label();
				Label log_id = new Label();

				// ● ○
				String data1 = idList.get(i).getDegree() + "_" + idList.get(i).getMem_name() + "("
						+ idList.get(i).getMem_id() + ")";

				log_id.setText(" ● ");
				log_id.setTranslateY(tY);
				log_id.setStyle("-fx-text-fill:#4ea849");
				id.setText(data1);
				id.setId(idList.get(i).getMem_id());
				id.setTranslateX(20);
				id.setTranslateY(tY);
				id.setAccessibleText(idList.get(i).getMem_name());
				id.setCursor(Cursor.HAND);

				log_window_list.addEventHandler(MouseEvent.MOUSE_MOVED, h -> {
					id.setOnMouseClicked(e -> {

						// 회원클릭시 팝업창 띄우기
						Label getLa = (Label) e.getSource();
						ShinYS.guest_Id = getLa.getId();

						VBox newBack = new VBox();
						newBack.setTranslateX(h.getX() - 10);
						newBack.setTranslateY(h.getY() - 10);
						newBack.setStyle("-fx-background-color:#3D3F46; -fx-background-radius:20; ");
						newBack.setEffect(new DropShadow(10, 0, 0, Color.web("0xffffff",0.5)));
						newBack.setSpacing(5);

						Label lb1 = new Label(getLa.getAccessibleText() + "\n" + getLa.getId());
						lb1.setPrefSize(100, 60);
						lb1.setAlignment(Pos.CENTER);
						lb1.setStyle("-fx-background-color:#3D3F46;");
						lb1.setTextFill(Color.web("0xffffff", 1.0));
						newBack.setMargin(lb1, new Insets(0, 10, 0, 10));

						Button btn1 = new Button("방문하기");
						btn1.setPrefSize(100, 30);
						btn1.setCursor(Cursor.HAND);
						btn1.setStyle("-fx-background-color:#ffffff;");
						newBack.setMargin(btn1, new Insets(0, 10, 0, 10));

						Button btn2 = new Button("쪽지보내기");
						btn2.setPrefSize(100, 30);
						btn2.setCursor(Cursor.HAND);
						btn2.setStyle("-fx-background-color:#ffffff;");
						newBack.setMargin(btn2, new Insets(0, 10, 0, 10));

						Button btn3 = new Button("형광펜선물");
						btn3.setPrefSize(100, 30);
						btn3.setCursor(Cursor.HAND);
						btn3.setStyle("-fx-background-color:#ffffff;");
						newBack.setMargin(btn3, new Insets(0, 10, 25, 10));

						newBack.getChildren().addAll(lb1, btn1, btn2, btn3);
						log_window_list.getChildren().add(newBack);

						newBack.addEventHandler(MouseEvent.MOUSE_EXITED, f -> {
							log_window_list.getChildren().remove(newBack);
						});

						// 방문하기
						btn1.setOnMouseClicked(kk -> {
							ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "c_dashboard/visit_userhome.fxml",
									"#contents");
							openchat_method();

						});

						// 쪽지보내기
						btn2.setOnMouseClicked(kk -> {

							message = new Stage(StageStyle.DECORATED);
							message.initModality(Modality.APPLICATION_MODAL);
							message.initOwner(Main.StageHome);
							Parent parent = null;
							try {
								parent = FXMLLoader
										.load(getClass().getResource(Global.RootDir + "/g_messenger/send_message.fxml"));

								ComboBox combo_go = (ComboBox) parent.lookup("#send_id_list");
								combo_go.setValue(ShinYS.guest_Id);

							} catch (Exception e1) {
								e1.printStackTrace();
							}

							Scene scene = new Scene(parent);
							message.setTitle("Message Box");
							message.setScene(scene);
							message.show();
						});

						// 형광펜선물
						btn3.setOnMouseClicked(kk -> {

							Parent window1 = null;
							try {

								window1 = FXMLLoader
										.load(getClass().getResource(Global.RootDir + "/e_cash/highlighter_gift.fxml"));

								AnchorPane lay = (AnchorPane) Main.StageHome.getScene().getRoot().lookup("#contents");

								ComboBox combo_a = (ComboBox) window1.lookup("#gift_degree");

								List<MemberVO> lll = Global.memberService.selectOne(ShinYS.guest_Id);

								String get_guest_id = lll.get(0).getDegree() + "_" + lll.get(0).getMem_name() + "("
										+ lll.get(0).getMem_id() + ")";
								combo_a.setValue(get_guest_id);
								lay.getChildren().clear();
								lay.getChildren().setAll(window1);

								openchat_method();

							} catch (IOException e2) {
								e2.printStackTrace();
							}

						});

					});
				});

				tY += 20;
				log_window_list.getChildren().addAll(log_id,id);
			}
			log_window_list.setPrefHeight(tY+190);
			//

		}

		
		
		
	// 매세지 박스 열기
	public void message_box(String pramId) {
		System.out.println("Open Message Box : " + pramId);

		message = new Stage(StageStyle.DECORATED);
		message.initModality(Modality.APPLICATION_MODAL);
		message.initOwner(Main.StageHome);
		Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("../g_messenger/locker_message.fxml"));
			List<MessageBoxVO> list = Global.messageBoxService.select_MessageList();
			System.out.println(list.size());

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		Scene scene = new Scene(parent);
		message.setTitle("Message Box");
		message.setScene(scene);
		message.show();

	}

	// 열림 - 대시보드적용 (hsh)
	public void init_main(int select) {
		contents.setOpacity(0);

		try {

			AnchorPane board;
			board = FXMLLoader.load(getClass().getResource("../c_dashboard/member_homepage.fxml"));
			contents.getChildren().clear();
			contents.getChildren().setAll(board);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (select == 1) {
			log_window_list.getChildren().clear();
			log_window_chat(); // 로그인 리스트 호출 - 상호
			return;
		}

		FadeTransition dash_contents = new FadeTransition(Duration.millis(400), contents);
		dash_contents.setFromValue(0);
		dash_contents.setToValue(1);
		// left_children.setDelay(Duration.millis(1200));
		dash_contents.setOnFinished(f -> {
			log_window_list.getChildren().clear();
			log_window_chat(); // 로그인 리스트 호출 - 상호
		});
		dash_contents.play();

	}

	// 닫힘
	public void init_main_close() {
		FadeTransition dash_contents = new FadeTransition(Duration.millis(300), contents);
		dash_contents.setFromValue(1);
		dash_contents.setToValue(0);
		// left_children.setDelay(Duration.millis(1200));
		dash_contents.play();

		dash_contents.setOnFinished(e -> {
			// contents.getChildren().clear();
		});

	}

	// 게시판 번호저장 및 이동
	void board_list(JFXButton button) {
		ShinYS.visBack(false);
		
		ShinYS.select_Board = button.getText();

		try {
			AnchorPane board;
			board = FXMLLoader.load(getClass().getResource("../b_board/Board.fxml"));
			contents.getChildren().clear();
			contents.getChildren().setAll(board);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	void init_setup() {
		// left_menu.setPrefWidth(main.getPrefWidth());
		// dashmain.setLayoutY(main.getPrefHeight());
		// top.setLayoutY(-(top.getPrefHeight()+4));
	}

	void init_animate() {

		left_menu.setPrefWidth(main2.getPrefWidth());
		dashmain.setLayoutY(main2.getPrefHeight());
		dash_title.setLayoutY(main2.getPrefHeight());
		top.setLayoutY(-(top.getPrefHeight()));

		// open_chatpane.translateXProperty().set(open_chatpane.getTranslateX());

		List<Animation> ani = new ArrayList<>(5);

		Duration duration = Duration.millis(1200);

		// 좌측메뉴
		Timeline t_left = new Timeline();

		KeyValue kv_left = new KeyValue(left_menu.prefWidthProperty(), d_left_width, Interpolator.EASE_IN);
		KeyFrame kf_left = new KeyFrame(Duration.millis(1200), kv_left);
		t_left.getKeyFrames().add(kf_left);

		// 컨텐츠
		Timeline t_content = new Timeline();
		KeyValue kv_dashmain = new KeyValue(dashmain.layoutYProperty(),
				top.getPrefHeight() + dash_title.getPrefHeight(), Interpolator.EASE_OUT);
		KeyFrame kf_dashmain = new KeyFrame(Duration.millis(1000), kv_dashmain);
		t_content.getKeyFrames().add(kf_dashmain);

		// 타이틀
		KeyValue kv_title = new KeyValue(dash_title.layoutYProperty(), top.getPrefHeight(), Interpolator.EASE_OUT);
		KeyFrame kf_title = new KeyFrame(Duration.millis(1000), kv_title);
		t_content.getKeyFrames().add(kf_title);

		// 상단메뉴
		TranslateTransition a_top = new TranslateTransition(Duration.millis(700), top);
		a_top.setFromY(-(top.getPrefHeight() + 4));
		a_top.setToY(top.getPrefHeight());
		// a_top.setAutoReverse(true); //자동반전
		// a_top.setCycleCount(Animation.INDEFINITE); //반복

		// a_top.setInterpolator(Interpolator.LINEAR)
		a_top.setAutoReverse(true);
		t_left.setAutoReverse(true);
		t_content.setAutoReverse(true);

		if (cnt == 1.0) {
			cnt = 2.0;

			init_main_close();

			// 메신저 감추기
			FadeTransition open_right = new FadeTransition(Duration.millis(600), open_chatpane);
			open_right.setFromValue(1.0);
			open_right.setToValue(0);
			open_right.play();

			a_top.setCycleCount(2);
			t_left.setCycleCount(2);
			t_content.setCycleCount(2);

			a_top.setDuration(Duration.millis(500));
			a_top.jumpTo(Duration.millis(500));
			t_left.jumpTo(Duration.millis(1200));
			t_content.jumpTo(Duration.millis(1000));

			// 왼쪽메뉴 감추기
			ObservableList<Node> sample = left_menu.getChildren();
			for (Node gg : sample) {
				FadeTransition left_children = new FadeTransition(Duration.millis(1200), gg);
				left_children.setFromValue(1);
				left_children.setToValue(0);
				// left_children.setDelay(Duration.millis(1200));
				left_children.play();
			}

			// 탑메뉴 감추기
			ObservableList<Node> sample2 = top.getChildren();
			for (Node gg : sample2) {
				FadeTransition left_children = new FadeTransition(Duration.millis(1200), gg);
				left_children.setFromValue(1);
				left_children.setToValue(0);
				// left_children.setDelay(Duration.millis(1600));
				left_children.play();

			}

			// 로그인정보 초기화
			TextField get_txt_id = (TextField) Main.StageHome.getScene().getRoot().lookup("#txt_id");
			PasswordField get_txt_pw = (PasswordField) Main.StageHome.getScene().getRoot().lookup("#txt_password");
			get_txt_id.setText("");
			get_txt_pw.setText("");

			// 로그인화면 보여주기
			Main.StageHome.getScene().getRoot().lookup("#layout_module").toBack();
			FadeTransition login_animate = new FadeTransition(Duration.millis(1000),
					Main.StageHome.getScene().getRoot().lookup("#login_module"));
			login_animate.setFromValue(0);
			login_animate.setToValue(1);
			login_animate.setOnFinished(e -> {

				AnchorPane lm = (AnchorPane) Main.StageHome.getScene().getRoot().lookup("#layout_module");
				lm.getChildren().clear();
				Main.StageHome.getScene().getRoot().lookup("#layout_module").setStyle("-fx-background-color:#3D3F46;");

			});
			login_animate.setDelay(Duration.millis(900));

			login_animate.setOnFinished(f -> {
				try {
					// 로그인 db삭제
					Global.logWindowService.delete_LogInfo(ShinYS.query_id); 
					//오픈채팅 종료
					ShinYS.chatClient.clientStop();
					
				} catch (RemoteException e1) {

					e1.printStackTrace();
				}
			});
			login_animate.play();

		} else {
			cnt = 1.0;
			a_top.setCycleCount(1);
			t_left.setCycleCount(1);
			t_content.setCycleCount(1);
			a_top.setDelay(Duration.millis(1200));
			t_left.setDelay(Duration.millis(300));
			t_content.setDelay(Duration.millis(800));
			a_top.setOnFinished(e -> {
				// 애니메이션 끝나고 동작-> 재우
				// 출석이벤트호출
				// if(ShinYS.event_count == 1) {
				// Attendance_event();
				// ShinYS.event_count--;
				// }
				// System.out.println("asdas");
				

				//	채팅클라이언트 ON
				Platform.runLater(new Runnable() {
					@Override
					public void run() {

						ShinYS.chatClient = new ChatSystemClient();
						ShinYS.chatClient.clientStart();

					}
				});

				
				
			});

			init_main(0); // 메인대시 로딩 // 로그인시 디비 가져오도록 수정해야함. 애니메이션 끊김

			// 왼쪽메뉴 보여주기
			ObservableList<Node> sample = left_menu.getChildren();
			for (Node gg : sample) {
				gg.setOpacity(0);

				FadeTransition left_children = new FadeTransition(Duration.millis(1200), gg);
				left_children.setFromValue(0);
				left_children.setToValue(1.0);
				left_children.setDelay(Duration.millis(1200));
				// left_children.setOnFinished(f->{
				// init_main(0); //메인대시 로딩
				// });
				left_children.play();
			}

			// 탑메뉴 보여주기
			ObservableList<Node> sample2 = top.getChildren();
			for (Node gg : sample2) {
				gg.setOpacity(0);

				FadeTransition left_children = new FadeTransition(Duration.millis(1200), gg);
				left_children.setFromValue(0);
				left_children.setToValue(1.0);
				left_children.setDelay(Duration.millis(1600));
				left_children.play();

			}

		}

		t_left.setOnFinished(j -> {
			System.out.println("left 완료");
			t_left.pause();
		});

		t_content.setOnFinished(j -> {
			System.out.println("contents 완료");
		});

		// a_top.setOnFinished(j -> {
		// System.out.println("top 열림");
		// });

		t_left.play();
		t_content.play();
		a_top.play();

		System.out.println(t_left.getTargetFramerate());

	}

	// 출석이벤트
	private void Attendance_event() {

		int random = (int) (Math.random() * 100) + 1;

		if (random < 30) {
			try {
				Global.supportPenService.addition_myPen_Quantity2(ShinYS.query_id, "100");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ShinYS.infoMsg("출석이벤트", "<출석이벤트 당첨> 형광펜100개 획득!");
		} else if (random > 30) {
			ShinYS.infoMsg("출석이벤트", "<출석이벤트 낙첨> 다음기회에..");
		}

	}
	
	

}
