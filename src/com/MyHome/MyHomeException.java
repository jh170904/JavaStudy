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
	
	public void localCheck(String local) throws AuthenException{
		
		int check = 0;
		String localCheck[] = {"강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구",
							   "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구","영등포구", "용산구", "은평구",
							   "종로구", "중구", "중랑구"};
		
		for(String s : localCheck){
			if(local.equals(s))
				check = 1;
		}
		
		if(check == 0)
			throw new AuthenException("\n지역을 제대로 입력해주세요. \n[XX구]형식으로 입력해주세요");
		
	}

}
