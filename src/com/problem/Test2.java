/* 
 	2.네개의 정수를 입력 받고, 큰 숫자와 작은 숫자를 구분해서 출력.(if문 이용)
	예) 20, 30 입력시 -> 큰 숫자 30, 작은 숫자 20

*/
package com.problem;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		int i, j;

		Scanner sc = new Scanner(System.in);

		System.out.print("비교할 두 숫자를 입력하세요:"); //60 20
		i = sc.nextInt(); //형변환
		j = sc.nextInt(); 

		if(i < j) {
			System.out.printf("큰 수는 %d, 작은 수는 %d입니다.", j, i); 
		} else if(i > j) {
			System.out.printf("큰 수는 %d, 작은 수는 %d입니다.", i, j); 
		} else {	
			System.out.printf(" %d와 %d는 같습니다.", i, j); 
		}

		sc.close();


	}

}
