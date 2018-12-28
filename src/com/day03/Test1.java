package com.day03;

import java.util.Scanner;

class Test1 {
	
	public static void main(String[] args) {
		
/*		
		반복문(for,while,do~while)
		for:시작과 끝값이 정해져있을 때
		while:끝값이 정해져있지 않을 때
		do~while:1번은 무조건 실행시키고 확인해야 할때
*/
		//선언
		Scanner sc = new Scanner(System.in);
		int dan;
		
		//입력
		System.out.print("단 입력?");
		dan = sc.nextInt(); //Scanner 안에 있는 메소드 : .nextInt(). 반드시 Scanner 가 먼저 정의되어 있어야 함

		//for(초기값;최대값_조건;증가값)
		for (int i=1;i<=9;i++) {
			//System.out.println(dan + " * " + i + " = " + (dan*i));
			System.out.printf("%d * %d = %d\n",dan, i, dan*i);
		}

		System.out.println("------------------------------------------");

		//while문은 일반적으로 초기값을 0으로 설정함. 
		//배열을 사용할 경우 첫번째 배열이 [0]인 걸 활용하기 위해
		
		//while(조건) 몇번 돌려야 할지 모를떄 대부분 사용.
		
		int j=0; //나중에 배열을 사용할 때 편하게 하기 위해서 0으로 시작. 무조건은 아님. 
		while (j<9) {			
		
			j++;
			System.out.printf("%d * %d = %d\n",dan, j, dan*j);
		
		}
		
		System.out.println("------------------------------------------");

		//do~while(조건문); 세미콜론 잊으면 안됨. 1번은 무조건 바로 실행이 된다.
		int k=0;
		do {

			k++;
			System.out.printf("%d * %d = %d\n",dan, k, dan*k);			

		} while (k<9);

		System.out.println("------------------------------------------");		
/*		

		//무한루프. 조건문이 true면 실행.계속 반복실행
		while (true) {
			System.out.println("돌아간당");
		}
*/
		sc.close(); //일종의 스트림이기 때문이 사용한 후 닫아주거나 null로 초기화 시켜야 함. 그렇지 않으면 쓰레기값이 남아있을 수 있음
		//하지만 Scanner는 알아서 초기화시켜줘서 오류는 안남!
		
	}
}
