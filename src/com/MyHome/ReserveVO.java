package com.MyHome;

import java.io.Serializable;

public class ReserveVO implements Serializable, Runnable {

	private static final long serialVersionUID = 1L;

	String buyerId;
	String sellerId;
	String buyerName;		//구매자
	String sellerName;		//판매자
	String buyerPhone;
	String sellerPhone;
	String item;
	String term;
	String local;
	long price;
	
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public String getBuyerPhone() {
		return buyerPhone;
	}
	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
	
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
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
		
		String str = String.format("판매자:%s[%s] \n예약자:%s[%s] \n%s지역 %s[%s] %s \n판매자 전화번호:%s \n예약자 전화번호:%s", 
								sellerName, sellerId, buyerName, buyerId, local, item, term, won.priceWon(price), sellerPhone, buyerPhone);
		
		return str;
		
	}

	@Override
	public void run() {
		Won won = new Won();
		
		try {
		    System.out.println(".------------------------------------------------------.");
		    System.out.println("|                                                      |");
			Thread.sleep(100);
		    System.out.println("|                                                      |");
		    System.out.println("|        부  동  산  매  매  상  담  신  청  서        |");
		    Thread.sleep(100);
			System.out.println("|                                                      |");
			System.out.printf("|   지역 : %3s                  주거형태 :%4s   |\n",local, item);
			Thread.sleep(100);
			System.out.printf("|   계약형태 : %3s              가격 : %4s        |\n", term, won.priceWon(price));
			Thread.sleep(100);
			System.out.printf("|   판매자 : %4s              신청자 : %4s     |\n", sellerName, buyerName);
			Thread.sleep(100);
			System.out.printf("|   판매자 연락처:%10s                        |\n", sellerPhone);
			Thread.sleep(100);
			System.out.printf("|   신청자 연락처:%10s                        |\n", buyerPhone);
			Thread.sleep(100);
			System.out.println("|                	상담 예약이 완료 되었습니다.   |");
			Thread.sleep(100);
			System.out.println(".-.     .-.     .-.     .-.     .-.     .-.     .-.    |");
			Thread.sleep(100);
		    System.out.println("   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'");
			System.out.println("\n");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
