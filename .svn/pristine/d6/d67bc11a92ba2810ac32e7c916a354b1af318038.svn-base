package kr.or.ddit.basic.c_dashboard;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_boardVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;
import javafx.scene.control.Button;

public class P_WriteController implements Initializable{

	@FXML TextField title_txt;   // 제목
	@FXML TextField writer_txt;	 // 작성자
	@FXML HTMLEditor content_txt;// 내용
	@FXML Button cancel_btn;	 // 취소버튼
	@FXML Button sub_btn;		 // 제출
	
	HashMap<String, String> map = new HashMap<String, String>();;
	ObservableList<Map<String, String>> data;
	List<Persnal_boardVO> list;
	List<MemberVO> mem_list;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		sub_btn.setOnAction(e->{
		Persnal_boardVO vo = new Persnal_boardVO();	
		
		vo.setPb_title(title_txt.getText());
		String title = vo.getPb_title();
		writer_txt.setText(ShinYS.query_id);
		vo.setMem_id(writer_txt.getText());
		String id = vo.getMem_id();
		
		vo.setPb_contents(content_txt.getHtmlText());
		String content = vo.getPb_contents();
		
		vo.setReceive_id(ShinYS.query_id);
		String receive = vo.getReceive_id();
		map.put("mem_id", id);
		map.put("pb_title", title);
		map.put("pb_contents", content);
		map.put("receive_id", receive);

		try {
			Global.persnalBoardService.insert_PersnalBoard_post(map);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			Global.memberService.update_pb_post_no(ShinYS.query_id);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "c_dashboard/member_homepage.fxml", "#contents");
		});
		
		cancel_btn.setOnAction(e->{
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "c_dashboard/member_homepage.fxml", "#contents");
			
		});
		

		
		
	}

}
