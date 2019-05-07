package kr.or.ddit.ibatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.restaurantVO.Resmenu_daysVO;

public class ResMenuDaoImpl implements ResMenuDao{
	
	private SqlMapClient smc;
	private static ResMenuDaoImpl dao;

	private ResMenuDaoImpl() {
		smc = DBUTIL1.getInstance();
		
	}
	
	public static ResMenuDaoImpl getInstance() {
		if(dao == null) {
			dao = new ResMenuDaoImpl();
		}
		return dao;
	}

	@Override
	public List<Resmenu_daysVO> selectList() {
		
		List<Resmenu_daysVO> list = new ArrayList<Resmenu_daysVO>();

		try {
			list = smc.queryForList("qr_resmenu_days.select_menuList");
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<Resmenu_daysVO> selectList_month(String res_order_date) {
		
		List<Resmenu_daysVO> list = new ArrayList<Resmenu_daysVO>();

		try {
			list = smc.queryForList("qr_resmenu_days.select_menuList_month", res_order_date);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<Resmenu_daysVO> selectList_day(String res_order_date) {
		List<Resmenu_daysVO> list = new ArrayList<Resmenu_daysVO>();

		try {
			list = smc.queryForList("qr_resmenu_days.select_menuList_day", res_order_date);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public int insert_menu(Resmenu_daysVO rvo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_resmenu_days.insert_MenuList", rvo);
		
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
		
	}

	@Override
	public List<Resmenu_daysVO> select_RestaurantMenuList(String res_no) {
		List<Resmenu_daysVO> list = new ArrayList<Resmenu_daysVO>();

		try {
			list = smc.queryForList("qr_resmenu_days.select_RestaurantMenuList", res_no);
			
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<Resmenu_daysVO> select_RestaurantmenuList_month(Resmenu_daysVO resmenu_daysVO) {
		List<Resmenu_daysVO> list = new ArrayList<Resmenu_daysVO>();

		try {
			list = smc.queryForList("qr_resmenu_days.select_RestaurantmenuList_month", resmenu_daysVO);
			
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<Resmenu_daysVO> select_RestaurantmenuList_day(Resmenu_daysVO resmenu_daysVO) {
		List<Resmenu_daysVO> list = new ArrayList<Resmenu_daysVO>();

		try {
			list = smc.queryForList("qr_resmenu_days.select_RestaurantmenuList_day", resmenu_daysVO);
			
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

}
