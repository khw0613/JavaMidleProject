package kr.or.ddit.ibatis.vo.boarderVO;

import java.io.Serializable;

/**
 * 댓글 VO
 * 
 * @author sanghoyun
 *
 */
public class Board_commentVO implements Serializable{

	private String board_no;
	private String mem_id;
	private String comment_contents;
	private String comment_time;
	private String comment_no;

	public String getComment_no() {
		return comment_no;
	}

	public void setComment_no(String comment_no) {
		this.comment_no = comment_no;
	}

	public String getBoard_no() {
		return board_no;
	}

	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getComment_contents() {
		return comment_contents;
	}

	public void setComment_contents(String comment_contents) {
		this.comment_contents = comment_contents;
	}

	public String getComment_time() {
		return comment_time;
	}

	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}

}
