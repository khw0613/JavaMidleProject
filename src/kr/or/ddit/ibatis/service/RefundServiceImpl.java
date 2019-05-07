package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import kr.or.ddit.ibatis.dao.RefundDao;
import kr.or.ddit.ibatis.dao.RefundDaoImpl;
import kr.or.ddit.ibatis.dao.ResMenuDao;
import kr.or.ddit.ibatis.dao.ResMenuDaoImpl;
import kr.or.ddit.ibatis.dao.SupportPenDao;
import kr.or.ddit.ibatis.dao.SupportPenDaoImpl;
import kr.or.ddit.ibatis.vo.hilightVO.RefundVO;
import kr.or.ddit.ibatis.vo.hilightVO.Refund_typeVO;
import kr.or.ddit.ibatis.vo.hilightVO.Surpport_penVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;

public class RefundServiceImpl extends UnicastRemoteObject implements RefundService{

	RefundDao refund_dao;
	private static RefundServiceImpl service;

	private RefundServiceImpl() throws RemoteException {
		super();

		refund_dao = RefundDaoImpl.getInstance();
		System.out.println("Refund Accept!");

	}

	public static RefundServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new RefundServiceImpl();
		}
		return service;
	}
	//모든 환불정보 조회하기
	@Override
	public List<RefundVO> select_RefundList() throws RemoteException {
		
		return refund_dao.select_RefundList();
	}
	//회원별 환불정보 조회하기
	@Override
	public List<RefundVO> select_myRefundInfo(String memid) throws RemoteException {
		return refund_dao.select_myRefundInfo(memid);
	}
	//형광펜 환불하기
	@Override
	public int insert_RefundInfo(RefundVO refundVO) throws RemoteException {
		
		return refund_dao.insert_RefundInfo(refundVO);
	}
	//회원 형광펜 수량 업데이트 하기(환불에 의한 감소)
	@Override
	public void subtration_myPen_Quantity(String refundPen, String mem_id) throws RemoteException {
		refund_dao.subtration_myPen_Quantity(refundPen, mem_id);
	}

	@Override
	public List<RefundVO> select_RefundDetailInfo(RefundVO refundVO) throws RemoteException {
		List<RefundVO> list = refund_dao.select_RefundDetailInfo(refundVO);
		return list;
	}

	
	

}
