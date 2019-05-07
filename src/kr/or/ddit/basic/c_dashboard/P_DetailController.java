package kr.or.ddit.basic.c_dashboard;

import java.lang.reflect.Field;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.SwingUtilities;

import com.sun.webkit.WebPage;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import kr.or.ddit.basic.Main;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_boardVO;
import library.Global;
import library.ShinYS;

public class P_DetailController implements Initializable{
	
	
	@FXML Label title_lb; //제목
	@FXML Label no_lb;	  //게시글 번호
	@FXML Label date_lb;  // 날짜
	@FXML Label writer_lb;// 작성자
	@FXML Label view_lb;  // 조회수
	@FXML WebView contents; // 내용
	@FXML Button list_btn; //글 목록 버튼
	@FXML Button del_btn;  // 삭제 버튼	
	@FXML Button edit_btn; // 수정버튼

	WebEngine webEngine;
	List<Persnal_boardVO> list = null;
	List<Persnal_boardVO> board = null;
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		try {
			list = Global.persnalBoardService.select_PersnalBoard_post(ShinYS.p_vo.getPb_post_no());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		title_lb.setText(ShinYS.p_vo.getPb_title());
		no_lb.setText(ShinYS.p_vo.getPb_post_no());
		date_lb.setText(ShinYS.p_vo.getPb_date());
		writer_lb.setText(ShinYS.p_vo.getMem_id());
		view_lb.setText(ShinYS.p_vo.getPb_view());
		
		// 작성자부분 못고치게
		writer_lb.setDisable(true);
		
		contents.setOnScroll(e->{
			ScrollPane cs = (ScrollPane) Main.StageHome.getScene().getRoot().lookup("#contents");
			  
			cs.setVvalue(cs.getVvalue() - (e.getDeltaY()*0.01));
			cs.setHvalue(cs.getHvalue() - (e.getDeltaX()*0.01));
      	   
//      	gg.setTranslateX(gg.getTranslateX() + e.getDeltaX());
//      	gg.setTranslateY(gg.getTranslateY() + e.getDeltaY());
             
         });
		 
		
		
		contents.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
	            @Override
	            public void changed(ObservableValue<? extends State> arg0, State oldState, State newState)         {
	                if (newState == State.SUCCEEDED) {
	                	setupHeight();
	                }				
	            }
	        });  
		 
		 
		contents.getChildrenUnmodifiable().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> change) {
                Set<Node> scrolls = contents.lookupAll(".scroll-bar");
                
                for (Node scroll : scrolls) {
                   scroll.setVisible(false);
                  
                }
            }
    	});
		
		 Platform.runLater(new Runnable(){
	            @Override                                
	            public void run() {
	            	
	            	double get_width = contents.getPrefWidth()-10;
	            	
	            	String st = ShinYS.p_vo.getPb_contents();
	    			if(st.contains("contenteditable=\"true\"")){
	    				st=st.replace("contenteditable=\"true\"", "contenteditable=\"false\"");
	    			    st=st.replace("contenteditable=\"false\">", "false\"><div style=\"width:"+get_width+"px; word-wrap: break-word;\">");
	    			    st=st.replace("</body>", "</div></body>");
	    			}else if(st.contains("contenteditable=\"false\"")) {
	    				st=st.replace("contenteditable=\"false\">", "false\"><div style=\"width:"+get_width+"px; word-wrap: break-word;\">");
	    			    st=st.replace("</body>", "</div></body>");
	    			}
	    			
	    			
	            	
	            	
	            	webEngine = contents.getEngine();
	        		webEngine.loadContent(st);
	        		
	        		

	        		try {
	        			Field field = webEngine.getClass().getDeclaredField("page");
	        			field.setAccessible(true);
	        			com.sun.webkit.WebPage page = (WebPage) field.get(webEngine);
	        			SwingUtilities.invokeLater(() -> {
	        			//page.setBackgroundColor((new java.awt.Color(0, 0, 0, 0)).getRGB());
	        			page.setBackgroundColor((new java.awt.Color(244, 249, 253, 100)).getRGB()); 
	        			
	        			});
	        			
	        			

	        			} catch ( Exception e ) {
	        			e.printStackTrace();
	        			}
	                Platform.runLater(new Runnable(){
	                    @Override                                
	                    public void run() {
	                    	setupHeight();
	                    }               
	                });
	            }               
	    	});
		 
		// 글 목록으로 가는 버튼
		 list_btn.setOnAction(e->{
			 ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "c_dashboard/member_homepage.fxml", "#contents");
				 
		 });
		
		// 삭제 버튼 (어려워서 ㅠㅠ)
		 del_btn.setOnAction(e->{
			 
			 try {
				Global.persnalBoardService.delete_PersnalBoard_post(ShinYS.p_vo.getPb_no());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "c_dashboard/member_homepage.fxml", "#contents");
		 });
		 
		// 수정화면으로 이동 
		 edit_btn.setOnAction(e->{
			 
			 ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "c_dashboard/c_Modify.fxml", "#contents");
		 });
		
		
	}// 초기화 완료부분
	
void setupHeight() {
		

		//webEngine.executeScript("document.body.style.width = '300px';");
        
        
        
		Object result = webEngine.executeScript("document.body.offsetHeight");
        if (result instanceof Integer) {
            Integer i = (Integer) result;
            double height = new Double(i);
            height = height + 60;
            contents.setPrefHeight(height);
           // contents2.getPrefHeight();
        }
	}
}
