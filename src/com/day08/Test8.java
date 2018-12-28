package com.day08;

//상속(부모가 자식한테 주는 것)
//1. 부모꺼는 내거다(자식도 그대로 쓸 수 있음)
//2. private 로 선언한 것은 상속이 불가능
//3. protected 로 선언한 것은 상속이 가능
//4. 내꺼는 내거다. 부모가 가져다가 쓸 순 없음
//5. 부모도 가지고 있고 나도 가지고 있으면 내꺼 쓴다.

class SuperClassA{
	
	private String title;
	protected int area; // 자식도 사용가능하도록 접근제어자 변경 
	
	public void set(String title){
		this.title = title;
	}
	
	public void print(){
		System.out.println(title + ":" + area);
	}
}

class SubClassA extends SuperClassA{ //다중상속이 안되기 때문에 하나만 쓸수있음(단일상속)
	
	private int w;
	private int h;
	
	public SubClassA(int w, int h){ //생성자 초기화
		this.w = w;
		this.h = h;
	}
	
	public void rectArea(){
		//int a = w*h;
		area = w*h; //3. protected 로 선언한 것은 상속이 가능
		set("사각형"); //1.부모꺼는 내거다	
	}
	
	
}

public class Test8 {

	public static void main(String[] args) {
		
		SubClassA ob = new SubClassA(100,200);
		ob.rectArea();
		
		ob.print();//1.부모꺼는 내거다
		ob.area = 10; //protected 일때는 접근 가능
		System.out.println("area : "+ ob.area);
	}

}
