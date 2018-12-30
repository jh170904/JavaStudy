package com.MyHome;

public interface MyHome {
	
	public boolean login(String id,String pw);//로그인
	public void iteminput(String id);//부동산 매물 등록
	public void search();//매물검색
	public void reserve(String id);//상담 예약 .. 콘솔 이쁘게
	public void contract(String id);//계약체결(매물삭제)

}
