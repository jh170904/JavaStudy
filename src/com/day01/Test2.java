package com.day01;
class Test2 {

	public static void main(String[] args) {
	//args = argument
	//static 내가 따로 손을 대지않아도 자동으로 메모리상에 올라가기 때문에 실행가능 - 모든 프로그램은 메모리에 올라가야 실행이 가능.
	//이걸 사용하지 않는다면 별도의 작업을 해줘야 함 
	//정수형 변수 integer. 반드시 소문자로 시작(정석). 두번째단어의 첫글자는 대문자 numOne. 상수일때만 NUM 전부 대문자로 사용

/*
		변수선언. 빈그릇만 생긴것. 초기값을 설정하지 않으면 쓰레기값만 들어있다.
		int num1; 
		int num2;
		int의 저장가능범위 : 약 -21억~21억 이 범위 초과시 long으로 지정해야 함  
		범위를 초과하면 런타임 에러 발생. 코딩상의 문제가 아니라 로직상의 에러
				
		변수 초기화.(초기값 설정)
		num1 = 20; 
		num2 = 3; 
*/

		//자료형 : int
		int num1 = 20;
		int num2 = 3;
		int num3;
		int num4;//초기값설정 안했으므로 쓰레기값이 들어있다
		
		//System.out.println(num3); //작성 시 쓰레기값만 들어있어서 오류
		num3 = num1 + num2 ; 
		num4 = num1 - num2 ; 
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);		
		System.out.println(num1 + "+" + num2 +"= " + num3 );
		System.out.println(num1 + "-" + num2 +"= " + num4 );
		System.out.print("랄라\n\n"); //print는 매개변수가 반드시 필요. println은 없어도 컴파일 가능
		
		//format
		System.out.printf("%d+%d=%d\n",num1,num2,num3);
		System.out.printf("%d-%d=%d\n",num1,num2,num4);

	}
}



