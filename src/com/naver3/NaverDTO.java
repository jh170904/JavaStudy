package com.naver3;

import java.io.Serializable;
import java.sql.Date;

public class NaverDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birth;
	private String email;
	private String tel;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return String.format("id:%s pw:%s name:%s gender:%s birth:%s email:%s tel:%s",
				id,pw,name,gender,birth,email,tel);
	}
	
}
