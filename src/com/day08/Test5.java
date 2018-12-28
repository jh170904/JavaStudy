package com.day08;

import java.io.IOException;
import java.util.Scanner;

class Calc{
	private int num1, num2;
	private char oper;
	public boolean input() throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.print("두개의 수?");//10 20
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		System.out.println("연산자?");//+,-,*,/
		oper = (char)System.in.read();
		if(oper!='+' && oper!='-' && oper!='/' && oper!='*'){
			return false;
		}
		return true;
	}
	
	public int result(){	
		int r = 0;
		switch(oper){
		case '+':
			r = num1 + num2; break;
		case '-':
			r = num1 - num2; break;
		case '/':
			r = num1 / num2; break;
		case '*':
			r = num1 * num2; break;
		}
		return r;
	}
	
	public void print(int r){
		System.out.printf("%d %c %d = %d\n",num1, oper, num2, r);	
	}
}

public class Test5 {

	public static void main(String[] args) throws IOException {	
		Calc ob = new Calc();
		boolean b = false;
		int r = 0 ;
/*		
		b = ob.input(); //예외처리를 main문에서도 써줘야 함
		if(b==true){		
			r = ob.result();
			ob.print(r);
		}
		System.out.println("연산자 오류!!");

*/
		//boolean이므로 True나 False값이 나옴. 일반적으로 중괄호 바깥을 정상실행의 경우로 작성. 소스코드가 길어서
		if(!ob.input()){  
			System.out.println("연산자 오류!!");
			return;
		}
		r = ob.result();
		ob.print(r);
		
	}

	
}
