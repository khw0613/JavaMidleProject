package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.ibatis.dao.LogWindowDao;
import kr.or.ddit.ibatis.dao.LogWindowDaoImpl;
import kr.or.ddit.ibatis.vo.memberVO.Log_WindowVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;

public class LogWindowServiceImpl extends UnicastRemoteObject implements LogWindowService {
	
	LogWindowDao log_dao;
	private static LogWindowServiceImpl service;

	private LogWindowServiceImpl() throws RemoteException {
		super();

		log_dao = LogWindowDaoImpl.getInstance();
		System.out.println("LogWindow Accept!");
	}

	public static LogWindowServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new LogWindowServiceImpl();
		}
		return service;
	}
	//로그인 정보 가져오기
	@Override
	public List<MemberVO> select_LogInfo() throws RemoteException {
		List<MemberVO> id = log_dao.select_LogInfo();
		return id;
	}
	//로그인 정보 삽입하기
	@Override
	public int insert_LogInfo(String mem_id) throws RemoteException {
		System.out.println("Service LogWindow");
		int cnt = log_dao.insert_LogInfo(mem_id);
		
		return cnt;
	}
	//로그인 정보 삭제하기
	@Override
	public void delete_LogInfo(String mem_id) throws RemoteException {
		log_dao.delete_LogInfo(mem_id);
	}

}
