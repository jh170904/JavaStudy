package com.day11;

class TestA{
	
	public void print(){
		System.out.println("A클래스....");
	}
	
}

class TestB{
	
	public void print(){
		System.out.println("A클래스....");
	}	

}

public class Test3 {

	public static void main(String[] args) {
		
		TestA a = new TestA();
		TestA b;
		TestB bb; 
		
		b = a; 
		//bb =a; 데이터 타입이 다름. 아예 다른 클래스. 불가
		//bb = (TestB)a; 형변환해서 넣을 수 있는가? 불가. 상속관계의 경우만 upcast, downcast 사용가능
	}

}
