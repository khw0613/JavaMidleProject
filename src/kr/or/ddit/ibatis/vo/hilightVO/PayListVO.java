package kr.or.ddit.ibatis.vo.hilightVO;

import java.io.Serializable;

/**
 * 결제관리
 * 
 * @author sanghoyun
 *
 */
public class PayListVO implements Serializable{

	private String pay_list_no;
	private String pay_no;

	public String getPay_list_no() {
		return pay_list_no;
	}

	public void setPay_list_no(String pay_list_no) {
		this.pay_list_no = pay_list_no;
	}

	public String getPay_no() {
		return pay_no;
	}

	public void setPay_no(String pay_no) {
		this.pay_no = pay_no;
	}

}
