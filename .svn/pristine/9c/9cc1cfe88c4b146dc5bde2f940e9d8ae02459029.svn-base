package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.ibatis.vo.hilightVO.ExchangeVO;
import kr.or.ddit.ibatis.vo.memberVO.Log_WindowVO;

public interface ExchangeService extends Remote{
	
	public List<ExchangeVO> select_ExchangeList() throws RemoteException; //전체 환정정보 조회
	
	public List<ExchangeVO> select_ExchangeInfo(String mem_id) throws RemoteException; //회원별 환불정보 조회(내 환불정보 보기)
	
	public int insert_ExchangeInfo(ExchangeVO exchangeVO) throws RemoteException; //환전정보 삽입
	
	public void subtration_myPen_Quantity3(String exchangePen, String mem_id) throws RemoteException; //회원 형광펜 수량 업데이트 하기(환전에 의한 감소-주는 회원)
	
	public List<ExchangeVO> select_ExchangeDetailInfo(String exchange_no) throws RemoteException; //형광펜 환전정보 가져오기(형관펜 사용내역 관리에 필요)
	
}
