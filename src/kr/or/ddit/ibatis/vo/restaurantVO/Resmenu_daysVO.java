package kr.or.ddit.ibatis.vo.restaurantVO;

import java.io.Serializable;

/**
 * 식단표
 * @author macbook
 *
 */
public class Resmenu_daysVO implements Serializable{
	private String res_order_date;
	private String res_no;
	private String menu_soup;
	private String menu_1;
	private String menu_2;
	private String menu_3;
	private String menu_4;
	private String menu_5;
	private String order_check;
	private String res_price;
	private String menu_no;
	
	public String getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(String menu_no) {
		this.menu_no = menu_no;
	}
	public String getRes_order_date() {
		return res_order_date;
	}
	public void setRes_order_date(String res_order_date) {
		this.res_order_date = res_order_date;
	}
	public String getRes_no() {
		return res_no;
	}
	public void setRes_no(String res_no) {
		this.res_no = res_no;
	}
	public String getMenu_soup() {
		return menu_soup;
	}
	public void setMenu_soup(String menu_soup) {
		this.menu_soup = menu_soup;
	}
	public String getMenu_1() {
		return menu_1;
	}
	public void setMenu_1(String menu_1) {
		this.menu_1 = menu_1;
	}
	public String getMenu_2() {
		return menu_2;
	}
	public void setMenu_2(String menu_2) {
		this.menu_2 = menu_2;
	}
	public String getMenu_3() {
		return menu_3;
	}
	public void setMenu_3(String menu_3) {
		this.menu_3 = menu_3;
	}
	public String getMenu_4() {
		return menu_4;
	}
	public void setMenu_4(String menu_4) {
		this.menu_4 = menu_4;
	}
	public String getMenu_5() {
		return menu_5;
	}
	public void setMenu_5(String menu_5) {
		this.menu_5 = menu_5;
	}
	public String getOrder_check() {
		return order_check;
	}
	public void setOrder_check(String order_check) {
		this.order_check = order_check;
	}
	public String getRes_price() {
		return res_price;
	}
	public void setRes_price(String res_price) {
		this.res_price = res_price;
	}
	
	
	 @Override
     public String toString() {
         StringBuffer sb = new StringBuffer();
         
         sb.append(" res_no : " + res_no);
         sb.append("res_order_date : " + res_order_date);
         sb.append(" ,menu_soup : " + menu_soup);
         sb.append(" ,menu_1 : " + menu_1);
         sb.append(" ,menu_2 : " + menu_2);
         sb.append(" ,menu_3 : " + menu_3);
         sb.append(" ,menu_4 : " + menu_4);
         sb.append(" ,menu_5 : " + menu_5);
         sb.append(" ,order_check : " + order_check);
         sb.append(" ,res_price : " + res_price);
         sb.append(" ,menu_no : " + menu_no);
         
         return sb.toString();
     }
	

}
