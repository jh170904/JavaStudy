package com.checkingAccount;

import java.util.regex.Pattern;

public class CADException {

	//¾ÆÀÌµğ Çü½Ä È®ÀÎ
	public void idFormat(String str) throws AuthenException {

		if (str.length() < 3 || str.length() > 10) {
			throw new AuthenException("\n3~10ÀÚ ÀÌ³»ÀÇ ¾ÆÀÌµğ¸¸ °¡´ÉÇÕ´Ï´Ù");
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
			throw new AuthenException("\n¾ÆÀÌµğ´Â ¿µ¹®ÀÚ¿Í ¼ıÀÚ¸¦ È¥¿ëÇØ¼­ ¸¸µé¾îÁÖ¼¼¿ä");

	}

	//ºñ¹Ğ¹øÈ£ Çü½ÄÈ®ÀÎ
	public void pwCheck(String pw1, String pw2) throws AuthenException {

		if (pw1.length() < 3 || pw1.length() > 10) {
			throw new AuthenException("\n5~20ÀÚ ÀÌ³»ÀÇ ºñ¹Ğ¹øÈ£¸¸ °¡´ÉÇÕ´Ï´Ù");
		}

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
			throw new AuthenException("\n¾ÆÀÌµğ´Â ¿µ¹®ÀÚ¿Í ¼ıÀÚ¸¦ È¥¿ëÇØ¼­ ¸¸µé¾îÁÖ¼¼¿ä");

		if (!pw1.equals(pw2))
			throw new AuthenException("\nºñ¹Ğ¹øÈ£°¡ ´Ù¸¨´Ï´Ù");
	}

	//´Ğ³×ÀÓ Çü½Ä
	public void nameCheck(String name) throws AuthenException {

		boolean check = Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", name);
		if (!check)
			throw new AuthenException("\n¡ØÀÌ¸§Àº ÇÑ±Û·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");
	}

	//ÀÔÃâ±İ, ¿¹/Àû±İ¸¸ ÀÔ·Â °¡´É
	public void accdivCheck(String accdiv) throws AuthenException {

		if (!accdiv.equals("ÀÔÃâ±İ") && !accdiv.equals("¿¹/Àû±İ"))
			throw new AuthenException("\n¡ØÀÔ·ÂÀº [ÀÔÃâ±İ],[¿¹/Àû±İ]À¸·Î¸¸ °¡´ÉÇÕ´Ï´Ù");
	}

	//°èÁÂ/Ä«µå °£ÆíÀÌ¸§ Çü½Ä
	public void accNickCheck(String accNick) throws AuthenException {

		if (accNick.length() < 1 || accNick.length() > 10) {
			throw new AuthenException("\n10ÀÚ ÀÌ³»ÀÇ °£ÆíÀÌ¸§¸¸ °¡´ÉÇÕ´Ï´Ù");
		}

		boolean check = Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", accNick);
		if (!check)
			throw new AuthenException("\n¡Ø°£ÆíÀÌ¸§Àº ÇÑ±Û·Î¸¸ ÀÔ·Â°¡´ÉÇÕ´Ï´Ù");
	}

	// ±İ¾×Àº ¼ıÀÚ¸¸ ÀÔ·Â °¡´É
	public int numberCheck1(String number) throws AuthenException{

		boolean check = number.matches("^[0-9]*$");
		if (!check)
			throw new AuthenException("\n¡Ø¹øÈ£´Â ¼ıÀÚ·Î¸¸ ÀÔ·Â°¡´ÉÇÕ´Ï´Ù");

		if (check)
			return Integer.parseInt(number);

		return 0;
	}

	//°èÁÂ/Ä«µå ¹øÈ£´Â ¼ıÀÚ¸¸ ÀÔ·Â °¡´É
	public String numberCheck2(String number) throws AuthenException{

		boolean check = number.matches("^[0-9]*$");
		if (!check)
			throw new AuthenException("\n¡Ø¼ıÀÚ·Î¸¸ ÀÔ·Â°¡´ÉÇÕ´Ï´Ù");

		if (check)
			return number;

		return null;
	}

	//Ä«Å×°í¸® ÀÔ·Â
	public void categoryCheck(String category) throws AuthenException {

		String check[] = {"ÀÚ±â°è¹ß", "»ıÈ°ºñ", "½Ä´ë", "±³À°", "¹®È­", "¹Ì¿ë", "±³Åë", "¼îÇÎ", "¿ù±Ş"};

		int x = 0;
		for(String i: check){
			if(category.equals(i)){
				x = 1;
				break;
			}
		}

		if(x!=1)
			throw new AuthenException(
					"\n¡ØÄ«Å×°í¸® : [ÀÚ±â°è¹ß] [»ıÈ°ºñ] [½Ä´ë] [±³À°] [¹®È­] [¹Ì¿ë] [±³Åë] [¼îÇÎ] [¿ù±Ş]");
	}

	// ³¯Â¥ È®ÀÎ
	public void dateCheck(String date) throws AuthenException {

		boolean check = Pattern.matches(
				"(\\d{4})-(\\d{2})-(\\d{2})", date);

		if (!check)
			throw new AuthenException("¡Ø³¯Â¥ ÀÔ·Â Çü½ÄÀº [YYYY-MM-DD]ÀÔ´Ï´Ù");
	}
	
	// ¿¬µµ È®ÀÎ
	public void yearCheck(String date) throws AuthenException {

		boolean check = Pattern.matches(
				"(\\d{4})", date);
		if (!check)
			throw new AuthenException("¡Ø¿¬µµ¸¦ Á¤È®È÷ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
	}
	
	// ¿ù È®ÀÎ
	public void monthCheck(String date) throws AuthenException {

		boolean check = Pattern.matches(
				"01|02|03|04|05|06|07|08|09|10|11|12", date);
		if (!check)
			throw new AuthenException("¡Ø¿ùÀ» Á¤È®È÷ ÀÔ·ÂÇØÁÖ¼¼¿ä. ÀÔ·Â Çü½ÄÀº 1¿ùÀÇ °æ¿ì [01]ÀÔ´Ï´Ù.");
	}
	
}
