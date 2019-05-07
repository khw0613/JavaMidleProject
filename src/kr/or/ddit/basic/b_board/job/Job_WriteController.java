package kr.or.ddit.basic.b_board.job;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import kr.or.ddit.basic.Main;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Board_typeVO;
import library.Global;
import library.ShinYS;

public class Job_WriteController implements Initializable {

		@FXML TextField title_txt;
		@FXML Button cancel_btn;
		@FXML Button sub_btn;
		@FXML HTMLEditor content_txt;
		@FXML TextField writer_txt;
		@FXML Button btn_image;
		
		List<Board_typeVO> board_type = null;
		BoardVO vo = new BoardVO();
		@FXML ImageView imageview; // 이미지업로드
		@FXML Button btn_loadfile; // 파일업로드
		
		Image fximage;
		
		File file_out;
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//이미지 삽입
		
		btn_image.setOnAction(e ->{
			
				FileChooser fileChooser = new FileChooser();
				
				//확장자별로 파일 구분하는 필터 등록하기
				fileChooser.getExtensionFilters().addAll(
						new ExtensionFilter("Text Files","*.txt"),
						new ExtensionFilter("Image Files", "*.png","*.jpg","*.gif"),
						new ExtensionFilter("Audio Files", "*.wave","*.mp3"),
						new ExtensionFilter("All Files", "*.*")
						);
				
				
				
				
				try {
					File selectFile = fileChooser.showOpenDialog(Main.StageHome);
					FileInputStream fin = new FileInputStream(selectFile);
					BufferedInputStream bin = new BufferedInputStream(fin);
					
					System.out.println("경로테스트 : " + selectFile.getPath());
					
					Date today = new Date();
				    System.out.println(today);
				        
				    SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
				    SimpleDateFormat time = new SimpleDateFormat("hhmmss");
				        
				    System.out.println("Date: "+date.format(today));
				    System.out.println("Time: "+time.format(today));

				    String nowDates = date.format(today);
				    String nowTimes = time.format(today);
					
					
					file_out = new File("lib/photo/" +(nowDates+nowTimes)+".jpg");
					FileOutputStream fout = new FileOutputStream(file_out);
					BufferedOutputStream bout = new BufferedOutputStream(fout);
					
					int c;
					
					while((c = bin.read()) != -1) {
						bout.write(c);
					}
					
					bout.close();
					bin.close();
					
					
					fximage = new Image(selectFile.toURL().toString());
					
					imageview.setImage(fximage);
					
					
					if(selectFile!=null) {
						//이 영역에서 파일내용을 읽어오는 작업을 수행한다.
						System.out.println("OPEN : "+selectFile.getPath());
					}
					
				} catch (FileNotFoundException gg) {
					gg.printStackTrace();
				} catch (IOException gg) {
					gg.printStackTrace();
				}
				
			
		});
		
		
		
		
		
		
		try {
			board_type = Global.boarderService.select_OneBoardType(ShinYS.select_Board);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		String type = board_type.get(0).getBoard_type();
		String name = board_type.get(0).getBoard_name();
		
		
		// 보여주기
		
		if(board_type.get(0).getBoard_type().equals("2") || board_type.get(0).getBoard_type().equals("5")) {
			btn_loadfile.setVisible(false);
		}else {
			btn_loadfile.setVisible(true);
		}
		
		
		
		
		
		
		cancel_btn.setOnMouseClicked(e->{
		
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "b_board/Board.fxml", "#contents");
		
		});
		
		
		sub_btn.setOnMouseClicked(e->{
			
			//취업게시판 보드타입 '4'번
			
			System.out.println("ddddd : " + board_type.get(0).getBoard_type());
			
			
//			String st = content_txt.getHtmlText();
//			if(st.contains("contenteditable=\"true\"")){
//				st=st.replace("contenteditable=\"true\"", "contenteditable=\"false\"");
//			}
			
			
			
			vo.setBoard_type(board_type.get(0).getBoard_type());
			vo.setMem_id(ShinYS.query_id);
			vo.setBoard_title(title_txt.getText());
			vo.setBoard_contents(content_txt.getHtmlText());
			
			
			
			if(file_out != null) {
			vo.setBoard_image(file_out.toURI().toString());		
			//vo.setBoard_image(fximage.impl_getUrl());		
			
			}
			
			
			imageview.setImage(fximage);// 첨부파일 (NULL 허용)
			
			try {
				Global.boarderService.insert_post(vo);
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			ShinYS.<AnchorPane>ChangePage(getClass(), Global.RootDir + "b_board/Board.fxml", "#contents");
		});
		
		
		

	}
	
}