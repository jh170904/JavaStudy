package com.MyHome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.excep.AuthenException;

public class JoinImpl implements Join {

	private List<JoinVO> lists;
	
	private String path = System.getProperty("user.dir");
	private File f = new File(path,"\\Join.txt");
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	JoinException jo = new JoinException();

	public JoinImpl() throws AuthenException{
		
		try {
			
			if(!f.getParentFile().exists()){
				f.getParentFile().mkdirs();
			}
			
			if(f.exists()){
				FileInputStream fis = new FileInputStream(f);
				
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				lists = (ArrayList<JoinVO>)ois.readObject();
				fis.close();
				ois.close();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void print(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("등록구분\t\t아이디\t\t이름\t\t핸드폰번호");
		System.out.println("---------------------------------------------------------------------");
		Iterator<JoinVO> it = lists.iterator();
		
		while(it.hasNext()){
			JoinVO vo = it.next();
			System.out.println(vo.toPrint());
		}
		System.out.println();
	}
	
	
	//회원가입
	@Override
	public void sign()  {

		JoinVO vo = new JoinVO();
		
		String pw2=null;		//비밀번호 확인
		String str=null;		//아이디 확인
		int type;
		boolean id=true;
		boolean pw=true;
		boolean typeCheck=true;
		
		System.out.println("             회 원 가 입 ");
		System.out.println("-------------------------------------");

		
		//아이디 입력
		do{
			try{
				System.out.print("아이디:");
				str = br.readLine();
				jo.idFormat(str);
			
				if(lists!=null){
					Iterator<JoinVO> it = lists.iterator();
					while(it.hasNext()){
						JoinVO vo1 = it.next();
						if(vo1.getId().equals(str)){
							jo.sameId();
						}
					}	
				}
			
				id = false;
				vo.setId(str);
			
			} catch (IOException e) {
				System.out.println(e.toString());
			
			} catch (AuthenException e) {
				System.out.println(e.toString());
			
			}
			
		}while(id);
		
		
		//비밀번호 입력
		do{
			try{
				System.out.print("비밀번호:");
				vo.setPw(br.readLine());
			
				System.out.print("비밀번호 확인:");
				pw2 = br.readLine();
				jo.pwCheck(vo.getPw(), pw2);
			
				pw=false;
			
			} catch (IOException e) {
				System.out.println(e.toString());
			
			} catch (AuthenException e) {
				System.out.println(e.toString());
			
			}
			
		}while(pw);
		
		try{
			
			System.out.print("이름:");
			vo.setName(br.readLine());
			
			System.out.print("전화번호:");
			vo.setPhone(br.readLine());
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		do{
			try{
				System.out.println("해당하는 번호를 입력주세요");
				System.out.print("1.부동산중개업자 2.구매자/판매자");
				type = Integer.parseInt(br.readLine());
				System.out.println(type);
				jo.typeCheck(type);
				
				typeCheck = false;
				vo.setType(type);
				
			} catch (IOException e) {
				System.out.println(e.toString());
				
			} catch (AuthenException e) {
				System.out.println(e.toString());
			
			}
			
		}while(typeCheck);
		
		try{
			
			System.out.println();
			System.out.println("****성공적으로 가입이 되었습니다!****");
			System.out.println();
		
			if(lists==null)//처음 실행 
				lists = new ArrayList<JoinVO>();

			lists.add(vo);
			System.out.println("-----------[회원가입 확인]-----------");
			System.out.println(vo.toString());
			
			
			if(lists!=null){
				
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(lists);
				
				fos.close();
				oos.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
