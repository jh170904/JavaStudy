package com.MyHome;

import java.util.Scanner;

public class Won {
	
	public String priceWon(long price) {
			
		long numi[] = new long[5];
		String num[] = new String[5];
		
		String str="";

		numi[0] = (long)(price / 100000000);
		num[0] = numi[0]+"억";
				
		numi[1] = (long)((price%100000000) / 10000000);
		num[1] = numi[1]+"천";
				
		numi[2] = (long)((price%10000000) / 1000000);
		num[2] = numi[2]+ "백";
				
		numi[3] = (long)((price%1000000) / 100000);
		num[3] = numi[3]+"십";
				
		numi[4] = (long)((price%100000) / 10000);
		num[4] = numi[4]+"만";
				
		for(int i=0;i<5;i++){
			if(!(numi[i]==0))
				str += num[i];
		}
		
		if(numi[4]==0)
			str += "만원";
		
		return str;

	}

}
