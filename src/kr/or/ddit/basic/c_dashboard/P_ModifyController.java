package kr.or.ddit.basic.c_dashboard;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.engine.transaction.Transaction;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_boardVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;
import javafx.scene.control.Button;

public class P_ModifyController implements Initializable{


	
	
	
	@FXML TextField title_txt;		// 제목 적는곳
	@FXML TextField writer_txt;		// 작성자 적는곳
	@FXML HTMLEditor content_txt;	// 내용적는곳
	@FXML Button cancel_btn;		// 취소버튼
	@FXML Button sub_btn;			// 수정완료 버튼

	
	List<MemberVO> list;
	List<Persnal_boardVO> list1;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
		title_txt.setText(ShinYS.p_vo.getPb_title());
		writer_txt.setText(ShinYS.p_vo.getMem_id());
		content_txt.setHtmlText(ShinYS.p_vo.getPb_contents());
		
		writer_txt.setDisable(true);
		

		cancel_btn.setOnAction(e->{
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "c_dashboard/member_homepage.fxml", "#contents");
		});
		
		sub_btn.setOnAction(e->{
			
			
			Persnal_boardVO vo1 = new Persnal_boardVO();
			vo1.setPb_title(title_txt.getText());
			vo1.setPb_contents(content_txt.getHtmlText());
			vo1.setPb_no(ShinYS.p_vo.getPb_no());
			
			
			try {
				Global.persnalBoardService.update_PersnalBoard_post(vo1);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "c_dashboard/member_homepage.fxml", "#contents");
		});
		
	}// 초기화 끝

}
