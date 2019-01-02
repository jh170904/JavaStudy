package day02;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Sol4 {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float cnt0 = 0;
        float cntP = 0;
        float cntN = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]>0)
                cntP++;
            else if(arr[i]<0)
                cntN++;
            else
                cnt0++;
        }
        System.out.println(cntP/arr.length);
        System.out.println(cntN/arr.length);
        System.out.println(cnt0/arr.length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
