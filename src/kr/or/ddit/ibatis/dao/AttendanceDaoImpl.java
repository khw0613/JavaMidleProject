package kr.or.ddit.ibatis.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.memberVO.AttendanceVO;

public class AttendanceDaoImpl implements AttendanceDao {
	
	private SqlMapClient smc;
	private static AttendanceDaoImpl dao;

	private AttendanceDaoImpl() {
		smc = DBUTIL1.getInstance();
	}

	public static AttendanceDaoImpl getInstance() {
		if (dao == null) {
			dao = new AttendanceDaoImpl();
		}
		return dao;
	}

	//전체 출석정보 조회
	@Override
	public List<AttendanceVO> select_AttendanceList() {
		System.out.println("select_AttendanceList");
		List<AttendanceVO> list = new ArrayList<AttendanceVO>();
		
		try {
			list = smc.queryForList("qr_attendance.select_AttendanceList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//로그인한 회원의 출석정보 조호;
	@Override
	public List<AttendanceVO> select_AttendanceInfo(String mem_id) {
		
		System.out.println("select_AttendanceInfo");
		System.out.println(mem_id);
		List<AttendanceVO> list = new ArrayList<AttendanceVO>();
		
		try {
			list = smc.queryForList("qr_attendance.select_AttendanceInfo", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//출석정보 삽입
	@Override
	public int insert_AttendanceInfo(AttendanceVO attendanceVO) {
		
//		System.out.println(mem_id);
//		int cnt = 0;
//		try {
//			System.out.println("Test");
//			Object obj = smc.insert("qr_log_window.insert_LogInfo", mem_id);
//			
//			if(obj == null) {
//				cnt = 1;
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		}
//		return cnt;
		int cnt = 0;
		
		try {
			Object obj = smc.insert("qr_attendance.insert_AttendanceInfo", attendanceVO);
			
			if (obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<AttendanceVO> select_TodayAttendanceList(String days_date) {
		List<AttendanceVO> list = new ArrayList<AttendanceVO>();
		
		try {
			list = smc.queryForList("qr_attendance.select_TodayAttendanceList", days_date);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return list;
	}

	@Override
	public List<AttendanceVO> select_MonthAttendanceInfo(AttendanceVO attendanceVO) {
		List<AttendanceVO> list = new ArrayList<AttendanceVO>();
		
		try {
			list = smc.queryForList("qr_attendance.select_MonthAttendanceInfo", attendanceVO);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return list;
	}

	@Override
	public List<AttendanceVO> select_AttendanceGrapeInfo() {
		List<AttendanceVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("qr_attendance.select_AttendanceGrapeInfo");
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return list;
	}

	@Override
	public List<Map> select_AttendanceRateGrapeInfo() {
		List<Map> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("qr_attendance.select_AttendanceRateGrapeInfo");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}

}
