package kr.or.ddit.ibatis.dao;

import java.util.List;

import kr.or.ddit.ibatis.vo.hilightVO.ExchangeVO;


public interface ExchangeDao {
	
	public List<ExchangeVO> select_ExchangeList(); //전체 환정정보 조회
	
	public List<ExchangeVO> select_ExchangeInfo(String mem_id); //회원별 환불정보 조회(내 환불정보 보기)
	
	public int insert_ExchangeInfo(ExchangeVO exchangeVO); //환전정보 삽입
	
	public void subtration_myPen_Quantity3(String exchangePen, String mem_id); //회원 형광펜 수량 업데이트 하기(환전에 의한 감소-주는 회원)
	
	public List<ExchangeVO> select_ExchangeDetailInfo(String exchange_no); //형광펜 환전정보 가져오기(형관펜 사용내역 관리에 필요)
	
	

}
