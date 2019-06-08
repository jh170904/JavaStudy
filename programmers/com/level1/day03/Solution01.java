package com.level1.day03;

import java.util.Arrays;

/*
 * 나누어 떨어지는 숫자 배열
문제 설명
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다.
*/


public class Solution01 {

	public int[] solution(int[] arr, int divisor) {
		int[] answer;
		int cnt = 0;
		Arrays.sort(arr);
		int k = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				cnt++;
			}
		}

		if (cnt == 0) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = new int[cnt];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % divisor == 0) {
					answer[k++] = arr[i];
				}
			}
		}

		return answer;
	}
	
	public static void main(String[] args) {
		
		Solution01 s = new Solution01();
		int[] arr = {2,3,4,5,6,7,8,9,9,10,15};
		int divisor = 5;
		int[] answer = s.solution(arr, divisor);
		for(int a: answer){
			System.out.print(a+" ");
		}	
	}
}