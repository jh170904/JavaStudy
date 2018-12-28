package com.score1;

import java.util.Scanner;

public class Manage {
	
	
	int inwon; //외부에서 수정하지 못하도록 이런 변수들은 private로 해둠 
	String[] title = {"이름","주소","핸드폰번호","키","몸무게","등록액"};
	
	Var[] rec;
	Scanner sc = new Scanner(System.in);
	
	public void set(){
		do{
			System.out.print("인원수?");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);		
		rec = new Var[inwon];
		
	}
	
	public void input(){

		for (int i = 0; i < inwon; i++) {

			rec[i] = new Var();

			for (int j = 0; j < 3; j++) {
				System.out.print(title[j]);
				rec[i].infor[j] = sc.next();
			}		
			
			for (int j = 0; j < 3; j++) {
				System.out.print(title[j+3]);
				rec[i].personal[j] = sc.nextInt();
			}	
			System.out.print("------------------\n");
		}
		
	}
	
	private void bmi(){
		
		for(int i=0;i<inwon;i++){			
			rec[i].bmi = (float)rec[i].personal[1]/(rec[i].personal[0]*rec[i].personal[0]) ;
		
		}			
	}
	
	public void print() {

		bmi();
		//System.out.println("이름 주소 핸드폰번호 키 몸무게 등록액 BMI ");

		for (int i = 0; i < inwon; i++) {
			
			for (int j = 0; j < 3; j++) {
				System.out.printf("%s  ", rec[i].infor[j]);
			}
			for (int j = 0; j < 3; j++) {
				System.out.printf("%s  ", rec[i].personal[j]);
			}
			System.out.printf("%f  ", rec[i].bmi);
			
			System.out.println();
		}
	
	}
	
}
	


