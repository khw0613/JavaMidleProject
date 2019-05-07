package kr.or.ddit.ibatis.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.restaurantVO.OrderVO;

public class OrderDaoImpl implements OrderDao{
	
	private SqlMapClient smc;
	private static OrderDaoImpl dao;

	private OrderDaoImpl() {
		smc = DBUTIL1.getInstance();
	}

	public static OrderDaoImpl getInstance() {
		if (dao == null) {
			dao = new OrderDaoImpl();
		}
		return dao;
	}

	@Override
	public List<OrderVO> select_order() {
		
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_order");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<OrderVO> select_memOrder(OrderVO orderVO) {

		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_memOrder",orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<OrderVO> select_orderday(OrderVO orderVO) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_orderday",orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insert_order(OrderVO orderVO) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_order.insert_order", orderVO);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int delete_order(String order_code) {
		int cnt = 0;
		try {
			cnt = smc.delete("qr_order.delete_order", order_code);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<OrderVO> select_OrdertypeList(String order_type) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_OrdertypeList",order_type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<OrderVO> select_OrdertypeListDate(OrderVO orderVO) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_OrdertypeListDate",orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<OrderVO> select_MemberOrderInfo(String mem_id) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_MemberOrderInfo",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<OrderVO> select_MemberOrdertypeInfo(OrderVO orderVO) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_MemberOrdertypeInfo",orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<OrderVO> select_MemberOrdertypeInfoDate(OrderVO orderVO) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_MemberOrdertypeInfoDate",orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<OrderVO> select_ResMemberOrderInfo(OrderVO orderVO) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_ResMemberOrderInfo",orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<OrderVO> select_ResMemberOrdertypeInfo(OrderVO orderVO) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_ResMemberOrdertypeInfo",orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<OrderVO> select_ResMemberOrdertypeInfoDate(OrderVO orderVO) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		try {
			list = smc.queryForList("qr_order.select_ResMemberOrdertypeInfoDate",orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int update_Ordertype(String order_code) {
		int cnt = 0;
		
		try {
			cnt = smc.update("qr_order.update_Ordertype", order_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<OrderVO> select_adminlist(String memDegree, String memClass, String res_order_date) {
		HashMap<String, String> pram = new HashMap<String, String>();
		pram.put("memDegree", memDegree);
		pram.put("memClass", memClass);
		pram.put("res_order_date", res_order_date);
		
		List<OrderVO> list = new ArrayList<OrderVO>();

		try {
			list = smc.queryForList("qr_order.select_adminlist", pram);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<OrderVO> select_adminlist2(String memDegree, String memClass, String res_order_date, String res_no) {
		HashMap<String, String> pram = new HashMap<String, String>();
		pram.put("memDegree", memDegree);
		pram.put("memClass", memClass);
		pram.put("res_order_date", res_order_date);
		pram.put("res_no", res_no);
		
		List<OrderVO> list = new ArrayList<OrderVO>();

		try {
			list = smc.queryForList("qr_order.select_adminlist2", pram);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<Map> select_order2(String degree, String memClass, String res_order_date) {
		HashMap<String, String> pram = new HashMap<String, String>();
		pram.put("degree", degree);
		pram.put("memClass", memClass);
		pram.put("res_order_date", res_order_date);
		
		List<Map> list = new ArrayList<Map>();

		try {
			list = smc.queryForList("qr_order.select_order2", pram);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;

	}
}
