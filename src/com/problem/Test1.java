/*
 	1.정수를 입력 받아서 짝수, 홀수를 구별해서 출력.
	예) 3 입력시 -> 3 => 홀수
	예) 4 입력시 -> 4 => 짝수
*/

package com.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int i;
		String ch;

		System.out.print("정수를 입력하세요 : ");
		i = Integer.parseInt(br.readLine());

		ch = i%2==0 ? "짝수" :"홀수";

		System.out.println(i+"는 "+ch+"입니다.");

	}

}
