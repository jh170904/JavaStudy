package com.day12;

//내부클래스(중첩)
//클래스안에 static 클래스를 생성

class Outer3{
	
	static int a = 10;
	int b = 20;
	
	public static class Inner3{ 
		int c = 30;
		public void write(){
			System.out.println(a);
			//System.out.println(b); //static이 아닌 instance변수는 사용할 수 없다.
			System.out.println(c);
		
			Outer3 out = new Outer3(); //static클래스는 메모리 할당 알아서 됨. 그래서 거꾸로 Outer 객체생성을 여기서 작성
			System.out.println(out.b);
		}		
	}
	
	public void print(){ //이 방법은 의미가 없음. 이미 static이므로 객체생성 되어있음
		Inner3 ob = new Inner3();
		ob.write();
	}
}

public class Test3 {

	public static void main(String[] args) {
		Outer3 out = new Outer3();
		out.print();
		
		Outer3.Inner3 inner = new Outer3.Inner3(); //이 방법은 의미가 없음. 이미 static이므로 객체생성 되어있음
		inner.write();

	}

}
