package kr.or.ddit.ibatis.vo.hilightVO;

import java.io.Serializable;

/**
 * 환불
 * @author macbook
 *
 */
public class RefundVO implements Serializable{
	private String pay_no;
	private String refund_no;
	private String refund_type_code;
	private String mem_id;
	private String refund_date;
	private String refund_cnt;
	private String pen_code;
	
	public String getPen_code() {
		return pen_code;
	}
	public void setPen_code(String pen_code) {
		this.pen_code = pen_code;
	}
	public String getRefund_cnt() {
		return refund_cnt;
	}
	public void setRefund_cnt(String refund_cnt) {
		this.refund_cnt = refund_cnt;
	}
	public String getPay_no() {
		return pay_no;
	}
	public void setPay_no(String pay_no) {
		this.pay_no = pay_no;
	}
	public String getRefund_no() {
		return refund_no;
	}
	public void setRefund_no(String refund_no) {
		this.refund_no = refund_no;
	}
	public String getRefund_type_code() {
		return refund_type_code;
	}
	public void setRefund_type_code(String refund_type_code) {
		this.refund_type_code = refund_type_code;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getRefund_date() {
		return refund_date;
	}
	public void setRefund_date(String refund_date) {
		this.refund_date = refund_date;
	}
	
}
