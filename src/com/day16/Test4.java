package com.day16;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//Externalizable: Serializable 인터페이스에 하위 인터페이스
//같은 기능을 하되 좀 더 완벽한 제어가 가능함
//writeExternal(), readExternal() 메소드를 정의해야 함
//Externalizable보다 Serializable을 많이 사용하긴 함 

class DataTest implements Externalizable{

	String name;
	int age;
	
	public DataTest(){}//기본생성자
	
	public DataTest(String name, int age){//오버로딩된 생성자
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + ":" + age;
	}
	
	//호출 하지 않아도 자동적으로 실행되는 메소드 : readExternal(), writeExternal()
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		
		name = (String)in.readObject();//downcast
		age = in.readInt();//downcast 안해도 됨. 메소드에서 정수형으로 반환
		System.out.println("readExternal....");
	
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		out.writeObject(name);
		out.writeInt(age);
		System.out.println("writeExternal....");
	
	}
	
}

public class Test4 {
	
	public static void main(String[] args) {
		try {
			
			DataTest ob = new DataTest("배수지", 25);//넣을 땐 오버로딩된 생성자로 객체 생성.
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out8.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ob);
			
			fos.close();
			oos.close();
			
			FileInputStream fis = new FileInputStream("d:\\doc\\out8.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);//직렬화 되었기 때문에 ObjectInputStream로 감싸줘야함
			
			DataTest ob1 = (DataTest)ois.readObject();//꺼낼 때는 기본생성자로! 
			
			System.out.println(ob1.toString());
			
			fis.close();
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
