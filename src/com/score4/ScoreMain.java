package com.score4;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Score ob = new ScoreImpl(); //upcast
		int ch;
		
		while (true) { //종료하기 전까지 계속 실행
			
			do {
				System.out.print("1.입력 \n2.출력 \n3.삭제 \n4.수정 "+ 
								"\n5.학번검색 \n6.이름검색 \n7.종료\n");
				System.out.print("-----------------------------------------------\n선택:");
				ch = sc.nextInt();
			}while (ch < 1);

			switch (ch) {
			case 1:
				ob.input();break;
			case 2:
				ob.print();break;
			case 3:
				ob.delete();;break;
			case 4:
				ob.update();break;
			case 5:
				ob.findHak();break;
			case 6:
				ob.findName();break;
			default:
				System.exit(0);
			}

		}

		
	}

}
