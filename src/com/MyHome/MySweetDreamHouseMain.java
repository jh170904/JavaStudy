package com.MyHome;

import java.util.Scanner;

import com.naver2.NaverImpl;

public class MySweetDreamHouseMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		NaverImpl ob = new NaverImpl();
		int ch;
		
		while(true){ //종료하기 전까지 계속 실행
			
			do {
				System.out.println("부동산 그것이 알고싶다 헤헤");
				System.out.print("1.회원가입\t2.로그인\t3.종료\n");
				System.out.print("-----------------------------------------------\n선택:");
				ch = sc.nextInt();
			}while (ch < 1);
			
			switch (ch) {
			case 1:
				ob.input();break;
			case 2:
				ob.print();break;
			case 3:
				ob.searchId();break;
			case 4:
				ob.writeFile();
			default:
				System.exit(0);
			}

			
			
		}
		
	}
	
}
