package com.day08;

//되부름 함수(재귀함수)
//장점 : 소스가 간단해짐. 소스가 짧음
//단점 : 처리속도가 느림(stack에 저장했다가 출력하기 때문에)

//비정형인수
public class Test4 {

	public void print(int n){		
		if(n!=1){
			print(n-1); //되부름함수, 메소드안에서 함수호출시 자기 자신을 부름	
		}
		System.out.printf("%5d",n);
	}
	
	public int sum(int n){
		//1-10까지의 합
		return n>1 ? n+sum(n-1) : n;
	}
	
	public int pow(int a , int b){
		return b>=1 ? a*pow(a,b-1) : 1;//메소드안에서 자기자신 호출 = 되부름함수
		
	}
	
	//비정형인수
	int sum(int...args){
		
		int sum=0;
/*
 		for(int i=0;i<args.length;i++){
			sum+=args[i];
		}
*/
		for(int su: args){ //확장for문으로도 사용가능
			sum += su;
		}	
		return sum;
	}
	
	public static void main(String[] args) {
		
		Test4 ob = new Test4();
		
		ob.print(5);
		System.out.println();
		
		int s = ob.sum(100);
		System.out.println(s);
		
		System.out.println("pow(2,10): " + ob.pow(2,10));
		
		//비정형인수
		int result;
		result = ob.sum(2,4,6,8,10); //배열 설정시에는 크기를 지정해야 되는데 비정형인수는 정해져 있지않아도 배열처럼 연산가능
		System.out.println(result);
		
		result = ob.sum(1,3,5,7,9,11,13,15,17);
		System.out.println(result);
		
	}

}
