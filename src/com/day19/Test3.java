package com.day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test3 {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("클래스명[java.lang.String]: ");//클래스 명 입력시 패키지도 이와 같이 입력해줘야 함  
			String str = br.readLine();
			
			Class cls = Class.forName(str);
			
			//생성자정보
			Constructor<?>[] c = cls.getConstructors(); //제너릭은 안쓸거면 ?로 두면 됨

			System.out.println("생성자.....");
			for(int i=0;i<c.length;i++){
				System.out.println(c[i]);
			}
			
			//필드(변수)정보
			Field[] f = cls.getFields();

			System.out.println("필드.....");
			for(int i=0;i<f.length;i++){
				System.out.println(f[i]);
			}
			
			//메소드 정보
			Method[] m = cls.getMethods();
			
			System.out.println("메소드.....");
			for(int i=0;i<m.length;i++){
				System.out.println(m[i]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
