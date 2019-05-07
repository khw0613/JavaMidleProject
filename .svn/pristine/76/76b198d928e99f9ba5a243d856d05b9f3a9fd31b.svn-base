package kr.or.ddit.ibatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import kr.or.ddit.ibatis.vo.memberVO.RightVO;

public class MemberDaoImpl implements MemberDao {

	private SqlMapClient smc;
	private static MemberDaoImpl dao;

	private MemberDaoImpl() {
		smc = DBUTIL1.getInstance();
		
	}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	
	//전체 회원정보 가져오기
	@Override
	public List<MemberVO> selectList() {
		System.out.println("Select List All Member Infomation");
		List<MemberVO> list = new ArrayList<MemberVO>();

		try {
			list = smc.queryForList("qr_member.select_memberList");
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	
	//아이디 중복 검사
	@Override
	public List<String> selectAllID() {
		List<String> list = new ArrayList<String>();
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		try {
			list = smc.queryForList("qr_member.select_allID");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	
	//이메일 중복 검사
	@Override
	public List<String> selectAllEmail() {
		List<String> list = new ArrayList<String>();

		try {
			list = smc.queryForList("qr_member.select_allEmail");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	
	//회원 등록
	@Override
	public int insertMemberInfo(MemberVO memberVO) {
		int cnt = 0;
		try {
			
			memberVO.setAvatar((int)(Math.random()*4)+1 + "");
			memberVO.setRight_name("가입대기");
			Object obj = smc.insert("qr_member.insert_memberInfo", memberVO);
		
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	//패스워드 검색
	@Override
	public List<String> selectAllPwd() {
		List<String> list = new ArrayList<String>();

		try {
			list = smc.queryForList("qr_member.select_allEmail");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	
	// 맴버 아이디를 파라미터로 받아서 회원정보 조회하기
	@Override
	public List<MemberVO> selectOne(String mem_Id) {
		System.out.println("Server_DaoImpl_Accept");
		List<MemberVO> list = new ArrayList<MemberVO>();

		try {
			list = smc.queryForList("qr_member.select_memberInfo", mem_Id);
			System.out.println("Clear Query");
			
			
		} catch (SQLException e) {
			System.out.println("Err!! Query");
			e.printStackTrace();

		}
		return list;
	}
	//회원정보 수정하기
	@Override
	public int updateMemberInfo(MemberVO memberVO) {
		int cnt = 0;
		try {
			cnt = smc.update("qr_member.update_memberInfo", memberVO);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	//아이디 찾기
	@Override
	public List<String> select_findId(String name, String email) {
		
		List<String> list = new ArrayList<String>();
		HashMap<String, String> info = new HashMap<String, String>();
		info.put("name", name);
		info.put("email", email);
		
		try {
			list = smc.queryForList("qr_member.select_findId", info);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	//회원 삭제 하기
	@Override
	public int deleteMemberInfo(String mem_id) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_member.delete_member", mem_id);

			if (obj == null) {
				cnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cnt;
	}
	
	
	
	
	//비밀번호 찾기
	@Override
	public List<String> select_findPwd(String id, String email) {
		
		List<String> list = new ArrayList<String>();
		HashMap<String, String> info = new HashMap<String, String>();
		info.put("id", id);
		info.put("email", email);
		
		try {
			list = smc.queryForList("qr_member.select_findPwd", info);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	//개인게시판 게시글 번호 증가
	@Override
	public int update_pb_post_no(String memid) {
		int cnt = 0;
		try {
			cnt = smc.update("qr_member.update_pb_post_no", memid);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	//방명록 게시글 번호 증가
	@Override
	public int update_pb_guestbook_no(String memid) {
		int cnt = 0;
		try {
			cnt = smc.update("qr_member.update_pb_guestbook_no", memid);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 비밀번호 변경하기
	@Override
	public int updateMemberInfoPwd(MemberVO memberVO) {
		int cnt = 0;
		try {
			cnt = smc.update("qr_member.update_memberInfoPwd", memberVO);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<RightVO> select_Right() {
		List<RightVO> list = new ArrayList<RightVO>();
		
		try {
			list = smc.queryForList("qr_member.select_Right");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> search_member_to_degree(String degree) {
		List<MemberVO> list = new ArrayList<MemberVO>();

		try {
			list = smc.queryForList("qr_member.search_member_to_degree", degree);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<MemberVO> search_member_to_rightcode(String right_code) {
		List<MemberVO> list = new ArrayList<MemberVO>();

		try {
			list = smc.queryForList("qr_member.search_member_to_rightcode", right_code);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<MemberVO> search_member_to_class(String mem_class) {
		List<MemberVO> list = new ArrayList<MemberVO>();

		try {
			list = smc.queryForList("qr_member.search_member_to_class", mem_class);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public int update_member_right(MemberVO memberVO) {
		int cnt = 0;
		
		try {
			cnt = smc.update("qr_member.update_member_right", memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int update_member_image(MemberVO memberVO) {
		int cnt = 0;
		
		try {
			cnt = smc.update("qr_member.update_membar_image", memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int update_member_avatar(MemberVO memberVO) {
		int cnt = 0;
		
		try {
			cnt = smc.update("qr_member.update_member_avatar", memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> search_member_to_name(String mem_name) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			list = smc.queryForList("qr_member.search_member_to_name", mem_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> select_adminUse_memberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			list = smc.queryForList("qr_member.select_adminUse_memberList");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> search_adminUse_memberRight(String right_name) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			list = smc.queryForList("qr_member.search_adminUse_memberRight", right_name);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update_member_out(MemberVO memberVO) {
		int cnt = 0;
		
		try {
			cnt = smc.update("qr_member.update_member_out", memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int update_LunchOrderDegree(String mem_id) {
		int cnt = 0;
		
		try {
			cnt = smc.update("qr_member.update_LunchOrderDegree", mem_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return cnt;
	}
}
