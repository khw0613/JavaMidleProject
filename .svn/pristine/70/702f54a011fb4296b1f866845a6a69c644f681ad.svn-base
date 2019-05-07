package kr.or.ddit.ibatis.dao;

import java.util.List;

import kr.or.ddit.ibatis.vo.hilightVO.RefundVO;

public interface RefundDao {
	
	public List<RefundVO> select_RefundList();//모든 환불정보 조회하기

	public List<RefundVO> select_myRefundInfo(String memid);//회원별 환불정보 조회하기
	
	public int insert_RefundInfo(RefundVO refundVO);//형광펜 환불하기
	
	public void subtration_myPen_Quantity(String refundPen, String mem_id);//회원 형광펜 수량 업데이트 하기(환불에 의한 감소)
	
	public List<RefundVO> select_RefundDetailInfo(RefundVO refundVO); //형관펜 환불정보 가져오기(형관펜 사용내역 관리에 필요)
	
}
