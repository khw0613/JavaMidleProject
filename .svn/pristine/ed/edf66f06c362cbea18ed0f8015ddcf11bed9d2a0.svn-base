package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.vo.memberVO.AttendanceVO;

public interface AttendanceService extends Remote{
	
	public List<AttendanceVO> select_AttendanceList() throws RemoteException; // 전체 출석정보 조회
	
	public List<AttendanceVO> select_AttendanceInfo(String mem_id) throws RemoteException; // 로그인한 회원의 출석정보 조회
	
	public List<AttendanceVO> select_TodayAttendanceList(String days_date) throws RemoteException; // 일별 전체 회원의 출석 현황 조회
	
	public List<AttendanceVO> select_MonthAttendanceInfo(AttendanceVO attendanceVO) throws RemoteException; // 회원의 월별 출석 현황 조회
	
	public int insert_AttendanceInfo(AttendanceVO attendanceVO) throws RemoteException; // 출석정보 삽입
	
	public List<AttendanceVO> select_AttendanceGrapeInfo() throws RemoteException; // 출석 그래프용 메서드(최근 7일자에 대한 출석 카운트)
	
	public List<Map> select_AttendanceRateGrapeInfo() throws RemoteException; // 출석 그래프용 메서드(오늘 날짜의 수강생-수료생 출석 비율)
}

