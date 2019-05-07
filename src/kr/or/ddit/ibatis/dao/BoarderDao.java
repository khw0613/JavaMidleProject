package kr.or.ddit.ibatis.dao;

import java.util.List;

import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Board_typeVO;

/**
 * 게시판 관리
 * @author sanghoyun
 *
 */
public interface BoarderDao {
	
	public List<BoardVO> select_boardList(String board_type);//공통 게시판별 정보 가져오기
	
	public List<BoardVO> select_boardList_degree(String board_type, String degree); // 기수별 게시판 정보 가져오기
	
	public List<BoardVO> select_common_post(BoardVO boardVO); // 공통 게시글 가져오기
	
	public List<BoardVO> select_degree_post(BoardVO boardVO); // 기수별 게시판 게시글 가져오기
	
	public int insert_common_post(BoardVO boardVO); // 공통게시판 게시글 정보 데이터베이스에 삽입하기

	public int insert_post(BoardVO boardVO); // 게시판 게시글 정보 데이터베이스에 삽입하기

	public int update_post(BoardVO boardno); // 게시물 정보 수정하기
	
	public int delete_post(String boardno); // 게시물 삭제
	
	public int update_viewCount(String boardno); // 조회수 업데이트하기
	
	public List<BoardVO> search_post_to_id(BoardVO boardVO); // 작성자(search_id + board_type)로 검색
	
	public List<BoardVO> search_post_to_no(String search_no); // 글번호(search_no)로 검색
	
	public List<BoardVO> search_post_to_title(BoardVO boardVO); // 제목(search_title + board_type)로 검색
	
	public List<BoardVO> search_post_to_titleAndcontents(BoardVO boardVO); // 제목 + 내용(search_txt + board_type)로 검색
	
	public List<Board_typeVO> select_BoardType(); // 게시판 유형 조회
	
	public List<Board_typeVO> select_OneBoardType(String board_name); // 게시판 유형명(board_name) 으로 검색 
	
	public List<BoardVO> select_notice_post(String degree); //공지사항 출력 메서드

}