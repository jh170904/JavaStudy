package com.day13;

//Generic
class Box<T>{
	
	private T t; //T의 자료형이 결정되지 않음
	
	public void set(T t){//초기화메소드
		this.t = t;
	}
	
	public T get(){//반환값호출메소드
		return t;
	}
	
}

public class Test4 {
	
	public static void main(String[] args) {
		//느려서 많이 쓰지는 않음. 제너릭 구조 
		Box<Integer> b1 = new Box<Integer>();
		
		b1.set(new Integer(10)); //T는 클래스. 매개변수 입력 시 객체를 생성해줘야 함. 참조형 자료형의 객체생성
		Integer i = b1.get();
		System.out.println(i);
		//-----------------------------------------
		
		Box<String> b2 = new Box<String>();
		b2.set("서울");
		String s = b2.get();
		System.out.println(s);
		//-----------------------------------------
		
		Box b3 = new Box(); //Box의 자료형 선언 안한 상태. Object로 만들어짐
		b3.set(30); //제일 큰 클래스 Object로 box에 30입력. upcast
		Integer ii = (Integer)b3.get(); //downcast
	
	}

}
