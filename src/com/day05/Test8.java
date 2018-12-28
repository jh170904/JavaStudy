package com.day05;

import java.util.Random;
import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		// 1~3사이의 난수를 발생시켜 가위,바위,보 게임 프로그램 작성
		// 1:가위, 2:바위, 3:보

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int me, com;
		String game[] = { "가위", "바위", "보" };

		com = rd.nextInt(3) + 1;
		
		do{
			System.out.print("1:가위, 2:바위, 3:보 입니다. 숫자를 입력하세요. : ");
			me = sc.nextInt();
		}while(me<1||me>3);
		
		System.out.println("컴퓨터: " + game[com - 1] + ", 사람: " + game[me - 1]);

		if (me == com) {
			System.out.println("비겼습니다.");
		} else if ((me == 1 && com == 3) || (me == 2 && com == 1)|| (me == 3 && com == 2)) {
			System.out.println("당신이 이겼습니다.");
		} else {
			System.out.println("컴퓨터가 이겼습니다.");
		}
/*		
 		//가위바위보 수학 공식
		if (me == com) {
			System.out.println("비겼습니다.");
		}else if((me+2)%3==com){
			System.out.println("당신이 이겼습니다.");
		}else{
			System.out.println("컴퓨터가 이겼습니다.");
		}
*/
		
		sc.close();
	}
}
