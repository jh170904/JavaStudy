package com.level1.day03;

import java.util.HashMap;
import java.util.Iterator;


//함수에 입력되는 시간은 12시간 표기법으로 am,pm으로 표기된다.
//첫번째 시간에서 두번째 시간이 될 때까지 걸리는 시간을 구하라.
public class Solution08 {
	public int[] changeTimetoIntArr(String time){
		time = time.replaceAll(" ","");//
		String stringTime[] = new String[3];
		stringTime = time.substring(2).split(":");
		int intTime[] = new int[3];
		
		for(int i=0; i<3; i++){
			intTime[i] = Integer.parseInt(stringTime[i]);
		}
		
		//오후일 경우 12시 더해서 int배열로 변환
		if(time.substring(0, 2).equals("PM")){
			intTime[0] += 12;
		}
		return intTime;
	}
	
	public String solution(String start, String end){
		String answer = "";
		int endTime[] = changeTimetoIntArr(end);
		int startTime[] = changeTimetoIntArr(start);
		int result[] = {0,0,0};
		
		for(int k=2;k>0;k--){
			result[k] += endTime[k] - startTime[k];
			if(result[k]<0){
				result[k-1]--;
				result[k] += 60;
			}
		}
		
		result[0] = endTime[0] - startTime[0];
		if(result[0]<0){
			result[0] += 24;
		}
		
		for(int i=0; i<3; i++){
			if(result[i]<10){
				answer += "0"+result[i];
			}else{
				answer += result[i];
			}
			if(i!=2)
				answer +=":";
		}
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		Solution08 gapCalculator = new Solution08();
		String start = "AM 01:30:50";
		String end = "PM 05:00:00";
		gapCalculator.solution(start, end);
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();		
		System.out.println("----------------------------");
		
	}
}
