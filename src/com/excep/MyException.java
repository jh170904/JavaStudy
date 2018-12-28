package com.excep;

public class MyException extends Exception {

	private static final long serialVersionUID = 1L;//이클립스에서 exception의 용량이 너무 커서 메모리 할당을 요청함. 그래서 작성해주는 소스
	
	public MyException (String msg){ //생성자
		super(msg); //Exception에 String값 msg를 보냄
	}
	
}
