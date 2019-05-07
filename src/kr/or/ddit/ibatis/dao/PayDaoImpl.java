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
import kr.or.ddit.ibatis.vo.hilightVO.PayVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;

public class PayDaoImpl implements PayDao{
	
	private SqlMapClient smc;
	private static PayDaoImpl dao;

	private PayDaoImpl() {
		smc = DBUTIL1.getInstance();
		
	}
	
	public static PayDaoImpl getInstance() {
		if(dao == null) {
			dao = new PayDaoImpl();
		}
		return dao;
	}
	
	//전체 결제정보 조회
	@Override
	public List<PayVO> select_PayList() {
		
		System.out.println("payList Accept!!");
		List<PayVO> list = new ArrayList<PayVO>();
		
		try {
			list = smc.queryForList("qr_pay.select_PayList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//회원별 결제정보 조회
	@Override
	public List<PayVO> select_myPayInfo(String mem_id) {
		List<PayVO> list = new ArrayList<PayVO>();
		
		try {
			list = smc.queryForList("qr_pay.select_myPayInfo", mem_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//결제정보 등록(형광펜 결제)
	@Override
	public int insert_PayInfo(PayVO vo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_pay.insert_PayInfo", vo);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	//결제한 회원의 형광펜 수량 수정(결제한 펜 갯수만큼 증가)
	@Override
	public void addition_myPen_Quantity(String mem_id, String payPen) {
		List<MemberVO> list;
		try {
			list = Global.memberService.selectOne(mem_id);
			String up_pen_quan = list.get(0).getPen_quantity();
			int qn = (Integer.parseInt(up_pen_quan)) + (Integer.parseInt(payPen));
			
			up_pen_quan = qn + "";
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("up_pen_quan", up_pen_quan);
			map.put("mem_id", mem_id);
				
			Object obj = smc.update("qr_pay.addition_myPen_Quantity", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<PayVO> select_PayDetailInfo(String pay_no) {
		List<PayVO> list = new ArrayList<PayVO>();
		
		try {
			list = smc.queryForList("qr_pay.select_PayDetailInfo", pay_no);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
