package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import kr.or.ddit.ibatis.vo.hilightVO.Surpport_penVO;

public interface SupportPenService extends Remote{
	
	
	/* 전체 후원 정보 조회하기*/
	public List<Surpport_penVO> select_SupportList() throws RemoteException;
	
	/* 내가 준 후원정보 조회하기*/
	public List<Surpport_penVO> select_GiveInfo(String mem_id) throws RemoteException;
	
	/* 내가 받은 후원정보 조회하기*/
	public List<Surpport_penVO> select_ReceiveInfo(String receive_id) throws RemoteException;
	
	/* 형광펜 후원하기 */
	public int insert_SupportInfo(Surpport_penVO vo) throws RemoteException;
	
	/* 회원의 형광펜 수량 변경하기 (주는 회원 기준 : 감소하기)*/
	public void subtration_myPen_Quantity2(String mem_id, String usePen) throws RemoteException;
	
	/* 회원의 형광펜 수량 변경하기 (받는 회원 기준 : 증가하기)*/
	public void addition_myPen_Quantity2(String mem_id, String usePen) throws RemoteException;
	
//	형관펜 후원정보 가져오기(형관펜 사용내역 관리에 필요)
	public List<Surpport_penVO> select_SupportDetailInfo(String support_no) throws RemoteException;

}
