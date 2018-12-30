package com.MyHome;

public class MyHomeException {
	
	//로그인(아이디 확인)
	public void loginCheck(String id) throws AuthenException{
		throw new AuthenException("\n" +id+ "가 존재하지 않습니다. \n아이디를 확인해주세요.");
	}
		
	//로그인(비밀번호 확인)
	public void pwCheck(String pw) throws AuthenException{
		throw new AuthenException("\n비밀번호가 일치하지 않습니다. \n비밀번호를 확인해주세요.");
	}

	public void homeCheck() throws AuthenException{
		throw new AuthenException("번호를 제대로 입력주세요");
	}
	
	public void choiceCheck(Object choice) throws AuthenException{
		
		if(!(choice instanceof Integer))
			throw new AuthenException("번호를 제대로 입력주세요");
	}
	
	
	//매물검색시 1-5번 번호 입력 확인
	public void searchCheck(Object choice) throws AuthenException{
		
		if(!(choice instanceof Integer))
			throw new AuthenException("번호를 제대로 입력주세요");
		
		if((Integer)choice>5)
			throw new AuthenException("1~5사이의 숫자를 입력해주세요");
		
	}

}
