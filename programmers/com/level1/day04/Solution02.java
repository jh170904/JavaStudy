package com.level1.day04;

public class Solution02 {

	public long solution(int n, int r, int c) {
		long answer = 0;
		int arr[][] = new int[n][n];
		int cnt = 1;

		for (int sw = 0; sw < (n + n - 1); sw++) {
			for (int i = 0; i < n; i++) {
				int j = sw - i;

				// 행렬 방향 스위치
				if (sw % 2 != 0) {

					if (j >= 0 && j < n) {
						arr[i][j] = cnt++;
					}

				} else if (sw % 2 == 0) {

					if (j >= 0 && j < n) {
						arr[j][i] = cnt++;
					}
				}
			}
		}

/*
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
*/
		answer = arr[r - 1][c - 1];
		return answer;
	}
}