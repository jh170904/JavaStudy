package com.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Test2 {

	public static void main(String[] args) throws Exception {
		// throws IOException : 예외처리
		// java.lang.Exception : Exception Class 확인하면 서브클래스 모두 확인 가능
		// 무슨 예외처리인지 클래스를 모르겠다면 Exception 으로 처리해도 됨. 상위클래스.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int su, sum;
		char ch; // 'y' or 'n' 한 단어를 받고자 함

		// 무한루프 사용. 계속 이용해야되는 경우
		while (true) {

			// 조건을 만족하면 실행되고 false면 종료.
			do {
				System.out.print("수 입력해주세요 : ");
				su = Integer.parseInt(br.readLine());
				// 100+enter 입력되면 엔터를 지우고 100입력. br.readLine()은 엔터까지 입력이 됨
			} while (su < 1 || su > 5000); //1보다 작거나 5000을 넘을 경우 True가 되서 종료.

			sum = 0; // 변수 초기화. 해주지 않으면 누적 합계로 처리됨

			// 1~su까지의 합계
			for (int i = 1; i <= su; i++) {
				sum = sum + i; // sum+=i
			}

			// 출력
			System.out.println("1~" + su + "까지의 합 : " + sum);

			// 계속 실행 여부
			System.out.print("계속 할래?[Y/N]"); // YN,y,Y,n,N 누르고 enter입력
			ch = (char) System.in.read(); // 하나의 유니코드값을 문자로 형변환시켜서 ch에 저장해라

			if (ch != 'Y' && ch != 'y') {
				break;
			}// Y,y가 아니면 종료하는 조건문 작성. 양쪽이 !=(부정)이면 &&로 작성. 2진수의 보수 때문

			System.in.skip(2);
			// System.in.skip(2); 없으면 NumberFormatException 발생. 
			// 앞에 null값을 int형으로 변환하라고 시킨거니까
			// Skips over and discards n bytes of data from this inputstream
			// enter에 해당하는 ASCII CODE : 10(커서왼쪽정렬)과 13(커서줄바꿈). 둘을 모두 지우기 위해서 2로 설정

		}// end~while

	}// end~main
}
