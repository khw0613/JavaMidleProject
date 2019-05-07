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
import kr.or.ddit.ibatis.vo.boarderVO.Board_commentVO;
import kr.or.ddit.ibatis.vo.hilightVO.Surpport_penVO;

public class BoardCommentDaoImpl implements BoardCommentDao {

	private SqlMapClient smc;
	private static BoardCommentDaoImpl dao;

	private BoardCommentDaoImpl() {
		smc = DBUTIL1.getInstance();
	}

	public static BoardCommentDaoImpl getInstance() {
		if (dao == null) {
			dao = new BoardCommentDaoImpl();
		}
		return dao;
	}

	/* 댓글 전체 가져오기 */
	@Override
	public List<Board_commentVO> select_listComment() {
		System.out.println("Select List Comment List");
		List<Board_commentVO> list = new ArrayList<Board_commentVO>();

		try {
			list = smc.queryForList("qr_boardComment.select_listComment");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	/* 게시글 번호 별 댓글 가져오기 */
	@Override
	public List<Board_commentVO> select_listCommentInboardNo(String board_no) {
		System.out.println("Select List Comment In board List");
		List<Board_commentVO> list = new ArrayList<Board_commentVO>();

		try {
			list = smc.queryForList("qr_boardComment.select_listCommentInboardNo", board_no);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	/* 댓글 달기 */
	@Override
	public int insert_comment(Board_commentVO vo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_boardComment.insert_comment", vo);

			if (obj == null) {
				cnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cnt;
	}

	@Override
	public int delete_comment(String comment_no) {
		int cnt = 0;
		try {
			cnt = smc.delete("qr_boardComment.delete_comment", comment_no);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int update_comment(Board_commentVO vo) {
		int cnt = 0;
		try {
			cnt = smc.delete("qr_boardComment.update_comment", vo);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
