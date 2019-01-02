package com.MyHome;

public class Won {
	
	public String priceWon(long price) {
			
		long numi[] = new long[5];
		String num[] = new String[5];
		
		String str="";

		numi[0] = (long)(price / 100000000);
		if(!(numi[0]==0))
			str += numi[0]+"억";
		
		numi[1] = (long)((price%100000000) / 10000000);
		if(!(numi[1]==0))
			str += numi[1]+"천";
				
		numi[2] = (long)((price%10000000) / 1000000);
		if(!(numi[2]==0))
			str += numi[2]+ "백";
				
		numi[3] = (long)((price%1000000) / 100000);
		if(!(numi[3]==0))
			str += numi[3]+"십";
				
		numi[4] = (long)((price%100000) / 10000);
		if(!(numi[4]==0))
			str += numi[4]+"";
		
		
		if(numi[1]==0 && numi[2]==0 && numi[3]==0 && numi[4]==0)
			str += "원";
		else
			str += "만원";
		
		
		return str;

	}

}
