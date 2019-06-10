package com.level1.day05;

/*
 * 제일 작은 수 제거하기
 문제 설명
 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

 제한 조건
 arr은 길이 1 이상인 배열입니다.
 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
 * 
 * */
public class Solution05 {

	public int[] solution(int[] arr) {
		int[] answer = new int[arr.length == 1 ? 1 : (arr.length - 1)];
		int min = arr[0];
		int j = 0;

		// 빈배열의 경우 -1
		if (arr.length == 1) {

			answer[0] = -1;
			return answer;

		} else {

			// 제일 작은 수 찾기
			for (int k = 0; k < arr.length; k++) {
				if (min > arr[k]) {
					min = arr[k];
				}
			}

			for (int i = 0; i < answer.length; i++) {

				if (arr[i] == min) {
					j = 1;
				}
				answer[i] = arr[i + j];
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution05 sol = new Solution05();
		int[] arr = { 9, 15, 4, 6, 98, 77 };
		int[] answer = sol.solution(arr);
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}
}