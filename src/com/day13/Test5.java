package com.day13;
//제너릭의 기본적인 구조 이해. 컬렉션이 이 형태로 이루어져 있음
class Box2<T>{
	
	private T t;//T는 전역변수 개념
	
	public void set(T t){
		this.t = t;
	}
	
	public T get(){
		return t; 
	}
	
	public <U> void print(U u){// 메소드에도 제너릭 사용가능. U는 print 메소드에서만 사용 가능한 자료형
		System.out.println(u);
		System.out.println("t클래스의 자료형: "+ t.getClass().getName()); //.getClass().getName() 어떤 클래스건간에 공통적으로 가지고 있는 메소드 
		System.out.println("u메소드의 자료형: "+ u.getClass().getName());
	}
}

public class Test5 {

	public static void main(String[] args) {

		Box2<Integer> b = new Box2<Integer>();
		b.set(new Integer(30)); //T를 초기화. T -> Integer
		b.print("test");		//메소드초기화(String). print 메소드의 매개변수로 test라는 문자열을 줌. 반환값도 문자열을 줌
		b.print(50);			//메소드초기화(Integer). T의 클래스는 고정. 각각 메소드의 자료형을 지정해 줄 수 있음. U의 자료형 정수형으로 바뀌어서 Integer 보임
	}

}
