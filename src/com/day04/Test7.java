package com.day04;

public class Test7 {
	
	public static void main(String[] args) {
		
		//123456789
		//1234 6789
		//123   789
		//12     89
		//1       9
		//---------
		//12    @@12         a=0+1     <    b=0 b=1
		//123   @123         a=1+1     <    b=0     
		//1234  1234         a=2+1         
		//12345 1234         a=3+1         
		
        //a:행, b:왼쪽별, C:오른쪽별
		for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                System.out.print(b < 5 - a ? "*" : " ");
            }
            for (int c = 0; c < 4; c++) {
                System.out.print(c >= a - 1 ? "*" :" ");
            }
            System.out.println();
        }
        
        
        for (int a = 0; a<4; a++) {
            for(int b = 0; b<5; b++) {
                System.out.print(a+1>=b?"*":" ");
            }
            //a=0+2        >=    b=4 b=3 b=2 b=1            XXOO
            //a=1+2        >=    b=4 b=3 b=2 b=1            XOOO
            //a=2+2        >=    b=4 b=3 b=2 b=1            OOOO
            //a=3+2        >=    b=4 b=3 b=2 b=1            OOOO
            for(int c = 4; c > 0; c--) {
                System.out.print(a+2>=c?"*":" ");
            }
            System.out.println();
        }
		
		
	}

}
