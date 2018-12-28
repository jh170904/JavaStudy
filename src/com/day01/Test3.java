package com.day01;
class Test3  {
	
	public static void main(String[] args) {
		//main 메소드는 프로그램의 시작을 의미

		////원의 면적과 둘레를 구하기 위해 변수 선언. 초기값 설정 안해서 쓰레기값 들어있음
		int r = 10;
		float area;
		float length; 
		//float area, length; 한줄로 선언 가능
		// 실수형 : float(100자리까지 가능), double(그 이상도 저장 가능) - 저장가능범위가 더블이 두배!

		area = r * r * 3.14f; // float으로 인식하라고 f붙여줌!
		length = 2 * r * (float)3.14; // float으로 인식하라고 (float)붙여줌!
		
		//System.out.println(area);
		System.out.printf("반지름: %d, 넓이: %f\n",r, area); // %d 정수 %f 플롯 %g 더블
		//실수가 표시할 수 있는 이진수는 6개. 부호표시로 하나 소진해서 다섯개 표시
		//System.out.println(length);
		System.out.printf("반지름: %d, 둘레: %.2f\n",r, length);		//float의 소수점길이 조정하는거는 printf에서만 가능함 println에서는 안됨
		System.out.println("반지름: " + r + ", 넓이: " + area + ", 둘레: " + length );

/*	
		String은 클래스. 문자열. ""로 묶어줘야함 
		char은 자료형. 문자. ''로 묶어줘야함 

		기본자료형은 총 8개 존재. boolean char byte short int long float double
		참조자료형 -> 클래스.  배열, 클래스, 인터페이스 등이 있습니다.
		값이 아닌 그에 대한 참조 즉 주소를 가지고 있습니다
*/
		

	}

}


