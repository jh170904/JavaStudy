package com.guestbook;

import java.util.regex.Pattern;

public class GBException {

	//아이디 형식 확인
	public void idFormat(String str) throws Exception {

		if (str.length() < 5 || str.length() > 15) {
			throw new Exception("3~10자 이내의 아이디만 가능합니다");
		}

		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
			else if (ch >= '0' && ch <= '9')
				cnt2++;
		}

		if (cnt1 == 0 || cnt2 == 0)
			throw new Exception("아이디는 영문자와 숫자를 혼용해서 만들어주세요");

	}

	//비밀번호 형식확인
	public void pwCheck(String pw1, String pw2) throws Exception {

		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < pw1.length(); i++) {
			char ch = pw1.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
			else if (ch >= '0' && ch <= '9')
				cnt2++;
		}

		if (cnt1 == 0 || cnt2 == 0)
			throw new Exception("아이디는 영문자와 숫자를 혼용해서 만들어주세요");

		if (!pw1.equals(pw2))
			throw new Exception("비밀번호가 다릅니다");
	}

	// 이름 확인
	public void nameCheck(String name) throws Exception {

		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
		if (!check)
			throw new Exception("※이름은 한글로 입력해주세요");
	}

	// 전화번호 확인
	public void phoneCheck(String phone) throws Exception {

		boolean check = Pattern.matches(
				"(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);

		if (!check)
			throw new Exception("※전화번호 입력 형식은 [XXX-XXXX-XXXX]입니다");
	}

	//성별 확인
	public void genCheck(String gender) throws Exception {

		if (!gender.equals("남자") && !gender.equals("여자")) {
			throw new Exception("※성별이 모호하군요!\n성별은 [남자/여자]로 적어주세요;)");
		}
	}
}
