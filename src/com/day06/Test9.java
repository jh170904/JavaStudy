package com.day06;

import java.util.Random;
import java.util.Scanner;

class Game{

	int me, com;
	String game[] = { "가위", "바위", "보" };
		
	public int rd(){
		
		Random rd = new Random();
		com = rd.nextInt(3)+1;	
		return com;
	
	}
	
	public int input(){
		
		Scanner sc = new Scanner(System.in);	
		do{
		
			System.out.print("1:가위, 2:바위, 3:보 입니다. 숫자를 입력하세요. : ");
			me = sc.nextInt();
		
		}while(me<1||me>3);	
		
		return me;
	
	}
		
	public void output(int com, int me){
	
		System.out.println("컴퓨터: " + game[com-1] + ", 사람: " + game[me-1]);
		if (me == com) {
			System.out.println("비겼습니다.");
		} else if ((me == 1 && com == 3) || (me == 2 && com == 1)|| (me == 3 && com == 2)) {
			System.out.println("당신이 이겼습니다.");
		} else {
			System.out.println("컴퓨터가 이겼습니다.");
		}

	}
		
}

public class Test9 {

	public static void main(String[] args) {
		// 1~3사이의 난수를 발생시켜 가위,바위,보 게임 프로그램 작성
		// 1:가위, 2:바위, 3:보
		
		Game g = new Game();
		int computer = g.rd();
		int user = g.input();
		g.output(computer, user);
	
	}
}
