package com.day06;

public class Test4 {
	
	public static void main(String[] args) {
		
		//배열의 배열
		//  1 2 3 4 5 
		// 10 9 8 7 6
		// 11 12 13 14 15
		//이렇게 출력되도록 만들기
		
		int[][] arr = new int[6][6]; //이렇게 만들게되면 배열안에는 모두 0이 들어있음	
		int i,j = 0 ; 
		int n=0;

		for (i = 0; i < 5; i++) {
						
			switch(i){
				case 0:
				case 2:
				case 4:
					for(j=0; j<5; j++){
						n++;
						arr[i][j] = n;
						arr[i][5] += n;
						arr[5][j] += n;
						arr[5][5] += n;	
					}break;
				
				case 1:
				case 3:
					for(j=4; j>=0; j--){
						n++;
						arr[i][j] = n;
						arr[i][5] += n;
						arr[5][j] += n;
						arr[5][5] += n;	
					}break;
			}
		}
	
		//출력
		System.out.println("switch문 사용한 방법");
		for(i=0;i<arr.length;i++){ //출력은 6*6
			for(j=0;j<arr.length;j++){			
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
		
		
		//방법2
		int a[][] = new int[6][6];	//숫자를 담을 배열
		int k=0;					//출력할 값을 담은 변수	
		int sw=1;					//증가,감소 구분하기 위한 스위치변수
		
		for(int x=0;x<5;x++){
			
			for(int y=0;y<5;y++){
				k++;
				if(sw==1){
					a[x][y] = k;
					a[5][y] += k;
				}else{
					a[x][4-y] = k;
					a[5][4-y] += k;
				}
				a[x][5] += k;
				a[5][5] += k;
			}
			sw = sw*(-1);
		}
		
		//출력
		System.out.println("sw변수를 사용한 방법");
		for(int x=0;x<6;x++){
			for(int y=0; y<6;y++){
				System.out.printf("%4d", a[x][y]);
			}
			System.out.println();
		}
		
		
	}//endmain

}//endclass
