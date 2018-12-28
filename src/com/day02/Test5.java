package com.day02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Test5 {
	
	public static void main(String[] args) throws IOException {
			
		//제어문 : if, switch, for, while, do~while
		//반복문 : for, while, do~while 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num;
		String str = ""; //null

		System.out.print("수입력?");
		num = Integer.parseInt(br.readLine());

		//if(조건절)

		//단일 IF문
/*
		if문 작성시 중괄호 안이 한줄이면 중괄호 생략 가능
		else가 없는 단일 If문은 초기화를 하지 않으면 오류 발생.

		if(num%2==0){
			str = "짝수";
		}

		if(num%2!=0){
			str = "홀수";
		}
*/

		//if~else문
		if(num%2==0) {
			str = "짝수";
		}else{
			str = "홀수";
		}

		System.out.println(num + ":" + str);
	}
}
