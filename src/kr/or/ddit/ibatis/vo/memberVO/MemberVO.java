package kr.or.ddit.ibatis.vo.memberVO;

import java.io.Serializable;

/**
 * 기본 회원정보
 * @author sanghoyun
 */
public class MemberVO implements Serializable{
	private String mem_id;
	private String right_code;
	private String mem_name;
	private String mem_pwd;
	private String email;
	private String telno;
	private String degree;
	private String mem_class;
	private String bank;
	private String acnt_owner;
	private String account;
	private String pen_quantity;
	private String mem_join_date;
	private String pb_post_no;
	private String pb_guestbook_no;
	private String avatar;
	private String mem_image;
	private String right_name;
	private String profile_contents;
	

	public String getProfile_contents() {
		return profile_contents;
	}

	public void setProfile_contents(String profile_contents) {
		this.profile_contents = profile_contents;
	}

	public String getRight_name() {
		return right_name;
	}

	public void setRight_name(String right_name) {
		this.right_name = right_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMem_image() {
		return mem_image;
	}

	public void setMem_image(String mem_image) {
		this.mem_image = mem_image;
	}

	public String getPb_post_no() {
		return pb_post_no;
	}

	public void setPb_post_no(String pb_post_no) {
		this.pb_post_no = pb_post_no;
	}

	public String getPb_guestbook_no() {
		return pb_guestbook_no;
	}

	public void setPb_guestbook_no(String pb_guestbook_no) {
		this.pb_guestbook_no = pb_guestbook_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getRight_code() {
		return right_code;
	}

	public void setRight_code(String right_code) {
		this.right_code = right_code;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMem_class() {
		return mem_class;
	}

	public void setMem_class(String mem_class) {
		this.mem_class = mem_class;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAcnt_owner() {
		return acnt_owner;
	}

	public void setAcnt_owner(String acnt_owner) {
		this.acnt_owner = acnt_owner;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String getPen_quantity() {
		return pen_quantity;
	}

	public void setPen_quantity(String pen_quantity) {
		this.pen_quantity = pen_quantity;
	}

	public String getMem_join_date() {
		return mem_join_date;
	}

	public void setMem_join_date(String mem_join_date) {
		this.mem_join_date = mem_join_date;
	}

}
