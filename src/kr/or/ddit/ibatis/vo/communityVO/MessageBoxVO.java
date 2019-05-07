package kr.or.ddit.ibatis.vo.communityVO;

import java.io.Serializable;

/**
 * 쪽지함
 * 
 * @author sanghoyun
 *
 */
public class MessageBoxVO implements Serializable{
	private String mem_id;
	private String msg_no;
	private String msg_title;
	private String msg_contents;
	private String msg_date;
	private String receive_id;
	private String read;

	public String getMsg_title() {
		return msg_title;
	}

	public void setMsg_title(String msg_title) {
		this.msg_title = msg_title;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMsg_no() {
		return msg_no;
	}

	public void setMsg_no(String msg_no) {
		this.msg_no = msg_no;
	}

	public String getMsg_contents() {
		return msg_contents;
	}

	public void setMsg_contents(String msg_contents) {
		this.msg_contents = msg_contents;
	}

	public String getMsg_date() {
		return msg_date;
	}

	public void setMsg_date(String msg_date) {
		this.msg_date = msg_date;
	}

	public String getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(String receive_id) {
		this.receive_id = receive_id;
	}

}
