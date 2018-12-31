package com.day06;

public class Test1 {

	public static void main(String[] args) {
/*
		버블정렬 : 가장 이웃한 수와 비교하여 정렬
		{30, 25, 20, 15, 7} : 초기값
		25 30 20 15 7
		25 20 30 15 7
		25 20 15 30 7
		25 20 15 7 30 ------ 1회전(가장 큰값 제일 끝으로)
		20 25 15 7 30
		20 15 25 7 30
		20 15 7 25 30 ------ 2회전
		15 20 7 25 30
		15 7 20 25 30 ------ 3회전 
		7 15 20 25 30 ------ 4회전
		
		j num i=1
		0 1 
		1 2
		2 3 
		3 4 
		----- i=2
		0 1 
		1 2
		2 3 
		----- i=3
		0 1 
		1 2
		----- i=4
		0 1 
		종료
		
*/
		//선언
		int[] num = {30,27,20,15,7};
		int temp, i, j;
		
		System.out.print("Source data: ");
		for(int su: num){
			System.out.printf("%4d",su);
		}
		System.out.println();
		
		//Bubble Sort : 이웃하는 수끼리 비교
		for(i=1;i<num.length;i++){
			for(j=0;j<num.length-i;j++){
				//System.out.println(i +":"+ j); //인덱스 조회
				if(num[j]>num[j+1]){
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;			
				}
			}
		}
		
		//출력
		System.out.print("Sorted data: ");
		for(i=0; i<num.length;i++){
			System.out.printf("%4d",num[i]);
		}
		
	}//endmain
}//endclass
