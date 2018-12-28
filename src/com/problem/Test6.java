/*
6. 이름과 3과목의 점수를 입력 받아 다음조건에 따라 출력
-모든 과목의 점수가 40점 이상이고 평균이 60점 이상이면 합격
-한과목이라도 40점 미만이고 평균이 60점 이상이면 과락
-평균이 60점 미만이면 불합격

이름 ? 홍길동
세과목 점수 ? 60 70 80
이름 : 홍길동
총점 : 210, 평균 : 70, 판정 :합격
*/
package com.problem;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {

		String name;
		int i, j, k;
		float average;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("세 과목의 점수 : ");
		i = sc.nextInt();
		j = sc.nextInt();
		k = sc.nextInt();
		
		average = (float)(i+j+k)/3 ;
		
		if(average<60){
			System.out.printf("%s님은 평균 %.1f로 불합격입니다.",name, average);
		}else if(i<40 || j<40 || k<40 ){
			System.out.printf("%s님은 과락으로 불합격입니다.",name);
		}else{
			System.out.printf("%s님은 평균 %f로 합격입니다.",name, average);	
		}	
		sc.close();
		
	
	}

}
