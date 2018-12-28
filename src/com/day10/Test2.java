package com.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		//오로지 String의 메소드로 코딩해볼 것!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("수식[3+5] : " ); //15+25  idx:01234
		String str = br.readLine();
		
		str = str.replaceAll("\\s", ""); //공백 입력 할 수 있으므로 제거.
/*		
 		String[] o = {"+","-","*","/"}; //영구적으로 배열저장.
		for(String op : o){		
		}
*/
		// 위에 3줄과 같은 코딩. 배열생성과 동시에 for문 작성.
		// 배열을 만들었는데 이름이 없는 것. 비교하고 없애버리겠다. 
		// 주소가 없어서 찾아갈 수 없다. garbage collector가 수집
		for(String op :new String[]{"+","-","*","/"}){ 
			
			int pos = str.indexOf(op);//15+25 라면 pos = 2 저장. 찾으려는 게 없으면 -1 저장
			if(pos>-1){ //연산자가 없을경우의 반환값이 -1
				int num1 = Integer.parseInt(str.substring(0,pos)); //substring은 마지막인덱스-1
				int num2 = Integer.parseInt(str.substring(pos+1)); //pos+1부터 끝까지의 숫자를 int형으로 바꿔서 저장
				int result = 0 ;
				char oper = str.charAt(pos); //2
				
				switch(oper){
				case '+':
					result = num1 + num2; break;
				case '-':
					result = num1 - num2; break;
				case '*':
					result = num1 * num2; break;
				case '/':
					result = num1 / num2; break;	
				}
				//System.out.printf("%d %c %d = %d", num1, oper, num2, result);	//이대로 출력해라	
				String s = String.format("%d %c %d = %d", num1, oper, num2, result); //반환값을 string으로 만드는 것
				System.out.println(s);
				//return s; 반환값 String이므로 원하는 곳에 저장된 s를 불러서 사용.
			}
			
			
		}
		
	}	

}
