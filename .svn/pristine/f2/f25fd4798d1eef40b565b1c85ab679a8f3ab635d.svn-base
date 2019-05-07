package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.ibatis.vo.boarderVO.Board_commentVO;

public interface BoardCommentService extends Remote{
	
	/* 댓글 전체 가져오기*/
	public List<Board_commentVO> select_listComment() throws RemoteException;
	
	/* 게시글 번호 별 댓글 가져오기*/
	public  List<Board_commentVO> select_listCommentInboardNo(String board_no) throws RemoteException;
	
	/* 댓글 달기*/
	public int insert_comment(Board_commentVO vo) throws RemoteException;
	
	/* 댓글 삭제*/
	public int delete_comment(String comment_no) throws RemoteException;
	
	/* 댓글 삭제*/
	public int update_comment(Board_commentVO vo) throws RemoteException;
}
