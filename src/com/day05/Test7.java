package com.day05;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) throws IOException {
		// 1~10사이의 난수를 발생시켜 발생시킨 난수를 3번안에 알아 맞추는 게임
		// (3번안에 알아맞추지 못하면 발생된 난수를 출력)
		int i, j, k;
		char play;

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		do {
			i = rd.nextInt(10) + 1;
			for (j = 1; j <= 3; j++) {
				System.out.printf("1~10중에 정수를 입력하세요. [%d번째 기회] :", j);
				k = sc.nextInt();
				if (k == i) {
					System.out.printf("정답은 %d. 정답입니다!\n",i);
					break;
				} else {
					System.out.printf("오답입니다!\n");
				}
			}
			System.out.printf("정답은 %d 입니다. ", i);
			System.out.println("계속할래?[Y/N]");
			play = (char) System.in.read();

		} while (play == 'y' || play == 'Y');
		sc.close();
		
	}//end main
}//end class
