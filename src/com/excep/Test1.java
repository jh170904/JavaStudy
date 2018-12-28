package com.excep;

//사용자정의 에러를 만드는 방법
public class Test1 {

	private int value;//전역변수. default값 0
	
	public void setValue(int value) throws MyException{
		
		if(value<0){
			throw new MyException("수는 0보다 작을수가 없다.");
			
		}else{
			this.value =value ; 
		}	
	}
	
	public int getValue(){
		return value;
	}
	
	public static void main(String[] args) {

		Test1 ob = new Test1();
		
		try {
			
			ob.setValue(-20);
			
		} catch (MyException e) {
			System.out.println(e.toString());
			System.out.println("-----------------------------");
			//e.printStackTrace();
		}
		System.out.println(ob.getValue());
	}

}
