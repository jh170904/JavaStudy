package day08;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sol3 {


	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try {
    		Pattern p;
    		p = Pattern.compile(".*[a-z].*");
    		
    		Matcher m = p.matcher(S);
    		if(!m.matches()){
    			System.out.print(Integer.parseInt(S));
    		}else{    		
				throw new Exception("Bad String");
    		}
		} catch (Exception e) {
			 System.out.println("Bad String");
		}


    }
}
