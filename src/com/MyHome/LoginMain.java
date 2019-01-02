package com.MyHome;

import java.util.Scanner;

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
				System.out.print("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□\n");
				System.out.print("□1. 매물 등록        2. 매물 검색        3. 부동산 상담예약       4. 상담 예약 확인  □\n");
				System.out.print("□5. 계약 체결 등록   6. 로그아웃         7. 가입회원 열람                            □\n");
				System.out.print("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□\n");
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
				mhi.readingReserve(id);
				break;
			case 5:
				mhi.contract(id);
				break;
			case 6:
				sweet.main(args);
			case 7:
				if(id.substring(0,5).equals("admin")){
					System.out.println("***********************회원 가입 내역***********************\n");
					System.out.println("   구분              아이디      이름     핸드폰 번호");
					System.out.println("-----------------------------------------------------------");
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
