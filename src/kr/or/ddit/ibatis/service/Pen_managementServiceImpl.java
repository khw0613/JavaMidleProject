package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.dao.Pen_managementDao;
import kr.or.ddit.ibatis.dao.Pen_managementDaoImpl;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;

public class Pen_managementServiceImpl extends UnicastRemoteObject implements Pen_managementService {
	Pen_managementDao pen_managementdao;
	private static Pen_managementServiceImpl service;

	private Pen_managementServiceImpl() throws RemoteException {
		super();

		pen_managementdao = Pen_managementDaoImpl.getInstance();
		System.out.println("Comment Accept!");
	}

	public static Pen_managementServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new Pen_managementServiceImpl();
		}
		return service;
	}

	@Override
	public int insert_UsetypePay(Pen_managementVO pen_managementVO) throws RemoteException {
		return pen_managementdao.insert_UsetypePay(pen_managementVO);
	}

	@Override
	public int insert_UsetypeRefund(Pen_managementVO pen_managementVO) throws RemoteException {
		return pen_managementdao.insert_UsetypeRefund(pen_managementVO);
	}

	@Override
	public int insert_UsetypeExchange(Pen_managementVO pen_managementVO) throws RemoteException {
		return pen_managementdao.insert_UsetypeExchange(pen_managementVO);
	}

	@Override
	public int insert_UsetypeSupport(Pen_managementVO pen_managementVO) throws RemoteException {
		return pen_managementdao.insert_UsetypeSupport(pen_managementVO);
	}

	@Override
	public List<Pen_managementVO> select_UsePenList() {
		List<Pen_managementVO> list = pen_managementdao.select_UsePenList();
		return list;
	}

	@Override
	public List<Pen_managementVO> select_MemberUsePenList(Pen_managementVO pen_managementVO) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_MemberUsePenList(pen_managementVO);
		return list;
	}

	@Override
	public List<Pen_managementVO> select_MemberPayPenList(String mem_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_MemberPayPenList(mem_id);
		return list;
	}

	@Override
	public List<Pen_managementVO> select_MemberRefundPenList(String mem_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_MemberRefundPenList(mem_id);
		return list;
	}

	@Override
	public List<Pen_managementVO> select_MemberExchangePenList(String mem_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_MemberExchangePenList(mem_id);
		return list;
	}

	@Override
	public List<Pen_managementVO> select_MemberSupportPenList(String mem_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_MemberSupportPenList(mem_id);
		return list;
	}

	@Override
	public List<Pen_managementVO> select_MemberReceivePenList(String mem_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_MemberReceivePenList(mem_id);
		return list;
	}

	@Override
	public int insert_UsetypeLunchPayment(Pen_managementVO pen_managementVO) throws RemoteException {
		return pen_managementdao.insert_UsetypeLunchPayment(pen_managementVO);
	}

	@Override
	public List<Pen_managementVO> select_MemberLunchPaymentPenList(String mem_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_MemberLunchPaymentPenList(mem_id);
		return list;
	}

	@Override
	public List<Pen_managementVO> select_PayPenList() throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_PayPenList();
		return list;
	}

	@Override
	public List<Pen_managementVO> search_PayPenList(String mem_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.search_PayPenList(mem_id);
		return list;
	}

	@Override
	public List<Pen_managementVO> select_ExchangePenList() throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_ExchangePenList();
		return list;
	}

	@Override
	public List<Pen_managementVO> search_ExchangePenList(String mem_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.search_ExchangePenList(mem_id);
		return list;
	}

	@Override
	public List<Pen_managementVO> select_SupportPenList() throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_SupportPenList();
		return list;
	}

	@Override
	public List<Pen_managementVO> search_SupportPenList(String mem_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.search_SupportPenList(mem_id);
		return list;
	}

	@Override
	public List<Pen_managementVO> search_ReceivePenList(String receive_id) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.search_ReceivePenList(receive_id);
		return list;
	}

	@Override
	public List<Pen_managementVO> select_ReceivePenList() throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_ReceivePenList();
		return list;
	}

	@Override
	public List<Pen_managementVO> select_Profit_Management() throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_Profit_Management();
		return list;
	}

	@Override
	public List<Pen_managementVO> select_Profit_BarGrape(String use_date) throws RemoteException {
		List<Pen_managementVO> list = pen_managementdao.select_Profit_BarGrape(use_date);
		return list;
	}

	@Override
	public List<Map> select_Profit_LineGrape() throws RemoteException {
		List<Map> list = pen_managementdao.select_Profit_LineGrape();
		return list;
	}
}
