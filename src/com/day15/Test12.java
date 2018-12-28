package com.day15;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//[File 클래스]
//파일 및 폴더를 관리할 수 있도록 기능을 제공해주는 클래스
//파일의 복사 또는 이름 변경 등의 조작을 할 경우에만 사용되고
//파일의 내용을 입출력하는 메소드는 제공되지 않는다.(내용 수정 불가)

public class Test12 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("d:\\doc\\test.txt");//f가 경로,파일명,내용까지 앎. 기본경로에 있는 파일을 이용할 경우 file이름으로 설정.
		
		// \\.. 상위디렉토리 
		//getAbsolutePath() : 실행 위치 또는 드라이브를 기반으로 경로를 해결합니다.
		//getCanonicalPath() : 시스템 의존한다. 경로가 나타내는 고유 한 위치가 해결됩니다. 따라서 경로에 "."이 있으면 일반적으로 제거됩니다.
		
		System.out.println("파일정보.............");
		System.out.println("파일명: " + f.getName());
		System.out.println("파일크기: " + f.length());//파일길이
		System.out.println("파일경로: " + f.getAbsolutePath());
		System.out.println("표준경로: " + f.getCanonicalPath());
		System.out.println("만든날: " + new Date(f.lastModified()));//lastModified() f의 마지막으로 변경된 일자
		System.out.println("파일상위경로: " + f.getParent());
		System.out.println("읽기속성: " + f.canRead());
		System.out.println("쓰기속성: " + f.canWrite());
		
		//현재 작업경로
		String path = System.getProperty("user.dir");//user.dir는 시스템 변수. 
		System.out.println("현재 작업경로 : " + path);//이클립스가 실행되는 현재 작업경로 뜸
		
	}

}
