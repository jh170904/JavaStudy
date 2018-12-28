package com.day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Test5 {
	//클래스는 기본적으로 접근지정자가 public - 누구나 접근 가능

	public static void main(String[] args) throws IOException {
		

		//선언부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String name;
		int kor, eng, mat, tot;
		

		//입력부
		System.out.print("이름?"); //사용자가 입력. 수지
		name = br.readLine();  // 두번째단어는 대문자!! readLine
		// String으로 입력을 받고 반환값도 String 이어서 문제없음. 
		
		System.out.print("국어?"); //50
		kor = Integer.parseInt(br.readLine());

		System.out.print("영어?"); //50
		eng = Integer.parseInt(br.readLine());

		System.out.print("수학?"); //50
		mat = Integer.parseInt(br.readLine());
		
		//연산부
		tot = kor + eng + mat;
		
		//출력부
		System.out.printf("이름:%s, 국어:%d, 영어: %d, 수학: %d, 총점은 %d입니다.\n",name, kor, eng, mat, tot); // string - '%s' 쓰려면 printf로 써야함! 
	
	
	// 항상 구조가 선언- 구조 입력 - 연산 - 출력 순대로 진행됨
	}
}
