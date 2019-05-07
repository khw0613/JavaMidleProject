package kr.or.ddit.ibatis.dao;

import java.util.List;

import kr.or.ddit.ibatis.vo.memberVO.Log_WindowVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;

public interface LogWindowDao {
	
	public List<MemberVO> select_LogInfo();
	
	public int insert_LogInfo(String mem_id);
	
	public int delete_LogInfo(String mem_id);

}
