package kr.or.ddit.ibatis.dao;

import java.util.List;

import kr.or.ddit.ibatis.vo.boarderVO.Board_commentVO;

public interface BoardCommentDao {
	
	/* 댓글 전체 가져오기*/
	public List<Board_commentVO> select_listComment();
	
	/* 게시글 번호 별 댓글 가져오기*/
	public List<Board_commentVO> select_listCommentInboardNo(String board_no);
	
	/* 댓글 달기*/
	public int insert_comment(Board_commentVO vo);
	
	/* 댓글 삭제*/
	public int delete_comment(String comment_no);
	
	/* 댓글 삭제*/
	public int update_comment(Board_commentVO vo);
	
	

}
