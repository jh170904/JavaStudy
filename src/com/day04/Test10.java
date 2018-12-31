package com.day04;

public class Test10 {

	public static void main(String[] args) {

		// 1-2+3-4+5-6+7-8+9-10 연산하기_방법1
		int num[] = new int[10];
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			num[i] = i + 1;
			if (num[i] % 2 == 0) {
				sum -= num[i];
			} else {
				sum += num[i];
			}
		}
		System.out.println("1-2+3-4+5-6+7-8+9-10 = " + sum);

		// 1-2+3-4+5-6+7-8+9-10 연산하기_방법2
		int tot = 0;
		for(int j=1;j<=10;j++){
			tot = (j%2==0)? tot-j : tot+j;
		}
		System.out.println("1-2+3-4+5-6+7-8+9-10 = " + tot);
	}

}
