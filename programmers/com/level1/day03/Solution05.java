package com.level1.day03;

/*
 * 소수 찾기 - 다시풀기
 문제 설명
 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 (1은 소수가 아닙니다.)

 제한 조건
 n은 2이상 1000000이하의 자연수입니다
 * */

public class Solution05 {
	public int solution(int n) {
		int cnt = 0;
		boolean flag;

		for (int i = 2; i <= n; i++) {
			flag = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0 && i != j) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
		}
		return cnt;
	}
}