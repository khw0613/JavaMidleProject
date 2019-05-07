package kr.or.ddit.ibatis.vo.boarderVO;

import java.io.Serializable;

/**
 * 개인 게시판 유형
 * @author macbook
 *
 */
public class Persnal_board_typeVO implements Serializable{
	private String persnal_board_no;
	private String persnal_board_type;
	
	public String getPersnal_board_no() {
		return persnal_board_no;
	}
	public void setPersnal_board_no(String persnal_board_no) {
		this.persnal_board_no = persnal_board_no;
	}
	public String getPersnal_board_type() {
		return persnal_board_type;
	}
	public void setPersnal_board_type(String persnal_board_type) {
		this.persnal_board_type = persnal_board_type;
	}
	
	
}
