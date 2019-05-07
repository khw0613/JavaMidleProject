package kr.or.ddit.ibatis.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.vo.boarderVO.Persnal_boardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_board_typeVO;

public interface PersnalBoarderService extends Remote{
	
	public List<Persnal_boardVO> select_guestBook(String mem_id) throws RemoteException;//개인 방명록 가져오기

	public List<Persnal_boardVO> select_PersnalBoardList(String mem_id) throws RemoteException;//개인게시판 정보 가져오기
	
	public List<Persnal_boardVO> select_PersnalBoard_post(String pb_no) throws RemoteException;//개인게시판 게시글 정보 가져오기
	
	public int insert_PersnalBoard_post(HashMap<String, String> map) throws RemoteException;//개인 게시판 글 작성

	public int insert_GuestBook_post(HashMap<String, String> map) throws RemoteException;//방명록 글 작성
	
	public int update_PersnalBoard_post(Persnal_boardVO pbVO) throws RemoteException; //개인 게시글 수정

	public int update_GuestBook_post(Persnal_boardVO pbVO) throws RemoteException;//방명록 수정하기
	
	public int delete_PersnalBoard_post(String pb_no) throws RemoteException;//개인게시판 게시글 삭제하기
	
	public List<Persnal_board_typeVO> select_PBtype() throws RemoteException; // 개인게시판 유형 조회
	
	public List<Persnal_board_typeVO> select_OnePBtype(String persnal_board_type) throws RemoteException; // 개인게시판 유형명(persnal_board_type)으로 게시판 유형 조회
	
	public int update_PostViewCount(String pb_no) throws RemoteException; // 개인 게시판 조회수 업데이트
	
	
	
}
