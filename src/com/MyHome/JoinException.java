package com.MyHome;

import java.util.regex.Pattern;

public class JoinException {
	
	//¾ÆÀÌµð °¡´É¿©ºÎ È®ÀÎ
	public void idFormat(String str) throws AuthenException{
		
		if(str.length()<5 || str.length()>10){
			throw new AuthenException("¡Ø5~10ÀÚ ÀÌ³»ÀÇ ¾ÆÀÌµð¸¸ °¡´ÉÇÕ´Ï´Ù");
		}
		
		int cnt1=0;
		int cnt2=0;
		
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
				cnt1++;
			else if(ch>='0' && ch<='9')
				cnt2++;
		}
	
		if(cnt1==0 || cnt2==0)
			throw new AuthenException("¡Ø¾ÆÀÌµð´Â ¿µ¹®ÀÚ¿Í ¼ýÀÚ¸¦ È¥¿ëÇØ¼­ ¸¸µé¾îÁÖ¼¼¿ä");	
		
	}
	
	//¾ÆÀÌµð Áßº¹¿©ºÎ È®ÀÎ
	public void sameId() throws AuthenException {
		throw new AuthenException("¡Øµ¿ÀÏÇÑ ¾ÆÀÌµð°¡ ÀÌ¹Ì Á¸ÀçÇÕ´Ï´Ù");	
	}
	
	
	//ºñ¹Ð¹øÈ£ È®ÀÎ
	public void pwCheck(String pw1, String pw2) throws AuthenException{
		if(!pw1.equals(pw2))
			throw new AuthenException("¡Øºñ¹Ð¹øÈ£°¡ ´Ù¸¨´Ï´Ù");	
	}
	
	//ÀÌ¸§ È®ÀÎ
	public void nameCheck(String name) throws AuthenException{

		boolean check = Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", name);
		if(!check)
			throw new AuthenException("¡ØÀÌ¸§Àº ÇÑ±Û·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");	
	}

	//ÀüÈ­¹øÈ£ È®ÀÎ
	public void phoneCheck(String phone) throws AuthenException{

		boolean check = Pattern.matches("(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);

		if(!check)
			throw new AuthenException("¡ØÀüÈ­¹øÈ£ ÀÔ·Â Çü½ÄÀº [XXX-XXXX-XXXX]ÀÔ´Ï´Ù");	
	}
	
	//Áß°³¾÷ÀÚ, ÆÇ¸ÅÀÚ/±¸¸ÅÀÚ È®ÀÎ
	public void typeCheck(int type) throws AuthenException{
		if(!(type==1) && !(type==2))
			throw new AuthenException("¡Ø¹øÈ£¸¦ ¹Ù¸£°Ô ÀÔ·ÂÇØÁÖ¼¼¿ä");
	}
}
