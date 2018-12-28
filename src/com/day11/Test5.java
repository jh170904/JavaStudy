package com.day11;

//Interface
//1.추상클래스의 일종(선언만 있고 내용이 없음)
//2.final 상수변수만 정의 가능
//3.인터페이스를 구현하기 위해서는 implements를 사용한다
//4.하나이상의 인터페이스를 implements한 클래스는 인터페이스의 모든 메소드를 재정의 해야한다.
//5.인터페이스가 다른 인터페이스를 상속 받을수있으며 이때는 extends를 사용한다.
//6.클래스와는 다르게 인터페이스는 다중 구현이 가능하다
//인터페이스를 사용하는 목적 : 강제성이 있음(인터페이스에 나온대로 무조건 만들어야함). 그로인해 통일성을 얻을 수 있다. 자바에서 인터페이스는 저장소. 

//session : 클라이언트가 서버에 접속하면 생기는 것. 연결의 개념도 있음. 그 사람을 위한 메모리공간
//세션에 얼마나 메모리를 할당해야 할지 모르기 때문에 자료형은 가장 큰 OBJECT 
//upcast가 언제 되었는지 알아야 다시 데이터를 받을 때 downcast 를 할 수 있음

// 세션 <---- a.jsp 
// a.jsp라는 웹페이지가 있을 때 여기있는 데이터를 세션으로 받고
// 세션 ----> b.jsp로 옮길 때 
// 그대로 object 자료형을 쓰면 용량 낭비가 큼. 그렇기 때문에 downcast 와 upcast 중요

interface Fruit{	//인터페이스와 추상클래스와 다른 점 : 일반메소드, 일반인스턴스변수 사용할 수 없음. 
	
	//final상수만 만들 수 있다. 초기화 꼭 해줘야 함
	//기본이 static변수. 
	String Won = "원"; //public static final이 생략
	int getPrice(); //public abstract 생략
	public String getName(); //abstract 생략	
	
}


class FruitImpl implements Fruit{ //FruitImpl : Fruit이라는 인터페이스를 구현한 클래스. 인터페이스 다중 상속이되면 Fruit, 인터페이스명+',' 옆으로 쓰면 됨
	
	@Override
	public int getPrice() {
		return 1000;
	}
	
	@Override
	public String getName() {
		return "사과";
	}
	
	public String getItems(){
		return "과일";		
	}
	
}

public class Test5 {

	public static void main(String[] args) {
		
		FruitImpl ob1 = new FruitImpl();
		System.out.println(ob1.getItems() + ":" + ob1.getName() + ":" + ob1.getPrice() + Fruit.Won );
		Fruit ob2 = ob1; //upcast. 형변환해서 Fruit클래스에 넣음
		System.out.println(ob2.getName());
		//System.out.println(ob2.getItem()); getItem() 사용안됨. 부모는 자식의 것을 가져다 쓸 수없음
		
	}

}
