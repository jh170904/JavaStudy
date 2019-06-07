package com.level1.day01;

/*
 최대공약수와 최소공배수
 문제 설명
 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

 제한 사항
 두 수는 1이상 1000000이하의 자연수입니다.
 * */
public class Solution09 {
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		int max, min, mok, mod;
		if (n > m) {
			max = n;
			min = m;
		} else {
			max = m;
			min = n;
		}

		/*
		 * 최대공약수 최소공배수연산 (유클리드호제법활용) 호제법이란 두 수가 서로 상대 수를 나누어서 원하는 수를 얻는 방법을 말한다.
		 * 2개의 자연수 a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
		 * 이 성질에 따라 b를 r로 나눈 나머지 r'를 구하고 다시 r을 r'로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이
		 * 되었을 때 나누는 수가 a와 b의 최대공약수이다.
		 */

		while (true) {
			mok = max / min;
			mod = max % min;
			if (mod == 0) {
				answer[0] = min;
				answer[1] = n * m / min;
				break;
			}
			max = min;
			min = mod;
		}
		return answer;
	}
}