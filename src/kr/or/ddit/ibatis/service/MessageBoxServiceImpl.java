package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.ibatis.dao.MessageBoxDao;
import kr.or.ddit.ibatis.dao.MessageBoxDaoImpl;
import kr.or.ddit.ibatis.vo.communityVO.MessageBoxVO;

public class MessageBoxServiceImpl extends UnicastRemoteObject implements MessageBoxService{

	MessageBoxDao message_dao;
	private static MessageBoxServiceImpl service;

	private MessageBoxServiceImpl() throws RemoteException {
		super();

		message_dao = MessageBoxDaoImpl.getInstance();
		System.out.println("MemSignUpDao Accept!");
	}

	public static MessageBoxServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new MessageBoxServiceImpl();
		}
		return service;
	}
	
	
	@Override
	public List<MessageBoxVO> select_MessageList() throws RemoteException {
		List<MessageBoxVO> list = message_dao.select_MessageList();
		return list;
	}

	@Override
	public List<MessageBoxVO> select_sendMessageInfo(String mem_id) throws RemoteException {
		List<MessageBoxVO> list = message_dao.select_sendMessageInfo(mem_id);
		return list;
	}

	@Override
	public List<MessageBoxVO> select_receiveMessageInfo(String receive_id) throws RemoteException {
		List<MessageBoxVO> list = message_dao.select_receiveMessageInfo(receive_id);
		return list;
	}

	@Override
	public int insert_MessageInfo(MessageBoxVO messageboxVO) throws RemoteException {
		return message_dao.insert_MessageInfo(messageboxVO);
	}

	@Override
	public int delete_MessageInfo(String msg_no) throws RemoteException {
		return message_dao.delete_MessageInfo(msg_no);
	}

	@Override
	public List<MessageBoxVO> select_allUnreadMessage(String receive_id) throws RemoteException {
		List<MessageBoxVO> list = message_dao.select_allUnreadMessage(receive_id);
		return list;
	}

	@Override
	public List<MessageBoxVO> select_allReadMessage(String receive_id) throws RemoteException {
		List<MessageBoxVO> list = message_dao.select_allReadMessage(receive_id);
		return list;
	}

	@Override
	public List<MessageBoxVO> select_ReadMessage(String msg_no) throws RemoteException {
		List<MessageBoxVO> list = message_dao.select_ReadMessage(msg_no);
		return list;
	}

	@Override
	public int updae_ReadMessage(String msg_no) throws RemoteException {
		return message_dao.updae_ReadMessage(msg_no);
	}

}
