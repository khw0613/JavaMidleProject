package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import kr.or.ddit.ibatis.vo.memberVO.RightVO;

public interface MemberService extends Remote{
	
	public void signUp() throws RemoteException;

	public void insertMemberInfo(MemberVO membervo) throws RemoteException;
	
	public List<MemberVO> selectOne(String memId) throws RemoteException;
	
	public int idCheck(String memid) throws RemoteException;//회원 정보중 아이디만 가져오기
	
	public int emailCheck(String memid) throws RemoteException;//회원 정보중 이메일만 가져오기

	public int pwdCheck(String memid) throws RemoteException;//회원 정보중 비밀번호만 가져오기
	
	public int updateMemberInfo(MemberVO memberVO) throws RemoteException; // 회원 정보 수정하기
	
	public int updateMemberInfoPwd(MemberVO memberVO) throws RemoteException;//회원보 수정하기 - 비밀번호
	
	public List<String> select_findId(String name, String email) throws RemoteException; // 아이디 찾기
	
	public List<String> select_findPwd(String id, String email) throws RemoteException; // 비밀번호 찾기
	
	public int deleteMemberInfo(String mem_id) throws RemoteException; // 회원 정보 삭제
	
	public int update_pb_post_no(String memid) throws RemoteException;//개인게시판 게시글 번호 증가
	
	public int update_pb_guestbook_no(String memid) throws RemoteException;//방명록 게시글 번호 증가 
	
	public List<MemberVO> select_MemberList() throws RemoteException; //회원 전체조회

	public List<RightVO> select_Right() throws RemoteException; //권한코드 + 권한명 검색
	
	public List<MemberVO> search_member_to_degree(String degree) throws RemoteException; // 기수로 회원 검색
	
	public List<MemberVO> search_member_to_rightcode(String right_code) throws RemoteException; // 기수로 회원 검색
	
	public List<MemberVO> search_member_to_class(String mem_class) throws RemoteException; // 기수로 회원 검색
	
	public int update_member_right(MemberVO memberVO) throws RemoteException; // 회원 등급(권한) 수정(관리자 기능)
	
	public int update_member_image(MemberVO memberVO) throws RemoteException; // 회원 프로필 이미지 수정
	
	public int update_member_avatar(MemberVO memberVO) throws RemoteException; // 회원 프로필 아바타 수정
	
	public List<MemberVO> search_member_to_name(String mem_name) throws RemoteException; // 이름으로 회원 검색
	
	public List<MemberVO> select_adminUse_memberList() throws RemoteException; // 관리자용 회원리스트 출력(등급이름까지 출력)
	
	public List<MemberVO> search_adminUse_memberRight(String right_name) throws RemoteException; // 관리자용 회원등급명으로 회원검색
	
	public int update_member_out(MemberVO memberVO) throws RemoteException; //회원 탈퇴(회원 등급을 탈퇴회원으로 변경)
	
	public int update_LunchOrderDegree(String mem_id) throws RemoteException; // 도시락 반장 권한주기
	
}
