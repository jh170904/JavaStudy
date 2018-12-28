package com.day04;

public class Test8 {

	public static void main(String[] args) {
/*
		// (1)+(1+2)+(1+2+3)+...+(1+2+3+...+10)
		int i, j;
		int sum = 0;
		for (i = 1; i <= 10; i++) {
			for (j = 1; j <= i; j++) {
				sum += j;
			}
		}
		System.out.println("(1)+(1+2)+(1+2+3)+...+(1+2+3+...+10):" + sum);
*/	

		int n, sum1, sum2;	
		n=sum1=sum2=0;
		
		while(n<10){
			n++;			//1 2 3  4  5  6  7  8   9   10
			sum1 +=n;		//1 3 6  10 15 21 28 36  45  55
			sum2 += sum1;	//1 4 10 20 35 56 84 120 165 220
		}
		
		System.out.println(sum2);
		
		
	}

}
