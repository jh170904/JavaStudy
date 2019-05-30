package com.naver3;

import java.util.Scanner;
public class NaverMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Naver ob = new Naver();
		int ch;
		
		while(true){ 
			
			do {
				System.out.println("네이버 회원가입 기능");
				System.out.print("1.회원가입 \n2.회원정보수정 \n3.회원정보삭제 \n4.회원전체출력 \n5.아이디 검색\n6.종료\n");
				System.out.print("-----------------------------------------------\n선택:");
				ch = sc.nextInt();
			}while (ch < 1);
			
			switch (ch) {
			case 1:
				ob.input();break;
			case 2:
				ob.update();break;
			case 3:
				ob.delete();break;
			case 4:
				ob.print();break;
			case 5:
				ob.searchId();break;
			default:
				System.exit(0);
			}
			
		}
		
	}
	

}
