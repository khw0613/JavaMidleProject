package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.ibatis.vo.restaurantVO.RestaurantVO;

public interface RestaurantService extends Remote {

	public int insert_RestaurantInfo(RestaurantVO restaurantVO) throws RemoteException; //업체정보 삽입
	
	public List<RestaurantVO> select_RestaurantList() throws RemoteException; // 전체 업체정보 조회

	public List<RestaurantVO> select_RestaurantInfo(String res_no) throws RemoteException; // 특정 업체정보 조회

	public List<RestaurantVO> search_Restaurant(String res_name) throws RemoteException; // 도시락 업체 검색
	
	public int update_RestaurantInfo(RestaurantVO restaurantVO) throws RemoteException; // 업체정보 수정
	
	public int delete_RestaurantInfo(String res_no) throws RemoteException; // 업체정보 삭제
	
}
