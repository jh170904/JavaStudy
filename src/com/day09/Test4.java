package com.day09;
//Object : 모든클래스는 Object를 상속받는다. 
class TestA extends Object{ // 모든클래스의 부모클래스는 Object. 
	//extends Object를 쓰지 않아도 오류 안남. 기본적으로 상속개념이 이미 반영되어있음
	
	private int a = 10;
	
	public void write(){
		System.out.println("a: " + a);
	}
	
}

public class Test4 {

	public static void main(String[] args) {
		
	TestA ob1 = new TestA();	// new : 물리적으로 새롭게 만들어라. 100번 썼으면 100개 만들어짐
	TestA ob2 = new TestA();	
	System.out.println("ob1==ob2 : " + (ob1==ob2) ); 	//false : 주소를 비교한 것 이기 때문
	//똑같은 클래스로 객체 생성했지만 ob1에 들은 주소와 ob2에 들은 주소가 다르기 때문
	System.out.println("ob1.equals(ob2) : " + (ob1.equals(ob2)) );	//.equals()라는 메소드 사용
	//모든 클래스의 부모는 Object. 내맘대로 가져다 쓸 수 있음 
	//equals() 메소드는 주소와 주소를 비교함
	System.out.println("ob1: " + ob1); //com.day9.TestA@15db9742    <- @뒤에 숫자는 hashcode
	System.out.println("ob2: " + ob2.toString()); //com.day9.TestA@6d06d69c 패키지.클래스.hashcode
	//자바에서는 포인터변수 사용 안한다. 
	
	
	}

}
