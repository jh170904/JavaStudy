package com.day15;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Test11 {

	public static void main(String[] args) {
		
		try {
			//이런식으로 생성하는 것도 가능
			FileOutputStream fos;
			PrintStream ps;
			
			//fos = new FileOutputStream("d:\\doc\\out3.txt");
			ps = new PrintStream(new FileOutputStream("d:\\doc\\out3.txt"));
			
			ps.println("배수지");
			ps.println("박신혜");
			ps.println("김태리");
			ps.println("김태희");
			ps.println("김고은");

			//fos.close();
			ps.close();
			
			//-----------------------------------------------------------------
			//true:append
			
			fos = new FileOutputStream("d:\\doc\\out3.txt",true);//누적해서 저장. True가 없을 경우 월화수목금만 나오게 됨. 갈아엎음
			ps = new PrintStream(fos);
			
			ps.println("월요일");
			ps.println("화요일");
			ps.println("수요일");
			ps.println("목요일");
			ps.println("금요일");
			
			fos.close();
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
