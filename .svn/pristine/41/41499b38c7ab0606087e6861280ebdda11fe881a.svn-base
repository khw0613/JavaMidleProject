package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.dao.MemberDao;
import kr.or.ddit.ibatis.dao.MemberDaoImpl;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import kr.or.ddit.ibatis.vo.memberVO.RightVO;
import library.SingleTone;

public class MemberServiceImpl extends UnicastRemoteObject implements MemberService {

	MemberDao mem_dao;
	private static MemberServiceImpl service;

	private MemberServiceImpl() throws RemoteException {
		super();

		mem_dao = MemberDaoImpl.getInstance();
		System.out.println("MemSignUpDao Accept!");
	}

	public static MemberServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}

	@Override
	public void signUp() {
		System.out.println("Connection Test!");
	}

	@Override
	public void insertMemberInfo(MemberVO membervo) throws RemoteException {
		// TODO Auto-generated method stub
		mem_dao.insertMemberInfo(membervo);

	}

	// 회원 정보중 아이디만 가져오기
	@Override
	public int idCheck(String memid) throws RemoteException {

		int cnt = 0;
		List<String> allId = mem_dao.selectAllID();

		for (String out : allId) {
			if (memid.equals(out)) {
				cnt = 1;
			}
		}
		return cnt;

	}

	// 회원 정보중 이메일만 가져오기
	@Override
	public int emailCheck(String email) throws RemoteException {
		int cnt = 0;
		List<String> allEmail = mem_dao.selectAllEmail();

		for (String out : allEmail) {
			if (email.equals(out)) {
				cnt = 1;
			}
		}
		return cnt;
	}

	// 회원 정보중 비밀번호만 가져오기
	@Override
	public int pwdCheck(String mempwd) throws RemoteException {
		int cnt = 0;
		List<String> allPwd = mem_dao.selectAllPwd();

		for (String out : allPwd) {
			if (mempwd.equals(out)) {
				cnt = 1;
			}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> selectOne(String mem_Id) {
		System.out.println("Server_ServiceImpl_SelectOne");

		List<MemberVO> memInfo = mem_dao.selectOne(mem_Id);
		System.out.println("Dao Accept Test");

		return memInfo;
	}
	//회원정보 수정하기
	@Override
	public int updateMemberInfo(MemberVO memberVO) throws RemoteException {
		return mem_dao.updateMemberInfo(memberVO);
	}
	//아이디 찾기
	@Override
	public List<String> select_findId(String name, String email) throws RemoteException {

		List<String> list = mem_dao.select_findId(name, email);

		return list;
	}
	//회원 정보 삭제
	@Override
	public int deleteMemberInfo(String mem_id) throws RemoteException {
		int cnt = mem_dao.deleteMemberInfo(mem_id);
		
		return cnt;
	}
	//비밀번호 찾기
	@Override
	public List<String> select_findPwd(String id, String email) throws RemoteException {
		List<String> list = mem_dao.select_findPwd(id, email);

		return list;
	}
	//개인 게시판 게시글 번호 증가
	@Override
	public int update_pb_post_no(String memid) throws RemoteException {
		return mem_dao.update_pb_post_no(memid);
	}
	//방명록 게시글 번호 증가
	@Override
	public int update_pb_guestbook_no(String memid) throws RemoteException {
		return mem_dao.update_pb_guestbook_no(memid);
	}

	@Override
	public int updateMemberInfoPwd(MemberVO memberVO) throws RemoteException {
		return mem_dao.updateMemberInfoPwd(memberVO);
	}

	@Override
	public List<RightVO> select_Right() throws RemoteException {
		return mem_dao.select_Right();
	}

	@Override
	public List<MemberVO> select_MemberList() throws RemoteException {
		List<MemberVO> list = mem_dao.selectList();
		return list;
	}

	@Override
	public List<MemberVO> search_member_to_degree(String degree) throws RemoteException {
		List<MemberVO> list = mem_dao.search_member_to_degree(degree);
		return list;
	}

	@Override
	public List<MemberVO> search_member_to_rightcode(String right_code) throws RemoteException {
		List<MemberVO> list = mem_dao.search_member_to_rightcode(right_code);
		return list;
	}

	@Override
	public List<MemberVO> search_member_to_class(String mem_class) throws RemoteException {
		List<MemberVO> list = mem_dao.search_member_to_class(mem_class);
		return list;
	}

	@Override
	public int update_member_right(MemberVO memberVO) throws RemoteException {
		return mem_dao.update_member_right(memberVO);
	}

	@Override
	public int update_member_image(MemberVO memberVO) throws RemoteException {
		return mem_dao.update_member_image(memberVO);
	}

	@Override
	public int update_member_avatar(MemberVO memberVO) throws RemoteException {
		return mem_dao.update_member_avatar(memberVO);
	}

	@Override
	public List<MemberVO> search_member_to_name(String mem_name) throws RemoteException {
		List<MemberVO> list = mem_dao.search_member_to_name(mem_name);
		return list;
	}

	@Override
	public List<MemberVO> select_adminUse_memberList() throws RemoteException {
		List<MemberVO> list = mem_dao.select_adminUse_memberList();
		return list;
	}

	@Override
	public List<MemberVO> search_adminUse_memberRight(String right_name) throws RemoteException {
		List<MemberVO> list = mem_dao.search_adminUse_memberRight(right_name);
		return list;
	}

	@Override
	public int update_member_out(MemberVO memberVO) throws RemoteException {
		return mem_dao.update_member_out(memberVO);
	}

	@Override
	public int update_LunchOrderDegree(String mem_id) throws RemoteException {
		return mem_dao.update_LunchOrderDegree(mem_id);
	}

}
