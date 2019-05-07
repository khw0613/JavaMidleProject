package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.ibatis.vo.restaurantVO.Resmenu_daysVO;


public interface ResMenuService extends Remote{
	
	public List<Resmenu_daysVO> selectList() throws RemoteException;
	
	public List<Resmenu_daysVO> selectList_month(String res_order_date) throws RemoteException;
	
	public List<Resmenu_daysVO> select_menuList_day(String res_order_date) throws RemoteException;

	public int insert_menu(Resmenu_daysVO rvo) throws RemoteException;
	
	public List<Resmenu_daysVO> select_RestaurantMenuList(String res_no) throws RemoteException; // 업체별 식단표 정보 가져오기

	public List<Resmenu_daysVO> select_RestaurantmenuList_month(Resmenu_daysVO resmenu_daysVO) throws RemoteException; // 업체별 식단표 정보 가져오기

	public List<Resmenu_daysVO> select_RestaurantmenuList_day(Resmenu_daysVO resmenu_daysVO) throws RemoteException; // 업체별 식단표 정보 가져오기
	
}
