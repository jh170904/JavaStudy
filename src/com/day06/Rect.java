package com.day06;

import java.util.Scanner;

public class Rect {

	int w,h; //instance변수. 클래스 안 어디서나 사용 가능한 전역변수
	
	//매개변수는 동시에 여러개 설정가능
	public void input() {
		Scanner sc = new Scanner(System.in); // Scanner객체생성. 매개변수가 반드시 필요함. api확인!!
		
		//입력
		System.out.print("가로?");//10
		w = sc.nextInt();		
		System.out.print("세로?");//10
		h = sc.nextInt();	
		//return; void라고 설정해놨기때문에 return 작성안해도됨
	}
	
	public int area(){//return값이 정수형
	
		int result;//지역변수. 다른 메소드에서 인식할 수 없음
		result = w*h;
		return result;
	
	}
	
	public int length(){//return값이 정수형
	
		return 2*(w+h); //지역변수를 만들어서 반환해도 되지만, 이렇게 return옆에 바로 결과값을 넣어도 문제는 없음
	
	}
	
	public void print(int a, int l){ //반환값없음, 매개변수 2개 필요, 메소드를 실행하고 끝남-프린트작업.
		
		System.out.println("가로: "+w);
		System.out.println("세로: "+h);
		System.out.println("넓이: "+ a);
		System.out.println("둘레: "+ l);
		
	}	
}//endclass
