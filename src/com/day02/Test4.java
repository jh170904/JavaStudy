package com.day02;
import java.io.IOException;

class Test4 {
	public static void main(String[] args) throws IOException {	
/*		
		boolean : 논리형 
		char : 문자형. 기본값 \u0000 유니코드. 표현범위 0~65535
		ASCII CODE : A -> 65 a -> 97 영대소문자로 바꿔야하면 +-32
		enter : 두개의 명령어로 구성되어있음 10(LF-커서를 왼쪽정렬), 13(CR-커서가 밑으로 내려감)
		char ch = 'a'; // 작은따옴표사용. 한 글자만 저장 가능. 'abc'는 오류 발생. ch에는 97이라는 아스키코드가 저장되어있음
*/	

		//선언
		char ch,result;

		//입력
		System.out.print("한개의 문자?");

/*
		ch = System.in.read(); 한개의 문자만 읽어냄. 
		읽게되면 97이라는 아스키코드를 인식. int타입이라 char에 저장안됨
		api를 확인하면
		입력 스트림로부터 데이터의 다음의 바이트를 읽어들입니다. 값의 바이트는,0 ~ 255 의 범위의 int 로서 돌려주어집니다
		adsflsdflksd 이렇게 입력하더라도 'a' 맨앞하나만 저장 가능
*/

		ch = (char)System.in.read(); //문자형으로 강제 형변환
		
/*		
		System.out.println(ch);
		System.out.println(Integer.toString(ch)); //String으로 바꿔서 그대로 보여달라
		사용자가 대문자를 입력했을때 아스키코드 범위 ch>=65 && ch<=90
		(char)(ch+32) 형변환을 해주지 않는다면 result는 문자형이므로 오류 발생
*/
		result = ch>=65 && ch<=90 ? (char)(ch+32) : (ch>='a'&&ch<='z' ? (char)(ch-32) : ch);
		
		System.out.println(ch + ":" + result);

	}



}
