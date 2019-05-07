package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.ibatis.vo.communityVO.MessageBoxVO;

public interface MessageBoxService extends Remote {
	
	public List<MessageBoxVO> select_MessageList() throws RemoteException; // 전체 쪽지정보 조회
	
	public List<MessageBoxVO> select_sendMessageInfo(String mem_id) throws RemoteException; // 보낸 쪽지정보 조회
	
	public List<MessageBoxVO> select_receiveMessageInfo(String receive_id) throws RemoteException; //받은 쪽지정보 조회
	
	public int insert_MessageInfo(MessageBoxVO messageboxVO) throws RemoteException; // 쪽지정보 데이터베이스에 삽입(쪽지 보내기)
	
	public int delete_MessageInfo(String msg_no) throws RemoteException; // 쪽지정보 삭제
	
	public List<MessageBoxVO> select_allUnreadMessage(String receive_id) throws RemoteException; // 읽지 않은 쪽지목록 조회
	
	public List<MessageBoxVO> select_allReadMessage(String receive_id) throws RemoteException; // 읽은 쪽지목록 조회
	
	public List<MessageBoxVO> select_ReadMessage(String msg_no) throws RemoteException; // 읽은 쪽지목록 조회
	
	public int updae_ReadMessage(String msg_no) throws RemoteException; // read 상태 수정하기
	
}
