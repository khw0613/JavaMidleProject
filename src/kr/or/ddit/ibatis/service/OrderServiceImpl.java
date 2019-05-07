package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.dao.BoardCommentDao;
import kr.or.ddit.ibatis.dao.BoardCommentDaoImpl;
import kr.or.ddit.ibatis.dao.OrderDao;
import kr.or.ddit.ibatis.dao.OrderDaoImpl;
import kr.or.ddit.ibatis.vo.restaurantVO.OrderVO;

public class OrderServiceImpl extends UnicastRemoteObject implements OrderService{

	OrderDao order_dao;
	private static OrderServiceImpl service;

	private OrderServiceImpl() throws RemoteException {
		super();

		order_dao = OrderDaoImpl.getInstance();
		System.out.println("Comment Accept!");
	}

	public static OrderServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new OrderServiceImpl();
		}
		return service;
	}

	@Override
	public List<OrderVO> select_order() throws RemoteException {
		List<OrderVO> list = order_dao.select_order();
		return list;
	}

	@Override
	public List<OrderVO> select_memOrder(OrderVO orderVO) throws RemoteException {
		List<OrderVO> list = order_dao.select_memOrder(orderVO);
		return list;
	}

	@Override
	public List<OrderVO> select_orderday(OrderVO orderVO) throws RemoteException {
		List<OrderVO> list = order_dao.select_orderday(orderVO);
		return list;
	}

	@Override
	public int insert_order(OrderVO orderVO) throws RemoteException {
		int cnt = order_dao.insert_order(orderVO);
		return cnt;
	}

	@Override
	public int delete_order(String order_code) throws RemoteException {
		int cnt = order_dao.delete_order(order_code);
		return cnt;
	}

	@Override
	public List<OrderVO> select_OrdertypeList(String order_type) throws RemoteException {
		List<OrderVO> list = order_dao.select_OrdertypeList(order_type);
		return list;
	}

	@Override
	public List<OrderVO> select_OrdertypeListDate(OrderVO orderVO) throws RemoteException {
		List<OrderVO> list = order_dao.select_OrdertypeListDate(orderVO);
		return list;
	}

	@Override
	public List<OrderVO> select_MemberOrderInfo(String mem_id) throws RemoteException {
		List<OrderVO> list = order_dao.select_MemberOrderInfo(mem_id);
		return list;
	}

	@Override
	public List<OrderVO> select_MemberOrdertypeInfo(OrderVO orderVO) throws RemoteException {
		List<OrderVO> list = order_dao.select_MemberOrdertypeInfo(orderVO);
		return list;
	}

	@Override
	public List<OrderVO> select_MemberOrdertypeInfoDate(OrderVO orderVO) throws RemoteException {
		List<OrderVO> list = order_dao.select_MemberOrdertypeInfoDate(orderVO);
		return list;
	}

	@Override
	public List<OrderVO> select_ResMemberOrderInfo(OrderVO orderVO) throws RemoteException {
		List<OrderVO> list = order_dao.select_ResMemberOrderInfo(orderVO);
		return list;
	}

	@Override
	public List<OrderVO> select_ResMemberOrdertypeInfo(OrderVO orderVO) throws RemoteException {
		List<OrderVO> list = order_dao.select_ResMemberOrdertypeInfo(orderVO);
		return list;
	}

	@Override
	public List<OrderVO> select_ResMemberOrdertypeInfoDate(OrderVO orderVO) throws RemoteException {
		List<OrderVO> list = order_dao.select_ResMemberOrdertypeInfoDate(orderVO);
		return list;
	}

	@Override
	public int update_Ordertype(String order_code) throws RemoteException {
		return order_dao.update_Ordertype(order_code);
	}

	@Override
	public List<OrderVO> select_adminlist(String memDegree, String memClass, String res_order_date) throws RemoteException {
		return order_dao.select_adminlist(memDegree, memClass, res_order_date);
	}

	@Override
	public List<OrderVO> select_adminlist2(String memDegree, String memClass, String res_order_date, String res_no)
			throws RemoteException {
		return order_dao.select_adminlist2(memDegree, memClass, res_order_date, res_no);
	}

	@Override
	public List<Map> select_order2(String degree, String memClass, String res_order_date) throws RemoteException {
		return order_dao.select_order2(degree, memClass, res_order_date);
	}

	
	

}
