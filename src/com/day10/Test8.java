package com.day10;

class Parent{
	
	protected int a = 10; //protected: 동일패키지안에서 사용가능
	protected int b = 20;
	
	public void write(){
		System.out.println("Parent Class write()...");
		System.out.println("a: "+ a + ", b: "+ b); //10,20
	}	
}

class Child extends Parent{
	protected int b = 30;
	protected int c = 40;
	
	@Override
	public void write() {
		//super.write();//부모의 write 메소드 호출
		System.out.println("Child Class write()...");
		System.out.println("a: "+ a + ", b: "+ b+", c: "+ c); //10,20
		System.out.println("super.b: " + super.b);
	}
	public void print1(){
		System.out.println("Child Class print1() : write()호출..");
		write(); //부모도 write메소드를 갖고있지만 나도 있으니까 내껄 호출
	}
	public void print2(){
		System.out.println("Child Class print2() : super.write()호출..");
		super.write();
	}	
}

public class Test8 {
	
	public static void main(String[] args) {

		Child ob = new Child();
		ob.write();		 //자신의 메소드 사용. a는 내거 없으니까 부모클래스에서 가져옴. a: 10,b: 30,c: 40
		System.out.println("--------------------------------------------");
		
		ob.print1();
		System.out.println("--------------------------------------------");
		
		ob.print2();     //부모의 메소드 사용. super 붙어있음
		System.out.println("--------------------------------------------");
		
		System.out.println("ob.b : " + ob.b);						//부모클래스, 자식클래스 모두 존재하면 자기거 사용. b=30
		System.out.println("((Parent)ob).b : " + ((Parent)ob).b);	//자식을 부모클래스로 형변환시킴. upcast. b=20
																	//자식을 부모로 casting : upcast 
		System.out.println("--------------------------------------------");
		
		ob.write();	//자식의 write메소드 호출
		System.out.println("--------------------------------------------");
		
		
		((Parent)ob).write();
		//메소드는 인스턴스 변수와는 다르게 자신의 메소드를 호출한다
		//메소드는 heap영역이 아니라 메소드 영역에 있기 때문에 접근 금지.(메소드 영역 보안 높음)
		//메소드는 upcast를 해도 무조건 자신의 것을 사용한다.
		//자식의 write메소드 호출
/*	
 	**결론**
	자식이 부모의 메소드를 override했다면 나에게 맞춰 메소드내용을 바꾸고 싶기 때문에 진행	
	나의 의도가 들어감 -> 책에서는 보안영역이 강하기 때문에 호출을 어떻게 하더라도 자신의 메소드 결과를 돌려줌
	오버라이드 메소드를 부모클래스의 메소드로 꼭 사용하고 싶다면 
	자식메소드에 super.메소드();로 호출해서 하는 방법있음. 단, main문에서는 불가.
*/
	}
}
