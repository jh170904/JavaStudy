package com.excep;

import java.util.Scanner;

class MyAuthen{
	
	public void inputForm(String str) throws Exception{
		
		//8~15이내인지 검사
		if(str.length()<8||str.length()>15){
			throw new Exception("문자의 길이는 8~15자 입니다.");	
		}
		
		int eng = 0;
		int num = 0;
		
		for(int i=0;i<str.length();i++){
			
			char ch =str.charAt(i);
			
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
				eng++;
			}else if(ch>='0'&&ch<='9'){
				num++;
			}
		}
		
		if(eng==0||num==0){
			throw new Exception("영문자,숫자 혼용만 가능합니다!");
		}
		
	}
	
}

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MyAuthen au = new MyAuthen();
		String str;
		
		try {
			System.out.print("ID?");
			str = sc.next();
			au.inputForm(str);//조건검색
			System.out.println("사용가능한 아이디 입니다.");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
