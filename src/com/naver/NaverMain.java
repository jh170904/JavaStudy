package com.naver;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Naver ob = new NaverImpl();
		int ch;
		
		while(true){ //종료하기 전까지 계속 실행
			
			do {
				System.out.println("네이버 회원가입 기능");
				System.out.print("1.회원가입 \n2.회원전체출력 \n3.아이디 검색 \n4.종료\n");
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
				break;
			default:
				System.exit(0);
			}
			
		}
		
	}
	
}
