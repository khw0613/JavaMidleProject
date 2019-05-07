package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.ibatis.vo.memberVO.Log_WindowVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;

public interface LogWindowService extends Remote{
	
	public List<MemberVO> select_LogInfo() throws RemoteException;
	
	public int insert_LogInfo(String mem_id) throws RemoteException;
	
	public void delete_LogInfo(String mem_id) throws RemoteException;
	
}
