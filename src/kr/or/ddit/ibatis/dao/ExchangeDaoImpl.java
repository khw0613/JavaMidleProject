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
import kr.or.ddit.ibatis.vo.hilightVO.ExchangeVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;

public class ExchangeDaoImpl implements ExchangeDao {
	
	private SqlMapClient smc;
	private static ExchangeDaoImpl dao;

	private ExchangeDaoImpl() {
		smc = DBUTIL1.getInstance();
	}

	public static ExchangeDaoImpl getInstance() {
		if (dao == null) {
			dao = new ExchangeDaoImpl();
		}
		return dao;
	}
	//전체 환정정보 조회
	@Override
	public List<ExchangeVO> select_ExchangeList() {
		List<ExchangeVO> list = new ArrayList<ExchangeVO>();

		try {
			list = smc.queryForList("qr_exchange.select_ExchangeList");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	//회원별 환불정보 조회(내 환불정보 보기)
	@Override
	public List<ExchangeVO> select_ExchangeInfo(String mem_id) {
		List<ExchangeVO> list = new ArrayList<ExchangeVO>();

		try {
			list = smc.queryForList("qr_exchange.select_ExchangeInfo", mem_id);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	//환전정보 삽입
	@Override
	public int insert_ExchangeInfo(ExchangeVO exchangeVO) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_exchange.insert_ExchangeInfo", exchangeVO);
			
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return cnt;
	}
	//회원 형광펜 수량 업데이트 하기(환전에 의한 감소-주는 회원)
	@Override
	public void subtration_myPen_Quantity3(String exchangePen, String mem_id) {
		List<MemberVO> list;
		try {
			list = Global.memberService.selectOne(mem_id);
			String down_quan = list.get(0).getPen_quantity();
			System.out.println(down_quan);
			
			int qn = (Integer.parseInt(down_quan)) - (Integer.parseInt(exchangePen));
			
			down_quan = qn + "";
	
			System.out.println(down_quan);
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("down_quan", down_quan);
			map.put("mem_id", mem_id);
			
			
			Object obj = smc.update("qr_exchange.subtration_myPen_Quantity3", map);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ExchangeVO> select_ExchangeDetailInfo(String exchange_no) {
		List<ExchangeVO> list = new ArrayList<ExchangeVO>();

		try {
			list = smc.queryForList("qr_exchange.select_ExchangeDetailInfo", exchange_no);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
}
