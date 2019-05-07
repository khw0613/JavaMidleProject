package kr.or.ddit.ibatis.service;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.dao.PersnalBoardDao;
import kr.or.ddit.ibatis.dao.PersnalBoardDaoImpl;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_boardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_board_typeVO;

public class PersnalBoardServiceImpl implements PersnalBoarderService {

	PersnalBoardDao persnal_dao;
	private static PersnalBoardServiceImpl service;

	private PersnalBoardServiceImpl() throws RemoteException {
		super();

		persnal_dao = PersnalBoardDaoImpl.getInstance();
		System.out.println("PersnalBoard Accept!");
	}

	public static PersnalBoardServiceImpl getInstance() throws RemoteException {

		if (service == null) {
			service = new PersnalBoardServiceImpl();
		}
		return service;
	}
	
	//개인 방명록 가져오기
	@Override
	public List<Persnal_boardVO> select_guestBook(String mem_id) throws RemoteException {

		List<Persnal_boardVO> list = persnal_dao.select_guestBook(mem_id);
		return list;
	}
	//개인게시판 정보 가져오기
	@Override
	public List<Persnal_boardVO> select_PersnalBoardList(String mem_id) throws RemoteException {
		List<Persnal_boardVO> list = persnal_dao.select_PersnalBoardList(mem_id);
		return list;
	}
	
	//개인게시판 게시글 정보 가져오기
	@Override
	public List<Persnal_boardVO> select_PersnalBoard_post(String pb_no) throws RemoteException {
		List<Persnal_boardVO> list = persnal_dao.select_PersnalBoard_post(pb_no);
		return list;
	}
	//개인게시판 게시글 수정하기
	@Override
	public int update_PersnalBoard_post(Persnal_boardVO pbVO) throws RemoteException {
		System.out.println("Service");
		return persnal_dao.update_PersnalBoard_post(pbVO);
	}
	
	//방명록 수정하기
	@Override
	public int update_GuestBook_post(Persnal_boardVO pbVO) throws RemoteException {
		return persnal_dao.update_GuestBook_post(pbVO);
	}
	//개인게시판 게시글 삭제하기
	@Override
	public int delete_PersnalBoard_post(String pb_no) throws RemoteException {
		return persnal_dao.delete_PersnalBoard_post(pb_no);
	}
	
	//개인 게시판 유형 조회
	@Override
	public List<Persnal_board_typeVO> select_PBtype() throws RemoteException {
		List<Persnal_board_typeVO> list = persnal_dao.select_PBtype();
		return list;
	}

	//개인게시판 유형명(persnal_board_type)으로 게시판 유형 조회
	@Override
	public List<Persnal_board_typeVO> select_OnePBtype(String persnal_board_type) throws RemoteException {
		List<Persnal_board_typeVO> list = persnal_dao.select_OnePBtype(persnal_board_type);
		return list;
	}

	// 개인 게시판 글 작성
	@Override
	public int insert_PersnalBoard_post(HashMap<String, String> map) throws RemoteException {
		return persnal_dao.insert_PersnalBoard_post(map);
	}
	
	//방명록 작성
	@Override
	public int insert_GuestBook_post(HashMap<String, String> map) throws RemoteException {
		return persnal_dao.insert_GuestBook_post(map);
	}

	@Override
	public int update_PostViewCount(String pb_no) throws RemoteException {
		return persnal_dao.update_PostViewCount(pb_no);
	}
	
	


}
