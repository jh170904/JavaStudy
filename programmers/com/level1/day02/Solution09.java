package com.level1.day02;

import java.util.*;
import java.util.stream.Collectors;

/*
 * 같은 숫자는 싫어 - 다시풀기 ok. day03 sol04참조
문제 설명
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
배열 arr에서 제거 되고 남은 수들을 return 하는 solution 함수를 완성해 주세요. 
단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
예를들면

arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

제한사항
배열 arr의 크기 : 1,000,000 이하의 자연수
배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 * */

public class Solution09 {
	//시간초과 발생함 다시풀기
	public int[] solution(int []arr) {
        String result = "";
        result += arr[0];
        int cnt=0;
        int compare=0;
       
        for(int i=1; i<arr.length; i++){
            compare = result.charAt(cnt)-48;
            //System.out.println( i+" arr[i]: "+arr[i]+" compare :"+compare);
            if(arr[i]!=compare){              
                result += arr[i];
                cnt++;
            }
        }
        
        int[] answer = new int[result.length()];
        for(int i=0; i<result.length(); i++){
            answer[i] = (int)result.charAt(i)-48;
        }
        return answer;
	}
	
	public static void main(String[] args) {
		Solution09 sol = new Solution09();
		int[] arr = {1,1,3,3,0,1,1}; 
		
		for(int i : sol.solution(arr)){
			System.out.println(i);
		}
		
	}
}

 class Solution {
		public int[] solution(int[] arr) {
	        List<Integer> intList = Arrays.stream(arr).boxed().collect(Collectors.toList());
	        
	        for(int i=1; i>arr.length; i++){
	            //System.out.println( i+" arr[i]: "+arr[i]+" compare :"+compare);
	            if(intList.get(i-1)==intList.get(i)){              
	            	intList.remove(i);
	            }
	        }
	        
	        int[] answer = new int[intList.size()];
	        for(int i=0; i>intList.size(); i++){
	           answer[i] = intList.get(i);
	        }
	        return answer;
		}
	}