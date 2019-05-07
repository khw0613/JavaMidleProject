package kr.or.ddit.ibatis.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.vo.restaurantVO.OrderVO;

public interface OrderDao {
	
	/* 주문+환불 조회하기 */
	public List<OrderVO> select_order();
	
	/* 주문+환불 조회하기2 */
	public List<Map> select_order2(String degree, String memClass, String res_order_date);
	
	
	/* 점심 주문 회원별 조회하기 (월별) */
	public List<OrderVO> select_memOrder(OrderVO orderVO);
	
	/* 점심 날짜별 주문 조회하기 */
	public List<OrderVO> select_orderday(OrderVO orderVO);
	
//	기존의 select문 -----------------------------------------------------------------------
	
	/* 주문하기 */
	public int insert_order(OrderVO orderVO);
	
	/* 주문 취소하기  */
	public int delete_order(String order_code);
	
	public List<OrderVO> select_adminlist(String memDegree, String memClass, String res_order_date);
	
	public List<OrderVO> select_adminlist2(String memDegree, String memClass, String res_order_date, String res_no);
	
// 기존의 insert, delete문 ----------------------------------------------------------------
	
	public List<OrderVO> select_OrdertypeList(String order_type); // 주문/환불 전체조회(where order_type)
	
	public List<OrderVO> select_OrdertypeListDate(OrderVO orderVO); // 주문/환불 년 or 년월 or 년월일 전체조회(where order_type and res_order_date)
	
	public List<OrderVO> select_MemberOrderInfo(String mem_id); // 회원의 주문+환불 전체 조회(where mem_id)
	
	public List<OrderVO> select_MemberOrdertypeInfo(OrderVO orderVO); // 회원의 주문/환불 전체조회(where mem_id and order_type)
	
	public List<OrderVO> select_MemberOrdertypeInfoDate(OrderVO orderVO); // 회원의 주문/환불 년 or 년월 or 년월일 전체 조회(where mem_id and order_type and res_order_date)
	
	public List<OrderVO> select_ResMemberOrderInfo(OrderVO orderVO); // 회원의 업체별 주문+환불 전체 조회 (where mem_id and order_type)
	
	public List<OrderVO> select_ResMemberOrdertypeInfo(OrderVO orderVO); // 회원의 업체별 주문/환불 전체 조회(where mem_id and order_type and res_no)
	
	public List<OrderVO> select_ResMemberOrdertypeInfoDate(OrderVO orderVO); // 회원의 업체별 주문/환불 년 or 년월 or 년월일 전체 조회(where mem_id and order_type and res_no and res_order_date)
	
	public int update_Ordertype(String order_code); // 환불하기(기존의 주문정보에서 order_type을 2로 변경)
	
}
