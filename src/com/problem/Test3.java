/*
 	3 네 개의 정수를 입력 받고, 제일 큰 숫자와 제일 작은 숫자를 구분해서 출력.(if문 이용)
	//예) 20, 30, 40, 50 입력시 -> 제일 큰 숫자 50, 제일 작은 숫자 20
*/
package com.problem;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {

		int i, j, k, l;
		Scanner sc = new Scanner(System.in);

		System.out.print("비교할 네 숫자를 입력하세요:"); // 60 20 30 40
		i = sc.nextInt(); // 형변환
		j = sc.nextInt();
		k = sc.nextInt();
		l = sc.nextInt();

		if (i >= j && i >= k && i >= l) {
			System.out.printf(" %d는 제일 큰 수 입니다.\n", i);
		} else if (j >= i && j >= k && j >= l) {
			System.out.printf(" %d는 제일 큰 수 입니다.\n", j);
		} else if (k >= i && k >= j && k >= l) {
			System.out.printf(" %d는 제일 큰 수 입니다.\n", k);
		} else if (l >= i && l >= j && l >= k) {
			System.out.printf(" %d는 제일 큰 수 입니다.\n", l);
		} else {
			System.out.printf("확인요망");
		}

		if (i <= j && i <= k && i <= l) {
			System.out.printf(" %d는 제일 작은 수 입니다.\n", i);
		} else if (j <= i && j <= k && j <= l) {
			System.out.printf(" %d는 제일 작은 수 입니다.\n", j);
		} else if (k <= i && k <= j && k <= l) {
			System.out.printf(" %d는 제일 작은 수 입니다.\n", k);
		} else if (l <= i && l <= j && l <= k) {
			System.out.printf(" %d는 제일 작은 수 입니다.\n", l);
		} else {
			System.out.printf("확인요망");
		}

		sc.close();
		
/*
		단일if문으로 변수 max,min를 만들어 작성
		int a,b,c,d,max=0,min=0;
		System.out.print("비교할 네 숫자를 입력하세요:");		

		a = sc.nextInt(); // 형변환
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		max=min=a;
		
		if(a>max)
		  max=a;
		if(b>max)
		  max=b;
		if(c>max)
		  max=c;
		if(d>max)
		  max=d;
		
		if(a<min)
		  min=a;
		if(b<min)
		  min=b;
		if(c<min)
		  min=c;
		if(d<min)
		  min=d;
		
		System.out.println("큰숫자:"+max+"작은숫자:"+min);		
		
*/		

	}

}
