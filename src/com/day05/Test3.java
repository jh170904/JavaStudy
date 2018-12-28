package com.day05;

import java.util.Scanner;

public class Test3 {
	
	public static void main(String[] args) {
		
		//selection sort
		//10명 이내의 이름과 점수를 입력받아 
		//점수가 높은 사람에서 낮은 사람순으로 출력	
		Scanner sc = new Scanner(System.in);
		
		int i, j, inwon, temp1;
		String temp2;

		String[] name; // 배열크기가 입력값에 따라 달라지므로 크기 지정을 미리 할 수 없음.
		int[] score;	
		
		do{
			System.out.print("인원수[1~10?]");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		//배열의 객체 생성, 메모리 할당. new가 붙으면 객체를 생성했다 = 메모리상에 로딩시켰다.
		name = new String[inwon];
		score = new int[inwon];
		
		//인원수 만큼 이름과 점수 입력
		for(i=0;i<inwon;i++){
			System.out.print((i+1)+"번째 이름?");
			name[i]=sc.next();
			System.out.print((i+1)+"번째 점수?");
			score[i]=sc.nextInt();
		}
		
		//정렬
		for(i=0;i<inwon-1;i++){		
			for(j=i+1;j<inwon;j++){
				if(score[i]<score[j]){//점수오름차순
					temp1=score[i];
					score[i]=score[j];
					score[j]=temp1;			   
					
					temp2=name[i];
					name[i]=name[j];
					name[j]=temp2;		
				}			
			}			
		}
		
		//출력. 확장for문은 배열1개일때만 가능. 예제에서는 2개의 배열이므로 사용불가	
		System.out.printf("이름   점수\n");
		System.out.printf("-----------\n");
		for(i=0;i<inwon;i++){
			System.out.printf("%6s %4d\n",name[i],score[i]);
		}	
		sc.close();		
		
	}//endmain

}//endclass
