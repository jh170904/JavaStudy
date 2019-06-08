package com.level1.day03;

import java.util.Scanner;

public class Solution12 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];

		map[0][0] = 1;
		map[N - 1][N - 1] = N * N;
		int x = 1, y = 0;
		int c = 2;
		
		for (int i = 1; i < N; ++i) {
			map[x][y] = c++;
			for (int j = 0; j < i; ++j) {
				if (i % 2 != 0) {
					x--;
					y++;
				} else {
					x++;
					y--;
				}
				map[x][y] = c++;
			}
			
			if (i % 2 != 0)
				y++;
			else
				x++;
		}

		if (x != 0) {
			x--;
			y++;
		} else {
			x++;
			y--;
		}

		for (int i = N - 2; i > 0; --i) {
			map[x][y] = c++;
			for (int j = 0; j < i; ++j) {
				if (i % 2 != 0) {
					x--;
					y++;
				} else {
					x++;
					y--;
				}
				map[x][y] = c++;
			}
			if (i % 2 != 0)
				x++;
			else
				y++;
		}


		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}