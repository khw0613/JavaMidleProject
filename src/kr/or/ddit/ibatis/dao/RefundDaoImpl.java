package kr.or.ddit.ibatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.hilightVO.RefundVO;
import kr.or.ddit.ibatis.vo.hilightVO.Surpport_penVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;

public class RefundDaoImpl implements RefundDao {

	private SqlMapClient smc;
	private static RefundDaoImpl dao;

	private RefundDaoImpl() {
		smc = DBUTIL1.getInstance();

	}

	public static RefundDaoImpl getInstance() {
		if (dao == null) {
			dao = new RefundDaoImpl();
		}
		return dao;
	}
	//모든 환불정보 조회하기
	@Override
	public List<RefundVO> select_RefundList() {
		List<RefundVO> list = new ArrayList<RefundVO>();

		try {
			list = smc.queryForList("qr_refund.select_RefundList");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	//회원별 환불정보 조회하기
	@Override
	public List<RefundVO> select_myRefundInfo(String memid) {
		List<RefundVO> list = new ArrayList<RefundVO>();

		try {
			list = smc.queryForList("qr_refund.select_myRefundInfo", memid);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	//형광펜 환불하기
	@Override
	public int insert_RefundInfo(RefundVO refundVO) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_refund.insert_RefundInfo", refundVO);
			
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return cnt;
	}
	//회원 형광펜 수량 업데이트 하기(환불에 의한 감소)
	@Override
	public void subtration_myPen_Quantity(String refundPen, String mem_id) {
//		int cnt = 0; 
		List<MemberVO> list;
		try {
			list = Global.memberService.selectOne(mem_id);
			String down_quan = list.get(0).getPen_quantity();
			int qn = (Integer.parseInt(down_quan)) - (Integer.parseInt(refundPen));
			
			down_quan = qn + "";
	
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("down_quan", down_quan);
			map.put("mem_id", mem_id);
			
			
			Object obj = smc.insert("qr_refund.subtration_myPen_Quantity", map);
//			cnt = (int) obj;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<RefundVO> select_RefundDetailInfo(RefundVO refundVO) {
		List<RefundVO> list = new ArrayList<RefundVO>();

		try {
			list = smc.queryForList("qr_refund.select_RefundDetailInfo", refundVO);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
		
}
