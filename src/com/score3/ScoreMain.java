package com.score3;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Score ob = new ScoreImpl(); //upcast
		int ch;
		
		while (true) { //종료하기 전까지 계속 실행
			
			do {
				System.out.print("1.입력 \n2.출력 \n3.학번검색 \n4.이름검색 \n5.총점내림차순정렬 \n6.학번오름차순정렬 \n7.종료\n");
				System.out.print("-----------------------------------------------\n선택:");
				ch = sc.nextInt();
			}while (ch < 1);

			switch (ch) {
			case 1:
				ob.input();break;
			case 2:
				ob.print();break;
			case 3:
				ob.searchHak();break;
			case 4:
				ob.searchName();break;
			case 5:
				ob.descSortTot();break;
			case 6:
				ob.ascSortHak();break;
			default:
				System.exit(0);
			}

		}
		
/*				 
		ScoreVO vo = new ScoreVO();
		vo.setHak("111");//초기화메소드
		vo.setName("배수지");
		vo.setKor(60);
		vo.setEng(80);
		vo.setMat(80);
			
		System.out.println(vo.getHak());
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
*/
		
	}

}
