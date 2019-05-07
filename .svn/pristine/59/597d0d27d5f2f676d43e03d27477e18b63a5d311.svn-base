package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import kr.or.ddit.ibatis.dao.PayDao;
import kr.or.ddit.ibatis.dao.PayDaoImpl;
import kr.or.ddit.ibatis.vo.hilightVO.PayVO;

public class PayServiceImpl extends UnicastRemoteObject implements PayService{

	PayDao pay_dao;
	private static PayServiceImpl service;

	private PayServiceImpl() throws RemoteException {
		super();

		pay_dao = PayDaoImpl.getInstance();
		System.out.println("PayDao Accept!");
	}

	public static PayServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new PayServiceImpl();
		}
		return service;
	}
	
	
	/*형광펜 결제정보 조회하기*/
	@Override
	public List<PayVO> select_PayList() throws RemoteException {
		List<PayVO> list = pay_dao.select_PayList();
		return list;
	}

	/* 회원별 형광펜 결제정보 조회하기*/
	@Override
	public List<PayVO> select_myPayInfo(String mem_id) throws RemoteException {
		List<PayVO> list = pay_dao.select_myPayInfo(mem_id);
		return list;
	}

	/* 형광펜 결제하기*/
	@Override
	public void insert_PayInfo(PayVO vo) throws RemoteException {
		pay_dao.insert_PayInfo(vo);
	}

	/* 형광펜 결제에 의한 형광펜 수량 증가하기*/
	@Override
	public void addition_myPen_Quantity(String mem_id, String payPen) throws RemoteException {
		pay_dao.addition_myPen_Quantity(mem_id, payPen);
	}

	@Override
	public List<PayVO> select_PayDetailInfo(String pay_no) throws RemoteException {
		List<PayVO> list = pay_dao.select_PayDetailInfo(pay_no);
		return list;
	}
	
	

}
