package com.day02;
import java.util.Scanner;

class Test7 {

	public static void main(String[] args) {

		//단락문자의 패턴을 사용해 분류
		//디폴트 단락은 공백

		Scanner sc = new Scanner(System.in); //sc객체 생성. 끝나고 난 후 sc.close(); 작성해줘야 함

		String name;
		int kor, eng, mat;

		//suzi 40 60 70 - 공백으로 데이터 구분해서 입력
		//System.out.print("이름 국어 영어 수학?");
		//연결된 하나의 값이지만 공백을 자동으로 인식하는게 Scanner의 특성 - 그 덕에 한꺼번에 입력할 수 있다.

		//suzi,40,60,70 
		System.out.print("이름 국어 영어 수학?");

		//공백이 아닌 다른 구분 단위를 사용하고 싶을때 사용 : 콤마로 부분된 데이터 읽기
		sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*"); 
		//suzi,40,60,70 를 통채로 읽어낸 뒤 
		//메소드 .useDelimiter("\\s*,\\s*");  공백없이 ,로 구분해라 : 정규화 표현식
		//공백을 기본으로 인식하기 때문에 'suzi, 40, 60, 70'로 작성하면 오류 발생.

/*		
		api 확인하기
		String input = "1 fish 2 fish red fish blue fish";
		Scanner s = new Scanner(input);
		s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
		MatchResult result = s.match();
		for (int i=1; i<=result.groupCount(); i++)
         System.out.println(result.group(i));
		s.close(); 
*/		

		name = sc.next(); //공백을 만나면 멈추고 거기까지의 값을 저장하므로 suzi만 name에 저장됨
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();

		sc.close();

		System.out.println(name + ":" + (kor+eng+mat)+"점");




	}
}
