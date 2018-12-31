package com.day06;

public class Test3 {
	
	public static void main(String[] args) {
			
		//배열의 배열
		
		int[][] arr = new int[6][6]; //이렇게 만들게되면 배열안에는 모두 0이 들어있음	
		int i,j ; 
		int n=0;
		
		for(i=0;i<5;i++){ //입력은 5*5
			for(j=0;j<5;j++){			
				//System.out.println(i +":"+ j); // 자릿값 출력
				n++;
				arr[i][j] = n;
				
				arr[i][5] += n; //[0,5] [1,5] [2,5] [3,5] [4,5]에 누적
				arr[5][j] += n;	//[5,0] [5,1] [5,2] [5,3] [5,4]에 누적		
				arr[5][5] += n;	//전체누적합계
			}
		}
			
		for(i=0;i<6;i++){ //출력은 6*6
			for(j=0;j<6;j++){			
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}		
		
	}

}
