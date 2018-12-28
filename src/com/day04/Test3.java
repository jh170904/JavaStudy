package com.day04;

import java.io.IOException;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2;
		char oper;
		
		System.out.print("첫번째 수?");//30
		num1 = sc.nextInt();
		
		System.out.print("두번째 수?");//20
		num2 = sc.nextInt();
		
		System.out.print("연산자[+,-,/,*]?");//+
		oper = (char)System.in.read();
		
/*		
 * switch문 사용
 		switch(oper){
		case '+':
			System.out.printf("%d %c %d = %d\n",num1, oper, num2, (num1+num2));
			break;
		case '-':
			System.out.printf("%d %c %d = %d\n",num1, oper, num2, (num1-num2));
			break;
		case '/':
			System.out.printf("%d %c %d = %d\n",num1, oper, num2, (num1/num2));
			break;
		case '*':
			System.out.printf("%d %c %d = %d\n",num1, oper, num2, (num1*num2));
			break;
		default:
			System.out.printf("연산자 오류");
		}
*/		
		

/*		
 * if문 사용
  		if(oper=='+')
			System.out.println(num1 +"+"+ num2+"="+ (num1+num2));
		else if(oper=='-')
			System.out.println(num1 +"-"+ num2+"="+ (num1-num2));		
		else if(oper=='/')
			System.out.println(num1 +"/"+ num2+"="+ (num1/num2));	
		else if(oper=='*')
			System.out.println(num1 +"*"+ num2+"="+ (num1*num2));			
*/
		
		//중복되는 내용은 최대한 줄여서 작성

		int result=0;
 		
		switch(oper){
		case '+':
			result = num1+num2;break;
		case '-':
			result = num1-num2;break;
		case '/':
			result = num1/num2;break;
		case '*':
			result = num1*num2;break;
		}	

		System.out.printf("%d %s %d = %d\n",num1, oper, num2, result);
		
		sc.close();
		}		
		
	}

	