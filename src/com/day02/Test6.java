package com.day02;
import java.util.Scanner;

class Test6 {


	public static void main(String[] args) {
			//java에서 사용자가 입력한 값을 읽는 방법은 2가지 존재.
			//BufferedReader , Scanner

			Scanner sc = new Scanner(System.in); 
			//BufferedReader와 다른 특성있음! -> Test7 
			//단락문자를 구분하는 기능.
			//기술문제로 Scanner가 나온 경우는 드물다

			//선언
			String name;
			int kor;
			
			System.out.print("이름이 뭐니?"); //수지
			name = sc.next();

			System.out.print("국어?"); //60
			kor = sc.nextInt(); //형변환도 가능

			String pan; //else if 로 끝나는 경우 초기화를 시켜줘야 함. 
			
			//else~if문은 조건이 여러개 일때.
			//조건이 여러개일땐 위쪽에 써주는게 좋음
			if(kor==100 || kor>=90){
				pan = "수";
			}else if(kor>=80){
				pan = "우";
			}else if(kor>=70){
				pan = "미";
			}else if(kor>=60){
				pan = "양";
			}else{
				pan = "가";
			}
			
			System.out.println(name + ":" + kor + ":" + pan );
			
			sc.close();
	}
}
