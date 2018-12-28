package com.day10;

import java.util.Calendar;
import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		//년도?2016
		//월?4
		//일?20
		//며칠 후? 100
		//만난날: 2016년 4월 20일 ㅇ요일
		//100일후: 2016년 7월 29일 ㅇ요일
		Scanner sc = new Scanner(System.in);
		int y, m , d, k, w;
		char[] yoil = {'일','월','화','수','목','금','토'};
		
		Calendar now = Calendar.getInstance();
		do {
			System.out.print("년도?");
			y = sc.nextInt();
		} while (y < 1);
		do {
			System.out.print("월?");
			m = sc.nextInt();
		} while (m < 1 || m > 12);
		do {
			System.out.print("일?");
			d = sc.nextInt();
		} while (d < 1 || d > 31);

		System.out.print("며칠후?");
		k = sc.nextInt();
	
		now.set(y,m-1,d);
		w = now.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("만난날: "+y + "-" + m + "-"+ d + "-" + yoil[w-1]+"요일"); 

		now.add(Calendar.DATE,k);
		int yy = now.get(Calendar.YEAR);			
		int mm = now.get(Calendar.MONTH)+1;  	
		int dd = now.get(Calendar.DAY_OF_MONTH); 
		int ww = now.get(Calendar.DAY_OF_WEEK);		
		System.out.println(k +"일 후: "+yy + "-" + mm + "-"+ dd + "-" + yoil[ww-1]+"요일"); 
	}

}
