package com.day15;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//DataOutputStream
//DataInputStream
//boolean, byte, char등의 자료형을 직접 읽을 수 있게 해주고
//이러한 읽기 동작은 사용하는 플랫폼과는 무관하게 동작한다.

public class Test19 {

	public static void main(String[] args) {

		try {
			
			//파일을 읽기 위해서 반드시 필요 : FileInputStream
			//파일을 만들기 위해서 반드시 필요 : FileOutputStream
			
			//DataInputStream. 텍스트파일을 열면 깨져서 보이지만 내용은 잘 저장된것. os가 달라도 잘 읽음
			FileOutputStream fos = new FileOutputStream("d:\\doc\\data.txt");//file 내보내라
			DataOutputStream dos = new DataOutputStream(fos); //한번더 DataOutputStream으로 감싸준것. 그 데이터 타입대로 저장해라
			
			dos.writeUTF("대한민국");
			dos.writeByte(10);
			dos.writeChar('A');
			dos.writeInt(20);
			dos.writeUTF("서울");
			
			fos.close();
			dos.close();
			
			FileInputStream fis = new FileInputStream("d:\\doc\\data.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			//위의 순서대로 호출
			System.out.println(dis.readUTF());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			
			fis.close();
			dis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
	}

}
