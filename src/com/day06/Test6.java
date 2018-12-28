package com.day06;

public class Test6 {

	public static void main(String[] args) {
		
		//배열 초기화
		int[][] a = {{3,6,9},{1,2,3},{7,8,9}};
		int[][] b = {{4,5,7},{1,3,3},{8,7,8}};
		int[][] sum = new int[3][3];
		
		int i,j;
		
		for(i=0;i<a.length;i++){
			for(j=0;j<b.length;j++){			
				sum[i][j]=a[i][j]+b[i][j];			
				System.out.printf("%4d",sum[i][j]);
			}
			System.out.println();
		}

	}

}
