package com.day15;

import java.io.File;
import java.io.FileOutputStream;

//실행 후 문자를 입력하면 폴더와 함께 파일이 생성됨

public class Test13 {

	public static void main(String[] args) {

		String str = "d:\\doc\\java\\stream\\text.txt";
		//idx		  012 3456 78901 2345678 90			
		
		//[방법1]
		String path = str.substring(0, str.lastIndexOf("\\"));
		//System.out.println(path); 	//d:\doc\java\stream 눈으로 보기엔 \\두개지만 컴퓨터에서는 \로 인식됨
		
		File f = new File(path);
		
		if(!f.exists()){//f가 없으면 디렉토리를 만들어라. Creates the directory named by this abstract pathname.
			f.mkdirs();
		}
		
		//----------------------------------------------------------
		//[방법2]		
/*		
  		File d = new File(str);
		if(!f.getParentFile().exists()){ //f가 없으면 디렉토리를 만들어라 
			d.getParentFile().mkdirs();
		}
*/		
		try {
			
			FileOutputStream fos = new FileOutputStream(str);
			System.out.print("문자열 입력:");
			
			int data;		//유니코드(아스키코드)로 읽으니까 int형
			while((data=System.in.read())!=-1){
				fos.write(data);
				fos.flush();
			}
			
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
