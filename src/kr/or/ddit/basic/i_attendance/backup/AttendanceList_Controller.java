package kr.or.ddit.basic.i_attendance.backup;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.ibatis.vo.memberVO.AttendanceVO;
import library.Global;
import library.ShinYS;
import javafx.scene.control.TableView;

public class AttendanceList_Controller implements Initializable{
	@FXML TableColumn<AttendanceVO, String>  col_user;
	@FXML TableColumn<AttendanceVO, String>  col_day_check;
	@FXML TableColumn<AttendanceVO, String>  col_date;
	@FXML TableView list_view;
	
	ObservableList<AttendanceVO> data;
	List<AttendanceVO> list;
	List<AttendanceVO> attenList = new ArrayList<AttendanceVO>();
	
	int count = 1;
	AttendanceVO vo = new AttendanceVO();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
		
		
		
		
		
		
		
		try {
			 list = Global.attendanceService.select_AttendanceList();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		col_user.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		col_day_check.setCellValueFactory(new PropertyValueFactory<>("count"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("days_date"));
		
		
		
		
		AttendanceVO vo = new AttendanceVO();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getDays_date().substring(8,10).equals(ShinYS.attendance_day)) {
				
				System.out.println("선택날짜 :" + ShinYS.attendance_day);
				System.out.println(list.get(i).getMem_id());
				System.out.println(list.get(i).getDays_check());
				System.out.println(list.get(i).getDays_date());
				
				
				
				
				vo.setMem_id(list.get(i).getMem_id());
				vo.setCount(count++);
				vo.setDays_date(list.get(i).getDays_date());
				
				attenList.add(vo);
				
			}
			
			vo = new AttendanceVO();
		}
		
		
		data = FXCollections.observableArrayList(attenList);
		list_view.setItems(data);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*for (int k = 0; k < list.size(); k++) {
			String sub = list.get(k).getDays_date();

			attenList.add(sub.substring(8, 10));
			System.out.println(attenList);
			
		}
		
		
		String temp_day = ShinYS.attendance_day;
		
		System.out.println("템프" + temp_day);
		
		for(String ss : attenList) {
			
			System.out.println(ss + ":" + temp_day);
			if(temp_day.length() == 1) {
				temp_day = "0" + temp_day;
			}
		
			
			if(ss.equals(list.get(0))) {
				vo.setDays_date(ss);
			
		
			list.add(vo);
		
			data = FXCollections.observableArrayList(list);
			list_view.setItems(data);
			}
		
	}*/

}
}
