package com.day08;

//상속(부모가 자식한테 주는 것)
//1. 부모꺼는 내거다
//2. private 로 선언한 것은 상속이 불가능
//3. protected 로 선언한 것은 상속이 가능. 같은 패키지안에서라면 사용 가능
//4. 내꺼는 내거다. 부모가 가져다가 쓸 순 없음. 이순신의 특징은 이순신만 사용 가능!
//5. 부모도 가지고 있고 나도 가지고 있으면 내꺼 쓴다.

class SuperClass{
	
	private String title;
	private int area;
	
	public void set(String title, int area){
		this.area=area;
		this.title = title;
	}
	
	public void print(){
		System.out.println(title + ":" + area);
	}
}

class SubClass extends SuperClass{ //다중상속이 안되기 때문에 하나만 쓸수있음(단일상속)
	
	private int w;
	private int h;
	
	public SubClass(int w, int h){ //생성자 초기화
		this.w = w;
		this.h = h;
	}
	
	public void rectArea(){
		int a = w*h;
		//area = w*h; 바로 area에 입력할 수 없음. private이기 때문 //2.private로 선언한 것은 상속이 불가능
		set("사각형", a); //1.부모꺼는 내거다
		
	}
	
	
}

public class Test7 {

	public static void main(String[] args) {
		
		SubClass ob = new SubClass(10,20);
		ob.rectArea();
		ob.print();//1.부모꺼는 내거다
	
	}

}
