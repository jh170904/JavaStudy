package com.day02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; //이클립스에선 어디서 import해야 되는지 자동으로 툴이 작성해줌

//간단한 계산기

class Test1  {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
/*		
		System.in: stream .컴퓨터 간의 통신시 사용하는 파이프라인 개념. 키보드로 입력한 1byte의 데이터 인식
		String a 
		System.out.printf("첫번째 수 입력?"); //50
		a = br.readLine();	
		num1 = Integer.parseInt(a);
		두 단계를 하나로 만들어도 됨~ 아래처럼!
*/
		
		int num1, num2 ;

		System.out.printf("첫번째 수 입력?"); 
		num1 = Integer.parseInt(br.readLine());
		//num1 = Double.parseDouble(br.readLine());
		
		System.out.printf("두번째 수 입력?");
		num2 = Integer.parseInt(br.readLine());

		//연산
		//int num3 = num1 + num2;
		//System.out.println(num3);
		
		//출력+연산
		System.out.printf("%d + %d = %d\t",num1,num2,(num1+num2));	
		System.out.printf("%d - %d = %d\n",num1,num2,(num1-num2));	
		System.out.printf("%d * %d = %d\t",num1,num2,(num1*num2));	
		System.out.printf("%d / %d = %d\n",num1,num2,(num1/num2));	
		System.out.printf("%d %% %d = %d\n",num1,num2,(num1%num2)); //나머지를 구할땐 %	

		System.out.println("-------------------------------------------");
		
		//숫자를 부등호로 비교를 하면 true(1), false(0) 문자가 생성.
		System.out.println("num1>num2:" + (num1>num2) ); // println에서는 부등호를 인지하는데 혼동이 올수있음. 괄호로 꼭 묶어주기

		String str;

		//삼항연산자 a ? true : false -> a값이 true면 앞에거 실행 false면 뒤에거 실행
		str = num1%2==0?"짝수":"홀수";
		//조건의 개수에 따라 증가 가능. 조건이 세개니까 2번 연산. 자료형에는 하나의 값만 저장
		str = num1>0?"양수":(num1<0?"홀수":"0"); 		

		//A &&(and) B
		//A ||(or) B
		// == 같냐 != 같지않냐 
		//윤년 구하는 공식
		str = num1%4==0 && num1%100!=0 || num1%400==0? "윤년":"평년";
		
		System.out.println(num1 + ":" + str);
		

	}
}
