package kr.or.ddit.ibatis.vo.boarderVO;

import java.io.Serializable;

/**
 * 게시판 유형
 * @author sanghoyun
 *
 */

public class Board_typeVO implements Serializable{
	private String board_type;
	private String board_name;
	private String board_level;

	public String getBoard_level() {
		return board_level;
	}

	public void setBoard_level(String board_level) {
		this.board_level = board_level;
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

}
