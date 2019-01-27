package com.day12;

//내부클래스(inner) 
//클래스 안에 클래스를 생성. Nested class
//클래스는 메소드안, 클래스안에 또 정의해도 문제 없음. 단, 괄호 잘 맞춰줘야 함

class Outer1{ 	//컴파일 하게되면 Outer1.class
	
	static int a = 10;
	int b = 20;
	
	//Inner클래스를 사용하기 위해서는 Outer1클래스를 반드시 객체 생성 해줘야 함
	//그런데 Outer1의 객체가 생성 됐다고 Inner가 생성된 건 아니다.
	
	public class Inner1{	//컴파일 하게되면 Outer$Inner.class 
		
		int c = 30;
		
		public void write(){
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
	}

	public void print(){
		Inner1 ob = new Inner1(); //첫번째 방법	
		ob.write();
	}

}


public class Test1 {

	public static void main(String[] args) {
		Outer1 out = new Outer1();
		out.print(); //Outer1안에 있는 메소드를 통해서 inner클래스를 생성할 수 있음

		Outer1.Inner1 inner = out.new Inner1(); //두번째방법
		inner.write();
	
	}

}
