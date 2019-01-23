package day06;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Sol2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = Integer.toBinaryString(n).split("[0]+");
        int max = 0;
        
        for (String s : arr) {
        	if (s.length() > max)
        		max = s.length();
            }
        
        System.out.println(max);
        
    }
}
