package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.ibatis.dao.BoarderDao;
import kr.or.ddit.ibatis.dao.BoarderDaoImpl;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Board_typeVO;

public class BoarderServiceImpl extends UnicastRemoteObject implements BoarderService {

	BoarderDao board_dao;
	private static BoarderServiceImpl service;

	private BoarderServiceImpl() throws RemoteException {
		super();

		board_dao = BoarderDaoImpl.getInstance();
		System.out.println("BoarderDao Accept!");
	}

	public static BoarderServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new BoarderServiceImpl();
		}
		return service;
	}

	// 게시판 데이터 가져오기
	@Override
	public List<BoardVO> select_boardList(String board_type) throws RemoteException {

		List<BoardVO> list = board_dao.select_boardList(board_type);

		return list;

	}
	//기수별 게시판 정보 가져오기
	@Override
	public List<BoardVO> select_boardList_degree(String board_type, String degree) throws RemoteException {
		List<BoardVO> list = board_dao.select_boardList_degree(board_type, degree);
		return list;
	}
	//공통 게시글 가져오기
	@Override
	public List<BoardVO> select_common_post(BoardVO boardVO) throws RemoteException{
		List<BoardVO> list = board_dao.select_common_post(boardVO);
		return list;
	}
	// 기수별 게시판 게시글 가져오기
	@Override
	public List<BoardVO> select_degree_post(BoardVO boardVO) throws RemoteException {
		List<BoardVO> list = board_dao.select_degree_post(boardVO);
		return list;
	}
	//공통게시판 게시글 정보 데이터베이스에 삽입하기
	@Override
	public int insert_common_post(BoardVO boardVO) throws RemoteException {
		int cnt = board_dao.insert_common_post(boardVO);
		return cnt;
	}
	//게시판 게시글 정보 데이터베이스에 삽입하기
	@Override
	public int insert_post(BoardVO boardVO) throws RemoteException {
		int cnt = board_dao.insert_post(boardVO);
		return cnt;
	}
	//게시물 정보 수정하기
	@Override
	public int update_post(BoardVO boardno) throws RemoteException {
		int cnt = board_dao.update_post(boardno);
		return cnt;
	}
	//게시물 삭제하기
	@Override
	public int delete_post(String boardno) throws RemoteException {
		int cnt = board_dao.delete_post(boardno);
		return cnt;
	}
	//조회수 업데이트 하기
	@Override
	public int  update_viewCount(String boardno) throws RemoteException {
		int cnt = board_dao.update_viewCount(boardno);
		return cnt;
		
	}

	@Override
	public List<BoardVO> search_post_to_id(BoardVO boardno) throws RemoteException {
		List<BoardVO> list = board_dao.search_post_to_id(boardno);
		return list;
	}

	@Override
	public List<BoardVO> search_post_to_no(String search_no) throws RemoteException {
		List<BoardVO> list = board_dao.search_post_to_no(search_no);
		return list;
	}

	@Override
	public List<BoardVO> search_post_to_title(BoardVO boardno) throws RemoteException {
		List<BoardVO> list = board_dao.search_post_to_title(boardno);
		return list;
	}

	@Override
	public List<BoardVO> search_post_to_titleAndcontents(BoardVO boardno) throws RemoteException {
		List<BoardVO> list = board_dao.search_post_to_titleAndcontents(boardno);
		return list;
	}

	@Override
	public List<Board_typeVO> select_BoardType() throws RemoteException {
		List<Board_typeVO> list = board_dao.select_BoardType();
		return list;
	}

	@Override
	public List<Board_typeVO> select_OneBoardType(String board_name) throws RemoteException {
		List<Board_typeVO> list = board_dao.select_OneBoardType(board_name);
		return list;
	}

	@Override
	public List<BoardVO> select_notice_post(String degree) throws RemoteException {
		List<BoardVO> list = board_dao.select_notice_post(degree);
		return list;
	}
}