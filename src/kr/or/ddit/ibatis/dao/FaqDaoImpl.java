package kr.or.ddit.ibatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.boarderVO.FaqVO;

public class FaqDaoImpl implements FaqDao{
	
	private SqlMapClient smc;
	private static FaqDaoImpl dao;

	private FaqDaoImpl() {
		smc = DBUTIL1.getInstance();
	}

	public static FaqDaoImpl getInstance() {
		if (dao == null) {
			dao = new FaqDaoImpl();
		}
		return dao;
	}

	@Override
	public List<FaqVO> selBox(String faq_question) {
		List<FaqVO> list = new ArrayList<FaqVO>();

		try {
			list = smc.queryForList("qr_faq.sel_box", faq_question);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<FaqVO> sel_answer(String faq_question) {
		List<FaqVO> list = new ArrayList<FaqVO>();

		try {
			list = smc.queryForList("qr_faq.sel_answer", faq_question);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public int insertFAQ(String faq_question, String faq_answer) {
		int cnt = 0;
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println(faq_question);
		System.out.println(faq_answer);
		
		
		map.put("faq_question", faq_question);
		map.put("faq_answer", faq_answer);
		
		try {
			Object obj = smc.insert("qr_faq.insertFAQData", map);
			
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<FaqVO> selectAll() {
		List<FaqVO> list = new ArrayList<FaqVO>();

		try {
			list = smc.queryForList("qr_faq.faqList");
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public int updateFAQData(String faq_question, String faq_answer) {
		int cnt = 0;
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("faq_question", faq_question);
		map.put("faq_answer", faq_answer);
		
		try {
			Object obj = smc.update("qr_faq.updateFAQData", map);
			
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteFAQdata(String faq_question) {
		int cnt = 0;
		
		
		try {
			Object obj = smc.delete("qr_faq.deleteFAQdata", faq_question);
			
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
