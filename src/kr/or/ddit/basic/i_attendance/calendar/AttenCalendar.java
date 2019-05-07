package kr.or.ddit.basic.i_attendance.calendar;

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
import kr.or.ddit.ibatis.vo.memberVO.AttendanceVO;
import kr.or.ddit.ibatis.vo.restaurantVO.OrderVO;
import kr.or.ddit.ibatis.vo.restaurantVO.Resmenu_daysVO;
import library.Global;
import library.ShinYS;

public class AttenCalendar implements Initializable {
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
	HashMap<String, AttendanceVO> hm3; // 주문내역 해시맵 저장
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

		gridPane.setPrefSize(680, 400);

		gridPane.setLayoutX(0);
		gridPane.setLayoutY(0);


		int counts = 0;
		for (int i = 0; i < btnn.length; i++) {
			for (int j = 0; j < btnn[i].length; j++) {

				int in_day = (i + 1) + ((j - 1) * 7);

				label[counts] = new Label();
				hbox[counts] = new AnchorPane();
				btn[counts] = new Button();
				btn[counts].getStyleClass().add("attenDay");
				
				btn[counts].setFocusTraversable(false);
				btn[counts].setCursor(Cursor.HAND);
				
				
				

				if (counts < 7) {
					btn[counts].setText(header[counts]);
				}
		

				if (j == 0) {
					btn[counts].setStyle("-fx-text-fill:#f04b84");
				}

				if (j == 6) {
					btn[counts].setStyle("-fx-text-fill:#319be5");
				}

				if (counts > 6) {
					
					btn[counts].getStyleClass().add("attenDay_hover");
					btn[counts].setPrefSize(gridPane.getPrefWidth()/7, 60);
					hbox[counts].setPrefSize(gridPane.getPrefWidth()/7, 60);
					btn[counts].setAlignment(Pos.TOP_LEFT);
					
					btn[counts].setOnMouseClicked(e -> {
						
						//이벤트키 형변환
						Button tbs = (Button) e.getSource();
						AnchorPane ap = (AnchorPane) tbs.getParent();
		
						ShinYS.attendance_day = tbs.getText();
						ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "i_attendance/Attendance_List.fxml", "#contents");
	
					});
					
					
				}else {
					
					
					btn[counts].setPrefSize(gridPane.getPrefWidth()/7, 50);
					hbox[counts].setPrefSize(gridPane.getPrefWidth()/7, 50);
					label[counts].setPrefSize(gridPane.getPrefWidth()/7, 50);
					btn[counts].getStyleClass().add("attenTitle");
					//label[counts].setStyle("-fx-background-color:#fafd7b; -fx-text-fill:000;");
					
					label[counts].setOpacity(0.2);
					
				}
				
				hbox[counts].getChildren().add(btn[counts]);
				
				gridPane.setStyle("-fx-border-color:#ffffff; -fx-border-weight:1;");
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

		
		
		
		//회원 월별 출석 가져오기
		hm3 = new HashMap<>();
		hm3.clear();
		List<AttendanceVO> list5 = new ArrayList<>();
		try {
			AttendanceVO vo5 = new AttendanceVO();
			vo5.setDays_date(get_month.format(cal.getTime()));
			vo5.setMem_id(ShinYS.login_memVO.getMem_id());
			list5 = Global.attendanceService.select_MonthAttendanceInfo(vo5);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		for(AttendanceVO dd : list5) {

			String temp_date1 = dd.getDays_date().substring(8, 10);

			if(temp_date1.substring(0, 1).equals("0")) {
				temp_date1 = temp_date1.substring(1, 2);
			}
			
			hm3.put(temp_date1, dd);

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
		
			
			
//			//오늘날짜 표시
//			if(day == t_day && month == t_month && year == t_year) {
//				btn[x].setStyle("-fx-border-color:#e02f64; -fx-border-width:4; -fx-border-radius:5;");
//				
//				Label lb = new Label("ToDay");
//				lb.setId("ddsz");
//				lb.setLayoutY(0);
//				lb.setLayoutX(50);
//				lb.setStyle("-fx-background-color:#e02f64; -fx-text-fill:white; -fx-padding:5; -fx-background-radius:0 0 8 8;");
//				lb.setMouseTransparent(true);
//				
//				hbox[x].getChildren().add(lb);
//				
//			}
			
			
			
			
			//출석 도장 찍기
			if(hm3.get(day2) != null || (hm3.get(day2) == null && hm3.containsKey(day2))){

				
				ImageView imb = new ImageView("image/check.png");
				imb.setMouseTransparent(true);
				imb.setFitWidth(40);
				imb.setFitHeight(40);
				imb.setTranslateY(10);
				imb.setTranslateX(32);
				imb.setId("ddsz");
				imb.setAccessibleText("order_cell");
		
				hbox[x].getChildren().add(imb);
				
				
			}
			

		}
		

	}

}
