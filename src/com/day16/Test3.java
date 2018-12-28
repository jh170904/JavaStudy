package com.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//역직렬화는 개념을 누구나 꺼낼 수 있음. password와 같은 개념은 그때 그때 물어보게 해야함
//해당 예제에서는 age변수에 transient를 설정하면 -> default 값이 나옴

public class Test3 {

	public static void main(String[] args) {
		
		try {
			
			//직렬화
			FileOutputStream fos = new FileOutputStream("d:\\doc\\score.txt");			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//MyData ob = new MyData("배수지", 30);
			oos.writeObject(new MyData("배수지",25,60));//클래스 객체 생성해서 바로 넣어주려고 오버로딩한 생성자를 만든 것
			oos.writeObject(new MyData("박신혜",29,60));
			oos.writeObject(new MyData("김태리",29,90));
			oos.writeObject(new MyData("천송이",40,80));
			
			oos.close();
			fos.close();
			
			//역직렬화
			FileInputStream fis = new FileInputStream("d:\\doc\\score.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			MyData ob = null;//클래스의 초기값은 null
			
			while(true){
				
				ob = (MyData)ois.readObject();//downcast
				
				if(ob==null){//null이면 더이상 출력할 MyData없음
					break;
				}
				
				System.out.println(ob.toString());
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
