package com.day19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//regex : 정규화표현식을 다루기 위한 클래스
//단어를 치환, 메일주소점검, 파일의 제어문자 제거, 파일검색

public class Test4 {
	
	public static void main(String[] args) {

		/*
		 *필요할 때 람다식을 api로 확인해서 활용
		 
			c[a-z]* : c로 시작하는 영단어(c, ca, caaa)
			c[a-z] : c로 시작하는 두글자 영단어(ca, ck)
			c[a-zA-Z0-9] : ca, cA, c4
			c. : c로 시작하는 두글자(ca,cB,c&)
			c.* : c로 시작하는 모든 문자 
			c.*t : ct, chhhhhht, c77777t
			[b|c].* 또는 [bc].* 또는 [b-c].* : b, c, bbb, cccc
			[^b|c].* 또는 [^bc].* 또는 [^b-c].* : b또는c로 시작되면 안됨
			.*c.* : c가 포함된 모든 문자열
			
			[\\d]+또는 [0-9]+ : 하나 이상의 숫자 
		*/
		
		String[] str = {"bat", "baby", "bonus", "c", "cA", "c.", "c0", "car", "combat","count", "date","disc"};
		
		Pattern p;
		p = Pattern.compile("c[a-z]*");
		
		System.out.println("c[a-z]* 결과....");
		for(String s:str){
			Matcher m = p.matcher(s);
			
			if(m.matches())
				System.out.print(s+" ");
		}
		
		System.out.println("\n------------------------");
		p = Pattern.compile("c[a-z]+");//2글자 이상
		
		System.out.println("c[a-z]+ 결과....");
		for(String s:str){
			Matcher m = p.matcher(s);
			
			if(m.matches())
				System.out.print(s+" ");
		}
		
		System.out.println("\n------------------------");
		p = Pattern.compile("c.");//2글자
		
		System.out.println("c. 결과....");
		for(String s:str){
			Matcher m = p.matcher(s);
			
			if(m.matches())
				System.out.print(s+" ");
		}
		
		System.out.println("\n------------------------");
		p = Pattern.compile("[\\w]+@[\\w]+(\\.[\\w]+)+");
		
		//이메일검증
		String[] mails = {"aaa@aaa.com", "@aaa.co.kr", "@bbb.com", "aaa@vvv.co.kr", "sss.co.kr", "abc@bbb"};
		
		// [\\w]+ : 한글자 이상의 영, 숫자
		// @
		// (\\.[\\w]+) : 괄호안에 있는 것은 반드시 한번을 출력되야 함
		// \\. : 도트
		String pat = "[\\w]+@[\\w]+(\\.[\\w]+)+";
		System.out.println("이메일 검증 결과.... [\\w]+@[\\w]+(\\.[\\w]+)+");
		for(String s:mails){
/*
			Matcher m = p.matcher(s);
			if(m.matches())
				System.out.println(s);
*/
			if(Pattern.matches(pat, s))//Matcher 한줄로 가능
				System.out.println(s);
		}
		
		
	}

}
