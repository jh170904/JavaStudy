package com.MyHome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MyHomeImpl implements MyHome {
	
	private List<JoinVO> joinLists;
	private List<MyHomeVO> myhomeLists;
	private String path = System.getProperty("user.dir");
	private File joinf = new File(path,"\\Join.txt");
	private File myhomef = new File(path,"\\Myhome.txt");
	Scanner sc = new Scanner(System.in);
	int s;
	int s2;
	int w;
	int w2;
	
	MyHomeException my = new MyHomeException();
	Find find = new Find();
	Won won = new Won();
	
	public MyHomeImpl() {
		
		try {
			
			//회원가입 정보 유뮤 확인
			if(!joinf.getParentFile().exists()){
				joinf.getParentFile().mkdirs();
			}
			
			if(joinf.exists()){
				FileInputStream joinFis = new FileInputStream(joinf);
				
				ObjectInputStream joinOis = new ObjectInputStream(joinFis);
				
				joinLists = (ArrayList<JoinVO>)joinOis.readObject();
				joinFis.close();
				joinOis.close();
				
			}
			
			//매물정보 유뮤 확인
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
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
public boolean login(String id, String pw) {
		
		boolean idCheck=false;
		boolean pwCheck=false;
		
		try {
			
			Iterator<JoinVO> it = joinLists.iterator();
			
			while(it.hasNext()){
				JoinVO vo = it.next();
				
				if(id.equals(vo.getId()))
					idCheck=true;
				
				if(pw.equals(vo.getPw()))
					pwCheck=true;
			}
			
			if(!idCheck)
				my.loginCheck(id);
		
			if(!pwCheck)
				my.pwCheck(pw);
			
			if(idCheck && pwCheck)
				return true;
			
		} catch (AuthenException e) {
			System.out.println(e.toString());
			return false;
		}
			
		return true;
		
	}
	@Override
	public void iteminput(String id) {
		
		JoinVO vo1 = new JoinVO();
		MyHomeVO vo = new MyHomeVO();

		do{
			w=0;
			System.out.println("주거형태를 입력하시오\n");
			System.out.println("1.아파트 2.빌라 3.상가 4.토지");
			s = (sc.nextInt());
			
			switch (s) {
			case 1:
				vo.setItem("아파트"); 
				w++;
				break;
			case 2:
				vo.setItem("빌라"); 
				w++;
				break;
			case 3:
				vo.setItem("상가"); 
				w++;
				break;
			case 4:
				vo.setItem("토지"); 
				w++;
				break;
			default:
				w=0;
			}
	

		}while(w<=0);
		
		do{
			w=0;
			System.out.println("주거형태를 고르시오\n");	
			System.out.println("1.전세 2.월세 3.매매");
			
			s = (sc.nextInt());
			
			switch (s) {
			case 1:
				vo.setTerm("전세");
				w++;
				break;
			case 2:
				vo.setTerm("월세"); 
				w++;
				break;
			case 3:
				vo.setTerm("매매"); 
				w++;
				break;
			default:
				w=0;
				break;
			}	

		}while(w<=0);
		
		System.out.print("지역?");
		vo.setLocal(sc.next());
		
		System.out.print("가격?");
		vo.setPrice(sc.nextLong());	
		
		//등록자 이름 (id 기준)
		try {
			FileInputStream fisjoin = new FileInputStream(joinf);
			ObjectInputStream oisjoin = new ObjectInputStream(fisjoin);
			joinLists = (List<JoinVO>)oisjoin.readObject();
			Iterator<JoinVO> it1 = joinLists.iterator();

			String name = null;
			while(it1.hasNext())
			{
				JoinVO compareVO = it1.next();
				if(id.equals(compareVO.id)){
					name = compareVO.getName();
				}
			}		
			vo.setName(name);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

		if(myhomeLists==null)//처음 실행 
			myhomeLists = new ArrayList<MyHomeVO>();
		
		myhomeLists.add(vo);
		System.out.println(vo);
		
		try {
			if(myhomeLists!=null){	
				FileOutputStream fos = new FileOutputStream("d:\\java\\work\\demo\\Myhome.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(myhomeLists);
				fos.close();
				oos.close();
				System.out.println("매물이 성공적으로 등록 되었습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void search() {
		
		SearchHome searchHome = new SearchHome();
		
		int ch = 0;
		boolean search = true;
		
		try {
			
			while(search){
				
				do{
					System.out.println("검색조건을 입력해주세요");
					System.out.println();
					System.out.println("1.주거형태");
					System.out.println("2.계약형태");
					System.out.println("3.지역별");
					System.out.println("4.가격");
					System.out.println("5.검색종료");
					System.out.print("입력:");
					ch = sc.nextInt();
					
				}while(ch<1);
			
				my.searchCheck(ch);
				
				switch(ch){
					case 1:
						find.item(); 
						searchHome.itemSearch(find.item);
						break;
					case 2:
						find.term(); 
						searchHome.termSearch(find.term);
						break;
					case 3:
						find.local(); 
						searchHome.localSearch(find.local);
						break;
					case 4:
						find.price(); 
						searchHome.priceSearch(find.price);
						break;
					case 5:
						System.out.println("검색을 종료합니다");
						search = false;
				}
				
			}
				
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (AuthenException e) {
			System.out.println(e.toString());
		}
		
	}
	@Override
	public void reserve(String id) {//상담예약
		
		boolean flagrv = false;
		
		try {
			
			System.out.println("부동산 상담예약을 하시겠습니까?");
			MyHomeVO reserveVO = new MyHomeVO();
			find.item();
			find.term();
			find.local();
			find.price();
			
			String name = "";
			
			FileInputStream fisjoin = new FileInputStream(joinf);
			ObjectInputStream oisjoin = new ObjectInputStream(fisjoin);
			joinLists = (List<JoinVO>)oisjoin.readObject();
			
			Iterator<JoinVO> it1 = joinLists.iterator();

			while(it1.hasNext())
			{
				JoinVO compareVO = it1.next();
				if(id.equals(compareVO.id)){
					name = compareVO.getName();
				}
			}		
			
			reserveVO.setName(name);
			reserveVO.setItem(find.item);
			reserveVO.setTerm(find.term);
			reserveVO.setLocal(find.local);
			reserveVO.setPrice(find.price);
			
			FileInputStream fis = new FileInputStream(myhomef);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			myhomeLists = (List<MyHomeVO>)ois.readObject();
			Iterator<MyHomeVO> it2 = myhomeLists.iterator();
			
			while(it2.hasNext()){		
				
				MyHomeVO compareVO = it2.next();
				if((reserveVO.item.equals(compareVO.getItem()) && reserveVO.term.equals(compareVO.getTerm()) &&
						reserveVO.local.equals(compareVO.getLocal()) && reserveVO.price==compareVO.getPrice())){
					System.out.println("상담예약이 완료 되었습니다");
					System.out.println(compareVO.toString());
					flagrv = true;
					return;
				}
			}

			if(!flagrv){
				System.out.println("해당 매물이 없습니다");
			}	
			fisjoin.close();
			oisjoin.close();
			fis.close();
			ois.close();
		
		} catch (Exception e) {
			
		}
	
	}

	@Override
	public void contract(String id) {//계약 후 삭제
		
		
		
	}

	
}
