package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.ibatis.dao.PbBoardCommentDao;
import kr.or.ddit.ibatis.dao.PbBoardCommentDaoImpl;
import kr.or.ddit.ibatis.vo.boarderVO.Board_pb_commentVO;

public class PbBoardCommentServiceImpl extends UnicastRemoteObject implements PbBoardCommentService{

	

	PbBoardCommentDao pbComment_dao;
	private static PbBoardCommentServiceImpl service;

	private PbBoardCommentServiceImpl() throws RemoteException {
		super();

		pbComment_dao = PbBoardCommentDaoImpl.getInstance();
		System.out.println("PB _ Comment Accept!");
	}

	public static PbBoardCommentServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new PbBoardCommentServiceImpl();
		}
		return service;
	}
	
	/* 댓글 전체 가져오기*/
	@Override
	public List<Board_pb_commentVO> select_pblistComment() throws RemoteException {
		List<Board_pb_commentVO> list = pbComment_dao.select_pblistComment();
		return list;
	}

	/* 게시글 번호 별 댓글 가져오기*/
	@Override
	public List<Board_pb_commentVO> select_pblistCommentInboardNo(String pb_no) throws RemoteException {
		List<Board_pb_commentVO> list = pbComment_dao.select_pblistCommentInboardNo(pb_no);
		return list;
	}

	
	/* 댓글 달기*/
	@Override
	public int insert_pbcomment(Board_pb_commentVO vo) throws RemoteException {
		int cnt  =  pbComment_dao.insert_pbcomment(vo);
		return cnt;
	}

	@Override
	public int delete_pbcomment(String pb_comment_no) throws RemoteException {
		int cnt = pbComment_dao.delete_pbcomment(pb_comment_no);
		return cnt;
	}

	/*수정하기*/
	@Override
	public int update_pbcomment(Board_pb_commentVO vo) throws RemoteException {
		int cnt = pbComment_dao.update_pbcomment(vo);
		return cnt;
	}

}
