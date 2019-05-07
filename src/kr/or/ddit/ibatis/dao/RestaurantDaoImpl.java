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
import kr.or.ddit.ibatis.vo.restaurantVO.RestaurantVO;

public class RestaurantDaoImpl implements RestaurantDao {

	private SqlMapClient smc;
	private static RestaurantDaoImpl dao;

	private RestaurantDaoImpl() {
		smc = DBUTIL1.getInstance();
		
	}
	
	public static RestaurantDaoImpl getInstance() {
		if(dao == null) {
			dao = new RestaurantDaoImpl();
		}
		return dao;
	}

	@Override
	public int insert_RestaurantInfo(RestaurantVO restaurantVO) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_restaurant.insert_RestaurantInfo", restaurantVO);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<RestaurantVO> select_RestaurantList() {
		List<RestaurantVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("qr_restaurant.select_RestaurantList");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}

	@Override
	public List<RestaurantVO> select_RestaurantInfo(String res_no) {
		List<RestaurantVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("qr_restaurant.select_RestaurantInfo", res_no);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}

	@Override
	public List<RestaurantVO> search_Restaurant(String res_name) {
		List<RestaurantVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("qr_restaurant.search_Restaurant", res_name);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}

	@Override
	public int update_RestaurantInfo(RestaurantVO restaurantVO) {
		int cnt = 0;
		
		try {
			cnt = smc.update("qr_restaurant.update_RestaurantInfo", restaurantVO);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int delete_RestaurantInfo(String res_no) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("qr_restaurant.delete_RestaurantInfo", res_no);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}
