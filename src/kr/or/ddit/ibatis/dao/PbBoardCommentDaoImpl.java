package kr.or.ddit.ibatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.boarderVO.Board_pb_commentVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;

public class PbBoardCommentDaoImpl implements PbBoardCommentDao{

	private SqlMapClient smc;
	private static PbBoardCommentDaoImpl dao;

	private PbBoardCommentDaoImpl() {
		smc = DBUTIL1.getInstance();
		
	}
	
	public static PbBoardCommentDaoImpl getInstance() {
		if(dao == null) {
			dao = new PbBoardCommentDaoImpl();
		}
		return dao;
	}
	
	
	
	/* 댓글 전체 가져오기*/
	@Override
	public List<Board_pb_commentVO> select_pblistComment() {
		List<Board_pb_commentVO> list = new ArrayList<Board_pb_commentVO>();

		try {
			list = smc.queryForList("qr_pbboardComment.select_pblistComment");
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	
	
	/* 게시글 번호 별 댓글 가져오기*/
	@Override
	public List<Board_pb_commentVO> select_pblistCommentInboardNo(String pb_no) {
		List<Board_pb_commentVO> list = new ArrayList<Board_pb_commentVO>();

		try {
			list = smc.queryForList("qr_pbboardComment.select_pblistCommentInboardNo", pb_no);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	
	
	/* 댓글 달기*/
	@Override
	public int insert_pbcomment(Board_pb_commentVO vo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_pbboardComment.insert_pbcomment", vo);

			if (obj == null) {
				cnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cnt;
	}
	
	
	/*댓글 삭제하기*/
	@Override
	public int delete_pbcomment(String pb_comment_no) {
		int cnt = 0;
		try {
			cnt = smc.delete("qr_pbboardComment.delete_pbcomment", pb_comment_no);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	/*댓글 수정하기*/
	@Override
	public int update_pbcomment(Board_pb_commentVO vo) {
		int cnt = 0;
		try {
			cnt = smc.update("qr_pbboardComment.update_pbcomment", vo);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


}
