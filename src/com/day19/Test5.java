package com.day19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//패턴과 정규화표현식을 이용한 치환
//replaceAll 메소드가 내부적으로 이루어지는 알고리즘
public class Test5 {
	
	public static String replaceAll(String str, String oldStr, String newStr){
		
		if(str==null)
			return null;
		
		Pattern p = Pattern.compile(oldStr);
		Matcher m = p.matcher(str);
		
		StringBuffer sb = new StringBuffer();
		while(m.find()){//일치하는 데이터를 찾아서 바꿔라
			m.appendReplacement(sb, newStr);
		}
		m.appendTail(sb);//newStr(대한)뒤의 문자열을 보이게 하기 위해서 appendTail사용해야 함
		
		return sb.toString(); //문자열로 반환
	}

	public static void main(String[] args) {

		String str = "우리나라 대한민국 대한독립만세 대한의 건아";
		
		String s = Test5.replaceAll(str, "대한", "大韓");
		System.out.println(s);
				
		
	}

}
