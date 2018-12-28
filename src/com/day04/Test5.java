package com.day04;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
/*		
		//만년달력
		1년 1월 1일 : 월요일부터 시작
		주의에 있는 날짜를 7로 나누면 나머지가 일요일:0 ~ 토요일:6으로 떨어지게 된다.
		
		현재시점 : 2018.12.01
		(y-1)*365+ 윤년의 갯수(2월 29일 카운팅) : 2017.12.31까지의 일 수
		2017년*365일 + 윤년의 갯수(2월 29일 카운팅)+ 올해 전월까지의 날수(31일+28일+31일+30일...11.30까지의 달마다 일수) + 이번 달 일수(1일이라면 +1)
		 = 현재시점까지의 날 수
		
		날수/7을 하면 나오는 나머지 활용(ㅁ%7==0 이면 일요일, 0~6사이의 값)
		2018년 12월 1일은 나눴을 때 6이 나왔기 때문에 토요일이다. 		
*/	 
		
		Scanner sc = new Scanner(System.in);

		//1~12월마다 일수가 며칠인지 알려주기 위해 배열을 만듦		
		int months[] = {31,28,31,30,31,30,31,31,30,31,30,31}; 
		int y, m, nalsu, i, week;
		
		//년도 입력시 0년 이전은 오류가 발생하도록 제약조건이 필요
		do{
			System.out.print("년도?"); //2018
			y = sc.nextInt();
		}while(y<1);

		//월수 입력시 1~12월로 입력
		do{
			System.out.print("월?"); //12
			m = sc.nextInt();
		}while(m<1 || m>12);

		//입력한 연도가 윤년이면 배열에서 2월의 일자를 29로 바꿔주면 됨.
		//윤년에 따른 2월의 날수 계산
		if(y%4==0 && y%100!=0 || y%400==0){
			months[1] = 29;
		}
		
		//1년1월1일 부터 y-1년12월31일 까지의 날수
		nalsu = (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400 ;
		
		//윤년의 개수
		//int yy = (y-1)/4 - (y-1)/100 + (y-1)/400;
		//System.out.println(yy);

		//월   :  1  2  3  4  5  6  7  8  9  10  11 12
		//배열 : {31,28,31,30,31,30,31,31,30,31,30,31}
		//idx  :  0  1  2  3  4  5  6  7  8  9  10  11
		for(i=0;i<m-1;i++) { 
		
			nalsu += months[i]; //nalsu = nalsu + months[i];
		
		}

		//1년1월1일 부터 y년m월1일 까지의 날수
		nalsu += 1; //nalsu = nalsu +1;
		
		//y년m월1일 의 주의 수 계산
		week = nalsu%7;
		//System.out.println(week);
		
		System.out.println("\n  일  월  화  수  목  금  토"); // 두칸SPACE + 한글1글자 : 4byte
		System.out.println("------------------------------");
		
		//월의 1일을 작성할 때 주의수에 따른 공백을 만들어준 뒤 작성해야함 
		for(i=0; i<week; i++){ //6이면 토요일의 자리까지 공백을 찍어줌
			System.out.print("    ");//공백4칸
		}	
			
		//해당 월의 날짜 출력	
		for(i=1; i<=months[m-1];i++){
			System.out.printf("%4d",i); //자릿수를 4byte씩 유지해라.
			week++;			
			if(week%7 == 0){
				System.out.println();
			}	
		}
		
		if(week%7!=0){
			System.out.println();
		}
		
		System.out.println("------------------------------");
		
		sc.close();
		
	}//endmain

}//endclass
