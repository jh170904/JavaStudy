package com.excep;

import java.util.Scanner;

//예외 처리 문제 
//[조건]
//1. 5~10글자 이내 인지 검사
//2. 영문자(대소문자 구문없이)만 입력

class MyAuthenticator{
	
	public void inputFormat(String str) throws Exception{
		
		if(str.length()<5 || str.length()>10) { 
			throw new Exception("문자열의 길이는 5~10 여야 합니다.");
		}
		
		for(int i=0; i<str.length(); i++){			
			char ch = str.charAt(i);	
			if( ch<65 || (ch>90 && ch<97) || ch>122 ){ 
				throw new Exception("영문자를 입력하세요! " + str );
			}
		}
	}
}

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		String str;
		MyAuthenticator ma = new MyAuthenticator();

		try {
			
			System.out.print("문자열?");//asdsa
			str = sc.next();
			ma.inputFormat(str);// 조건검사
			System.out.println(str);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}//endmain

}//endclass
