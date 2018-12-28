package com.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test7 {
	
	public static String getOper() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String oper = null;
		
		try {
			
			System.out.println("연산자?");
			oper =br.readLine();
			
			if(!oper.equals("+") && !oper.equals("-") && !oper.equals("/") && !oper.equals("*")){
			
				//throw로 예외를 의도적으로 발생 시킴
				//throw를 사용할려면 반드시 throws Exception을 기술한다 
				//try.. catch문으로 감싸준다.
				throw new Exception("연산자 입력 오류!");//이 메세지를 Exception에 전달			
			}		
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return oper;	
	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, result;
		String oper;
		
		try {
			System.out.print("첫번째 수? ");
			a = Integer.parseInt(br.readLine());
			System.out.print("두번째 수? ");
			b = Integer.parseInt(br.readLine());
			
			oper = Test7.getOper();

			result = 0;
			
			if (oper.equals("+"))
				result = a + b;
			else if (oper.equals("-"))
				result = a - b;
			else if (oper.equals("/"))
				result = a / b;
			else if (oper.equals("*"))
				result = a * b;
			System.out.printf("%d %s %d  = %d \n", a, oper, b, result);
			
		} catch (Exception e) { //Try문에서 에러 발생시 catch가 잡아냄
			System.out.println(e.toString());
		}
		
	}

}
