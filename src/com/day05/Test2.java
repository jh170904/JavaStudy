package com.day05;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		//int[] num = { 28, 65, 7, 4, 10 };
		int i, j, temp;
		int num[] = new int[5];
		
		Scanner sc = new Scanner(System.in);
		System.out.print("다섯개의 숫자를 입력하세요:");
		
		for(i=0;i<num.length;i++){
			num[i]= sc.nextInt();
		}
		
		System.out.print("Source data: ");
		for (i = 0; i < num.length; i++) {
			System.out.printf("%4d", num[i]); // 공백 네칸의 자리를 두고 숫자 출력
		}
		System.out.println();

		// Selection Sort. 선택정렬. 자주사용. 암기.
		for (i = 0; i < num.length - 1; i++) {

			for (j = i + 1; j < num.length; j++) { // 기준값과 비교하는 수는 항상 +1번째부터
												   // 시작부터 ~ 마지막 배열의자리까지
				//System.out.println(i+":"+j); //인덱스마다 회전수 조회
				if (num[i] > num[j]) { //부등호에 따라 내림차순(<), 오름차순(>) 정렬 가능. 크기에 따라 자리바꿈 진행
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}

		}

		// 출력
		System.out.print("Sorted data: ");
		for (int su : num) {// 확장 for문. 시작값과 끝값 선언 안해줘도됨. 배열, collection에서만 가능
			System.out.printf("%4d", su);
		}
		System.out.println();
		
		sc.close();
	}

}
