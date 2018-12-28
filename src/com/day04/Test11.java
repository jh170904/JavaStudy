 package com.day04;

public class Test11 {

	public static void main(String[] args) {

		// 1에서 100까지의 수중 3의 배수의 갯수
		int cnt = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				cnt++;
			}
		}

		System.out.println("1에서 100의 숫자 중 3의 배수 갯수: " + cnt);
	}

}
