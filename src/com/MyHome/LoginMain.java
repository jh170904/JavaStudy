package com.MyHome;

import java.util.Scanner;

import com.excep.AuthenException;

public class LoginMain {

	public static void main(String[] args) throws AuthenException {

		Scanner sc = new Scanner(System.in);
		MyHomeImpl mhi = new MyHomeImpl();
		JoinImpl ji = new JoinImpl();
		MySweetDreamHouseMain sweet = new MySweetDreamHouseMain();
		String id="";
		String pw="";
		int ch1;
		boolean flaglogin = false;
		
		// admin 계정일 경우, 회원정보 열람가능 아니면 예외처리로 권한없음 알림
		while(true){
			
			System.out.println("로그인을 위해 입력하세요.");
			System.out.print("ID: ");
			id = sc.next();
			System.out.print("PW: ");
			pw = sc.next();
			flaglogin = mhi.login(id,pw);
			if(flaglogin){
				break;
			}
		}
		
		
		while (true) { // 로그인 후 세부 메뉴
			
			do {
				System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
				System.out.print("□1. 매물 등록\t2. 매물 검색\t3. 부동산 상담예약\t4. 계약 체결 등록 \t5.로그아웃 \t6.가입회원 열람 □\n");
				System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
				ch1 = sc.nextInt();
			} while (ch1 < 1);

			switch (ch1) {

			case 1:
				mhi.iteminput(id);
				break;
			case 2:
				mhi.search();
				break;
			case 3:
				mhi.reserve(id);
				break;
			case 4:
				mhi.contract(id);
				break;
			case 5:
				sweet.main(args);
			case 6:
				if(id.substring(0,5).equals("admin")){
					ji.print(); 
				}else{
					System.out.println("관리자 계정이 아니므로 열람이 불가능합니다.");
				}
				break;
			default:
				System.exit(0);
			}

		}

	}

}
