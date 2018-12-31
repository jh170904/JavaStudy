package com.day07;

import java.io.IOException;

public class Test6 {

/*	[문제1]
			System.in.read()만 사용해서 숫자를 입력받고
			입력받은 수까지의 합계를 구하시오

			조건
			1.BufferedReader X
			2.Scanner X

			모양
			수입력? 10
			1-10까지의 합: 55
*/
	
	public static void main(String[] args) throws IOException {
/*			
		//방법1
		char ch = 0;
	    String str = "";
	    
		int sum, i , j ;
		sum = i = 0;

		System.out.print("숫자를 입력하세요: ");
		while (true) {
			ch = (char) System.in.read();

			for (i = 0; i <= 9; i++) {
				if (ch % 48 == i) {
					str = str + ch;
				}
			}
			
			if (ch == 13) {
				break;
			}
		}
		
		j = Integer.parseInt(str);
		
		for(i=0;i<=j;i++){		
			sum = sum + i;			
		}
		System.out.printf("1부터 %d까지의 합계는 %d 입니다.",j, sum);
*/		
		//방법2
		int n=0, s=0;
		int data;
		
		System.out.print("숫자를 입력하세요: ");//1(49)2(50)3(51)
												//System.in.read() 사용자가 입력한 숫자를 byte단위로 읽어서 저장함
		while((data=System.in.read())!=13){ 	
			n=n*10+data-48;						//char형태의 값을 정수로 변환.		
		}
		
		// 1 = 0 * 10 + 49 - 48
		// 12 = 1 * 10 + 50 - 48
		// 123 = 12 * 10 + 51 - 48
		
		for(int i=1;i<=n;i++){		
			s = s + i;			
		}
		System.out.printf("1부터 %d까지의 합계는 %d 입니다.",n,s);
		
	}

}
