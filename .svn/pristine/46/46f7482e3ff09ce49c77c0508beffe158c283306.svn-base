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
import kr.or.ddit.ibatis.vo.hilightVO.Surpport_penVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;

public class SupportPenDaoImpl implements SupportPenDao {

	private SqlMapClient smc;
	private static SupportPenDaoImpl dao;

	private SupportPenDaoImpl() {
		smc = DBUTIL1.getInstance();

	}

	public static SupportPenDaoImpl getInstance() {
		if (dao == null) {
			dao = new SupportPenDaoImpl();
		}
		return dao;
	}

	// 전체 후원 정보 조회하기
	@Override
	public List<Surpport_penVO> select_SupportList() {
		System.out.println("Select List Support List");
		List<Surpport_penVO> list = new ArrayList<Surpport_penVO>();

		try {
			list = smc.queryForList("qr_support_pen.select_SupportList");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	// 내가 준 후원정보 조회하기
	@Override
	public List<Surpport_penVO> select_GiveInfo(String mem_id) {
		System.out.println("Select List Support List_WHERE mem_id");
		List<Surpport_penVO> list = new ArrayList<Surpport_penVO>();

		try {
			list = smc.queryForList("qr_support_pen.select_GiveInfo", mem_id);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	// 내가 받은 후원 정보 조회하기
	@Override
	public List<Surpport_penVO> select_ReceiveInfo(String receive_id) {
		System.out.println("Select List Support List_WHERE mem_id");
		List<Surpport_penVO> list = new ArrayList<Surpport_penVO>();

		try {
			list = smc.queryForList("qr_support_pen.select_ReceiveInfo", receive_id);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public int insert_SupportInfo(Surpport_penVO vo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_support_pen.insert_SupportInfo", vo);

			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public void subtration_myPen_Quantity2(String mem_id, String usePen) {
		List<MemberVO> list;
		try {
			list = Global.memberService.selectOne(mem_id);
			String up_quan = list.get(0).getPen_quantity();
			int qn = (Integer.parseInt(up_quan)) - (Integer.parseInt(usePen));
			
			if (qn < 0) {
				System.out.println(" 형광펜의 수량이 부족합니다.");
			} else {
				up_quan = qn + "";

				HashMap<String, String> map = new HashMap<String, String>();
				map.put("up_quan", up_quan);
				map.put("mem_id", mem_id);
				
				
				Object obj = smc.insert("qr_support_pen.subtration_myPen_Quantity2", map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addition_myPen_Quantity2(String mem_id, String usePen) {
		List<MemberVO> list;
		try {
			list = Global.memberService.selectOne(mem_id);
			String up_quan = list.get(0).getPen_quantity();
			int qn = (Integer.parseInt(up_quan)) + (Integer.parseInt(usePen));
			
			if (qn < 0) {
				System.out.println(" 형광펜의 수량이 부족합니다.");
			} else {
				up_quan = qn + "";

				HashMap<String, String> map = new HashMap<String, String>();
				map.put("up_quan", up_quan);
				map.put("mem_id", mem_id);
				
				
				Object obj = smc.insert("qr_support_pen.addition_myPen_Quantity2", map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Override
	public List<Surpport_penVO> select_SupportDetailInfo(String support_no) {
		List<Surpport_penVO> list = new ArrayList<Surpport_penVO>();

		try {
			list = smc.queryForList("qr_support_pen.select_ExchangeDetailInfo", support_no);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

}
