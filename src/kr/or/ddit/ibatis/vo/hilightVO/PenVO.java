package kr.or.ddit.ibatis.vo.hilightVO;

import java.io.Serializable;

/**
 * 
 * @author sanghoyun
 *
 */

public class PenVO implements Serializable{
	private String pen_code;
	private String pen_name;
	private String pen_price;
	
	public String getPen_code() {
		return pen_code;
	}
	public void setPen_code(String pen_code) {
		this.pen_code = pen_code;
	}
	public String getPen_name() {
		return pen_name;
	}
	public void setPen_name(String pen_name) {
		this.pen_name = pen_name;
	}
	public String getPen_price() {
		return pen_price;
	}
	public void setPen_price(String pen_price) {
		this.pen_price = pen_price;
	}
	
	
}
