package com.excep;

//AuthenException 예외처리 클래스
//OperationAuthen 검사하는 여러 메소드 만들 것
//main문 계산기 사용시 try-catch문을 사용하기도 하지만, 검사하는 메소드를 사용해서 에러메세지를 띄울 것

public class OperationAuthen {
	
	public void inputFormat(String str) throws AuthenException{
		
		String temp[] = str.split(",");
		if(temp.length!=2){ //두개의 숫자를 입력할 것. split 했을때 배열 사이즈는 2가 나와야 함
			throw new AuthenException("숫자입력 형식오류: " + str );
		}
	}
	
	@SuppressWarnings("unused") //어노테이션. 사용하지 않은 변수에 대해서 뜨는 에러메세지를 보지 않겠다.
	public void number(String str) throws AuthenException{
		
		try {
			if(str.indexOf(".")!=-1){//소수점을 입력한 데이터가 있으면 double형태로 형변환
				double num = Double.parseDouble(str);
			}else{//정수형이면 integer
				int num = Integer.parseInt(str);
			}

		} catch (NumberFormatException e) {
			throw new AuthenException("숫자 변환 불가: " + str);//에러발생시 AuthenException로 String가지고 찾아감
		}
		
	}
	
	public void operator(char ch) throws AuthenException{
		
		switch(ch){
		case '+': 
		case '-': 
		case '/': 
		case '*':
			return; //연산자가 네가지중 하나에 해당하면 문제없음. return으로 나감.
		default:
			throw new AuthenException("연산자 오류 : " + ch);
		}
		
		
	}
	
	
}
