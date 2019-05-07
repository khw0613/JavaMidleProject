package kr.or.ddit.ibatis.dao;

import java.util.List;

import kr.or.ddit.ibatis.vo.restaurantVO.Resmenu_daysVO;

public interface ResMenuDao {
	
	public List<Resmenu_daysVO> selectList(); // 식단표 정보 가져오기
	
	public List<Resmenu_daysVO> selectList_month(String res_order_date); // 월별 식단표 정보 가져오기
	
	public List<Resmenu_daysVO> selectList_day(String res_order_date); // 일별 식단표 정보 가져오기 
	
	public int insert_menu(Resmenu_daysVO rvo); // 식단표 작성시 데이터베이스에 데이터 삽입하기
	
	public List<Resmenu_daysVO> select_RestaurantMenuList(String res_no); // 업체별 식단표 정보 가져오기

	public List<Resmenu_daysVO> select_RestaurantmenuList_month(Resmenu_daysVO resmenu_daysVO); // 업체별 식단표 정보 가져오기

	public List<Resmenu_daysVO> select_RestaurantmenuList_day(Resmenu_daysVO resmenu_daysVO); // 업체별 식단표 정보 가져오기

}
