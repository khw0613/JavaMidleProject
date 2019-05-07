package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import kr.or.ddit.ibatis.dao.ResMenuDao;
import kr.or.ddit.ibatis.dao.ResMenuDaoImpl;
import kr.or.ddit.ibatis.dao.SupportPenDao;
import kr.or.ddit.ibatis.dao.SupportPenDaoImpl;
import kr.or.ddit.ibatis.vo.hilightVO.Surpport_penVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;

public class SupportPenServiceImpl extends UnicastRemoteObject implements SupportPenService{

	SupportPenDao support_dao;
	private static SupportPenServiceImpl service;

	private SupportPenServiceImpl() throws RemoteException {
		super();

		support_dao = SupportPenDaoImpl.getInstance();
		System.out.println("MenuService Accept!");

	}

	public static SupportPenServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new SupportPenServiceImpl();
		}
		return service;
	}

	
	/* 전체 후원 정보 조회하기*/
	@Override
	public List<Surpport_penVO> select_SupportList() throws RemoteException {
		System.out.println("Support Select List");
		List<Surpport_penVO> list = support_dao.select_SupportList();

		return list;
	}
	/* 내가 준 후원정보 조회하기*/
	@Override
	public List<Surpport_penVO> select_GiveInfo(String mem_id) throws RemoteException {
		System.out.println("Support Select List WHERE mem_id");
		List<Surpport_penVO> list = support_dao.select_GiveInfo(mem_id);

		return list;
	}
	/* 내가 받은 후원정보 조회하기*/
	@Override
	public List<Surpport_penVO> select_ReceiveInfo(String receive_id) throws RemoteException {
		System.out.println("Support Select List WHERE mem_id");
		List<Surpport_penVO> list = support_dao.select_ReceiveInfo(receive_id);

		return list;
	}
	/* 형광펜 후원하기 */
	@Override
	public int insert_SupportInfo(Surpport_penVO vo) throws RemoteException {
		System.out.println("Insert Support");
		int cnt = support_dao.insert_SupportInfo(vo);

		return cnt;
	}
	/* 회원의 형광펜 수량 변경하기 (주는 회원 기준 : 감소하기)*/
	@Override
	public void subtration_myPen_Quantity2(String mem_id, String usePen) throws RemoteException {
		support_dao.subtration_myPen_Quantity2(mem_id, usePen);
		
	}
	/* 회원의 형광펜 수량 변경하기 (받는 회원 기준 : 증가하기)*/
	@Override
	public void addition_myPen_Quantity2(String mem_id, String usePen) throws RemoteException {
		support_dao.addition_myPen_Quantity2(mem_id, usePen);
		
	}

	@Override
	public List<Surpport_penVO> select_SupportDetailInfo(String support_no) throws RemoteException {
		List<Surpport_penVO> list = support_dao.select_SupportDetailInfo(support_no);
		return list;
	}

}
