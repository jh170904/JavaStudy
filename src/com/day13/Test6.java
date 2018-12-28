package com.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//Exception 클래스 (예외처리)

//코딩상에는 에러가 없는 데 실행하다가 오류가 발생하는 것을 Runtime Error
//숫자 입력해야되는데 문자 입력 or 연산자 잘못 입력

public class Test6 {

	public static void main(String[] args) {

		int a, b, result;
		String oper;

		// Scanner sc= new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// try{}에서 에러가 발생하게 되면 catch 가 잡아냄.
		// Exception이 오류처리한 결과를 매개변수 e 에 할당
		// 내가 사용자에러를 발생시키는 경우도 있음

		try {

			System.out.print("첫번째 수? ");
			// a = sc.nextInt();
			// b = sc.nextInt();
			a = Integer.parseInt(br.readLine());
			System.out.print("첫번째 수? ");
			b = Integer.parseInt(br.readLine());

			System.out.print("연산자? ");
			// oper = sc.next();

			oper = br.readLine();

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

		} catch (NumberFormatException e) {
			System.out.println("정수를 입력해라!");

		} catch (ArithmeticException e) {
			System.out.println("0으로 나누면 안돼!");

		} catch (Exception e) {
			System.out.println("숫자가 아니야!");
			// System.out.println(e.toString());
			e.printStackTrace();// 원래 뜨던 에러 화면. default였는데 try catch 사용한 것
		} finally {//에러발생시 해당하는 에러부분의 catch문이 실행되고 finally가 항상 실행.
			System.out.println("난 항상 보인다");
		}
		System.out.println("여기는 try밖...");

	}

}
