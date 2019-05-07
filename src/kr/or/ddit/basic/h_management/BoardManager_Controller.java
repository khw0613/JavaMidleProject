package kr.or.ddit.basic.h_management;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.basic.Main;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.communityVO.MessageBoxVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;
import javafx.scene.control.Pagination;

public class BoardManager_Controller implements Initializable{
	
	
	@FXML JFXComboBox<String> b_degree;				// 기수 콤보박스
	@FXML JFXComboBox<String> b_boardType;			// 보드타입 콤보박스
	@FXML Button manager_view;						// 게시판 조회하기

	
	@FXML TableView<BoardVO> m_tableView;
	@FXML TableColumn<BoardVO, String> mb_no;
	@FXML TableColumn<BoardVO, String> mb_title;
	@FXML TableColumn<BoardVO, String> mb_author;
	@FXML TableColumn<BoardVO, String> mb_date;
	@FXML TableColumn<BoardVO, String> mb_view;
	@FXML Button mb_del_btn;						// 삭제버튼
	@FXML Pagination paging;						// 페이징
	
	int from, to, itemsForPage;
	ObservableList<BoardVO> boardData = null;
	ObservableList<BoardVO> data = null;
	ObservableList<BoardVO> currentPageData = null;
	ObservableList<String> boardTypeCombo2 = null;
	List<String> boardTypeCombo;
	
	BoardVO board = new BoardVO();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		// DB접속 : 데이터 셋팅 : 기수
		HashSet<String> degreeCombo = new HashSet<>();
		boardTypeCombo = new ArrayList<>();
		
		
		
		try {
			Global.DbConnect();
			List<MemberVO> list = Global.memberService.select_MemberList();
			degreeCombo.add("공용게시판");
			for (int i = 0; i < list.size(); i++) {
				degreeCombo.add(list.get(i).getDegree());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ObservableList<String> degreeCombo2 = FXCollections.observableArrayList(degreeCombo);
		b_degree.setItems(degreeCombo2);

		ObservableList<String> boardCombo2 = FXCollections.observableArrayList();
		b_boardType.setItems(boardCombo2);

		b_degree.valueProperty().addListener((observable, oldV, newV) -> {
			String textValue = newV;

			if (textValue.equals("공용게시판")) {
				boardCombo2.clear();
				boardCombo2.add("4.[공통]스터디 게시판");
				boardCombo2.add("5.[공통]자유게시판");
				boardCombo2.add("6.[공통]오픈소스 게시판");
			} else {
				boardCombo2.clear();
				boardCombo2.add("1.[기수별]공지사항");
				boardCombo2.add("2.[기수별]우리반 게시판");
				boardCombo2.add("3.[기수별]스터디 게시판");
			}
				
			});
		
		
		// 조회하기 버튼 : 데이터 가져오기
		manager_view.setOnAction(e-> {

			// 데이터 조회 할 값 뽑아오기
			String viewDegree = b_degree.getValue();
			String viewb_boardType = b_boardType.getValue().substring(0, 1);

			// 테이블 뷰 컬럼 연결
			mb_no.setCellValueFactory(new PropertyValueFactory<>("board_no"));
			mb_title.setCellValueFactory(new PropertyValueFactory<>("board_title"));
			mb_author.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
			mb_date.setCellValueFactory(new PropertyValueFactory<>("board_date"));
			mb_view.setCellValueFactory(new PropertyValueFactory<>("board_view"));

			
			// 공용 게시판 데이터 추출
			if (viewDegree.equals("공용게시판")) {
				try {
					List<BoardVO> list = Global.boarderService.select_boardList(viewb_boardType);
					boardData = FXCollections.observableArrayList(list);

					m_tableView.setItems(boardData);
					
					mb_del_btn.setOnAction(e1 -> {
						BoardVO vo = m_tableView.getSelectionModel().getSelectedItem();
						String delNo = vo.getBoard_no();
						System.out.println(delNo);

						try {
							int cnt = Global.boarderService.delete_post(delNo);
							if (cnt != 0) {
								boardData.remove(vo);
								ShinYS.infoMsg("게시판 관리자 모드", "게시글이 정상적으로 삭제되었습니다.");
								
							}
							
						} catch (RemoteException e2) {
							e2.printStackTrace();
						}
						m_tableView.refresh();
					});
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

			// 기수별 게시판 데이터 추출
			if(viewb_boardType.equals("1") || viewb_boardType.equals("2") || viewb_boardType.equals("3")) {
				try {
					List<BoardVO> list = Global.boarderService.select_boardList_degree(viewb_boardType, viewDegree);
					boardData = FXCollections.observableArrayList(list);

					m_tableView.setItems(boardData);
					
					mb_del_btn.setOnAction(e1 -> {
						BoardVO vo = m_tableView.getSelectionModel().getSelectedItem();
						String delNo = vo.getBoard_no();
						System.out.println(delNo);

						try {
							int cnt = Global.boarderService.delete_post(delNo);
							if (cnt != 0) {
								boardData.remove(vo);
								ShinYS.infoMsg("게시판 관리자 모드", "게시글이 정상적으로 삭제되었습니다.");
							
							}
						} catch (RemoteException e2) {
							e2.printStackTrace();
						} 

						
					});
				
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} 
			}
			
			itemsForPage = 10; 
			int totPageCount = boardData.size()%itemsForPage == 0 ? boardData.size()/itemsForPage : boardData.size()/itemsForPage + 1;
			
			if (boardData.size() < 1) {
			totPageCount = 1;
			}
			
			paging.setPageCount(totPageCount); 
			
			paging.setPageFactory((Integer pageIndex) -> {
			
				from = pageIndex * itemsForPage;
				to = from + itemsForPage - 1; 
//				m_tableView.setItems(getTableViewData(from, to, boardData));
				
				return m_tableView;
			 
			});
			
			
			
			
		});
	// 더블 클릭시 상세보기
		
		m_tableView.setOnMouseClicked(e->{
			if(e.getClickCount() ==2) {
				BoardVO bvo = m_tableView.getSelectionModel().getSelectedItem();
				ShinYS.mem = bvo;
				
				Stage board_detile = new Stage(StageStyle.DECORATED);
				board_detile.initModality(Modality.APPLICATION_MODAL);
				board_detile.initOwner(Main.StageHome);
				Parent parent = null;
				try {
					parent = FXMLLoader.load(getClass().getResource("../h_management/Board_detail_admin.fxml"));
					List<BoardVO> list = Global.boarderService.select_degree_post(bvo);
					System.out.println(list.size());

				} catch (Exception e1) {
					e1.printStackTrace();
				}

				Scene scene = new Scene(parent);
				board_detile.setTitle("Message Box");
				board_detile.setScene(scene);
				board_detile.show();
				
			}
		});
		
	}
	
	private Node createPage(int pageIndex) {

		from = pageIndex * itemsForPage;
		to = from + itemsForPage - 1;

		m_tableView.setItems(getTableViewData(from, to));
			
		return m_tableView;
	}
	
	private ObservableList<BoardVO> getTableViewData(int from, int to) {

		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = data.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData.add(data.get(i));
		}

		return currentPageData;
	}

}
