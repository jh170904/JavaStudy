package com.day04;

public class Test9 {

	public static void main(String[] args) {

		// 1에서 100까지 수의 홀수의 합, 짝수의 합, 전체의 합
		int num[] = new int[100];
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < 100; i++) {
			num[i] = i + 1;
			// System.out.println(num[i]);

			if (num[i] % 2 == 0) {
				sum1 += num[i]; //짝수합
			} else {
				sum2 += num[i];	//홀수합
			}
			sum = sum1 + sum2; //전체합
		}

		System.out.println("1~100의 전체의 합:" + sum);
		System.out.println("1~100의 짝수의 합:" + sum1);
		System.out.println("1~100의 홀수의 합:" + sum2);

	}

}
