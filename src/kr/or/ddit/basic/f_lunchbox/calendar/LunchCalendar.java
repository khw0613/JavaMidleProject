package kr.or.ddit.basic.f_lunchbox.calendar;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import kr.or.ddit.ibatis.vo.restaurantVO.OrderVO;
import kr.or.ddit.ibatis.vo.restaurantVO.Resmenu_daysVO;
import library.Global;
import library.ShinYS;

public class LunchCalendar implements Initializable {
	public int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	public int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	
	String day = "";
	

	Button[] btn = new Button[49];
	Button[][] btnn = new Button[7][7];

	AnchorPane[] hbox = new AnchorPane[49];
	Label[] label  = new Label[49];
	
	public int temp_int; //인트 저장소
	HashMap<String, Resmenu_daysVO> hm;	// 식단표 해시맵저장
	HashMap<String, OrderVO> hm2; // 주문내역 해시맵 저장
	public static String res_code;
	
	public static List<String> hs = new ArrayList<>();
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		start();

	}
	

	public AnchorPane start() {
				
				
		int x = 0;
		int y = 0;

		GridPane gridPane = new GridPane();
		AnchorPane anchor = new AnchorPane();

		String[] header = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };

		//anchor.setPrefSize(915, 715);

		gridPane.setPrefSize(800, 715);

		gridPane.setLayoutX(0);
		gridPane.setLayoutY(0);


		int counts = 0;
		for (int i = 0; i < btnn.length; i++) {
			for (int j = 0; j < btnn[i].length; j++) {

				int in_day = (i + 1) + ((j - 1) * 7);

				label[counts] = new Label();
				hbox[counts] = new AnchorPane();
				btn[counts] = new Button();
				btn[counts].getStyleClass().add("lunchDay_btn");
				
				btn[counts].setFocusTraversable(false);
				btn[counts].setCursor(Cursor.HAND);
				
				
				

				if (counts < 7) {
					btn[counts].setText(header[counts]);
				}
		

				if (j == 0) {
					btn[counts].setStyle("-fx-text-fill:red");
				}

				if (j == 6) {
					btn[counts].setStyle("-fx-text-fill:blue");
				}

				if (counts > 6) {
					
					btn[counts].setPrefSize(gridPane.getPrefWidth()/7, 150);
					hbox[counts].setPrefSize(gridPane.getPrefWidth()/7, 150);
					btn[counts].setAlignment(Pos.TOP_LEFT);
					
					btn[counts].setOnMouseClicked(e -> {
						
						//이벤트키 형변환
						Button tbs = (Button) e.getSource();
						AnchorPane ap = (AnchorPane) tbs.getParent();
		
						for(int ss = 0; ss < hs.size(); ss++) {
							System.out.println(hs.get(ss).toString());
						}
						
						//System.out.println(tbs.getId());
						//System.out.println(hm.get(tbs.getId()).getRes_order_date());
						
				
						//식단표 없는 셀 체크
						boolean check1 = false;
						for(int c = 1; c < ap.getChildren().size(); c++) {		
							if(("l_cell").equals(ap.getChildren().get(c).getAccessibleText())) {
								check1 = true;
							}
						}
						
						if(!check1) {
							System.out.println("식단표가 없는 날 입니다");
							return;
						}
						
						
						//버튼 동결
						tbs.setDisable(true);
						//셀렉트 이미 존재하면 지우기
						for(int c = 1; c < ap.getChildren().size(); c++) {		
	
							if(("l_select").equals(ap.getChildren().get(c).getAccessibleText())) {
								
								hs.remove(tbs.getText());
								
								temp_int=c;
								FadeTransition selectbox = new FadeTransition(Duration.millis(500), (Label)ap.getChildren().get(c));
								selectbox.setFromValue(0.3);
								selectbox.setToValue(0);
								selectbox.setOnFinished(k->{
									ap.getChildren().remove(temp_int);
									//버튼 동결해제
									tbs.setDisable(false);
								});
								selectbox.play();
								return;
							};
						}
							
						
						hs.add(tbs.getText());
						
						
						
						//선택된 날 라벨 추가하기
						Label lbl = new Label();
						lbl.setId("ddsz");
						lbl.setAccessibleText("l_select");
						lbl.setPrefSize(gridPane.getPrefWidth()/7, 150);
						lbl.setStyle("-fx-background-color:#265baf;");
						lbl.setMouseTransparent(true);
						lbl.setOpacity(0);
						ap.getChildren().add(lbl);
						lbl.toBack();
						tbs.toBack();	
						
						
						
						
						FadeTransition selectbox = new FadeTransition(Duration.millis(500), lbl);
						selectbox.setFromValue(0);
						selectbox.setToValue(0.3);
						selectbox.setOnFinished(g->{
							
							//버튼 동결해제
							tbs.setDisable(false);
							
						});
						selectbox.play();

					});
					
					
				}else {
					
					
					btn[counts].setPrefSize(gridPane.getPrefWidth()/7, 50);
					hbox[counts].setPrefSize(gridPane.getPrefWidth()/7, 50);
					label[counts].setPrefSize(gridPane.getPrefWidth()/7, 50);
					label[counts].setStyle("-fx-background-color:yellow;");
					label[counts].setOpacity(0.1);
					
				}
				
				hbox[counts].getChildren().add(btn[counts]);
				
				gridPane.setStyle("-fx-border-color:#5d210d; -fx-border-weight:1;");
				gridPane.add(hbox[counts], j, i);
				gridPane.add(label[counts], j, i);
				
				

				counts++;
			}// for end


		}

		displayDate();
		anchor.getChildren().addAll(gridPane);

		return anchor;

	}

	public String setPickedDate() {
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
		
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}

	public void displayDate() {
		hs = new ArrayList<>();
		for (int x = 7; x < btn.length; x++)
			btn[x].setText("");

		//오늘 날짜 고정
		int t_year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		int t_month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
		int t_day = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH);
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
		java.text.SimpleDateFormat get_month = new java.text.SimpleDateFormat("yyyyMM");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);

		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

		
		
		
		//월별 도시락 메뉴 출력
		hm= new HashMap<>();
		hm.clear();
		
		List<Resmenu_daysVO> list= new ArrayList<Resmenu_daysVO>();
		
		Resmenu_daysVO vo = new Resmenu_daysVO();
		vo.setRes_order_date(get_month.format(cal.getTime()));
		vo.setRes_no(res_code);
		
		
		try {
			list = Global.resMenuService.select_RestaurantmenuList_month(vo);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		

		
//		try {
//			list  = Global.resMenuService.selectList_month(get_month.format(cal.getTime()));
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
		
		for(Resmenu_daysVO dd : list) {

			String temp_date1 = dd.getRes_order_date().substring(6, 8);
			
			if(temp_date1.substring(0, 1).equals("0")) {
				temp_date1 = temp_date1.substring(1, 2);
			}
			
			//System.out.println(temp_date1);
			hm.put(temp_date1, dd);

		}
		
		
		
		//주문내역 조회
		hm2 = new HashMap<>();
		hm2.clear();
		OrderVO vo2 = new OrderVO();
		vo2.setMem_id(ShinYS.login_memVO.getMem_id());				// 조회할 아이디
		vo2.setRes_order_date(get_month.format(cal.getTime()));			// 조회할 월(년월까지만 입력해주세요!)
		
		List<OrderVO> list2 = new ArrayList<>();
		try {
			list2 = Global.orderService.select_memOrder(vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		
		for(OrderVO dd : list2) {

			if(dd.getRes_no().equals(res_code)) {
				String temp_date1 = dd.getRes_order_date().substring(6, 8);
				
				if(temp_date1.substring(0, 1).equals("0")) {
					temp_date1 = temp_date1.substring(1, 2);
				}
				System.out.println(temp_date1 + " // " + dd);
				hm2.put(temp_date1, dd);
			}
		}
				
				
		
		
		
		//인덱스 값으로 아이디 찾아서 삭제하기
		for(int i = 0; i < btn.length; i++) {
			for(int z = 1; z < hbox[i].getChildren().size(); z++) {
 
				if(hbox[i].getChildren().get(z).getId().equals("ddsz")) {
					hbox[i].getChildren().remove(z);
					z--;
				}	
			}
		}
		
		
		


		//날짜에 맞게 값 넣어주기
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {

			//달력 내용 초기화
			String day2 = ""+day;
			btn[x].setText(day2);
			
			//id값 01 02 03. . . 10 11 12 로 저장하기
//			String day3 =day2;
//			if(day2.length()==1) {
//				day3 = "0"+day2;
//			}
//			btn[x].setId(day3);
			
			
			btn[x].setId(day2);
			//스타일 초기화
			btn[x].setStyle("");
		
			
			
			//오늘날짜 표시
			if(day == t_day && month == t_month && year == t_year) {
				btn[x].setStyle("-fx-border-color:#e02f64; -fx-border-width:4; -fx-border-radius:5;");
				
				Label lb = new Label("ToDay");
				lb.setId("ddsz");
				lb.setLayoutY(0);
				lb.setLayoutX(50);
				lb.setStyle("-fx-background-color:#e02f64; -fx-text-fill:white; -fx-padding:5; -fx-background-radius:0 0 8 8;");
				lb.setMouseTransparent(true);
				
				hbox[x].getChildren().add(lb);
				
			}
			
			
			//식단표 넣기
			if(hm.get(day2) != null || (hm.get(day2) == null && hm.containsKey(day2))){
				String menu_all = hm.get(day2).getMenu_1() + "\n" + hm.get(day2).getMenu_2() + ""
						+ "\n" + hm.get(day2).getMenu_3() + "\n" + hm.get(day2).getMenu_4() + ""
						+ "\n" + hm.get(day2).getMenu_5() + "\n" + hm.get(day2).getMenu_soup();
				
				
				Label lb = new Label(menu_all);
				lb.setId("ddsz");
				lb.setAccessibleText("l_cell");
				lb.setLayoutY(30);
				lb.setLayoutX(10);
				lb.setMouseTransparent(true);
				
				hbox[x].getChildren().add(lb);
			}
			
			
			
			//주문 도장 넣기
			if(hm2.get(day2) != null || (hm2.get(day2) == null && hm2.containsKey(day2))){

				//Label lb = new Label("주문완료");
				//lb.setMouseTransparent(true);
				
				ImageView imb = new ImageView("image/lunch_order.png");
				imb.setMouseTransparent(true);
				imb.setTranslateY(30);
				imb.setTranslateX(18);
				imb.setOpacity(0.35);
				imb.setId("ddsz");
				imb.setAccessibleText("order_cell");
		
				hbox[x].getChildren().add(imb);
				
				
				
				
			}
			

		}
		

	}

}
