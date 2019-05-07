package kr.or.ddit.ibatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.ibatis.DBUTIL1;
import kr.or.ddit.ibatis.vo.communityVO.MessageBoxVO;

public class MessageBoxDaoImpl implements MessageBoxDao {
	
	private SqlMapClient smc;
	private static MessageBoxDaoImpl dao;

	private MessageBoxDaoImpl() {
		smc = DBUTIL1.getInstance();
		
	}
	
	public static MessageBoxDaoImpl getInstance() {
		if(dao == null) {
			dao = new MessageBoxDaoImpl();
		}
		return dao;
	}

	@Override
	public List<MessageBoxVO> select_MessageList() {
		List<MessageBoxVO> list = new ArrayList<MessageBoxVO>();
		try {
			
			list = smc.queryForList("qr_messagebox.select_MessageList");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MessageBoxVO> select_sendMessageInfo(String mem_id) {
		List<MessageBoxVO> list = new ArrayList<MessageBoxVO>();
		try {
			
			list = smc.queryForList("qr_messagebox.select_sendMessageInfo", mem_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MessageBoxVO> select_receiveMessageInfo(String receive_id) {
		List<MessageBoxVO> list = new ArrayList<MessageBoxVO>();
		try {
			
			list = smc.queryForList("qr_messagebox.select_receiveMessageInfo", receive_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert_MessageInfo(MessageBoxVO messageboxVO) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qr_messagebox.insert_MessageInfo", messageboxVO);
		
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int delete_MessageInfo(String msg_no) {
		int cnt = 0;
		try {
			
			cnt = smc.delete("qr_messagebox.delete_MessageInfo", msg_no);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MessageBoxVO> select_allUnreadMessage(String receive_id) {
		List<MessageBoxVO> list = new ArrayList<MessageBoxVO>();
		
		try {
			list = smc.queryForList("qr_messagebox.select_allUnreadMessage", receive_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MessageBoxVO> select_allReadMessage(String receive_id) {
		List<MessageBoxVO> list = new ArrayList<MessageBoxVO>();
		
		try {
			list = smc.queryForList("qr_messagebox.select_allReadMessage", receive_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MessageBoxVO> select_ReadMessage(String msg_no) {
		List<MessageBoxVO> list = new ArrayList<MessageBoxVO>();
		
		try {
			list = smc.queryForList("qr_messagebox.select_ReadMessage", msg_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updae_ReadMessage(String msg_no) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("qr_messagebox.updae_ReadMessage", msg_no);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
