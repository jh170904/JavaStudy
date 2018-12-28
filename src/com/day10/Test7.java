package com.day10;

//final을 붙일 수 있는 3가지 경우
//멤버변수에 final을 붙이면 : 단 한번만 초기화가 가능
//메소드에 final을 붙이면 : Override(재정의) 불가.
//클래스에 final을 붙이면 : 상속 불가
//final class Test{} -> public class Test7 extends Test{}  불가능!

class Test{ 								//Test클래스에 final붙으면 상속 불가
	public static final double PI;			//멤버변수
	static{
		PI = 3.141592; 
	}
	public double area; 					//인스턴스 변수
	public final void write(String title){	//메소드에 final붙어서 오버라이딩 불가
		System.out.println(title+":"+area);
	}
}

public class Test7 extends Test{ 
/* 
    부모클래스에 final이 붙어있으면 오버라이딩이 불가능하다.
 	@Override
	public void write(String title) {
		super.write(title);
	}
*/	
	public void circleArea(int r){
		area= (double)r*r*PI;	
	}
	
	public static void main(String[] args) {
		Test7 ob = new Test7();			//객체생성
		//PI = 100; 초기화된 값에서 변경 불가
		ob.circleArea(10);				//자식클래스 메소드
		ob.write("원");					//부모클래스 메소드
	}

}
