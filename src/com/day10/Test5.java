package com.day10;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test5 {

	public static void main(String[] args) {		
		//Calendar클래스. 자주 쓰는 메소드
		//현재 컴퓨터 시스템의 날짜 및 시간을 관리
		
		//Calendar now = new Calendar();와 아랫줄은 의미가 같음
		Calendar now = Calendar.getInstance(); //instance -> 객체를 사용해야만 쓸 수 있는 변수
		
		//Calendar now = new GregorianCalendar();  // upcast
		//부모                자식
		//GregorianCalendar now1 = new GregorianCalendar(); GregorianCalendar의 부모클래스는 Calendar이므로 
		//부모클래스의 메소드 사용 가능 
		
		int y = now.get(Calendar.YEAR);					//년
		int m = now.get(Calendar.MONTH)+1;  			//월. 0-11의 숫자를 가지고 있음
														//꺼낼때는 +1 (넣어줄때는 월-1 해주면됨)
		int d = now.get(Calendar.DAY_OF_MONTH);			//일
		int w = now.get(Calendar.DAY_OF_WEEK);			//주의수(1-7: 1일요일 ~ 7토요일)
		
		char[] yoil = {'일','월','화','수','목','금','토'};
		
		System.out.println(y + "-" + m + "-"+ d + "-" + yoil[w-1]);
		
		//달의 마지막날
		int firtDay = now.getActualMinimum(Calendar.DATE); //1. 매번 똑같으니 그냥 숫자 1쓰는게 나음
		int lastday = now.getActualMaximum(Calendar.DATE); //매달 말일은 다름
		
		System.out.println(firtDay + " : " + lastday);
		//Calendar클래스가 있으니까 매달 말일이 언젠지 계산할 필요가 없다.
			
		System.out.printf("%tF \n",now);					//2018-12-12
		System.out.printf("%tT \n",now);					//14:04:54
		System.out.printf("%1$tF %1$tT \n",now);			//2018-12-12 14:04:54. 1$는 뒤에 있는 인수가 하나니까 같은거로 써라
		
		//사용자가 입력한 연도, 월, 일수
		now.set(2019,10-1,10);//오버로딩된 메소드 많음. 집어넣을땐 -1해줘야 함(0~11까지 존재)
		y = now.get(Calendar.YEAR);			
		m = now.get(Calendar.MONTH)+1;  	
		d = now.get(Calendar.DAY_OF_MONTH); 
		w = now.get(Calendar.DAY_OF_WEEK);
			
		System.out.println(y + "-" + m + "-"+ d + "-" + yoil[w-1]); //내년10월10일은 목요일
		
	
	
	
	}

}
