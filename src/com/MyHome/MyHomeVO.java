package com.MyHome;

import java.io.Serializable;

public class MyHomeVO implements Serializable {
	
	String name; // 로그인한 고객의 name
	String item; // 아파트/오피스텔/빌라/상가/토지
	String term; // 전세/매매/월세/단기임대 
	String local;// 강남구, 논현구, 서초구
	long price;	 // 0~5천 / 5천~1억미만 / 1억이상~5억 / 5억이상
	
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
		
		String str = String.format("지역:%s\t %s\t %s\t 가격:%s \t%s등록", 
						local, item, term, won.priceWon(price), name);
		return str;
		
	}
	
	
}
