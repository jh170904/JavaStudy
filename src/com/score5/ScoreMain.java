package com.score5;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		ScoreImpl ob = new ScoreImpl(); 
		
		int ch;
		
		while (true) { 
			
			do {
				System.out.println("**선택**");
				System.out.print("1.입력\t 2.출력\t 3.종료\n");
				System.out.print("-----------------------------------------------\n선택:");
				ch = sc.nextInt();
				
			}while (ch < 1);

			switch (ch) {
			case 1:
				ob.input();break;
			case 2:
				ob.print();break;
			case 3:
				ob.writeFile();
			default:
				System.exit(0);
			}

		}
	}

}
