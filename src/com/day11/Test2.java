package com.day11;

//추상클래스 안에는 무조건 추상메소드가 1개 이상 존재해야 함. 
//일반 메소드만 있다면 에러는 안나지만 추상클래스로 만들 필요가 없음
abstract class SortInt{ //정수를 정렬하는 클래스
	
	private int[] value; //배열을 담을 수 있는 공간만 생성

	protected abstract void sorting(); //추상 메소드
	
	public void sort(int[] value){//매개변수로 배열.

		this.value = value;
		sorting();//sort 메소드안에서 추상메소드 sorting 호출 가능
		//자식은 부모클래스의 것을 사용가능하지만 부모는 자식클래스의 것을 사용할 수 없다.
		//abstract를 쓰면 예외적으로 자식클래스의 것을 사용한다.
		//매소드만은 예외가 없음. 
	}
	
	public int length(){
		
		if(value==null){ //객체생성시 new로 생성. 초기값은 null로 되어있음. 배열 안의 int값은 0. [0,0,0]
			return 0;
		}	
		return value.length; //배열안에 해쉬코드가 들어있다면 배열의길이를 반환
	}

	protected final int compare(int i, int j) { //final메소드 : 자식클래스가 오버라이드 할수없음
		
		//compare가 1이면 오름차순정렬 -1이면 내림차순정렬
		if(value[i]==value[j])
			return 0;
		else if(value[i]>value[j])	//경우의 수 3가지 존재. 필요한 건 31,32줄 코드
			return 1;
		else
			return -1;
	}
	
	protected final void swap(int i , int j) {
		int temp;
		temp = value[i];
		value[i] = value[j];
		value[j] = temp;
	}
	
	public void print() {
		if(value == null){
			return;
		}

		for(int n: value){
			System.out.printf("%4d", n);
		}
		System.out.println();
	}
	
}

class SortTest extends SortInt{
	
	@Override
	protected void sorting() { //Override가 붙으면 자신의 메소드 호출
	
		//Selection sort
		for(int i=0; i<length()-1; i++){
			for(int j=i+1; j<length();j++){
				if(compare(i, j)>0){ //0보다 큰 경우는 return값이 1 일때 밖에 없음. 이때 swap메소드 실행해라
					 swap(i, j);
				}
			}
		}		
	
	}

}

public class Test2 {

	public static void main(String[] args) {

		int value[] = {50,20,6,58,99};
		SortTest ob = new SortTest();
		ob.sort(value);
		ob.sorting();
		ob.print();
		
	}

}
