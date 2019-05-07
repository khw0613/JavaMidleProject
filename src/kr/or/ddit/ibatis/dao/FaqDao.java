package kr.or.ddit.ibatis.dao;

import java.util.List;

import kr.or.ddit.ibatis.vo.boarderVO.FaqVO;

public interface FaqDao {
	
	public List<FaqVO> selBox(String faq_question);
	
	public List<FaqVO> sel_answer(String faq_question);
	
	public int insertFAQ(String faq_question, String faq_answer);
	
	public List<FaqVO> selectAll();
	
	public int updateFAQData(String faq_question, String faq_answer);
	
	public int deleteFAQdata(String faq_question);

}
