package com.MyHome;

import java.io.IOException;
import java.util.Scanner;

public class Find {
	
	int choice;
	String item ="";
	String term ="";
	String local ="";
	long price =0;
	
	boolean check;
	
	MyHomeException my = new MyHomeException();
	
	Scanner sc = new Scanner(System.in);
	
	public void item() throws IOException {
		
		check = true;
		
		do{
			try {
				
				System.out.println("주거형태를 입력하시오[번호로 입력해주세요]");
				System.out.print("1.아파트 2.빌라 3.상가 4.토지 : ");
				
				choice = sc.nextInt();
				my.choiceCheck(choice);		//입력한 값이 숫자인지 확인
				
				switch (choice) {
				case 1:
					item = "아파트"; break;
				case 2:
					item = "빌라"; break;
				case 3:
					item = "상가"; break;
				case 4:
					item = "토지"; break;
				default:
					my.homeCheck();			//1-4사이의 숫자가 아닐경우 
				}
				
				check = false;
				
			} catch (AuthenException e) {
				System.out.println(e.toString());
			}
			
		}while(check);

	}
	
	
	public void term() throws IOException{
		
		check = true;
		do{
			try {
				
				System.out.println("계약형태를 고르시오[번호로 입력해주세요]");
				System.out.print("1.전세 2.월세 3.매매 : ");
				
				choice = sc.nextInt();
				my.choiceCheck(choice);		//입력한 값이 숫자인지 확인
				
				switch (choice) {
				case 1:
					term = "전세"; break;
				case 2:
					term = "월세"; break;
				case 3:
					term = "매매"; break;
				default:
					my.homeCheck();			//1-3사이의 숫자가 아닐경우 
				}
				
				check = false;
				
			} catch (AuthenException e) {
				System.out.println(e.toString());
			}
			
		}while(check);
		
	}
	
	public void local() throws IOException{
		
		System.out.print("지역:");
		local = sc.next();
		
	}
	
	public void price() throws IOException{
		
		System.out.print("가격:");
		price = sc.nextInt();	
		
	}
}
