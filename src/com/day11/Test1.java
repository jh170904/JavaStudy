package com.day11;

//추상클래스
//메모리의 낭비 없이 클래스를 미리 설계
//메소드를 재정의(override)해서 사용한다.
//메소드명을 가져다 사용하면 됨. 강제성을 띄지만 메소드명 만드는데 노력x
//메소드명이 동일하여 통일성.

abstract class ShapeClass{ //추상클래스도 부모클래스의 역할을 함

	abstract void draw(); //틀을 만들어 놨으니 가져다가 재정의하여 사용해라. interface와 똑같음
						  //무조건 return값은 void고 메소드명은 draw
}

class Circle extends ShapeClass{

	@Override
	public void draw() {
		System.out.println("원을 그린다..");
	}
	
}

class Rect extends ShapeClass{ //추상클래스의 메소드중 unimplement method 존재시 오류 

	@Override
	public void draw() {
		System.out.println("사각형을 그린다..");
	}
}

class Tri extends ShapeClass{
	
	@Override
	public void draw() {
		System.out.println("삼각형을 그린다..");
	}
	
}

public class Test1 {

	public static void main(String[] args){
	
		Circle ob1 = new Circle();
		Rect ob2 = new Rect();
		Tri ob3 = new Tri();
		
		ob1.draw();
		ob2.draw();
		ob3.draw();
		
	}
}
