package com.MyHome;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.naver2.NaverVO;

public class SearchHome {
	
	private List<MyHomeVO> myhomeLists;
	private String path = System.getProperty("user.dir");
	private File myhomef = new File(path, "\\Myhome.txt");
	
	Scanner sc = new Scanner(System.in);
	
	MyHomeException my = new MyHomeException();
	
	int cnt;
	boolean flag;
	
	public SearchHome(){
		
		try {
			
			//매물정보 유무 확인
			if(!myhomef.getParentFile().exists()){
				myhomef.getParentFile().mkdirs();
			}
			
			if(myhomef.exists()){
				FileInputStream myhomeFis = new FileInputStream(myhomef);
				ObjectInputStream myhomeOis = new ObjectInputStream(myhomeFis);
				
				myhomeLists = (ArrayList<MyHomeVO>)myhomeOis.readObject();
				
				myhomeFis.close();
				myhomeOis.close();
				
			}
			
			if (myhomeLists == null) {// lists가 생성이 안되어 있으면 객체 생성 진행.
				myhomeLists = new ArrayList<MyHomeVO>();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void itemSearch(String item) throws IOException{
		
		cnt=1;
		flag=false;
		
		Iterator<MyHomeVO> it = myhomeLists.iterator();
		
		while(it.hasNext()){
			MyHomeVO vo = it.next();
			
			if(item.equals(vo.getItem())){
				System.out.println(cnt+ "번 매물");
				System.out.println(vo.toString());
				cnt++;
				flag = true;
			}
		}
		
		noHome(flag);
	}
	
	
	public void termSearch(String term) throws IOException{
		
		cnt=1;
		flag=false;
		
		Iterator<MyHomeVO> it = myhomeLists.iterator();
		
		while(it.hasNext()){
			MyHomeVO vo = it.next();
			
			if(term.equals(vo.getTerm())){
				System.out.println(cnt+ "번 매물");
				System.out.println(vo.toString());
				cnt++;
				flag = true;
			}
		}
		
		noHome(flag);
		
	}

	public void localSearch(String local) throws IOException{
	
		cnt=1;
		flag=false;
		
		Iterator<MyHomeVO> it = myhomeLists.iterator();
		
		while(it.hasNext()){
			MyHomeVO vo = it.next();
			
			if(local.equals(vo.getLocal())){
				System.out.println(cnt+ "번 매물");
				System.out.println(vo.toString());	
				cnt++;
				flag = true;
			}
		}
		
		noHome(flag);
		
	}

	public void priceSearch(long price) throws IOException{
	
		cnt=1;
		flag=false;
		
		Iterator<MyHomeVO> it = myhomeLists.iterator();
	
		while(it.hasNext()){
			MyHomeVO vo = it.next();
			long comparep = vo.getPrice();
			
			if((comparep>=(price-50000000)) && ((price+50000000)<=comparep)) {
				System.out.println(cnt+ "번 매물");
				System.out.println(vo.toString());		
				cnt++;
				flag = true;
			}
		}
		
		noHome(flag);
	
	}
	
	public void noHome(boolean flag) {
		
		if(!flag)
			System.out.println("등록된 매물이 없습니다.");
		
	}
}
