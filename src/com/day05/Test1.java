package com.day05;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
/*		
 		배열에서의 정렬작업.(Selection Sort)
		
		자바에서는 배열의 단점을 보완하기위해 collection 사용함
		collection 도 배열과 사용하는 방법 동일
		변수 하나가 별도로 있어야 저장해뒀다가 덮어씌움
		num[0] > num[1,2,3,4]? num[0]이 더 크면 자리바꿈 : 정렬의 기본 원리

		int num[] = {35,27,13,5,10}  

		27 35 13 5 10
		13 35 27 5 10
		5 35 27 13 10		
		5 35 27 13 10 (4번 반복)
		->5는 전체데이터중 가장 작은 값으로 고정.
		
		5 27 35 13 10
		5 13 35 27 10
		5 10 35 27 13 (3번 반복)
		->5 ,10 고정.
		
		5 10 27 35 13
		5 10 13 35 27 (2번 반복)
		->5 ,10, 13 고정.
		
		5 10 13 27 35 (1번 반복)
		->정렬 끝
			
		이중 for문 이용. 전체적으로 '배열의 length-1'번, 내부적으로 4-3-2-1번
*/
		
		//세 개의 수를 입력받아서 작은 수 에서 큰 수로 출력
		
		Scanner sc = new Scanner(System.in);
		
		int num1,num2,num3,temp;
		System.out.print("세개의 수?");//9 5 2
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
/*		
 	 	//1-2, 2-3, 1-2비교 
 		if(num1>num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		if(num2>num3){
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		if(num1>num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
*/

		//1-2, 1-3, 2-3비교 
		if(num1>num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
 		
 		if(num1>num3){
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
 		
		if(num2>num3){
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		System.out.printf("결과 : %d %d %d\n",num1, num2, num3);
		sc.close();
	}
}
