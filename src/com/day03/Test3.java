package com.day03;

public class Test3 {

	public static void main(String[] args) {

		// 다중for문. for문이 4중으로 중첩되는 정도까지는 가지 않음. 오버헤드가 크기 때문.

		// 선언
		int i, j;

		for (i = 2; i <= 9; i++) {

			System.out.println(i + "단");

			for (j = 2; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + (i * j));
			}

			System.out.println();
		}

	}

}
