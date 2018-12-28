package com.naver2;

class MyAuthenticator extends Exception{
	
	public void inputFormat(String id) throws Exception{
		
		if(id.length()<8 || id.length()>15) { 
			throw new Exception("id는 8~15 여야 합니다.");		
		}
		
		int cnt1=0; 
		int cnt2=0;
		
		for(int i=0; i<id.length(); i++){			
			char ch = id.charAt(i);	
			if( (ch>=65 && ch<=90) || (ch>=97 && ch<=122) ){//영대소문자아스키
				cnt1++;
			}else if(ch>=48 && ch<=57){//숫자아스키
				cnt2++;
			}
		}
		
		if(cnt1==0||cnt2==0){
			throw new Exception("id는 영대소문자와 숫자를 혼용해야 합니다.");
		}

	}
	
	public void inputFormat(String pw1, String pw2) throws Exception{
		if(!pw1.equals(pw2)){ 
			throw new Exception("비밀번호가 서로 일치하지 않습니다.");
		}	
	}
	
}