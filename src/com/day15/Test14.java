package com.day15;

import java.io.File;
import java.io.FileFilter;

//FileFilter 인터페이스 : 폴더의 전체를 보여주는 역할을 함
class MyFileList implements FileFilter{

	private File f;
	//Spring 의존성주입
	public MyFileList(String filePath) {//생성자에서 특정 파일의 객체를 생성할 수 있음. 중요
		f = new File(filePath);//파일경로를 입력받아 파일 f 객체 생성
	}
	
	public void result(){
		
		try {
			
			if(!f.exists()){//파일 없으면 메세지 띄우고 종료.
				System.out.println("파일이 없습니다.");
				return;
			}
			
			System.out.println("절대경로: " + f.getAbsolutePath());
			System.out.println("파일사이즈: " + f.length());

			//디렉토리(폴더)인 경우 실행
			if(f.isDirectory()){//isDirectory메소드. boolean반환. 있으면 T, 없으면 F
			
				//File[] : D드라이브를 클릭 했을때 폴더 다양. 폴더를 배열에다 넣어놓은 개념  
				//accept메소드에서 FileFilter 인터페이스로 리턴할 대상을 지정
				File[] lists = f.listFiles(this);	//accept메소드를 통해 저장된 내용이 this에 있음
				
				System.out.println("\n폴더의 내용.........");

				for(int i=0;i<lists.length;i++){
					System.out.print(lists[i].getName());
					System.out.println("\t" + lists[i].length());
				}
			
			}
			
			System.out.println("\n디렉토리 구조....");
			
			File[] root = File.listRoots();//File클래스의 static메소드 : listRoots
			
			for(int i=0;i<root.length;i++){
				System.out.println(root[i].getPath());
			}
			//C:
			//D: 형식으로 보여줄 것
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	@Override
	public boolean accept(File pathname) {	//accept()메소드 호출하지 않아도 스스로 실행됨. 하드디스크에 가서 사용자가 입력한 파일과 폴더의 내용을 받음. 받아서 this에 리턴값 반환.
		return pathname.isFile() || pathname.isDirectory() ;
	}
	
}

public class Test14 {

	public static void main(String[] args) {
		MyFileList m = new MyFileList("c:\\windows");
		m.result();
	}

}
