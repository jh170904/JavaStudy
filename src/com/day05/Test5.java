package com.day05;

import java.util.Scanner;

public class Test5 {
	
	public static void main(String[] args) {
		
		//Selection sort
		//10명 이내의 이름과 점수를 입력받아 석차를 구하세요
		//석차가 높은 사람순으로 출력			
		Scanner sc = new Scanner(System.in);
		int i, j, k, inwon;

		String[] name; 
		int[] score;	
		int[] rank;
		
		//인원수 입력
		do{
			System.out.print("인원수[1~10?]");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		//인원수에 따른 객체 생성
		name = new String[inwon];
		score = new int[inwon];
		rank = new int[inwon]; 
		
		//int형 배열에는 초기값 0 이 들어있음. 모두 1로 초기화
		for(i=0;i<inwon;i++){
			rank[i]=1;
		}
		
		//인원수 만큼 이름과 점수 입력
		for(i=0;i<inwon;i++){
			System.out.print("이름?");
			name[i]=sc.next();
			System.out.print("점수?");
			score[i]=sc.nextInt();
		}
		
 		//순위작성. if문 사용
		for (i = 0; i < inwon - 1; i++) {
			for (j = i + 1; j < inwon; j++) {
				if (score[i] > score[j])
					rank[j]++;
				else if (score[i] < score[j])
					rank[i]++;
			}
		}
		
		//정렬 후 출력
		System.out.printf("이름   점수    석차\n");
		System.out.printf("-------------------\n");
		for(k=1;k<=inwon;k++){
			for(i=0;i<inwon;i++){
				if(k==rank[i]){
					System.out.printf("%6s %4d %4d\n",name[i],score[i],k);
				}
			}
		}
		sc.close();	
		
	}//endmain

}//endclass
