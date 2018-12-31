package com.day04;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		// switch
		Scanner sc = new Scanner(System.in);
		int su;

		System.out.print("1~3이내의 수?");
		su = sc.nextInt();

		// switch(변수)에는 자료형 모두 사용 가능. String도 가능해짐. 따옴표 잊으면 오류
		switch (su) {
		case 3:
			System.out.print("***");break;
		case 2:
			System.out.print("**");break;
		case 1:
			System.out.print("*");break;
		default:
			System.out.print("숫자입력오류!!");
		}

		sc.close();

	}
}
