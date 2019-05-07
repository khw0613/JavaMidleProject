package kr.or.ddit.ibatis.vo.hilightVO;

import java.io.Serializable;

public class Pen_managementVO implements Serializable {
	private String management_no;
	private String use_type;
	private String use_name;
	private String pen_type;
	private String pen_cnt;
	private String mem_id;
	private String receive_id;
	private String use_date;
	private String no_parameter;   // insert문에 필요한 파라미터(결제, 환불, 후원, 환전의 key값이 되는 번호를 담을 변수)
	private String pen_name;
	private String profit;
	private String exchange_amount;
	private String profit_date;
	
	
	
	public String getProfit_date() {
		return profit_date;
	}
	public void setProfit_date(String profit_date) {
		this.profit_date = profit_date;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	public String getExchange_amount() {
		return exchange_amount;
	}
	public void setExchange_amount(String exchange_amount) {
		this.exchange_amount = exchange_amount;
	}
	public String getPen_name() {
		return pen_name;
	}
	public void setPen_name(String pen_name) {
		this.pen_name = pen_name;
	}
	public String getNo_parameter() {
		return no_parameter;
	}
	public void setNo_parameter(String no_parameter) {
		this.no_parameter = no_parameter;
	}
	public String getUse_name() {
		return use_name;
	}
	public void setUse_name(String use_name) {
		this.use_name = use_name;
	}
	public String getManagement_no() {
		return management_no;
	}
	public void setManagement_no(String management_no) {
		this.management_no = management_no;
	}
	public String getUse_type() {
		return use_type;
	}
	public void setUse_type(String use_type) {
		this.use_type = use_type;
	}
	public String getPen_type() {
		return pen_type;
	}
	public void setPen_type(String pen_type) {
		this.pen_type = pen_type;
	}
	public String getPen_cnt() {
		return pen_cnt;
	}
	public void setPen_cnt(String pen_cnt) {
		this.pen_cnt = pen_cnt;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getReceive_id() {
		return receive_id;
	}
	public void setReceive_id(String receive_id) {
		this.receive_id = receive_id;
	}
	public String getUse_date() {
		return use_date;
	}
	public void setUse_date(String use_date) {
		this.use_date = use_date;
	}
	
}
