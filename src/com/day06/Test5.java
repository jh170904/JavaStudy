package com.day06;

public class Test5 {

	public static void main(String[] args) {
		
		//구구단(2~5단) 가로로 나오도록 만들기 사이는 \t으로 띄우기 
		//구구단(6~9단) 
		//3중 for문으로 작성 - 방법 3가지 존재. 2중 for문도 가능함
		//힌트:변수를 중간에 초기화시켜야 함
		
		int i, j;
		
		for(i=1;i<10;i++){ 
			for(j=2;j<6;j++){			
				System.out.printf("%d * %d = %d\t",j,i,(i*j) );
			}
			System.out.println();
		
		}
		
		System.out.println("-----------------------------------------------------------");
		
		for(i=1;i<10;i++){ 
			for(j=6;j<10;j++){			
				System.out.printf("%d * %d = %d\t",j,i,(i*j) );
			}
			System.out.println();
		}
		

	}

}
