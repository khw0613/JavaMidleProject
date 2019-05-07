package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.ibatis.vo.boarderVO.Board_pb_commentVO;

public interface PbBoardCommentService extends Remote{
	
	
	/* 댓글 전체 가져오기*/
	public List<Board_pb_commentVO> select_pblistComment() throws RemoteException;
	
	/* 게시글 번호 별 댓글 가져오기*/
	public List<Board_pb_commentVO> select_pblistCommentInboardNo(String pb_no) throws RemoteException;
	
	/* 댓글 달기*/
	public int insert_pbcomment(Board_pb_commentVO vo) throws RemoteException;
	
	/* 댓글 삭제*/
	public int delete_pbcomment(String pb_comment_no) throws RemoteException;
	
	/* 댓글 삭제*/
	public int update_pbcomment(Board_pb_commentVO vo) throws RemoteException;
	

}
