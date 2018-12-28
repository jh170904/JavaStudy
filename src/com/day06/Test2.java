package com.day06;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

/*
 		주민등록번호 검증 
		jumin : 801112-1234567
		check : 234567 892345 고유값 체크값 존재	
		제일 마지막 값은 확인값으로 체크값 없음
		합 = (8*2)+(0*3)+(1*4)+...+(6*5) 세로로 곱해서 합을 구함
		n = 11 - 합%11
		n = n % 10
		n == 7(주민등록번호의 마지막값) 일치한다면 주민등록번호는 정상.
*/		
		Scanner sc = new Scanner(System.in);
		
		String jumin;
		int[] chk = {2,3,4,5,6,7,8,9,2,3,4,5};
		int i, tot, su;
		
		System.out.print("주민등록번호[xxxxxx-xxxxxxx]를 입력하세요. : ");//801112-1234567 최소14자리
		jumin = sc.next();
		
		if(jumin.length()!=14){
			System.out.printf("다시 입력하세요");
			//System.exit(0); //콘솔 프로그램을 종료하는 명령어. main을 나가버림. 0값은 yes로 인식
			return; //stop. 반환값없음. 여기까지만 실행해라. 아랫부분은 실행되지 않음. 순차적으로 나감. 
		}
		
		tot=0;		
		//index : 01234567890123 배열에 넣는 순간 일렬로 인덱스가 부여된다.
		//jumin : 801112-1234567
		//check : 234567 892345	
		
		for(i=0;i<12;i++){ // '-'와 맨마지막숫자 제외하고 비교라서 12번 반복.  
			if(i>=6){
				tot+=chk[i]*Integer.parseInt(jumin.substring(i+1,i+2));	// '-' 때문에 구분. 주민번호 뒷자리
			}else{ 
				tot+=chk[i]*Integer.parseInt(jumin.substring(i,i+1));	//생년월일
			}
		}
		
		su = 11 - tot % 11;
		su = su % 10;
		if(su == Integer.parseInt(jumin.substring(13))){// jumin.substring(13) : 13번째부터 끝까지 
			System.out.println("정확한 주민번호!");
		}else{
			System.out.println("틀린 주민번호!");
		}	
		sc.close();
	}

	private static void extracted() {
		return;
	}

}

/*		
	String str = "seoul korea"; //String클래스의 method중 substring사용. 문자 추출
				//012345678910 고유인덱스
	System.out.println(str.substring(0, 3));
	System.out.println(str.substring(6, 8));
	//Returns a string that is a substring of this string. 
	//The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. 
	//API 확인하면 endIndex입력시 -1 해줘야 함을 알수있음
	
	System.out.println(str.substring(6)); //인덱스 6부터 끝까지

*/