/*
지난주 리뷰
 [자료형]
 
 boolean 1byte true/false
 
 byte : 1byte -128~127
 
 int : 4byte
 long : 8byte
 
 10진수:10
 8진수:016
 16진수:0x17
  
 단정도(float):3.14f
 배정도(double):3.14
  
 char:문자상수('a')
 UTF-16
 
 [연산자]
  
  산술연산자
  +,-,*,/,%,++,--
  
  관계형연산자
  >,>=,<,<=: 결과(true, false)
  
  등가연산자
  ==,!=
  
  논리연산자 
  &&(and),||(or)
  
  비트단위 - 2진수 사용할때 씀
  &,|,^,~,>>,<<,>>>
  
  삼항연산자
  조건 ? 참값 : 거짓값

  대입연산자
  =, +=, -=, *=, /=
  ----------------------------------------
  
int a=10; 
double b; //초기화 안시켜서 쓰레기값 들어있음

b=a;			//암시적 형변환
b=(double)a;	//명시적 형변환 

a=b;			//형변환을 하라고 오류 메세지 뜸
a=(int)b;		//명시적 형변환

//부모클래스, 자식클래스의 상속 개념시 형변환 작업 많이 필요하므로 꼭 이해.

  --------------------------------------------

if(조건){
작업
}

if(조건){
작업1
}else{
작업2
}

if(조건){
작업1
}else if(조건2){
작업2
}
 
if(조건1){
작업1
}else if(조건2){
작업2
}else if(조건3){
작업3
}else{
작업4
}

while(조건){
증가값
작업
}
  
do{
작업
}while(조건);

for(시작값;최대값;증가값){
작업
}

 */

package com.day04;

public class Test1 {

	public static void main(String[] args) {

		int i, j;

/*
		 //행의 수 5개
		 for(i=1;i<=5;i++){
		 
		 //j는 5-i번까지 공백을 찍음 
		 for(j=1;j<=5-i;j++){ 
		 	System.out.print(" ");//공백한칸
		 }
		 
		 //j는 i번 별을 찍어라 
		 for(j=1;j<=i;j++){ 
		 	System.out.print("*"); 
		 	}
		
		 System.out.println();//줄바꿈 
		 }

*/
/*
		 //행의 수 5개 for(i=1;i<=5;i++){
		  
		 //j는 5-i번까지 공백을 찍음. 위의 예제와 공백개수는 동일 for(j=1;j<=5-i;j++){
		 System.out.print(" ");//공백한칸 }
		  
		 //j는 2i-1번 별을 찍어라. 어떠한 수든 2*x-1은 홀수가 나온다. for(j=1;j<=i*2-1;j++){
		 System.out.print("*"); }
		  
		 System.out.println();//줄바꿈 }
*/

/*
		 for(i=5;i>=1;i--){//i=i-1
		   
		 	for(j=1;j<=5-i;j++){ 
		 	System.out.print(" ");//공백한칸 
		 }
		 
		 	for(j=1;j<=i*2-1;j++){ 
		 	System.out.print("*"); 
		 }
		  	System.out.println();//줄바꿈 
		  
		 }
*/

		// 모래시계
		for (i = 5; i >= 1; i--) {// i=i-1

			for (j = 1; j <= 5 - i; j++) {
				System.out.print(" ");// 공백한칸
			}

			for (j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}

			System.out.println();// 줄바꿈
		}

		for (i = 2; i <= 5; i++) {

			// j는 5-i번까지 공백을 찍음. 위의 예제와 공백개수는 동일
			for (j = 1; j <= 5 - i; j++) {
				System.out.print(" ");// 공백한칸
			}

			// j는 2i-1번 별을 찍어라. 어떠한 수든 2*x-1은 홀수가 나온다.
			for (j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}

			System.out.println();// 줄바꿈
		}

	}

}
