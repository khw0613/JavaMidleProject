package kr.or.ddit.ibatis.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import kr.or.ddit.ibatis.vo.memberVO.RightVO;

/**
 * 회원 관리 인터페이스
 * @author sanghoyun
 */
public interface MemberDao {
	
	public List<MemberVO> selectList();//전체 회원정보 가져오기
	
	public List<MemberVO> selectOne(String memId);// 맴버 아이디를 파라미터로 받아서 회원정보 조회하기
	
	public List<String> selectAllID(); //회원정보 중 아이디만 가져오기
	
	public List<String> selectAllEmail();//회원정보 중 이메일만 가져오기
	
	public List<String> selectAllPwd();//비밀번호만 가져오기
	
	public int insertMemberInfo(MemberVO memberVO);//회원가입 시 데이터베이스에 데이터 삽입하기
	
	public int updateMemberInfo(MemberVO memberVO);//회원정보 수정하기
	
	public int updateMemberInfoPwd(MemberVO memberVO);//회원보 수정하기 - 비밀번호
	
	public List<String> select_findId(String name, String email);//아이디 찾기
	
	public List<String> select_findPwd(String id, String email);// 비밀번호 찾기
	
	public int deleteMemberInfo(String mem_id);//회원 탈퇴
	
	public int update_pb_post_no(String memid);//개인게시판 게시글 번호 증가
	
	public int update_pb_guestbook_no(String memid);//방명록 게시글 번호 증가 
	
	public List<RightVO> select_Right(); //권한코드 + 권한명 검색
	
	public List<MemberVO> search_member_to_degree(String degree); // 기수로 회원 검색
	
	public List<MemberVO> search_member_to_rightcode(String right_code); // 기수로 회원 검색
	
	public List<MemberVO> search_member_to_class(String mem_class); // 기수로 회원 검색
	
	public int update_member_right(MemberVO memberVO); // 회원 등급(권한) 수정(관리자 기능 >> 회원탈퇴 상태로 변경 가능)
	
	public int update_member_image(MemberVO memberVO); // 회원 프로필 이미지 수정
	
	public int update_member_avatar(MemberVO memberVO); // 회원 프로필 아바타 수정
	
	public List<MemberVO> search_member_to_name(String mem_name); // 이름으로 회원 검색
	
	public List<MemberVO> select_adminUse_memberList(); // 관리자용 회원리스트 출력(등급이름까지 출력)
	
	public List<MemberVO> search_adminUse_memberRight(String right_name); // 관리자용 회원등급명으로 회원검색
	
	public int update_member_out(MemberVO memberVO); //회원 탈퇴(회원 등급을 탈퇴회원으로 변경)
	
	public int update_LunchOrderDegree(String mem_id); // 도시락 반장 권한주기
	
}
