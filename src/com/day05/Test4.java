package com.day05;

import java.util.Random;

public class Test4 {

	public static void main(String[] args) {

		// 1~45까지의 수중 6개의 난수를 발생시켜 크기순으로 출력

		Random rd = new Random();
		//난수생성 : Random class 사용자가 정해준 숫자범위 중에서 임의의 숫자를 하나 만들어낸다.

		int[] num = new int[6];
		int i, j, su, temp;
		su = 0;

		// while문은 몇번을 반복해야할지 모를 때 사용.
		// 난수를 추출할때 동일한 난수가 나오게되면 다시 진행해야 함.
		while (su < 6) {
			num[su] = rd.nextInt(45) + 1; // 1~45를 꺼내라. 0부터 시작하므로 '+1'을 해줘야함
			for (int n = 0; n < su; n++) { //이전 데이터와 전부 비교해야하므로 for문 사용
				if (num[su] == num[n]) { // su:추출한 난수 데이터 갯수(배열의 인덱스), n번째 데이터와 동일하냐
					su--; // 동일하다면 su를 줄이고 break문으로 나가라. 중복데이터 발생하면 여러번 돌릴 필요없이 다시 난수 뽑아내야 함
					break;
				}
			}
			su++;		
		}

		// 정렬
		for (i = 0; i < num.length - 1; i++) {
			for (j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}

		// 출력
		for (int n : num) {
			System.out.printf("%4d", n);
		}
		System.out.println();
	}
}
