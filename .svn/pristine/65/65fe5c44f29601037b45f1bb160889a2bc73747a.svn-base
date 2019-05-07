package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.ibatis.dao.ResMenuDao;
import kr.or.ddit.ibatis.dao.ResMenuDaoImpl;
import kr.or.ddit.ibatis.vo.restaurantVO.Resmenu_daysVO;

public class ResMenuServiceImpl extends UnicastRemoteObject implements ResMenuService {

	ResMenuDao res_dao;
	private static ResMenuServiceImpl service;

	private ResMenuServiceImpl() throws RemoteException {
		super();

		res_dao = ResMenuDaoImpl.getInstance();
		System.out.println("MenuService Accept!");

	}

	public static ResMenuServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new ResMenuServiceImpl();
		}
		return service;
	}

	@Override
	public List<Resmenu_daysVO> selectList() throws RemoteException {
		List<Resmenu_daysVO> list = res_dao.selectList();

		return list;
	}

	@Override
	public List<Resmenu_daysVO> selectList_month(String res_order_date) throws RemoteException {
		List<Resmenu_daysVO> list = res_dao.selectList_month(res_order_date);

		return list;
	}

	@Override
	public List<Resmenu_daysVO> select_menuList_day(String res_order_date) throws RemoteException {
		List<Resmenu_daysVO> list = res_dao.selectList_day(res_order_date);
		
		return list;
	}

	@Override
	public int insert_menu(Resmenu_daysVO rvo) throws RemoteException {
		
		return res_dao.insert_menu(rvo); 
	}

	@Override
	public List<Resmenu_daysVO> select_RestaurantMenuList(String res_no) throws RemoteException {
		List<Resmenu_daysVO> list = res_dao.select_RestaurantMenuList(res_no);
		return list;
	}

	@Override
	public List<Resmenu_daysVO> select_RestaurantmenuList_month(Resmenu_daysVO resmenu_daysVO) throws RemoteException {
		List<Resmenu_daysVO> list = res_dao.select_RestaurantmenuList_month(resmenu_daysVO);
		return list;
	}

	@Override
	public List<Resmenu_daysVO> select_RestaurantmenuList_day(Resmenu_daysVO resmenu_daysVO) throws RemoteException {
		List<Resmenu_daysVO> list = res_dao.select_RestaurantmenuList_day(resmenu_daysVO);
		return list;
	}


}
