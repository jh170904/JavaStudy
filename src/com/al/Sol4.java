package com.al;

import java.util.Scanner;
import java.util.TreeMap;

public class Sol4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		int i = sc.nextInt();
		int cnt = sc.nextInt();
		do{
			int max=0;
			TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
			int[] arr = new int[1000];
			
			for(int j=0;j<1000;j++){
				arr[i] = sc.nextInt();
			}
			
			for(int k=0; k<=100; k++){
				if(map.get(k)>max){
					max = k;	
				}	
			}
			System.out.println("#"+cnt+" "+max);
			cnt++;
			
		}while(cnt<=i);
	
	}

}
