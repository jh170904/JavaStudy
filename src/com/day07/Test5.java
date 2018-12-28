package com.day07;

class Rect{//전부 instance변수와 instance메소드
	
	private int w,h ; //전역변수, instance변수
	
	public void set(int w, int h){ // 전역변수와 매개변수의 이름이 똑같아서 혼란이 옴. 이럴때 this 사용
		//우회해서 초기화 시킬 수 있도록함. 초기화메소드
		this.w= w;
		this.h= h;	
	}
	public int area(){
		return w*h;
	}
	
	public int length(){
		return (w+h)*2;	
	}
	
	public void print(int a, double l){ 
		System.out.println("가로: "+w+", 세로: "+h);
		System.out.println("넓이: "+a+", 둘레: "+l);
	}
	
	// Overload(Overloading : 메소드 중복정의)
	// 조건: 같은 클래스안에서 메소드의 이름은 동일하지만 매개변수의 갯수나 자료형은 달라야 한다. -> 다른 메소드로 인식한다.
	// 메소드이름같고, 매개변수갯수같고, 자료형도 같다면 같은 메소드로 인식
	// 왜 존재? 같은 역할을 하는 메소드를 통일시키기 위해서 
	public void print(){	
		System.out.println("가로: "+w+", 세로: "+h);		
	}
	
	public void print(int a){ //매개변수1개
		System.out.println("가로: "+w+", 세로: "+h);			
		System.out.println("넓이: "+a);		
	}

	public void print(double l){//매개변수1개. 자료형 다름
		System.out.println("가로: "+w+", 세로: "+h);			
		System.out.println("둘레: "+l);		
	}
	
}

public class Test5 {

	public static void main(String[] args) {
		
		Rect ob1 = new Rect();
		
		ob1.set(10,20); //w,h에 초기화시킴
		int a = ob1.area();
		double l = ob1.length();
		
		ob1.print(a,l);
		ob1.print();
		ob1.print();
		
		//ob1.printt(l);얘는 메소드이름이 다르기 때문에 overloading 이 아니다.

		//String str;
		//str.valueof(); 같은 메소드명으로 9개 존재. 모두 자료형 다름 
	}

}
