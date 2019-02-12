package com.guestbook;

import java.util.regex.Pattern;

public class GBException {

	//¾ÆÀÌµð Çü½Ä È®ÀÎ
	public void idFormat(String str) throws Exception {

		if (str.length() < 5 || str.length() > 15) {
			throw new Exception("3~10ÀÚ ÀÌ³»ÀÇ ¾ÆÀÌµð¸¸ °¡´ÉÇÕ´Ï´Ù");
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
			throw new Exception("¾ÆÀÌµð´Â ¿µ¹®ÀÚ¿Í ¼ýÀÚ¸¦ È¥¿ëÇØ¼­ ¸¸µé¾îÁÖ¼¼¿ä");

	}

	//ºñ¹Ð¹øÈ£ Çü½ÄÈ®ÀÎ
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
			throw new Exception("¾ÆÀÌµð´Â ¿µ¹®ÀÚ¿Í ¼ýÀÚ¸¦ È¥¿ëÇØ¼­ ¸¸µé¾îÁÖ¼¼¿ä");

		if (!pw1.equals(pw2))
			throw new Exception("ºñ¹Ð¹øÈ£°¡ ´Ù¸¨´Ï´Ù");
	}

	// ÀÌ¸§ È®ÀÎ
	public void nameCheck(String name) throws Exception {

		boolean check = Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", name);
		if (!check)
			throw new Exception("¡ØÀÌ¸§Àº ÇÑ±Û·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");
	}

	// ÀüÈ­¹øÈ£ È®ÀÎ
	public void phoneCheck(String phone) throws Exception {

		boolean check = Pattern.matches(
				"(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);

		if (!check)
			throw new Exception("¡ØÀüÈ­¹øÈ£ ÀÔ·Â Çü½ÄÀº [XXX-XXXX-XXXX]ÀÔ´Ï´Ù");
	}

	//¼ºº° È®ÀÎ
	public void genCheck(String gender) throws Exception {

		if (!gender.equals("³²ÀÚ") && !gender.equals("¿©ÀÚ")) {
			throw new Exception("¡Ø¼ºº°ÀÌ ¸ðÈ£ÇÏ±º¿ä!\n¼ºº°Àº [³²ÀÚ/¿©ÀÚ]·Î Àû¾îÁÖ¼¼¿ä;)");
		}
	}
}
