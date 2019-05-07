package kr.or.ddit.ibatis.dao;

import java.util.List;

import kr.or.ddit.ibatis.vo.boarderVO.Board_pb_commentVO;

public interface PbBoardCommentDao {
	
	/* 댓글 전체 가져오기*/
	public List<Board_pb_commentVO> select_pblistComment();
	
	/* 게시글 번호 별 댓글 가져오기*/
	public List<Board_pb_commentVO> select_pblistCommentInboardNo(String pb_no);
	
	/* 댓글 달기*/
	public int insert_pbcomment(Board_pb_commentVO vo);
	
	/* 댓글 삭제*/
	public int delete_pbcomment(String pb_comment_no);
	
	/* 댓글 삭제*/
	public int update_pbcomment(Board_pb_commentVO vo);
	

}
