package com.day09;

class SuperA{
	
	private String title;
	protected double area;
	
	public SuperA(){} //기본생성자
	public SuperA(String title){ //오버로딩된 생성자
		this.title = title;
	} 
	
	//메소드
	public void write(){
		System.out.println(title + " : " + area);
	}
	
}


//Circle클래스와 Recta클래스는 아무 상관 없음. 
class Circle extends SuperA{
	private int r;
	protected static final double PI = 3.14; //static이므로 폰트 기울여짐. 메모리상에 알아서 올라감
	
	public Circle(int r){
		super("원"); //SuperA클래스의 기본생성자를 찾아가는데 그곳에 기본생성자가 없다면. 에러
		this.r=r;
	}
	
	public void circleArea(){
		area=r*r*PI; //PI가 double이므로 형변환됨
	}

}

class Recta extends SuperA{
	
	private int w,h;
	public void rectArea(int w, int h){
		this.w= w; //이게없으면 초기값 0으로 처리
		this.h= h;
		area = w*h;
		//super.write();
	}
	
	//마우스우클릭 - Source > Override > 부모클래스중에 어느 메소드를 재정의할지 어노테이션 기능 사용 가능
	//Annotation : 메소드명이나 매개변수 갯수,자료형들이 달라지면 알려줌
	//부모클래스가 무엇인지도 쉽게 볼 수 있음
	@Override
	public void write() {
		//super.write(); //자식클래스의 메소드안에서 부모의 메소드를 간접적으로 사용 가능. main문에서는 작성안됨.  
		System.out.println("가로:"+w);
		System.out.println("세로:"+h);
		System.out.println("면적:"+area);
	}
	
	//override(오버라이드, 재정의, 다형성) : 저장공간이 다르기 때문에 메소드이름이 동일해도 가능함. 
	//상속관계에서 부모의 메소드와 똑같이 만들고...(메소드명, 매개변수 등) 내용만 다르게 만듦
	//하는 역할은 유사. 자식의 마음대로 내용을 변형. 프로그래머의 의도가 반영
	//@Override 어노테이션(Annotation)
	
}

public class Test3 {

	public static void main(String[] args) { 
		
		Circle ob1 = new Circle(10);
		ob1.circleArea();
		ob1.write();
		
		System.out.println("------------------------------------");
		
		Recta ob2 = new Recta();//기본생성자로 생성
		ob2.rectArea(10, 20); //매개변수값 필요
		ob2.write(); //5. 부모도 가지고 있고 나도 가지고 있으면 내꺼 쓴다. 무조건!!
		//어떠한 방법으로도 부모 메소드를 사용할 수 없음. 보안이 철저하기 때문. 클래스 정의시 메소드 안에서는 가능(53줄).
		//메소드는 하늘이 두쪽나도 자신 것을 사용함. 그만큼 보안이 철저.
	}

}
