package kr.or.ddit.basic.h_management;

import java.lang.reflect.Field;
import java.net.URL;
import java.nio.channels.ShutdownChannelGroupException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.SwingUtilities;

import com.sun.webkit.WebPage;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
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
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import library.Global;
import library.ShinYS;

public class BoardDetail_Controller implements Initializable{

	@FXML Label title_lb;
	@FXML Label no_lb;
	@FXML Label date_lb;
	@FXML Label writer_lb;
	@FXML Label view_lb;
	@FXML WebView contents;
	@FXML Button list_btn;
	@FXML Button del_btn;
	@FXML Button edit_btn;
	
	List<BoardVO> data;
	WebEngine webEngine;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 관리자는 글목록과 삭제버튼만 보이게
		edit_btn.setVisible(false);
		try {
			data = Global.boarderService.select_degree_post(ShinYS.mem);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		title_lb.setText(ShinYS.mem.getBoard_title());
		no_lb.setText(ShinYS.mem.getBoard_no());
		date_lb.setText(ShinYS.mem.getBoard_date());
		writer_lb.setText(ShinYS.mem.getMem_id());
		view_lb.setText(ShinYS.mem.getBoard_view());
		
		contents.setOnScroll(e->{
			ScrollPane cs = (ScrollPane) Main.StageHome.getScene().getRoot().lookup("#contents");
			  
			cs.setVvalue(cs.getVvalue() - (e.getDeltaY()*0.01));
			cs.setHvalue(cs.getHvalue() - (e.getDeltaX()*0.01));
      	   
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
	            	
	            	String st = ShinYS.mem.getBoard_contents();
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
	}
	
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
