package com.day16;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

//객체의 직렬화 : DB개념이 나오기전에는 파일을 모두 이와 같이 저장함
//메모리에 생성된 클래스를 객체의 멤버변수의 현재 상태를 
//그대로 보존해서 파일에 저장하거나 네트워크를 통해 전달할 수 있는 기능
//오로지 바이트 단위로만 데이터를 송수신 가능하다.

//장점은 객체 자체의 내용을 입출력 형식에 구애받지 않고
//객체를 저장함으로써 영속성(프로그램을 종료해도 저장되어 있음)을 제공할 수 있고 
//객체 자체를 네트워크를 통해서 손쉽게 교환할 수 있다.

//implements Serializable(인터페이스)로 구현(단, 메소드가 없다). 선언만 하면 됨

//컬렉션은 기본적으로 Serializable 구현된 인터페이스로 지님.
//그래서 아래 코드에 구현 내용이 없어도 가능
public class Test1 {

	public static void main(String[] args) {
		
		try {
			
			//Map 생성
			Hashtable<String, String> h = new Hashtable<String, String>();
			
			h.put("1", "배수지");
			h.put("2", "김태리");
			h.put("3", "천송이");//직렬화
			
			//아웃풋파일 생성(파일은 character방식이라 h를 바로 넣을 수 없음. 유니코드로 된 데이터만 가능)
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out7.txt");
			
			//파일을 메모리상에 있는 binary 형식으로 저장.
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(h);//upcast. 클래스는 데이터 타입이 Object
			
			oos.close();
			fos.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
