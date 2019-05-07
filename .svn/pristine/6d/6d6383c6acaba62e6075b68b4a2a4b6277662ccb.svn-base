package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.ibatis.vo.boarderVO.FaqVO;

public interface FaqService extends Remote{
	 
	public List<FaqVO> selBox(String faq_question) throws RemoteException;
	
	public List<FaqVO> sel_answer(String faq_question) throws RemoteException;
	
	public int insertFAQ(String faq_question, String faq_answer) throws RemoteException;

	public List<FaqVO> selectAll() throws RemoteException;
	
	public int updateFAQData(String faq_question, String faq_answer) throws RemoteException;

	public int deleteFAQdata(String faq_question) throws RemoteException;
}
