package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.ibatis.dao.ExchangeDao;
import kr.or.ddit.ibatis.dao.ExchangeDaoImpl;
import kr.or.ddit.ibatis.dao.LogWindowDao;
import kr.or.ddit.ibatis.dao.LogWindowDaoImpl;
import kr.or.ddit.ibatis.vo.hilightVO.ExchangeVO;
import kr.or.ddit.ibatis.vo.memberVO.Log_WindowVO;

public class ExchangeServiceImpl extends UnicastRemoteObject implements ExchangeService {
	
	ExchangeDao exchange_dao;
	private static ExchangeServiceImpl service;

	private ExchangeServiceImpl() throws RemoteException {
		super();

		exchange_dao = ExchangeDaoImpl.getInstance();
		System.out.println("Exchange Accept!");
	}

	public static ExchangeServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new ExchangeServiceImpl();
		}
		return service;
	}
	//전체 환정정보 조회
	@Override
	public List<ExchangeVO> select_ExchangeList() throws RemoteException {
		
		return exchange_dao.select_ExchangeList();
	}
	//회원별 환불정보 조회(내 환불정보 보기)
	@Override
	public List<ExchangeVO> select_ExchangeInfo(String mem_id) throws RemoteException {
		return exchange_dao.select_ExchangeInfo(mem_id);
	}
	//환전정보 삽입
	@Override
	public int insert_ExchangeInfo(ExchangeVO exchangeVO) throws RemoteException {
		return exchange_dao.insert_ExchangeInfo(exchangeVO);
	}
	//회원 형광펜 수량 업데이트 하기(환전에 의한 감소-주는 회원)
	@Override
	public void subtration_myPen_Quantity3(String exchangePen, String mem_id) throws RemoteException {
		exchange_dao.subtration_myPen_Quantity3(exchangePen, mem_id);
	}

	@Override
	public List<ExchangeVO> select_ExchangeDetailInfo(String exchange_no) throws RemoteException {
		List<ExchangeVO> list = exchange_dao.select_ExchangeDetailInfo(exchange_no);
		return list;
	}

}
