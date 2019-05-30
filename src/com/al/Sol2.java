package com.al;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
  	
  	Difference(int[] elements){
  		this.elements = elements;
  	}

	public void computeDifference() {
		
		int result;
		
		for(int i=0; i<elements.length-1; i++){
			for(int j=1; j<elements.length-2;i++){
				result = elements[i] - elements[j];
				
				if(result<0)
					result = Math.abs(result);
			
				if(result>maximumDifference)
					maximumDifference = result;
			}
		}
		
	}
	
} // End of Difference class

public class Sol2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}