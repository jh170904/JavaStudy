package com.day05;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {

		//5개의 정수를 입력받아 입력받은 수를 출력하고 입력받은 수중 가장 큰수와 적은수를 출력

		int num[] = new int[5];
		int i, max, min;

		System.out.print("정수 다섯개를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		for (i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}

		max = min = num[0];

		for (i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
			if (num[i] < min) {
				min = num[i];
			}
		}

		System.out.println("최댓값: " + max + ", 최소값: " + min);
		sc.close();

	}// endmain

}// endclass
