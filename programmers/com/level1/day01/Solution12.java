package com.level1.day01;

/*
 * 정수 내림차순으로 배치하기
 문제 설명
 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

 제한 조건
 n은 1이상 8000000000 이하인 자연수입니다.
 * */
public class Solution12 {
	public long solution(long n) {
		String answer = "";
		String str = Long.toString(n);
		int arr[] = new int[str.length()];
		int temp;
		long result = 0;
		for (int k = 0; k < str.length(); k++) {
			arr[k] = Character.getNumericValue(str.charAt(k));
		}

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int s : arr) {
			System.out.printf("%d  ", s);
			answer += s;
		}
		result = Long.parseLong(answer);
		return result;
	}
}