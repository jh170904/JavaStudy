package com.day07;

import java.util.Calendar;

public class Test4 {

	public static void main(String[] args) {		
		
		Data ob = new Data();	//객체생성
		ob.print();				
		
		Data.print(); //클래스이름.메소드명 
		//위에 두줄을 이처럼 하나로 바로 호출 가능. 미리 메모리상에 올라가있는 static 메소드
		
		//Calendar now = new Calendar(); Calendar 현재시점의 날짜와 시간을 이용하는 클래스. static class. new 로 만들 수 없음
		Calendar now1 = Calendar.getInstance(); //언제 호출해도 같은 값. 굳이 똑같은 값을 여러개 만들어 메모리 낭비할 필요 없음.
				
	}

}
