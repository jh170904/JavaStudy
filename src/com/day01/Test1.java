package com.day01;
class Test1{
	//class이름: 반드시 대문자로 시작해야함. 두번째 단어의 첫글자도 대문자 TestOne

	//메소드(method) 명령어라고 생각해두세요. 이 안에 부분
	public static void main(String[] args) { 
	//public : 접근지정자(모두 접근 가능)
	//static : 자신이 알아서 메모리에 올라감
	//void : return-반환값이 없다. 줄거없음. 실행하면 끝. 자료형 8개 중 하나만.
	//public static void  빼먹으면 에러남

	//main : 메소드명 - method명은 반드시 소문자로 시작해야함. 두번째 단어의 첫글자는 무조건 대문자. testOne
	//String[] args : 매개변수. 밖에서 할당하는 변수값. string은 문자열
	// \n 엔터
	// System.out.println(); 엔터

		System.out.println("자바 첫시간!");
		System.out.println("오늘은 수요일!!");
		System.out.println();
		System.out.println("나보이냐?\n");

	}
}
