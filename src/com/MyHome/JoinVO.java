package com.MyHome;

import java.io.Serializable;

public class JoinVO implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;		//아이디
	String pw;		//비밀번호
	String name;	//이름
	String phone;	//휴대폰 번호
	int type;		//1.부동산, 2.판매자/구매자
	
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

	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		
		String str;
		
		if(type==1){
			str = String.format("***중개업자 회원가입 완료*** \n아이디:%s \n비밀번호:%s \n이름:%s \n번호:%s \n", 
					id, pw, name, phone);
		}
		else{
			str = String.format("***구매자/판매자 회원가입 완료*** \n아이디:%s \n비밀번호:%s \n이름:%s \n번호:%s \n", 
					id, pw, name, phone);	
		}
		
		return str;
	}
	
	public String toPrint() {
		
		String str2;
		if(type==1){
			str2 = String.format("중개업자 \t %10s  %6s \t %10s", id,name, phone);
		}else{
			str2 = String.format("구매자/판매자 \t %10s  %6s \t %10s", id,name,phone);
		}
		return str2;
	}
	
}
