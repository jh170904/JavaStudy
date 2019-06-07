package com.level1.day02;

/*
 * 수박수박수박수박수박수?
 문제 설명
 길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

 제한 조건
 n은 길이 10,000이하인 자연수입니다.
 * */
public class Solution02 {
	public String solution(int n) {
		String answer = "";
		int cnt = 1;
		while (cnt <= n) {
			if (cnt % 2 == 1) {
				answer += "수";
			} else if (cnt % 2 == 0) {
				answer += "박";
			}
			cnt++;
		}
		System.out.print(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		Solution02 sol = new Solution02();
		sol.solution(3);
	}
}