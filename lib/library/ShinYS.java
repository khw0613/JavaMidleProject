package library;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.aes256;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import kr.or.ddit.basic.Main;
import kr.or.ddit.basic.g_messenger.ChatSystemClient;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_boardVO;
import kr.or.ddit.ibatis.vo.hilightVO.PayVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;

public class ShinYS {
	
	
	public static MemberVO login_memVO;			// 로그인 회원정보 vo
	public static String query_id;				// 아이디
	public static String recive_id;				// 메시지 답장보내기 ID
	public static String query_Degree;			// 기수
	public static String query_Number;			// 게시물 번호
	public static String select_Board;			// 접속 게시판코드
	public static String query_Password;		// 패스워드
	public static String attendance_day;        // 출석체크
	public static String temp = "";				// 간편출석
	public static String login_right_name;		// 등급
	public static String repl_number;		    // 댓글번호
	public static int event_count = 1;		        // 출석이벤트
	
	public static BoardVO mem; 					// 게시판 더블클릭시 정보얻는값
	public static Persnal_boardVO p_vo;         // 개인 게시글 조회
	public static PayVO pay_vo = new PayVO();	// 형광펜 수량 
	public static MemberVO visitmem;            // 방문한 사람의 정보값
	
	
	public static Map<String,String> avator_map = new HashMap<>();
	
	public static String guest_Id;				// 방문 대시보드 아이디
	
	
	//fx
	public static int cate_positionY_default = 0;	// 카테고리 기본 위치 값
	static TranslateTransition t_cs2 = new TranslateTransition();	// 카테고리 클로즈 애니메이션 전역변수 설정
	
		
	
	//암호화 복호화 api
	 public static String key = "aes256-test-key!!";       // key는 16자 이상 
	 public static aes256 aes256;
	
