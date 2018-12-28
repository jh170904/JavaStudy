package com.day09;

class Super{
	public Super(){}
	public Super(int x){		
		
	}
	public Super(int x, int y){		
		
	}	
}

class Sub extends Super{
	
	//Sub(){} 기본생성자 존재
	//그 안에 super() 숨겨져있음. super()의 역할은 부모-자식관의 관계를 유지시켜주는 것 
	public Sub(){
		this(10); //public Sub(int a){} 호출. 생성자에서 생성자 호출. 이럴땐 this사용
	}  
	public Sub(int a){
		//super(); 기본생성자 호출
		super(10,20); //오버로딩된 생성자를 호출.
	}
	
}



public class Test2 {

	public static void main(String[] args){
		Sub ob = new Sub(10);
	}
	
}
