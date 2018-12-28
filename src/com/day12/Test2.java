package com.day12;

//내부클래스(Local)
//메소드안에 클래스를 생성

class Outer2{
	
	static int a = 10;
	int b = 20;
	
	public void write(){
		int c = 30;
		final int d = 40;
		
		class Local{//메소드안에 클래스를 생성
			public void  print(){
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);
			}		
		}
		
		//메소드안에 있는 내부클래스는 메소드 안에서만 객체 생성 가능
		Local ob = new Local();
		ob.print();
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		Outer2 out = new Outer2();
		out.write();
	}

}