	 //클라이언트 서버 인스턴스
	 public static ChatSystemClient chatClient;;
	 
	 
	// ShinYS 변수 초기화
	public static void init() {

		try {
			aes256 = new aes256(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ShinYS.avator_map.put("1", "#8cacb8");
		ShinYS.avator_map.put("2", "#89adcc");
		ShinYS.avator_map.put("3", "#db8fbc");
		ShinYS.avator_map.put("4", "#8ecac3");
		
		//변수 초기화 작성해야함.
		
		
	}
	
	//형광펜 페이지 이동
	public static void gotoHightlight() {
		ShinYS.<AnchorPane>ChangePage(Main.class, Global.RootDir + "e_cash/highlighter_management.fxml", "#contents");

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
	
	
	//뒤로가기 버튼 가져오기
	public static ImageView visBack(boolean tf) {
		ImageView getimg = (ImageView) Main.StageHome.getScene().getRoot().lookup("#btn_left_img");
		if(tf) {
			getimg.setVisible(true);
		}else {
			getimg.setVisible(false);
		}
		
		return getimg;
	}
	
	// 카테고리 오픈 - 완성
	public static void categoryOpen(List<Button> btnList) {
		t_cs2.stop();
		
		AnchorPane cs = (AnchorPane) Main.StageHome.getScene().getRoot().lookup("#dash_cate");
		cs.setTranslateY(0);
		
//		if(cs.getTranslateY() > cate_positionY_default) {
//			return;
//		}
		
		
		//카테고리 메뉴 추가
		HBox csi = (HBox) Main.StageHome.getScene().getRoot().lookup("#dash_cate_item");
		csi.getChildren().clear();
		
		for(int i=0; i<btnList.size(); i++) {
			btnList.get(i).setPrefWidth(csi.getPrefWidth()/btnList.size());
			btnList.get(i).setPrefHeight(50);
			btnList.get(i).setCursor(Cursor.HAND);
			btnList.get(i).setFocusTraversable(false);
			btnList.get(i).setStyle("-fx-background-color:#ffffff; -fx-border-width:0 1 4 0; -fx-border-color:#000000 #777777 #777777;");
			
			btnList.get(i).addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
				Button btn_hover = (Button) e.getSource();
				btn_hover.setStyle(btn_hover.getStyle().replace("background-color:#ffffff", "background-color:#dddddd"));
				btn_hover.setStyle(btn_hover.getStyle().replace("border-color:#000000 #777777 #777777", "border-color:#000000 #777777 #223f82"));
			});
			
			btnList.get(i).addEventHandler(MouseEvent.MOUSE_EXITED, e->{
				Button btn_hover = (Button) e.getSource();
				btn_hover.setStyle(btn_hover.getStyle().replace("background-color:#dddddd", "background-color:#ffffff"));
				btn_hover.setStyle(btn_hover.getStyle().replace("border-color:#000000 #777777 #223f82", "border-color:#000000 #777777 #777777"));
			});

		}
		
		
		csi.getChildren().addAll(btnList);
		
		

		
		
		//카테고리 오픈 애니메이션

		cs.setVisible(true);

		TranslateTransition t_cs = new TranslateTransition(Duration.millis(500),cs);
		t_cs.setToY(cs.getTranslateY()+cs.getPrefHeight());
		t_cs.play();
		
		//컨텐츠 위치변경
		AnchorPane dm = (AnchorPane) Main.StageHome.getScene().getRoot().lookup("#dashmain");
		dm.setTranslateY(0);
		TranslateTransition t_dm = new TranslateTransition(Duration.millis(500), dm);
		t_dm.setToY(dm.getTranslateY()+cs.getPrefHeight());
		t_dm.play();
		
		//컨텐츠 크기 변경
		
		ScrollPane csc = (ScrollPane) Main.StageHome.getScene().getRoot().lookup("#con_scroll");
		csc.setPrefHeight(700);
		
		AnchorPane anc = (AnchorPane) Main.StageHome.getScene().getRoot().lookup("#contents");
		anc.setMinHeight(csc.getPrefHeight()-(cs.getPrefHeight()+10));
		
		Timeline t_csc = new Timeline();
		KeyValue kv_t_csc = new KeyValue(csc.prefHeightProperty(), csc.getPrefHeight()-cs.getPrefHeight(), Interpolator.EASE_IN);
		KeyFrame kf_t_csc = new KeyFrame(Duration.millis(500), kv_t_csc);
		t_csc.getKeyFrames().add(kf_t_csc);
		t_csc.play();
		
	}
	
	
	// 카테고리 닫기
	public static void categoryClose() {
		AnchorPane cs = (AnchorPane) Main.StageHome.getScene().getRoot().lookup("#dash_cate");
		
		if(cs.getTranslateY() <= cate_positionY_default) {
			return;
		}
		
		
		
		//카테고리 클로즈 애니메이션
		t_cs2 = new TranslateTransition(Duration.millis(500),cs);
		t_cs2.setToY(cs.getTranslateY()-cs.getPrefHeight());
		t_cs2.setOnFinished(e->{
			System.out.println("메뉴삭제");
			cs.setVisible(false);
			
			//카테고리 메뉴 삭제
			HBox csi = (HBox) Main.StageHome.getScene().getRoot().lookup("#dash_cate_item");
			csi.getChildren().clear();
		});
		t_cs2.play();
		
		//컨텐츠 원위치로
		AnchorPane dm = (AnchorPane) Main.StageHome.getScene().getRoot().lookup("#dashmain");
		TranslateTransition t_dm = new TranslateTransition(Duration.millis(500), dm);
		t_dm.setToY(dm.getTranslateY()-cs.getPrefHeight());
		t_dm.play();
		
		//컨텐츠 크기 변경
		ScrollPane csc = (ScrollPane) Main.StageHome.getScene().getRoot().lookup("#con_scroll");
		
		AnchorPane anc = (AnchorPane) Main.StageHome.getScene().getRoot().lookup("#contents");
		anc.setMinHeight(690);
		
		Timeline t_csc = new Timeline();
		KeyValue kv_t_csc = new KeyValue(csc.prefHeightProperty(), csc.getPrefHeight()+cs.getPrefHeight(), Interpolator.EASE_IN);
		KeyFrame kf_t_csc = new KeyFrame(Duration.millis(500), kv_t_csc);
		t_csc.getKeyFrames().add(kf_t_csc);
		t_csc.play();
		
	
		//	멈춤 기능
			
//		TimeUnit.MILLISECONDS.sleep(400);

	}
	
	
	// 화면 컨텐츠 전환
	public static <A extends Pane> void ChangePage(Class getC, String fxml, String id) {
		
		ShinYS.visBack(false);
		
		try {
			AnchorPane board;
			board = FXMLLoader.load(getC.getResource(fxml));
			A lay = (A) Main.StageHome.getScene().getRoot().lookup(id);
			lay.getChildren().clear();
			lay.getChildren().setAll(board);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	// 화면 전체 전환
		public static void ChangeView(Class getC, String fxml) {
				
			try {
				AnchorPane board;
				board = FXMLLoader.load(getC.getResource(fxml));
				Scene lay = Main.StageHome.getScene();
				lay.setRoot(board);
				
				board.requestFocus();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			
		}
		
		
		// 화면 전체 전환 백업
			public static void ChangeView22(Class getC, String fxml, boolean blur) {
					
				Parent window1 = null;
			    try {
			        window1 = FXMLLoader.load(getC.getResource(fxml));
			        Stage newStage;
			        Scene newScene = new Scene(window1);
			        newScene.getStylesheets().add("https://fonts.googleapis.com/css?family=Do+Hyeon");
			        
			        if(blur) {
			        	window1.requestFocus();
			        }
			        
			        
			        
			        newStage = Main.StageHome;
			        newStage.setScene(newScene);
			        
			        //newStage.show();
			        //BoardMain.StageHome.getScene().getRoot().lookup("VBox").requestFocus();
			        
			    } catch (IOException e2) {
			        e2.printStackTrace();
			    }
			}
			
		
		// 에러메시지 메서드
			public static void errMsg(String headerText, String msg) {
				Alert errAlert = new Alert(AlertType.ERROR);
				errAlert.setTitle("Error");
				errAlert.setHeaderText(headerText);
				errAlert.setContentText(msg);
				errAlert.showAndWait();
			}

			// 알림창 메서드
			public static void infoMsg(String headerText, String msg) {
				Alert infoAlert = new Alert(AlertType.INFORMATION);
				infoAlert.setTitle("info");
				infoAlert.setHeaderText(headerText);
				infoAlert.setContentText(msg);
				infoAlert.showAndWait();
			}
			
			
		
	}
