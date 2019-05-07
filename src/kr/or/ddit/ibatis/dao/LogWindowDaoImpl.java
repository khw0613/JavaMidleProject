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
import kr.or.ddit.ibatis.vo.memberVO.Log_WindowVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;

public class LogWindowDaoImpl implements LogWindowDao {
	
	private SqlMapClient smc;
	private static LogWindowDaoImpl dao;

	private LogWindowDaoImpl() {
		smc = DBUTIL1.getInstance();
	}

	public static LogWindowDaoImpl getInstance() {
		if (dao == null) {
			dao = new LogWindowDaoImpl();
		}
		return dao;
	}
	
	
	//로그인 정보 가져오기
	@Override
	public List<MemberVO> select_LogInfo() {
		List<MemberVO> id = new ArrayList<MemberVO>(); 
		
		try {
			id = smc.queryForList("qr_log_window.select_LogInfo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	//로그인 정보 삽입하기
	@Override
	public int insert_LogInfo(String mem_id) {
		System.out.println("Accept Dao");
		System.out.println(mem_id);
		int cnt = 0;
		try {
			System.out.println("Test");
			Object obj = smc.insert("qr_log_window.insert_LogInfo", mem_id);
			
			if(obj == null) {
				cnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cnt;
	}

	//로그인 정보 삭제하기
	@Override
	public int delete_LogInfo(String mem_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("qr_log_window.delete_LogInfo", mem_id);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
