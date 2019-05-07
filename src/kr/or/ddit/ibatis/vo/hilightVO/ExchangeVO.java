package kr.or.ddit.ibatis.vo.hilightVO;

import java.io.Serializable;

public class ExchangeVO implements Serializable{

	private String exchange_no;
	private String exchange_cnt;
	private String exchange_date;
	private String mem_id;
	private String pen_code;

	public String getPen_code() {
		return pen_code;
	}

	public void setPen_code(String pen_code) {
		this.pen_code = pen_code;
	}

	public String getExchange_no() {
		return exchange_no;
	}

	public void setExchange_no(String exchange_no) {
		this.exchange_no = exchange_no;
	}

	public String getExchange_cnt() {
		return exchange_cnt;
	}

	public void setExchange_cnt(String exchange_cnt) {
		this.exchange_cnt = exchange_cnt;
	}

	public String getExchange_date() {
		return exchange_date;
	}

	public void setExchange_date(String exchange_date) {
		this.exchange_date = exchange_date;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

}
