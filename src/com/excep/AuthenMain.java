package com.excep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthenMain {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		double num1, num2, result;
		
		OperationAuthen oa = new OperationAuthen();

		try {
			
			System.out.print("두 숫자 입력[a,b]");//10.5,30
			str = br.readLine();
			
			oa.inputFormat(str);//입력 포맷 검사. 예외 처리를 통해 오류 발생시 에러메세지. 에러안나게되면 그냥 넘어감
			
			String[] temp = str.split(",");
			
			//------------------------------------------
			
			oa.number(temp[0]);//정수 실수 검사
			num1 = Double.parseDouble(temp[0]); //정수,실수 상관없이 double형태로 num1에 저장
			oa.number(temp[1]);//정수 실수 검사
			num2 = Double.parseDouble(temp[1]);
			
			//------------------------------------------
			
			System.out.print("연산자?");
			str = br.readLine();
			
			oa.operator(str.charAt(0));//연산자 검사. str:String. operator메소드:char로 비교. 그러므로 0번째에 해당하는 char값으로 비교. 에러안나면 넘어감
			char ch = str.charAt(0);
			result=0;
			
			switch(ch){
				case '+':
					result = num1+num2; break;
				case '-':
					result = num1-num2; break;
				case '/':
					result = num1/num2; break;
				case '*':
					result = num1*num2; break;
			}
		
			System.out.printf("%g %s %g = %g\n",num1, ch, num2, result);
			
		} catch (IOException e) {

			System.out.println(e.toString());
		
		} catch (AuthenException e) {
		
			System.out.println(e.toString());
		
		}
		

	}

}
