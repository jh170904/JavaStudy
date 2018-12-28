package com.day08;

class Rect{
	
	private int w;
	private int h;
	
	//private 변수 초기화 방법은 두가지. 초기화메소드 이용, 생성자 이용 
	
	public Rect(){//기본생성자	
	}
	
	public Rect(int w, int h){//오버로딩된 생성자
		this.w = w;
		this.h = h;
	}
	
	public void set(int w, int h){//초기화 메소드
		this.w = w;
		this.h = h;
	}
	
	public int area(){	
		return w*h;
	}
	
	public int length(){
		return 2*(w+h);
	}
	
	public void print(int a, int l){
		System.out.println("가로: "+ w);
		System.out.println("세로: "+ h);
		System.out.println("넓이: "+ a);
		System.out.println("둘레: "+ l);
	}
	
	public void print(int a){ //메소드 오버로딩(중복정의)
		System.out.println("가로: "+ w);
		System.out.println("세로: "+ h);
		System.out.println("넓이: "+ a);
	}
}

public class Test2 {
	
	public static void main(String[] args) {
		
		Rect ob1 = new Rect(); //기본생성자 + 초기화메소드 사용
		ob1.set(10, 20);		
		
		int area = ob1.area();
		int length = ob1.length();		
		ob1.print(area);
		ob1.print(area, length);
		
		System.out.println("-------------------");
		
		Rect ob2 = new Rect(100,200); //오버로딩된 생성자를 통해 객체 생성시 초기화 바로 진행. spring에서 '의존성 주입'이라고 함
		
		area = ob2.area();
		length = ob2.length();	
		ob2.print(area);
		ob2.print(area, length);
		
	}

}
