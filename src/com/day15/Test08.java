package com.day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test08 {
	
	public boolean flieCopy(String file1, String file2){
		
		File f = new File(file1);//파일 경로에 대한 정보
		
		if(!f.exists()){//해당 파일 없으면 종료
			return false; 
		}
		
		try {
			FileInputStream fis = new FileInputStream(f);//f, file1 뭘 써도 상관 없음. f에 file1를 넣어놨기 때문
			FileOutputStream fos = new FileOutputStream(file2);
			
			//**버퍼를 사용해서 while문 쓰는 건 자주 사용**
			int data;
			byte[] buffer= new byte[1024];//1024byte크기의 버퍼 생성	
			
			while((data=fis.read(buffer, 0, 1024))!=-1){//해당 범위에 있는 버퍼의 데이터를 0번째부터 1024번째까지 모두 읽어라
				fos.write(buffer, 0, data); 			//data는 byte
			}
			fis.close();
			fos.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
			
		Test08 ob = new Test08();
		Scanner sc= new Scanner(System.in);
		
		String file1, file2;
		
		System.out.print("원본파일?:");
		file1 =sc.next();
					
		System.out.print("대상파일?:");
		file2 =sc.next();
		
		if(ob.flieCopy(file1, file2)){
			System.out.println("파일 복사 성공!");
		}else{
			System.out.println("파일 복사 실패!");
		}

		sc.close();
	}

}
