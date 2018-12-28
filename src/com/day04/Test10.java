package com.day04;

public class Test10 {

	public static void main(String[] args) {

		// 1-2+3-4+5-6+7-8+9-10 연산하기
		int num[] = new int[10];
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			num[i] = i + 1;
			// System.out.println(num[i]);

			if (num[i] % 2 == 0) {
				sum -= num[i];
			} else {
				sum += num[i];
			}
		
		}

		System.out.println("1-2+3-4+5-6+7-8+9-10 = " + sum);

	}

}
