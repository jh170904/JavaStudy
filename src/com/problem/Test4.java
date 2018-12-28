/*
  	4. 년도를 입력받고, 윤년인지 아닌지를 출력.
	예) 2010 입력시 -> 2010 => 평년
    2012 입력시 -> 2012 => 윤년
*/
package com.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws IOException {

		int i;
		String year;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("연도를 입력하세요. : ");

		i = Integer.parseInt(br.readLine());
		year = i % 4 == 0 && i % 100 == 0 || i % 400 == 0 ? "윤년" : "평년";

		System.out.println(i + "년도는 " + year + "입니다.");

	}

}
