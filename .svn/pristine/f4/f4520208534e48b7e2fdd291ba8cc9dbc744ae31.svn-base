package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.ibatis.dao.BoardCommentDao;
import kr.or.ddit.ibatis.dao.BoardCommentDaoImpl;
import kr.or.ddit.ibatis.vo.boarderVO.Board_commentVO;

public class BoardCommentServiceImpl extends UnicastRemoteObject implements BoardCommentService {

	BoardCommentDao comment_dao;
	private static BoardCommentServiceImpl service;

	private BoardCommentServiceImpl() throws RemoteException {
		super();

		comment_dao = BoardCommentDaoImpl.getInstance();
		System.out.println("Comment Accept!");
	}

	public static BoardCommentServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new BoardCommentServiceImpl();
		}
		return service;
	}

	/* 댓글 전체 가져오기 */
	@Override
	public List<Board_commentVO> select_listComment() throws RemoteException {
		List<Board_commentVO> list = comment_dao.select_listComment();

		return list;
	}

	/* 게시글 번호 별 댓글 가져오기 */
	@Override
	public List<Board_commentVO> select_listCommentInboardNo(String board_no) throws RemoteException {
		List<Board_commentVO> list = comment_dao.select_listCommentInboardNo(board_no);
		return list;
	}

	/* 댓글 달기 */
	@Override
	public int insert_comment(Board_commentVO vo) throws RemoteException {
		int cnt = comment_dao.insert_comment(vo);

		return cnt;
	}

	@Override
	public int delete_comment(String comment_no) throws RemoteException {
		int cnt = comment_dao.delete_comment(comment_no);

		return cnt;
		
	}

	@Override
	public int update_comment(Board_commentVO vo) throws RemoteException {
		int cnt = comment_dao.update_comment(vo);
		
		return cnt;
	}

}
