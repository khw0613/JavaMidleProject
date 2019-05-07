package kr.or.ddit.ibatis.vo.boarderVO;

import java.io.Serializable;

/**
 * 게시판
 * 
 * @author sanghoyun
 *
 */
public class BoardVO implements Serializable{
	
	private String board_no;
	private String board_type;
	private String mem_id;
	private String board_title;
	private String board_contents;
	private String board_date;
	private String board_image;
	private String board_view;

	public String getBoard_no() {
		return board_no;
	}

	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_contents() {
		return board_contents;
	}

	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public String getBoard_image() {
		return board_image;
	}

	public void setBoard_image(String board_image) {
		this.board_image = board_image;
	}

	public String getBoard_view() {
		return board_view;
	}

	public void setBoard_view(String board_view) {
		this.board_view = board_view;
	}

}
