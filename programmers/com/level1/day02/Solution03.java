package com.level1.day02;
/*
 * 문자열 다루기 기본
문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
 * 
 * */
public class Solution03 {

	public boolean solution(String s) {
		boolean answer = true;
		if (s.length() != 4 && s.length() != 6) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) > 47) || !(s.charAt(i) < 58)) {
				return false;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Solution03 sol = new Solution03();
		System.out.println(sol.solution("a123"));
		System.out.println(sol.solution("1123"));
	}
}