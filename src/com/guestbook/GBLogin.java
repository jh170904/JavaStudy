package com.guestbook;

import java.util.Scanner;

public class GBLogin {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		GB gb = new GB();
		
		int ch;
		
		while(true) {
	
			String id = gb.login();
				
			while(!id.equals("")){
					
				do{
					System.out.println("------------------------------------------------------------");
					System.out.println("1.방명록 작성  2.방명록 조회   3.방명록 삭제   4.로그아웃");
					System.out.println("------------------------------------------------------------");
					System.out.print("▶");
					ch = sc.nextInt();

				}while(ch<1 || ch>4);
					
				System.out.println();
				
				switch (ch) {
				case 1:
					gb.insertGB(id);	 //지훈
					break;

				case 2:
					gb.selectGB();		 //정희
					break;
					
				case 3:
					gb.deleteGB(id); 	 //지훈
					break;
					
				case 4:
					GBMain.main(args);
					break;
				}
			}
				
			if(id.equals(""))
				System.out.println("로그인에 실패하였습니다.");
				
			GBMain.main(args);
		}
	}
}
