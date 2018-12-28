package com.day10;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarA {

	public static void main(String[] args) {

		// Calendar 클래스를 사용해서 만년 달력 만들기
		Calendar now = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);

		int i, y, m, w, lastday;
		do {
			System.out.print("년도?");
			y = sc.nextInt();
		} while (y < 1);

		do {
			System.out.print("월?");
			m = sc.nextInt();
		} while (m < 1 || m > 12);

		now.set(y, m - 1, 1);

		w = now.get(Calendar.DAY_OF_WEEK);
		lastday = now.getActualMaximum(Calendar.DATE);

		// 출력
		System.out.println(y + "년 " + m + "월");
		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.println("------------------------------");

		for (i = 1; i < w; i++) {
			System.out.print("    ");
		}

		for (i = 1; i <= lastday; i++) {
			System.out.printf("%4d", i);
			w++;
			if (w % 7 == 1) {
				System.out.println();
			}
		}

		if (w % 7 != 1) {
			System.out.println();
		}

		System.out.println("------------------------------");
	}
}
