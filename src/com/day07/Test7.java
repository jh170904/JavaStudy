package com.day07;

import java.util.Scanner;

import com.score1.Manage;

class Record {

	String name;
	String[] level = new String[3];
	int[] score = new int[3];
	int tot, ave;

}

class Score {

	int inwon;
	Record[] rec;
	Scanner sc = new Scanner(System.in);

	public void set() {

		do {
			System.out.print("인원수?");
			inwon = sc.nextInt();
		} while (inwon < 1 || inwon > 10);
		rec = new Record[inwon];

	}

	public void input() {

		String[] title = { "국어", "영어", "수학" };

		for (int i = 0; i < inwon; i++) {

			rec[i] = new Record();
			System.out.print("이름?");// 이름
			rec[i].name = sc.next();

			for (int j = 0; j < 3; j++) {

				System.out.print(title[j]);
				rec[i].score[j] = sc.nextInt();// 국영수
				rec[i].tot += rec[i].score[j];// 총점
			}

			rec[i].ave = rec[i].tot / 3;// 평균

		}

	}

	public void print() {

		for (int i = 0; i < inwon; i++) {
			System.out.printf("%d번째 이름 %6s", i, rec[i].name);
			for (int j = 0; j < 3; j++) {
				System.out.printf("%4d%s", rec[i].score[j],rec[i].level[j]);
			}
			System.out.printf("%4d", rec[i].tot);
			System.out.printf("%4d", rec[i].ave);
			System.out.println();
		}

	}

	public void pan() {

		for (int i = 0; i < inwon; i++) {
			
			for (int j = 0; j < 3; j++) {
				if (rec[i].score[j] == 100 || rec[i].score[j] >= 90) {
					rec[i].level[j] = "(수)";
				} else if (rec[i].score[j] >= 80) {
					rec[i].level[j] = "(우)";
				} else if (rec[i].score[j] >= 70) {
					rec[i].level[j] = "(미)";
				} else if (rec[i].score[j] >= 60) {
					rec[i].level[j] = "(양)";
				} else {
					rec[i].level[j] = "(가)";
				}

			}

		}

	}
}

public class Test7 {

	public static void main(String[] args) {
		/*
		 * [문제2] 인원수를 입력 받아 인원수만큼 과목별 점수를 입력하고 각 과목별 판정을 하시오 
		 * 인원수 : 2 
		 * 1번째 이름 :전지현 국어 ? : 100 영어 ? : 100 수학 ? : 100
		 * 
		 * 2번째 이름 :옥주현 국어 ? : 80 영어 ? : 80 수학 ? : 80
		 * 
		 * 전지현 100(수) 100(수) 100(수) 300 100
		 * 
		 * 옥주현 80(우) 80(우) 80(우) 240 80
		 */
		
		Score ob1 = new Score();		
		ob1.set();
		ob1.input();
		ob1.pan();
		ob1.print();

	}
	
	

}
