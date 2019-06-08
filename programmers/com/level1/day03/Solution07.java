package com.level1.day03;
/*
 * 스트링을 받아와서 가장 많이 사용한 알파벳 소문자로 출력하기
 * 동률있을 경우 동시 출력
 * */
public class Solution07 {
	public String solution(String s){
		String answer = "";
		String str =s.toLowerCase();
		char elements[]= new char[26];
		int cnt[] = new int[26];
		int maxNum = 0 ;
		
		for(int i=0; i<elements.length; i++){
			elements[i] = (char)(97+i); //배열 알파벳 소문자 초기화
		}
		
		for(int i=0;i<elements.length; i++){
			for(int j=0; j<str.length();j++){
				if(str.charAt(j)==elements[i]){
					cnt[i]++;		
				}
			}
		}
		
		for(int i=0; i<elements.length; i++){
			if(cnt[i]>maxNum){
				maxNum = cnt[i];
			}
		}
		
		for(int i=0; i<elements.length; i++){
			if(cnt[i]==maxNum){
				answer += Character.toString(elements[i]);
			}
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		Solution07 s = new Solution07();
		String str = "abbbBbbbbbbBBBBKKKKKKKkKkkkkkeewd";
		System.out.println(s.solution(str));
	}
}
