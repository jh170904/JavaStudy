package com.day07;

public class Data {
	
	static String name = "배수지"; //static변수이므로 이미 메모리 할당되어 있음 
	static int age = 25;
	
	public static void print(){
		System.out.println(name +"의 나이는 "+ age +"살입니다.");
		
		//현재상태에서는 오류 없으나, 배수지와 25가 static변수가 아니면 오류발생함. 메모리 할당 안해준것.
		
	}
	
	

}
