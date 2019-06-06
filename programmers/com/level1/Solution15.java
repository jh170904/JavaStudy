package com.level1;

/*
 * 약수의 합
 문제 설명
 자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

 제한 사항
 n은 0 이상 3000이하인 자연수입니다.
 */
public class Solution15 {
	public int solution(int n) {
		int answer = 0;

		for (int i = 1; i <= (n / 2); i++) {
			answer += (n % i == 0) ? i : 0;
		}
		answer += n; // 자기자신
		return answer;
	}
}