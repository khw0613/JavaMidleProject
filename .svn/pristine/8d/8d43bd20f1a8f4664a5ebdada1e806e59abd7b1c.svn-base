package kr.or.ddit.basic.i_attendance;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import kr.or.ddit.basic.i_attendance.calendar.AttenCalendar;
import kr.or.ddit.ibatis.vo.restaurantVO.Resmenu_daysVO;
import library.Global;

public class Attendance_Controller implements Initializable {

	@FXML
	HBox cal_top;
	@FXML
	HBox cal_middle;
	@FXML
	HBox cal_bottom;
	@FXML
	Button c_btn_left;
	@FXML
	Label c_date_view;
	@FXML
	Button c_btn_right;

	AttenCalendar lc = new AttenCalendar();


	@Override
	public void initialize(URL location, ResourceBundle resources) {


		c_btn_left.setFocusTraversable(false);
		c_btn_right.setFocusTraversable(false);

		AnchorPane ll = lc.start();
		
		cal_middle.getChildren().add(ll);
		dateview();
	
		// 왼쪽버튼
		c_btn_left.setOnMouseClicked(e -> {
			lc.month--;
			lc.displayDate();
			dateview();
		});

		// 오른쪽버튼
		c_btn_right.setOnMouseClicked(e -> {
			lc.month++;
			lc.displayDate();
			dateview();
		});

		
	
	}// 초기화 완료
	

	void dateview() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy년 MM월");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(lc.year, lc.month, 1);

		c_date_view.setText(sdf.format(cal.getTime()));
		c_date_view.setStyle("-fx-font-size: 18;");
	}
	
	
	
	
	
	//다음달 메뉴 등록하기 (DB인서트)
	public static void printList(List<Resmenu_daysVO> list) {
    	Resmenu_daysVO vo = new Resmenu_daysVO();
        
        for (int i = 0; i < list.size(); i++) {
            /*vo = list.get(i);
            System.out.println(vo.toString());*/
      
       
        	vo.setRes_order_date(list.get(i).getRes_order_date());
        	vo.setRes_no(list.get(i).getRes_no());
        	vo.setMenu_soup(list.get(i).getMenu_soup());
        	vo.setMenu_1(list.get(i).getMenu_1());
        	vo.setMenu_2(list.get(i).getMenu_2());
        	vo.setMenu_3(list.get(i).getMenu_3());
        	vo.setMenu_4(list.get(i).getMenu_4());
        	vo.setMenu_5(list.get(i).getMenu_5());
        	vo.setOrder_check(list.get(i).getOrder_check());
        	vo.setRes_price(list.get(i).getRes_price());
       
        
        try {
			Global.resMenuService.insert_menu(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        }
   
	
	
	}
	
	
	
	

}
