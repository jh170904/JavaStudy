package com.day10;

//Wrapper class
//자바형의 데이터는 2개 존재.
//boolean, byte, char, short, int, long, float, double

//레퍼런스(참조형) 데이터
//Boolean, Byte, Character, Short, Integer, Long, Float, Double
//양방향 통신이 되느냐 

//auto-Boxing : stack -> heap  stack 영역의 데이터가 heap 영역으로 넘어가는 것 
//auto-UnBoxing :heap -> stack  

public class Test4 {

	//n1 -> num1 , num2 -> n2 들어가는지 확인. 잘 들어간다!
	public static void main(String[] args) {
		
		int n1 = 10;
		int n2; //쓰레기값 
		
		Integer num1;	//null. Integer는 Wrapper class. class의 초기값은 null
		Integer num2 = new Integer(20);
		 
		num1 = n1; //auto-Boxing 
		n2 = num2; //auto-UnBoxing 
		
		System.out.println(n1+":"+ num1); //10:10
		System.out.println(n2+":"+ num2); //20:20
		
		/*
		int a = 10;
		double b; 
	
		b = a;			암시적형변환 잘들어감. 
		b = (double)a;  명시적형변환
		
		a = b; 			안들어감
		a = (int)b;		명시적형변환. 큰 데이터자료형을 넣기 위해선 반드시 명시적형변환 필수
		---------------------------------------------
		
		**double과 int는 상속관계는 아니지만 이해하기 편하게 쓴 것
		부모(b) - 자식(a)	double이 더 크다 라고 생각. 
		
		부모 = 자식 		O upcast 
		부모 = (부모)자식	O upcast 
		
		자식 = 부모			X
		자식 = (자식)부모  	O downcast
		
		upcast시점을 알아야 나중에 downcast할 때 이용이 가능
		
		*/
	
	}
	
}
