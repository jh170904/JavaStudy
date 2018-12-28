package com.day02;
class Test3 {
	public static void main(String[] args) {
		
		float f = 0; //실수형 실제 저장값은 0.0
		double d = 0; //실수형 실제 저장값은 0.0
		
		//반복문 for (초기값, 조건문, 증감) 
		//i++ -> i=i+1
		for (int i=1;i<=100000;i++){

			f = f + 100000;
			d = d + 100000;	

		}
		
		System.out.println("float: "+ (f/100000));
		System.out.println("double: "+ (d/100000));
		//실수를 연산할때 float은 데이터의 손실이 생길 수 있음.-> double로 연산하는게 좋다
	}
}
