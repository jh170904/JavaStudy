package com.MyHome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class MyThread extends Thread{
	
	@Override
	public void run() {
		
		for(int i=0;i<15;i++){
			System.out.print(".");
		
			try {
				sleep(100);
			} catch (Exception e) {
		
			}
		}
		System.out.println("\n");
	}
	
}

class thread {

	public static void th(){
		MyThread t = new MyThread();
		System.out.println();
		System.out.print("검색중");
		t.start();

		try {
			t.join();
		} catch (Exception e) {

		}
	}
}

public class MyHomeImpl extends Thread implements MyHome {
	
	private List<JoinVO> joinLists;
	private List<MyHomeVO> myhomeLists;
	private List<ReserveVO> reserveLists;
	private String path = System.getProperty("user.dir");
	private File joinf = new File(path,"\\Join.txt");
	private File myhomef = new File(path,"\\Myhome.txt");
	private File reservef = new File(path, "\\Reserve.txt");
	Scanner sc = new Scanner(System.in);
	
	MyHomeException my = new MyHomeException();
	Find find = new Find();
	Won won = new Won();
	thread t = new thread();
	
	public MyHomeImpl() {
		
		try {
			
			//회원가입 정보 유무 확인
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
			
			//예약정보 유무 확인
			if(!reservef.getParentFile().exists()){
				reservef.getParentFile().mkdirs();
			}
			
			if(reservef.exists()){
				FileInputStream reserveFis = new FileInputStream(reservef);
				
				ObjectInputStream reserveOis = new ObjectInputStream(reserveFis);
				
				reserveLists = (ArrayList<ReserveVO>)reserveOis.readObject();
				reserveFis.close();
				reserveOis.close();
				
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

		try {
			System.out.println("********등록할 매물을 입력하세요*********");
			MyHomeVO reserveVO = new MyHomeVO();
			
			find.item();
			find.term();
			find.local();
			find.price();
			
			vo.setItem(find.item);
			vo.setTerm(find.term);
			vo.setLocal(find.local);
			vo.setPrice(find.price);
			vo.setId(id);
			vo.setPop(0);
			
			FileInputStream fisjoin = new FileInputStream(joinf);
			ObjectInputStream oisjoin = new ObjectInputStream(fisjoin);
			joinLists = (List<JoinVO>)oisjoin.readObject();
			Iterator<JoinVO> it1 = joinLists.iterator();

			while(it1.hasNext())
			{
				JoinVO compareVO = it1.next();
				if(id.equals(compareVO.id)){
					vo.setName(compareVO.getName());
					vo.setPhone(compareVO.getPhone());
				}
			}		
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		if(myhomeLists==null)//처음 실행 
			myhomeLists = new ArrayList<MyHomeVO>();
		
		myhomeLists.add(vo);
		
		try {
			if(myhomeLists!=null){	
				FileOutputStream fos = new FileOutputStream(myhomef);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(myhomeLists);
				fos.close();
				oos.close();
				System.out.println("\n매물이 성공적으로 등록 되었습니다.**");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(vo.toString3()+"\n");
	
	}

	@Override
	public void search() {
		
		//매물검색
		SearchHome searchHome = new SearchHome();
		int ch = 0;
		boolean search = true;
		System.out.println("********검색할 매물을 입력하세요*********");
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
					System.out.print("입력: ");
					ch = sc.nextInt();
					System.out.println();
					
				}while(ch<1);
			
				my.searchCheck(ch);
				
				switch(ch){
					case 1:
						find.item(); 
						t.th();
						searchHome.itemSearch(find.item);
						break;
					case 2:
						find.term(); 
						t.th();
						searchHome.termSearch(find.term);
						break;
					case 3:
						find.local(); 
						t.th();
						searchHome.localSearch(find.local);
						break;
					case 4:
						find.price();
						t.th();
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
			
			System.out.println("*******상담 예약할 매물을 입력하세요********");
			
			//검색할 매물 등록
			ReserveVO  reserveVO = new ReserveVO();
			find.item();
			find.term();
			find.local();
			find.price();
			
			//기존 파일 읽기(로그인된 id 통해 이름 찾기)
			FileInputStream fisjoin = new FileInputStream(joinf);
			ObjectInputStream oisjoin = new ObjectInputStream(fisjoin);
			joinLists = (List<JoinVO>)oisjoin.readObject();
			Iterator<JoinVO> it1 = joinLists.iterator();
			while(it1.hasNext()){
				JoinVO compareVO = it1.next();
				if(id.equals(compareVO.id)){
					reserveVO.setBuyerName(compareVO.getName());
					reserveVO.setBuyerPhone(compareVO.getPhone());
				}
			}
			
			
			//예약 매물 VO 설정
			reserveVO.setBuyerId(id);
			reserveVO.setItem(find.item);
			reserveVO.setTerm(find.term);
			reserveVO.setLocal(find.local);
			reserveVO.setPrice(find.price);
			
			//동일 매물 리스트 검색
			FileInputStream fis = new FileInputStream(myhomef);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			myhomeLists = (List<MyHomeVO>)ois.readObject();
			Iterator<MyHomeVO> it2 = myhomeLists.iterator();
						
			//예약 리스트 생성
			
			while(it2.hasNext()){		
				MyHomeVO myhomeVO  = it2.next();
				
				if((reserveVO.item.equals(myhomeVO.getItem()) && reserveVO.term.equals(myhomeVO.getTerm()) &&
						reserveVO.local.equals(myhomeVO.getLocal()) && reserveVO.price==myhomeVO.getPrice())){
					
					reserveVO.setSellerName(myhomeVO.getName()); //매물 등록 시 등록자(판매자의 이름) 
					reserveVO.setSellerPhone(myhomeVO.getPhone());
					reserveVO.setSellerId(myhomeVO.getId());
					
					//상담 예약 건수 적립
					myhomeVO.setPop(myhomeVO.getPop()+1);
					myhomeLists.remove(myhomeVO);
					myhomeLists.add(myhomeVO);
					
					FileOutputStream fos = new FileOutputStream(myhomef);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(myhomeLists);
					fos.close();
					oos.close();
					
					flagrv = true;
					reserveVO.run();
				}
			}

			if(reserveLists==null)	//처음 실행시 리스트 생성
				reserveLists = new ArrayList<ReserveVO>();
			
			reserveLists.add(reserveVO);
			
			if(!flagrv){
				System.out.println("해당 매물이 없습니다");
				reserveLists.remove(reserveVO);
			}
			
			try {

				if(reserveLists!=null){	
					FileOutputStream fos = new FileOutputStream(reservef);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(reserveLists);
					fos.close();
					oos.close();
				}
			} catch (Exception e) {

			}
			
			fisjoin.close();
			oisjoin.close();
			fis.close();
			ois.close();
		
		} catch (Exception e) {
			
		}
	
	}

	@Override
	public void readingReserve(String id) {
		
		boolean flag = false;
		System.out.println("*************상담 예약 내역*************");
		if (reserveLists == null) {// lists가 생성이 안되어 있으면 객체 생성 진행.
			reserveLists = new ArrayList<ReserveVO>();
		}
		
		Iterator<ReserveVO> it = reserveLists.iterator();
		
		while(it.hasNext()){
			ReserveVO vo = it.next();
			if(id.equals(vo.getBuyerId()) || id.equals(vo.getSellerId())){
				System.out.println(vo.toString());
				flag = true;
			}
		}
		System.out.println();
		
		if(!flag)
			System.out.println("예약이 없습니다.");
	
	}
	
	
	@Override
	public void popRanking() {
		
		try{
			FileInputStream fis = new FileInputStream(myhomef);
			ObjectInputStream ois = new ObjectInputStream(fis);
			myhomeLists = (List<MyHomeVO>)ois.readObject();


			Comparator<MyHomeVO> comp = new Comparator<MyHomeVO>() {
				@Override
				public int compare(MyHomeVO vo1, MyHomeVO vo2) {
					return vo1.getPop()<vo2.getPop()?1:-1;
				}
			};

			Collections.sort(myhomeLists, comp);

			Iterator<MyHomeVO> it = myhomeLists.iterator();
			

			int cnt=1;
			while(it.hasNext()){
				MyHomeVO vo = it.next();	
				if(vo.getPop()>0){
					if(cnt==1){
						System.out.println("-------------------------------------------------------------------------");
						System.out.println("   등록자       지역      주거형태       계약형태       금액       ");
						System.out.println("-------------------------------------------------------------------------");
					}
					System.out.print(cnt);
					System.out.println(vo.toString());
					System.out.println();

					if(cnt>4)
						return;
					
					cnt++;
				}

			}
			if(cnt==1)
				System.out.println("인기 매물이 없습니다.");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
	}
	
	@Override
	public void contract(String id) {//계약 후 삭제
		boolean flagrv = false;
		
		try {
			
			System.out.println("********체결된 매물을 입력하세요*********");
			//MyHomeVO contractVO = new MyHomeVO();
			ContractVO  contractVO = new ContractVO();
			find.item();
			find.term();
			find.local();
			find.price();
			
			String name = "";
			
			FileInputStream fisjoin = new FileInputStream(joinf);
			ObjectInputStream oisjoin = new ObjectInputStream(fisjoin);
			joinLists = (List<JoinVO>)oisjoin.readObject();
			
			Iterator<JoinVO> it1 = joinLists.iterator();//회원가입정보

			while(it1.hasNext()){
				JoinVO compareVO = it1.next();
				if(id.equals(compareVO.id)){
					contractVO.setBuyerName(compareVO.getName());
					contractVO.setBuyerPhone(compareVO.getPhone());
				}
			}

			contractVO.setBuyerId(id);
			contractVO.setItem(find.item);
			contractVO.setTerm(find.term);
			contractVO.setLocal(find.local);
			contractVO.setPrice(find.price);
	
			FileInputStream fis = new FileInputStream(myhomef);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			myhomeLists = (List<MyHomeVO>)ois.readObject();
			Iterator<MyHomeVO> it2 = myhomeLists.iterator();//매물정보
			
			while(it2.hasNext()){		
				MyHomeVO compareVO = it2.next();
				if((contractVO.item.equals(compareVO.getItem()) && contractVO.term.equals(compareVO.getTerm()) &&
						contractVO.local.equals(compareVO.getLocal()) && contractVO.price==compareVO.getPrice())){
					
					contractVO.setSellerName(compareVO.getName()); //매물 등록 시 등록자(판매자의 이름) 
					contractVO.setSellerPhone(compareVO.getPhone());
					contractVO.setSellerId(compareVO.getId());
					
					try {
						
						myhomeLists.remove(compareVO);
						
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
						if(myhomeLists!=null){	
							FileOutputStream fos = new FileOutputStream(myhomef);
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(myhomeLists);
							fos.close();
							oos.close();
							System.out.println("매물 정보가 성공적으로 삭제 되었습니다.\n");
							flagrv = true;
							
							contractVO.run();
							
							return;
						}
				}
				
			}
			if(!flagrv)
				System.out.println("해당 매물이 없습니다");
			
			fisjoin.close();
			oisjoin.close();
			fis.close();
			ois.close();
		
		} catch (Exception e) {
			
		}
		
	}
	
}
