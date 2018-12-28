package com.day09;

public class Test7 {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		sb.append("서울");
		sb.append("부산");
		sb.append("대구");
		
		System.out.println(sb);
		String str = sb.toString(); //object.toString을 override한 것. 결과만 저장. 
		System.out.println(str); //StringBuffer와 StringBuilder사용시 이렇게 저장 후 출력해주면 됨
		
		//Integer(int의 참조형 자료형) double의 참조자료형은 Double
		//int a = 10; //일반자료형
		//Integer b = new Integer(10); //자료형의 참조형 자료형 8개있음. (String은 class이므로 제외)
		
		int a = 24;
		System.out.println(a); //정수 10
		System.out.println(Integer.toString(a)); //문자 10
		System.out.println(Integer.toString(a,2)); //2진수
		System.out.println(Integer.toString(a,8)); //8진수
		System.out.println(Integer.toString(a,16)); //16진수
		
		
		
	}

}
