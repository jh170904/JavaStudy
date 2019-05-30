package day08;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;

	Difference(int a[]){
        this.elements = a;
    }
    public void computeDifference(){
        int result;
        for(int i=0; i<elements.length; i++){
            for(int j=1;j<elements.length; j++){
                result = Math.abs(elements[i]-elements[j]);
                if(result> maximumDifference)
                	maximumDifference = result;
            }
        }
    }
} // End of Difference class

public class Sol1 {

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
