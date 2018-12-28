/*
 5.단가 15,800원짜리 상품을 일정 수량 이상 구입시 할인을 해줍니다.
 할인율은 다음과 같습니다.
 10개 이상 -> 10%
 20개 이상 -> 15%
 30개 이상 -> 20%
 판매금액을 계산해봅니다.
 예) 구입수량 15개인 경우 -> 구입수량: 15개, 판매총금액: 213300원
 */
package com.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	public static void main(String[] args) throws IOException {

		int price = 15800;
		int i;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("단가는 15800원입니다. 수량을 입력하세요. : ");
		i = Integer.parseInt(br.readLine());

		if (i >= 30) {
			System.out.printf("구입수량: %d개, 판매총금액: %d원, 할인금액: %d원.\n", i,
					(int) (0.8 * price * i), (int) (0.2 * price * i));
		} else if (i >= 20) {
			System.out.printf("구입수량: %d개, 판매총금액: %d원, 할인금액: %d원.\n", i,
					(int) (0.85 * price * i), (int) (0.15 * price * i));
		} else if (i >= 10) {
			System.out.printf("구입수량: %d개, 판매총금액: %d원, 할인금액: %d원.\n", i,
					(int) (0.9 * price * i), (int) (0.1 * price * i));
		} else {
			System.out.printf("구입수량: %d개, 판매총금액: %d원, 할인금액 없습니다.\n", i,
					(price * i));
		}

/*
		double sum = 0;
		int qty = 15800;
				 
 		if (i >= 30) {
			sum = i*qty*0.8;
		} else if (i >= 20) {
			sum = i*qty*0.85;
		} else if (i >= 10) {
			sum = i*qty*0.9;
		} else { 
			sum = i*qty;
		}
 		System.out.printf("구입수량: %d개, 판매총금액: %g원, 할인금액 %g입니다.\n", i, sum,((i*qty)-sum));
*/ 		

		
		
		
	}

}
