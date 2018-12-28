package com.score2;

import java.util.Scanner;

public class ScoreImpl implements Score{
	
	int inwon;
	Scanner sc = new Scanner(System.in);
	Record rec[];
	
	@Override
	public void set() {
		do{
			System.out.print("인원수?");//3
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		rec = new Record[inwon];	
	}

	@Override
	public void input() {			
		for(int i=0;i<inwon;i++){		
			rec[i] = new Record();		
			System.out.print("이름?");
			rec[i].name =sc.next();		
			
			System.out.print("학번?");
			rec[i].hak =sc.next();	
			
			System.out.print("국어 영어 수학?");
			rec[i].kor = sc.nextInt();
			rec[i].eng = sc.nextInt();
			rec[i].mat = sc.nextInt();
			rec[i].tot = rec[i].kor + rec[i].eng + rec[i].mat;
			rec[i].ave = rec[i].tot/3;			
		}	
	}

	private String panjung(int score){

		String panjung = "";

		if(score>=90){
			panjung = "(수)";
		}else if(score>=80){
			panjung = "(우)";
		}else if(score>=70){
			panjung = "(미)";
		}else if(score>=60){
			panjung = "(양)";
		}else{
			panjung = "(가)";
		}	
		return panjung;
	}
	
	@Override
	public void print() {

		for(int i=0;i<rec.length;i++){
			System.out.printf(
					"이름: %s, 학번: %s, 국어: %d%s, 영어: %d%s, 수학: %d%s ,총점: %d, 평균: %d%s",
					rec[i].name, rec[i].hak, rec[i].kor, panjung(rec[i].kor), rec[i].eng, panjung(rec[i].eng), rec[i].mat, panjung(rec[i].mat),
					rec[i].tot, rec[i].ave, panjung(rec[i].ave));
			System.out.println();

		}
	}

}
