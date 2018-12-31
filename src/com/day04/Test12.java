package com.day04;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {
		// 두수를 입력받아 적은 수에서 큰수까지의 합 1 10
		
		//선언
		int i, j, k, tot;
		int max, min;
		
		//변수 초기화
		max = min = tot = 0;

		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("두 수를 입력하세요.");
		i = sc.nextInt();//30
		j = sc.nextInt();//20		
		
		//연산
		if (i > j) {
			max = i;
			min = j;
		}

		if (j > i) {
			max = j;
			min = i;
		}

		for (k = min; k <= max; k++) {
			tot += k;
		}
		//출력
		System.out.printf("%d에서 %d까지의 합 : %d", min, max, tot);

		sc.close();

	}

}
