package com.MyHome;

import java.io.Serializable;

public class MyHomeVO implements Serializable {
	
	String name; // 로그인한 고객의 name
	String phone;// 로그인 고객의 phone
	String id;
	String item; // 아파트/오피스텔/빌라/상가/토지
	String term; // 전세/매매/월세/단기임대 
	String local;// 강남구, 논현구, 서초구
	long price;	 // 0~5천 / 5천~1억미만 / 1억이상~5억 / 5억이상
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		Won won = new Won();
		
		String str = String.format("[지역: %s, 주거형태: %s, 계약형태: %s, 금액: %s, 등록자: %s]", 
						local, item, term, won.priceWon(price), name);
		return str;
		
	}
	
	public String toString2() {
		
		Won won = new Won();
		
		String str = String.format("     지역:%s, %s, %s, 금액:%s  ", 
						local, item, term, won.priceWon(price), name);
		return str;
		
	}
	
	
	
}
