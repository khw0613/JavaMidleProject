package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import kr.or.ddit.ibatis.vo.hilightVO.PayVO;

public interface PayService extends Remote{
	
	/*형광펜 결제정보 조회하기*/
	public List<PayVO> select_PayList() throws RemoteException;
	
	/* 회원별 형광펜 결제정보 조회하기*/
	public List<PayVO> select_myPayInfo(String mem_id) throws RemoteException;
	
	/* 형광펜 결제하기*/
	public void insert_PayInfo(PayVO vo) throws RemoteException;
	
	/* 형광펜 결제에 의한 형광펜 수량 증가하기*/
	public void addition_myPen_Quantity(String mem_id, String payPen) throws RemoteException;
	
	/* 결제 상세정보 추출(형광펜 사용내역 관리에 필요) */
	public List<PayVO> select_PayDetailInfo(String pay_no) throws RemoteException;
	
}
