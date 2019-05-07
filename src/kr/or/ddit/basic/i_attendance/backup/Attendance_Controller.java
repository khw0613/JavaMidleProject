package kr.or.ddit.basic.i_attendance.backup;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.omg.CORBA.PUBLIC_MEMBER;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import kr.or.ddit.basic.Main;
import kr.or.ddit.ibatis.vo.memberVO.AttendanceVO;
import library.Global;
import library.ShinYS;
import javafx.fxml.FXML;

public class Attendance_Controller implements Initializable {
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	String day = "";

	Button[] btn = new Button[49];
	Button[][] btnn = new Button[7][7];
	
	AnchorPane[] hbox = new AnchorPane[49];

	Scene scene = null;
	Label label = null;
	List<AttendanceVO> list = null;
	List<String> attenList = new ArrayList<>();

	
	@FXML HBox cal_top;
	@FXML Button c_btn_left;
	@FXML Label c_date_view;
	@FXML Button c_btn_right;
	@FXML HBox cal_middle;
	@FXML AnchorPane main;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		int x = 0;
		int y = 0;

		GridPane gridPane = new GridPane();
		AnchorPane anchor = new AnchorPane();

		String[] header = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };

		anchor.setPrefSize(800, 715);

		gridPane.setPrefSize(800, 715);

		gridPane.setLayoutX(0);
		gridPane.setLayoutY(0);

		
		
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		Date currentTime = new Date();
		String mTime = mSimpleDateFormat.format(currentTime);
		
		
		
		
		
		
		
		
		
		//회원 월별 출석 가져오기
				try {
					
					AttendanceVO vo = new AttendanceVO();
					vo.setDays_date(mTime.replaceAll("[.]", "").substring(0, 6));
					vo.setMem_id(ShinYS.query_id);
					list = Global.attendanceService.select_MonthAttendanceInfo(vo);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		
		for (int k = 0; k < list.size(); k++) {
			String sub = list.get(k).getDays_date();

			attenList.add(sub.substring(8, 10).replaceAll("[-]", ""));
			System.out.println("수정날짜 : " + attenList);
			
		}
		
		
		
		int counts = 0;
		for (int i = 0; i < btnn.length; i++) {
			for (int j = 0; j < btnn[i].length; j++) {

				int in_day = (i + 1) + ((j - 1) * 7);

				label = new Label();
				hbox[counts] = new AnchorPane();
				btn[counts] = new Button();
				
				btn[counts].setPrefSize(gridPane.getPrefWidth()/7, 120);
				hbox[counts].setPrefSize(gridPane.getPrefWidth()/7, 120);
				btn[counts].setAlignment(Pos.TOP_LEFT);
				
				

				if (counts < 7) {
					btn[counts].setText(header[counts]);
				}
				hbox[counts].getChildren().add(btn[counts]);
				gridPane.add(hbox[counts], j, i);
				gridPane.add(label, j, i);

				if (j == 0) {
					btn[counts].setStyle("-fx-text-fill:red");
				}

				if (j == 6) {
					btn[counts].setStyle("-fx-text-fill:blue");
				}


				counts++;
			}

		}

		anchor.getChildren().addAll(gridPane);
		displayDate();
		cal_middle.getChildren().add(anchor);
		//========================================================
		//달력넘김 버튼이미지 삽입
		c_btn_left.setFocusTraversable(false);
		c_btn_right.setFocusTraversable(false);
		
		       // 왼쪽버튼
				c_btn_left.setOnMouseClicked(e -> {
					month--;
					displayDate();
					dateview();
				});

				// 오른쪽버튼
				c_btn_right.setOnMouseClicked(e -> {
					month++;
					displayDate();
					dateview();
				});
		
		
		
		
		
	
	}
	
	void dateview() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy년 MM월");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);

		c_date_view.setText(sdf.format(cal.getTime()));
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

		for (int x = 7; x < btn.length; x++)
			btn[x].setText("");

		
		//오늘 날짜 고정
				int t_year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
				int t_month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
				int t_day = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH);
		
		
		
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);

		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {

			
			
			btn[x].setText("" + day);
			// 1일부터 말일까지 데이터 넣기
			
			
			
			
			
			
			
			
			
			
			
			
			//FontAwesomeIconName font = new FontAwesomeIconName("FLAG");
			FontAwesomeIcon font = new FontAwesomeIcon();
			font.setIconName("FLAG");
			font.setSize("3em");
			
			
			
			/*//날짜비교
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
			Date currentTime = new Date();
			String mTime = mSimpleDateFormat.format(currentTime);

			 System.out.println(mTime.replaceAll("[.]", "").substring(0, 8));*/
			
			
			
			
			
			String temp_day = btn[x].getText();
			for(String ss : attenList){//DB날짜 
				
				System.out.println(ss + ":" + temp_day);
				if(temp_day.length() == 1) {
					temp_day = "0" + temp_day;
				}
				
				if(ss.equals(temp_day)) {
					
//					유수 테스트중 지우지마요~
//					String test = "#test"+btn[x].getText();
//					System.out.println(test);
//					AnchorPane ap = (AnchorPane) Main.StageHome.getScene().getRoot().lookup(test);
//					System.out.println("id" + ap.getId());
//					
//					ap.getChildren().add(new Label("asd"));
					
					Label label = new Label("", font);
					label.setLayoutX(20);
					label.setLayoutY(20);
					
					
					
					
					hbox[x].getChildren().add(label);
					
				String a = btn[x].getText();
			
				}
			}
			
			
			
			if (x > 6) {
				btn[x].setOnMouseClicked(e -> {
					
					System.out.println("테스트 :" +((Button)e.getSource()).getText());
					
					ShinYS.attendance_day = ((Button)e.getSource()).getText();
					
					ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "i_attendance/Attendance_List.fxml", "#contents");
					
					

				});
			}
			
		}
		
		

	}

}
