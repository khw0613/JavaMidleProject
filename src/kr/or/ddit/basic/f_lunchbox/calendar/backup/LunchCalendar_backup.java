package kr.or.ddit.basic.f_lunchbox.calendar.backup;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import kr.or.ddit.ibatis.vo.memberVO.AttendanceVO;
import library.Global;
import library.ShinYS;

public class LunchCalendar_backup implements Initializable {
	public int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	public int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	String day = "";

	Button[] btn = new Button[49];
	Button[][] btnn = new Button[7][7];

	HBox hbox = null;
	Scene scene = null;
	Label label = null;
	List<AttendanceVO> list = null;
	List<String> attenList = new ArrayList<>();
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		start();

	}

	public AnchorPane start() {
		
		//출석 데이터 받기	//월별로 데이터 받아와야함
		try {
			 list = Global.attendanceService.select_AttendanceInfo(ShinYS.query_id);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
				
		int x = 0;
		int y = 0;

		GridPane gridPane = new GridPane();
		AnchorPane anchor = new AnchorPane();

		String[] header = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };

		//anchor.setPrefSize(915, 715);

		gridPane.setPrefSize(700, 715);

		gridPane.setLayoutX(0);
		gridPane.setLayoutY(0);


		int counts = 0;
		for (int i = 0; i < btnn.length; i++) {
			for (int j = 0; j < btnn[i].length; j++) {

				int in_day = (i + 1) + ((j - 1) * 7);

				label = new Label();
				hbox = new HBox();
				btn[counts] = new Button();
				btn[counts].setPrefSize(gridPane.getPrefWidth()/7, 130);
				hbox.setPrefSize(gridPane.getPrefWidth()/7, 130);

				if (counts < 7) {
					btn[counts].setText(header[counts]);
				}
				hbox.getChildren().add(btn[counts]);
				gridPane.add(hbox, j, i);
				gridPane.add(label, j, i);

				if (j == 0) {
					btn[counts].setStyle("-fx-text-fill:red");
				}

				if (j == 6) {
					btn[counts].setStyle("-fx-text-fill:blue");
				}

				if (counts > 6) {
					btn[counts].setOnMouseClicked(e -> {

						//String date = ((Button) e.getSource()).getText();
					});
				}

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

		for (int x = 7; x < btn.length; x++)
			btn[x].setText("");

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);

		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

		
		
		
		
		
		
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {

			btn[x].setText("" + day);
			// 1일부터 말일까지 데이터 넣기

			//출석 리스트에 넣기
			for (int k = 0; k < list.size(); k++) {
				String sub = list.get(k).getDays_date();
				attenList.add(sub.substring(8, 10));
			}
			
			//출석 출력시키
			String temp_day = btn[x].getText();
			for(String ss : attenList) {
				
				System.out.println(ss + ":" + temp_day);
				if(temp_day.length() == 1) {
					temp_day = "0" + temp_day;
				}
				
				if(ss.equals(temp_day)) {
					btn[x].setText("출석");
				}
			}
			
			
		}

	}

}
