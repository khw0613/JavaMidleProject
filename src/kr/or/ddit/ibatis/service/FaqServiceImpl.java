package kr.or.ddit.ibatis.service;

import java.io.DataOutput;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.ibatis.dao.FaqDao;
import kr.or.ddit.ibatis.dao.FaqDaoImpl;
import kr.or.ddit.ibatis.vo.boarderVO.FaqVO;

public class FaqServiceImpl extends UnicastRemoteObject implements FaqService{
	
	FaqDao faq_dao;
	private static FaqServiceImpl service;

	private FaqServiceImpl() throws RemoteException {
		super();

		faq_dao = FaqDaoImpl.getInstance();
		System.out.println("Exchange Accept!");
	}

	public static FaqServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new FaqServiceImpl();
		}
		return service;
	}

	@Override
	public List<FaqVO> selBox(String faq_question) throws RemoteException {
		List<FaqVO> list = faq_dao.selBox(faq_question);
		return list;
	}

	@Override
	public List<FaqVO> sel_answer(String faq_question) throws RemoteException {
		List<FaqVO> list = faq_dao.sel_answer(faq_question);
		return list;
	}

	@Override
	public int insertFAQ(String faq_question, String faq_answer) throws RemoteException {
		int cnt = faq_dao.insertFAQ(faq_question, faq_answer);
		return cnt;
	}

	@Override
	public List<FaqVO> selectAll() throws RemoteException {
		List<FaqVO> list = faq_dao.selectAll();
		return list;
	}

	@Override
	public int updateFAQData(String faq_question, String faq_answer) throws RemoteException {
		int cnt = faq_dao.updateFAQData(faq_question, faq_answer);
		return cnt;
	}

	@Override
	public int deleteFAQdata(String faq_question) throws RemoteException {
		int cnt = faq_dao.deleteFAQdata(faq_question);
		return cnt;
	}

}
