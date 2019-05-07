package kr.or.ddit.ibatis.dao;

import java.util.List;

import kr.or.ddit.ibatis.vo.communityVO.MessageBoxVO;

public interface MessageBoxDao {
	
	public List<MessageBoxVO> select_MessageList(); // 전체 쪽지정보 조회
	
	public List<MessageBoxVO> select_sendMessageInfo(String mem_id); // 보낸 쪽지정보 조회
	
	public List<MessageBoxVO> select_receiveMessageInfo(String receive_id); //받은 쪽지정보 조회
	
	public int insert_MessageInfo(MessageBoxVO messageboxVO); // 쪽지정보 데이터베이스에 삽입(쪽지 보내기)
	
	public int delete_MessageInfo(String msg_no); // 쪽지정보 삭제
	
	public List<MessageBoxVO> select_allUnreadMessage(String receive_id); // 읽지 않은 쪽지목록 조회
	
	public List<MessageBoxVO> select_allReadMessage(String receive_id); // 읽은 쪽지목록 조회
	
	public List<MessageBoxVO> select_ReadMessage(String msg_no); // 읽은 쪽지목록 조회
	
	public int updae_ReadMessage(String msg_no); // read 상태 수정하기
	
}
