package com.day12;

import java.util.Iterator;
import java.util.Vector;

public class Test6 {

	private static final String city[] = {"서울","부산","대구","인천","광주","대전","울산"};
	
	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>(); //벡터 v에 String값만 넣겠다. 강제성을 띈 통일성
		for(String s : city){
			v.add(s);
		}
		
		//v.add(10); int형 데이터 넣을 수 없음. 객체생성시 String값만 넣겠다 선언
		
		String str;
		str = v.get(0); 
		System.out.println(str);
		
		str = v.firstElement(); //첫번째 데이터 꺼내올 때. second, third같은건 없음
		System.out.println(str);
		
		str = v.lastElement(); //마지막 데이터 꺼내올 때
		System.out.println(str);
		
		for(int i=0; i<v.size();i++){ //벡터의 크기:7
			System.out.print(v.get(i)+" ");
			
		}
		System.out.println();
		//----------------------------------------------
		for(String s: v){ //벡터도 확장 for문 가능
			System.out.print(s + " ");
		}
		System.out.println();
		//----------------------------------------------
		
		
		//Iterator : 반복자
		Iterator<String> it = v.iterator(); //copy의 개념
		
		while(it.hasNext()){ //move의 개념
			
			str = it.next();
			System.out.print(str + " " );
			
		}
		
		
		
		
		
	}

}
