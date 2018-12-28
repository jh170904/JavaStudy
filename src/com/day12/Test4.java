package com.day12;

//내부클래스
//익명의, Annonymous, 무명의 클래스
//메모리 낭비가 적다. 한번 사용하고 버림을 반복.
//안드로이드에서 많이 사용
//컴파일 할 경우 Test4$1.class 로 만들어짐

public class Test4 {
	
	public Object getTitle(){

		return new Object(){//return값이 객체. 객체의 이름이 없음. 메모리의 낭비를 막아줌. 매번 사용하고 끝남. 주소가 연결되어 있지 않아 garbage collector가 수집.
			@Override
			public String toString() {
				return  "익명의클래스";
			}					
		};		
				
	}
	
	public static void main(String[] args) {
		
		Test4 ob = new Test4();
		System.out.println(ob.getTitle());
	}

}
