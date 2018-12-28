package com.day04;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {

		// 배열. 두 방식 다 작성 가능
		// 일반적으로 1차원 배열,2차원 배열 많이 사용함. 3차원 배열도 가끔 씀
		// int num[]= new int[5];
		int[] num = new int[5];

		Scanner sc = new Scanner(System.in);

		System.out.println("정수 입력하세요");
		// 배열을 만들고 초기값을 설정안하면 디폴트값이 존재
		// String:null, int:0, boolean:False(0)

		// for문안에서 쓰인 변수는 지역변수. 다른 for문의 지역변수와는 서로 겹치지 않음
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}

		// 시작값과 끝값이 정해져 있으므로 배열 + 반복문 함께쓰는 게 간편
		for (int i = 0; i < num.length; i++) {
			System.out.println("num[" + i + "]: " + num[i]);
		}

		// 배열의 갯수
		System.out.println("배열의 갯수: " + num.length); // 배열의 length 메소드만 ()가 없다.
		System.out.println("배열의 마지막 방 번호: " + (num.length - 1));

		sc.close();

	}

}
