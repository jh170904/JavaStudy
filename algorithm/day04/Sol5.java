package day04;

import java.io.*;
import java.util.*;

public class Sol5 {

    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String[] word = new String[2];
        String[] str = new String[i];
        
        for(int k=0;k<i;k++){
             str[k] = sc.next();
        }

        for(int k=0;k<i;k++){            
            word[0] = word[1] = "";
            for(int j=0;j<str[k].length();j++){
            
                if(j%2==0){
                    word[0] += str[k].substring(j, j+1);
                }else{
                    word[1] += str[k].substring(j, j+1);
                }
            }
            System.out.println(word[0]+" "+word[1]);   
            
        }}
}

