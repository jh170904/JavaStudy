package com.day10;

public class Test1 {

	public static void main(String[] args) {
		
		String s1 = "서울,부산,대구";
		String ss[] = s1.split(","); //split메소드 : ,를 기준으로 내용을 잘라서 ss배열에 저장해라
	
		for(String s:ss){
			System.out.print(s + " ");
		}
		
		String s2 = "seoul";
		String s3 = "Seoul"; //s2 s3의 주소는 상이함. 영대소문자 구분.
		
		System.out.println(s2.equals(s3)); //false 
		System.out.println(s2.equalsIgnoreCase(s3)); //true
		//equalsIgnoreCase메소드 : 대소문자 구분하지 않고 내용만 비교
		
		String s4 = "abc.def.hij";
		//index      01234567890
		
		System.out.println(s4.indexOf(".")); 		// 3 : "."이 나오는 index값을 반환함 
		System.out.println(s4.lastIndexOf(".")); 	// 7 : "."이 나오는 마지막 index값을 반환함
		System.out.println(s4.indexOf("deff"));		// -1 : 해당하는 값이 없으므로 -1 반환. def 입력시 제일 첫번째 인뎃스인 4 반환 
		System.out.println(s4.indexOf("x"));		//a != -1 이면 반복문실행 등으로 많이 이용
		
		String s5 = "우리나라 대한민국 좋은나라 대한민국";
		//String s6 = s5.replaceAll(regex, replacement); regex: 정규화표현식. '//s' 공백과 같은 특수기호
		String s6 = s5.replaceAll("대한", "大韓"); //replace는 문자만 가능. replaceAll은 정규화표현식도 사용가능
		System.out.println(s6);
		
		String s7 = "  a  b  c  ";
		System.out.println(s7);
		System.out.println(s7.trim()); 					//맨왼쪽과 맨오른쪽의 공백 제거
		System.out.println(s7.replaceAll(" ", "")); 	//공백을 null로 바꿔라
		System.out.println(s7.replaceAll("\\s", ""));	//공백을 null로 바꿔라
														//web에서는 enter를 인식못함. <br>로 작성. 이때 replace메소드 많이 쓴다.
		
		char ch = "abcdefg".charAt(2); //string변수는 만들지 않았지만 String값에서 2번에 있는 한개의 문자를 추출해라
		//idx      0123456
		System.out.println(ch); //c
		System.out.println("abcdefg".startsWith("abc")); //true. String이 "abc"로 시작하느냐. ajax의 제시어 때 나옴. 웹의 연관검색어
		System.out.println("abcdefg".startsWith("abd")); //false.
		System.out.println("abcdefg".length()); //7
		
		//사전식 배열 정렬.(ASCII값의 차) 가나다순으로 
		String s8 = "abcdefg";
		String s9 = "abcefgh";
		
		System.out.println(s8.compareTo(s9)); //-1
		System.out.println(s9.compareTo(s8)); //1
	
	
		
		
	}
}
