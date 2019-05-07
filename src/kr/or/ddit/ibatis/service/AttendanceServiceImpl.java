package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.dao.AttendanceDao;
import kr.or.ddit.ibatis.dao.AttendanceDaoImpl;
import kr.or.ddit.ibatis.dao.BoardCommentDao;
import kr.or.ddit.ibatis.dao.BoardCommentDaoImpl;
import kr.or.ddit.ibatis.vo.memberVO.AttendanceVO;

public class AttendanceServiceImpl extends UnicastRemoteObject implements AttendanceService {
	
	AttendanceDao attendance_dao;
	private static AttendanceServiceImpl service;

	private AttendanceServiceImpl() throws RemoteException {
		super();

		attendance_dao = AttendanceDaoImpl.getInstance();
		System.out.println("Comment Accept!");
	}

	public static AttendanceServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new AttendanceServiceImpl();
		}
		return service;
	}
	
	//전체 출석정보 조회
	@Override
	public List<AttendanceVO> select_AttendanceList() throws RemoteException {
		List<AttendanceVO> list = attendance_dao.select_AttendanceList();
		return list;
	}
	
	//로그인한 회원의 출석정보 조회
	@Override
	public List<AttendanceVO> select_AttendanceInfo(String mem_id) throws RemoteException {
		List<AttendanceVO> list = attendance_dao.select_AttendanceInfo(mem_id);
		return list;
	}

	//출석정보 삽입
	@Override
	public int insert_AttendanceInfo(AttendanceVO attendanceVO) throws RemoteException {
		int cnt = attendance_dao.insert_AttendanceInfo(attendanceVO);
		return cnt;
	}

	// 일별 전체 회원의 출석 현황 조회
	@Override
	public List<AttendanceVO> select_TodayAttendanceList(String days_date) throws RemoteException {
		List<AttendanceVO> list = attendance_dao.select_TodayAttendanceList(days_date);
		return list;
	}

	// 회원의 월별 출석 현황 조회
	@Override
	public List<AttendanceVO> select_MonthAttendanceInfo(AttendanceVO attendanceVO) throws RemoteException {
		List<AttendanceVO> list = attendance_dao.select_MonthAttendanceInfo(attendanceVO);
		return list;
	}

	@Override
	public List<AttendanceVO> select_AttendanceGrapeInfo() throws RemoteException {
		List<AttendanceVO> list = attendance_dao.select_AttendanceGrapeInfo();
		return list;
	}

	@Override
	public List<Map> select_AttendanceRateGrapeInfo() throws RemoteException {
		List<Map> list = attendance_dao.select_AttendanceRateGrapeInfo();
		return list;
	}

}
