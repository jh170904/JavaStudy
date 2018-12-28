package com.day19;

//Class 클래스 : 다른 클래스에 대한 클래스 정보를 가져옴 

class Test{
	
	public void write(){
		System.out.println("테스트....");
	}
	
}

public class Test2 {

	public static void main(String[] args)  {
		
		try {
			Class c = Class.forName("com.day19.Test");//Class클래스는 메소드가 하나 > forName
			Object ob = c.newInstance();
			Test t = (Test)ob;
			t.write();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
