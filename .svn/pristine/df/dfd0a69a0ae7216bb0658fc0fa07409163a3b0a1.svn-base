package kr.or.ddit.ibatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_boardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_board_typeVO;

public class PersnalBoardDaoImpl implements PersnalBoardDao{
	
	private SqlMapClient smc;
	private static PersnalBoardDaoImpl dao;

	private PersnalBoardDaoImpl() {
		smc = DBUTIL1.getInstance();
		
	}
	
	public static PersnalBoardDaoImpl getInstance() {
		if(dao == null) {
			dao = new PersnalBoardDaoImpl();
		}
		return dao;
	}
//	개인 방명록 정보 가져오기
	@Override
	public List<Persnal_boardVO> select_guestBook(String mem_id) {
		List<Persnal_boardVO> list = new ArrayList<Persnal_boardVO>();
		
		try {
			list = smc.queryForList("qr_persnal_board.select_GuestBookList", mem_id);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
//	개인게시판 정보 가져오기
	@Override
	public List<Persnal_boardVO> select_PersnalBoardList(String mem_id) {
		List<Persnal_boardVO> list = new ArrayList<Persnal_boardVO>();

		try {
			list = smc.queryForList("qr_persnal_board.select_PersnalBoardList", mem_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}
//	개인게시판 게시글 정보 가져오기
	@Override
	public List<Persnal_boardVO> select_PersnalBoard_post(String pb_no) {
		List<Persnal_boardVO> list = new ArrayList<Persnal_boardVO>();

		try {
			list = smc.queryForList("qr_persnal_board.select_PersnalBoard_post", pb_no);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}
//	개인 게시판 글 작성
	@Override
	public int insert_PersnalBoard_post(HashMap<String, String> map) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_persnal_board.insert_PersnalBoard_post", map);
			
			if(obj == null) {
				cnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cnt;
	}
//	방명록 글 작성
	@Override
	public int insert_GuestBook_post(HashMap<String, String> map) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_persnal_board.insert_GuestBook_post", map);
			
			if(obj == null) {
				cnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cnt;
	}
//	개인게시판 게시글 수정하기
	@Override
	public int update_PersnalBoard_post(Persnal_boardVO pbVO) {
		int cnt = 0;
		
		try {
			cnt = smc.update("qr_persnal_board.update_PersnalBoard_post", pbVO);
			System.out.println("Dao");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

//	방명록 수정하기
	@Override
	public int update_GuestBook_post(Persnal_boardVO pbVO) {
		int cnt = 0;
		try {
			cnt = smc.update("qr_persnal_board.update_GuestBook_post", pbVO);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
//	개인게시판 게시글 삭제하기
	@Override
	public int delete_PersnalBoard_post(String pb_no) {
		int cnt = 0;
		try {
			cnt = smc.delete("qr_persnal_board.delete_PersnalBoard_post", pb_no);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	//개인 게시판 유형 조회
	@Override
	public List<Persnal_board_typeVO> select_PBtype() {
		
		List<Persnal_board_typeVO> list = new ArrayList<Persnal_board_typeVO>();
		
		try {
			list = smc.queryForList("qr_persnal_board.select_PBtype");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//개인 게시판 유형 검색(유형 명으로 검색)
	@Override
	public List<Persnal_board_typeVO> select_OnePBtype(String persnal_board_type) {
		List<Persnal_board_typeVO> list = new ArrayList<Persnal_board_typeVO>();
		
		try {
			list = smc.queryForList("qr_persnal_board.select_OnePBtype", persnal_board_type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 개인 게시판 조회수 업데이트
	@Override
	public int update_PostViewCount(String pb_no) {
		int cnt = 0;
		
		try {
			cnt = smc.update("qr_persnal_board.update_PostViewCount", pb_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	
	
}
