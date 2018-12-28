package com.day07;

class IntClass{//int값 두개를 저장할 수 있는 클래스. 클래스 자체를 자료형이라고 생각. 클래스=저장소로 기억하면 편함
	//변수선언만 진행
	int a;
	int b;	
}


public class Test1 {

	public static void main(String[] args) {

		IntClass ob1 = new IntClass(); //new로 객체를 생성한 전역변수는 초기값이 들어있음. int형이므로 0
		IntClass ob2 = new IntClass();
		
		//인스턴스변수는 반드시 메모리를 다른곳에 저장하고 
		//메소드만 동일 주소로 사용함을 볼 수 있는 예제

		ob1.a=10;
		ob1.b=20;
		System.out.println("ob1.a:"+ob1.a); //10
		System.out.println("ob1.b:"+ob1.b); //20
		System.out.println("-------------");
		
		System.out.println("ob2.a:"+ob2.a); //0
		System.out.println("ob2.b:"+ob2.b);	//0
		System.out.println("-------------");
		
		ob2.a=100;
		ob2.b=200;
		System.out.println("ob2.a:"+ob2.a); //100
		System.out.println("ob2.b:"+ob2.b);	//200
		System.out.println("-------------");
		
		System.out.println("ob1.a:"+ob1.a); //10
		System.out.println("ob1.b:"+ob1.b); //20
		
	}

}
