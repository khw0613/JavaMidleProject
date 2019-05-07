package kr.or.ddit.ibatis.dao;

import java.util.HashMap;
import java.util.List;

import kr.or.ddit.ibatis.vo.hilightVO.Surpport_penVO;

public interface SupportPenDao {
	
	/* 전체 후원 정보 조회하기*/
	public List<Surpport_penVO> select_SupportList();
	
	/* 내가 준 후원정보 조회하기*/
	public List<Surpport_penVO> select_GiveInfo(String mem_id);
	
	/* 내가 받은 후원정보 조회하기*/
	public List<Surpport_penVO> select_ReceiveInfo(String receive_id);
	
	/* 형광펜 후원하기 */
	public int insert_SupportInfo(Surpport_penVO vo);
	
	/* 회원의 형광펜 수량 변경하기 (주는 회원 기준 : 감소하기)*/
	public void subtration_myPen_Quantity2(String mem_id, String usePen);
	
	/* 회원의 형광펜 수량 변경하기 (받는 회원 기준 : 증가하기)*/
	public void addition_myPen_Quantity2(String mem_id, String usePen);
	
//	형관펜 후원정보 가져오기(형관펜 사용내역 관리에 필요)
	public List<Surpport_penVO> select_SupportDetailInfo(String support_no);
	
	

	
}
