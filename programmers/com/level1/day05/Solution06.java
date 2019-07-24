package com.level1.day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * 문자열 내 마음대로 정렬하기
문제 설명
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 
각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.

제한 조건
strings는 길이 1 이상, 50이하인 배열입니다.
strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
모든 strings의 원소의 길이는 n보다 큽니다.
인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
입출력 예
strings	n	return
[sun, bed, car]	1	[car, bed, sun]
[abce, abcd, cdx]
 * */

public class Solution06 {

	public String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
		int cnt = 0;
		for (int i = 0; i < strings.length; i++) {
			hm.put(i, strings[i].charAt(n-1));
		}
		
		Iterator it = sortByValue(hm).iterator();
        
        while(it.hasNext()){
            int idx = (Integer)it.next();
            //System.out.println(idx + " = " + hm.get(idx));
            answer[cnt++] = strings[idx];
        }

		return answer;
	}
	
    public static List<String> sortByValue(final Map map){
        List<String> list = new ArrayList<String>();
        list.addAll(map.keySet());
         
        Collections.sort(list,new Comparator(){
             
            public int compare(Object o1,Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                 
                return ((Comparable) v1).compareTo(v2);
            }
             
        });
        
        return list;
    }
    
    public static void main(String[] args) {
    	Solution06 s = new Solution06();
    	String strings[] = {"sun", "bed", "car"};
    	String answer[] = s.solution(strings, 2);
    	for(String str : answer){
    		System.out.print(str + " " );
    	}
	}

}