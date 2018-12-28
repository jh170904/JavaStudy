package com.score1;

import java.util.Scanner;

public class Score {
	
	int inwon ;
	
	//int[] inwon = new int[3] //instance변수. 배열
	//idx : 0 1 2
	//{정수,정수,정수}
	
	Record[] rec;//Record라는 데이터 타입의 변수를 저장할 수 있는 rec 배열 생성. Class를 자료형이라고 생각. 
				 //{name, str[3], tot, ave, rank}를 저장할 수 있는 자료형
	
	//Record[] rec = new Record[3];
	//배열로도 class활용해서 만들 수 있음. 레코드 클래스 형태의 데이터가 배열로 만들어짐.
	//idx : 0 1 2
	//{[name, score[3], tot, ave, rank], [name, score[3], tot, ave, rank], [name, score[3], tot, ave, rank]}
	//{record의 첫번째 주소,record의 두번째 주소,record의 세번째 주소 }
	
	//첫번째로 만든 rec의 이름을 호출하고 싶다 : rec[0].name
	//세번째로 만든 rec의 수학점수를 호출하고 싶다 : rec[2].score[1]
	//두번째로 만든 rec의 총점을 호출하고 싶다 : rec[1].tot
	
	
	Scanner sc = new Scanner(System.in);
	//한번에 set()과 input()을 동시에 실행할 수 없으므로 밖으로 빼놔서 동일하게 사용해도 문제 없음
		
	public void set(){
			
		do{
			System.out.print("인원수?");//3
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		rec = new Record[inwon]; //객체를 생성해서 배열안에 주소를 넣음. inwon크기의 배열이 만들어짐
		
	}
	
	public void input(){
		
		String[] title = {"국어","영어","수학"};
		
		
		for(int i=0;i<inwon;i++){
		
			rec[i] = new Record(); //Record의 주소를 담을 수 있는 배열을 생성한 것. 인원수에 따른 객체 생성. 반복문 안에 있어야 함
		
			//rec[i] 스택영역 / new Record() heap영역
			//{Record주소, Record주소, Record주소} 
			System.out.print("이름?");//이름
			rec[i].name =sc.next();
			
			for(int j=0;j<3;j++){

				System.out.print(title[j]);
				rec[i].score[j] =sc.nextInt();//국영수
				rec[i].tot += rec[i].score[j];//총점 		
			}			
			
			rec[i].ave = rec[i].tot/3;//평균
			
		}
		
	}
	
	private void ranking(){ //반환값 없음. 	
		int i, j;
		for(i=0;i<inwon;i++){
			rec[i].rank = 1; //전부 다 1로 초기값 설정	
		}
		
		for(i=0;i<inwon-1;i++){
			for(j=i+1;j<inwon;j++){
				if(rec[i].tot >rec[j].tot){
					rec[j].rank++;					//점수가 작은 쪽에 순위 +1				
				}else if(rec[i].tot<rec[j].tot){
					rec[i].rank++;					//점수가 작은 쪽에 순위 +1
				}
			}
		}		
		
	}

	public void print(){
		
		ranking(); //print 메소드에서 ranking 메소드를 호출할 수 있다. 외부로 유출되지 못하므로 같은 클래스안에서 호출
		
		for (int i = 0; i < inwon; i++) {
			System.out.printf("%6s", rec[i].name);
			for (int j = 0; j < 3; j++) {
				System.out.printf("%4d", rec[i].score[j]);
			}
			System.out.printf("%4d", rec[i].tot);
			System.out.printf("%4d", rec[i].ave);
			System.out.printf("%4d", rec[i].rank);
			System.out.println();
		}		
		
	
	}
	

}
