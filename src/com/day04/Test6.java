package com.day04;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {

		// 년,월,일을 입력받아 요일을 출력하세요
		// 2018년 12월 3일 월요일

		Scanner sc = new Scanner(System.in);

		int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int y, m, nalsu, i, week, day;
		String w[] = {"일", "월", "화", "수", "목", "금", "토"};

		do {
			System.out.print("년도?"); // 2018
			y = sc.nextInt();
		} while (y < 1);

		do {
			System.out.print("월?"); // 12
			m = sc.nextInt();
		} while (m < 1 || m > 12);

		do {
			System.out.print("일?"); // 31
			day = sc.nextInt();
		} while (day < 1 || day > months[m-1]);

		if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
			months[1] = 29;
		}

		nalsu = (y - 1) * 365 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;
		for (i = 0; i < m - 1; i++) {
			nalsu += months[i]; 
		}

		nalsu += day;
		week = nalsu % 7;
		System.out.printf("%d년 %d월 %d일은 %s요일입니다.", y, m, day, w[week]);
		sc.close();
	}

}
