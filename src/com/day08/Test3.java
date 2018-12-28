package com.day08;

public class Test3 {
	
	int a=5; //instance변수
	
	//객체가 생성되면 바로 실행되는 instance 블럭
	
	{//초기화 블럭. 메소드로 호출하진 않는데 형식은 갖춰야 함. instance. 객체를 생성해야 볼 수 있음
		System.out.println("초기화 블럭 a -> " + a);
		a=10;
		System.out.println("초기화 블럭 a -> " + a);	
	}
	
	static int b; //클래스변수. 메모리 할당 되어 있음.
	
	static{//static 블럭
		b = 20;
		System.out.println("static 블럭 b -> " + b);
	}
	
	final int C; //final변수 = 상수. 항상 변하지 않는 수. 대문자로 작성함. 프로그램이 끝날 때 까지 값을 바꿀 수 없음
	//은행에서의 변동하지 않는 고정이자율. 원주율(파이)와 같은 변수 설정시 사용한다.
	//상수에 값을 설정 안해두면 에러. 초기값 반드시 설정해야 함. 메모리에 올라가야만 초기화 가능. 
	//일반 메소드에서 초기화 시킬 수 없음
	
	public Test3(){
		System.out.println("생성자...");
		C = 100;
		System.out.println("C:"+ C);
	}//이런 경우에 가장 마지막에 생성되는 것은 생성자.
	
	public static void main(String[] args) {
		
		Test3 ob = new Test3(); //객체생성. static블록이 제일 먼저 생성됨
		Test3 ob1 = new Test3(); //객체 두개 생성시 static은 객체를 여러번 만들어도 한번만 만들어진다. 메모리를 같이 쓰니까
	
		final int k = 10;
	}

}
