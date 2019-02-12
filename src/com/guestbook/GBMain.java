package com.guestbook;

import java.util.Scanner;

public class GBMain {

	public static void main(String[] args) {
		// 회원가입 -> 방명록 작성, 방명록 조회, 방명록 삭제, 로그아웃
		// 로그인
		// 종료
		Scanner sc = new Scanner(System.in);
		int ch, ch2;
		GB gb = new GB();
		
		try {
			while (true) {

				do {
					System.out.println("------------------------------------------------------------");
					System.out.println("                         GUEST BOOK  ");
					System.out.println("1.회원가입    2.로그인     3.회원탈퇴     4.종료  ");
					System.out.println("------------------------------------------------------------");
					System.out.print("▶");
					ch = sc.nextInt();

				} while (ch < 1 || ch > 4);

				switch (ch) {

				case 1:
					gb.insert(); 			//1. 회원가입 (예린)
					break;
				case 2:
					GBLogin.main(args);		//2. 로그인   (예린)
					break;	
				case 3:
					gb.deleteMember();		//3. 회원탈퇴 (정희)
					break;
				case 4:
					DBConn.close();			//4. 종료
					System.exit(0);
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
