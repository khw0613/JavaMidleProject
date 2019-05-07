package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.ibatis.dao.RestaurantDao;
import kr.or.ddit.ibatis.dao.RestaurantDaoImpl;
import kr.or.ddit.ibatis.vo.restaurantVO.RestaurantVO;

public class RestaurantServiceImpl extends UnicastRemoteObject implements RestaurantService {

	RestaurantDao restaurant_dao;
	private static RestaurantServiceImpl service;

	private RestaurantServiceImpl() throws RemoteException {
		super();

		restaurant_dao = RestaurantDaoImpl.getInstance();
		System.out.println("Restaurant Accept!");
	}

	public static RestaurantServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new RestaurantServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insert_RestaurantInfo(RestaurantVO restaurantVO) throws RemoteException {
		return restaurant_dao.insert_RestaurantInfo(restaurantVO);
	}

	@Override
	public List<RestaurantVO> select_RestaurantList() throws RemoteException {
		List<RestaurantVO> list = restaurant_dao.select_RestaurantList();
		return list;
	}

	@Override
	public List<RestaurantVO> select_RestaurantInfo(String res_no) throws RemoteException {
		List<RestaurantVO> list = restaurant_dao.select_RestaurantInfo(res_no);
		return list;
	}

	@Override
	public List<RestaurantVO> search_Restaurant(String res_name) throws RemoteException {
		List<RestaurantVO> list = restaurant_dao.search_Restaurant(res_name);
		return list;
	}

	@Override
	public int update_RestaurantInfo(RestaurantVO restaurantVO) throws RemoteException {
		return restaurant_dao.update_RestaurantInfo(restaurantVO);
	}

	@Override
	public int delete_RestaurantInfo(String res_no) throws RemoteException {
		return restaurant_dao.delete_RestaurantInfo(res_no);
	}

}
