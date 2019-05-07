package kr.or.ddit.ibatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Board_typeVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;

public class BoarderDaoImpl implements BoarderDao {

	private SqlMapClient smc;
	private static BoarderDaoImpl dao;

	private BoarderDaoImpl() {
		smc = DBUTIL1.getInstance();
	}

	public static BoarderDaoImpl getInstance() {
		if (dao == null) {
			dao = new BoarderDaoImpl();
		}
		return dao;
	}

	//공통 게시판별 정보 가져오기
	@Override
	public List<BoardVO> select_boardList(String board_type) {
		
 		System.out.println("Board List Accept!!");
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = smc.queryForList("qr_board.select_boardList", board_type);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	//기수별 게시판 정보 가져오기
	@Override
	public List<BoardVO> select_boardList_degree(String board_type, String degree) {
		HashMap<String, String> pram = new HashMap<String, String>();
		pram.put("board_type", board_type);
		pram.put("degree", degree);
		
		System.out.println("Degree Board List Accept!!");
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = smc.queryForList("qr_board.select_boardList_degree", pram);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
		
		
	}
	//공통 게시글 가져오기
	@Override
	public List<BoardVO> select_common_post(BoardVO boardVO) {
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = smc.queryForList("qr_board.select_common_post", boardVO);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}

	// 기수별 게시판 게시글 가져오기
	@Override
	public List<BoardVO> select_degree_post(BoardVO boardVO) {
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = smc.queryForList("qr_board.select_degree_post", boardVO);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	//공통게시판 게시글 정보 데이터베이스에 삽입하기
	@Override
	public int insert_common_post(BoardVO boardVO) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_board.insert_common_post", boardVO);
			
			if(obj == null) {
				cnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cnt;
	}
	//게시판 게시글 정보 데이터베이스에 삽입하기
	@Override
	public int insert_post(BoardVO boardVO) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_board.insert_post", boardVO);

			if (obj == null) {
				cnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cnt;
	}
	//게시물 정보 수정하기
	@Override
	public int update_post(BoardVO boardno){
		int cnt = 0;
		try {
			cnt = smc.update("qr_board.update_post", boardno);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	// 게시물 삭제하기
	@Override
	public int delete_post(String boardno) {
		int cnt = 0;
		try {
			cnt = smc.delete("qr_board.delete_post", boardno);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
//	조회수 업데이트하기
	@Override
	public int update_viewCount(String boardno) {
		int cnt = 0;
		try {
			cnt = smc.update("qr_board.update_viewCount", boardno);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("다오");
		return cnt;
	}
	
//	작성자로 검색
	@Override
	public List<BoardVO> search_post_to_id(BoardVO boardVO) {
 		System.out.println("Board List Accept!!");
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = smc.queryForList("qr_board.search_post_to_id", boardVO);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	
//	글번호로 검색
	@Override
	public List<BoardVO> search_post_to_no(String search_no) {
 		System.out.println("Board List Accept!!");
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = smc.queryForList("qr_board.search_post_to_no", search_no);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

//	제목으로 검색
	@Override
	public List<BoardVO> search_post_to_title(BoardVO boardVO) {
 		System.out.println("Board List Accept!!");
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = smc.queryForList("qr_board.search_post_to_title", boardVO);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

//	제목 + 내용으로 검색
	@Override
	public List<BoardVO> search_post_to_titleAndcontents(BoardVO boardVO) {
		System.out.println("Board List Accept!!");
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = smc.queryForList("qr_board.search_post_to_titleAndcontents", boardVO);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

//	게시판 유형번호검색
	@Override
	public List<Board_typeVO> select_BoardType() {
		List<Board_typeVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("qr_board.select_BoardType");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

//	게시판이름 검색
	@Override
	public List<Board_typeVO> select_OneBoardType(String board_name) {

		List<Board_typeVO> list = new ArrayList<Board_typeVO>();
		
		try {
			list = smc.queryForList("qr_board.select_OneBoardType", board_name);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<BoardVO> select_notice_post(String degree) {
		List<BoardVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("qr_board.select_notice_post", degree);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}
	
}