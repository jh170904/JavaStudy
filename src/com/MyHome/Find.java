package com.MyHome;

import java.io.IOException;
import java.util.Scanner;

public class Find {
	
	int choice;
	String item ="";
	String term ="";
	String local ="";
	long price =0;
	String pr = "";
	boolean check;
	
	MyHomeException my = new MyHomeException();
	
	Scanner sc = new Scanner(System.in);
	
	public void item() throws IOException {
		
		check = true;
		
		do{
			try {
				
				System.out.println("▶주거형태를 입력하시오[번호로 입력해주세요]");
				System.out.print("1.아파트 2.빌라 3.상가 4.토지 : ");
				
				choice = sc.nextInt();
				my.choiceCheck(choice);		//입력한 값이 숫자인지 확인
				
				switch (choice) {
				case 1:
					item = "아파트"; break;
				case 2:
					item = "빌  라"; break;
				case 3:
					item = "상  가"; break;
				case 4:
					item = "토  지"; break;
				default:
					my.homeCheck();			//1-4사이의 숫자가 아닐경우 
				}
				
				check = false;
				
			} catch (AuthenException e) {
				System.out.println(e.toString());
			}
			
		}while(check);

	}
	
	
	public void term() {
		
		check = true;
		do{
			try {
				
				System.out.println("▶계약형태를 고르시오[번호로 입력해주세요]");
				System.out.print("1.전세 2.월세 3.매매 : ");
				
				choice = sc.nextInt();
				my.choiceCheck(choice);		//입력한 값이 숫자인지 확인
				
				switch (choice) {
				case 1:
					term = "전  세"; break;
				case 2:
					term = "월  세"; break;
				case 3:
					term = "매  매"; break;
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
		
		check = true;
		do{
			try{
				System.out.print("▶지역[XX구]:");
				local = sc.next();
				
				my.localCheck(local);
				check = false;
				
			}catch (AuthenException e) {
				System.out.println(e.toString());
			}
		}while(check);
		
	}
	
	public void price() throws IOException{
		
		check = true;
		do{
			try {
				System.out.print("▶가격:");
				pr = sc.next();
				
				my.check(pr);
				price = Integer.parseInt(pr);
				check = false;
				
			} catch (AuthenException e) {
				System.out.println(e.toString());
			}
			
		}while(check);
		
		
	}
}
