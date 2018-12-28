package com.day14;

import java.util.Random;
import java.util.Scanner;

class MyThread12 extends Thread {
	
	@Override
	public void run() {
		
		for(int i=0;i<15;i++){
			System.out.print(".");
		
			try {
				sleep(200);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
}

public class Test12 {

public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		MyThread12 t12 = new MyThread12();
		
		String name[] = {"오예린", "이정희", "정지훈", "박진수", "남은주", "김영우", 
						 "강준영", "정보연", "전가영", "나현우", "박종민", "장윤지", 
						 "간현진", "박상혁", "박창진", "최설화", "황병열", "최보근" };
		
		String presenter[];//발표자 몇명일지 모름. 객체 생성만.
		int num, su, checkName;
	
		do{
			System.out.print("발표자 인원수를 입력해주세요[1~18]:");
			num = sc.nextInt();
		}while(num<1 || num>18);
		
		presenter = new String[num];//배열크기 지정
		
		su=0;
		while(su<num){
			
			checkName = rd.nextInt(18);
			presenter[su] = name[checkName];
			
			for(int i=0;i<su;i++){
				if(presenter[i].equals(presenter[su])){
					su--;
					break;
				}
			}
			su++;
			
		}
		
		System.out.print("고민중");
		t12.start();
		
		try {
			
			t12.join();//main절이 끝나지 않도록 기다려라.
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
		
		System.out.println();
		System.out.println("\n***축하합니다! 발표자 입니다***");
		System.out.println("*                             *");
	
		int k=1;
		for(String i:presenter){
			
			System.out.printf("*%6d번 발표자 : %s     *\n" ,k, i);
			k++;
			Thread.sleep(50);
		}
		
		System.out.println("*                             *");
		System.out.println("*******************************");
		sc.close();
		
	}

}
