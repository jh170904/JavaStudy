package com.MyHome;

import java.io.IOException;
import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) throws AuthenException, IOException {

		Scanner sc = new Scanner(System.in);
		MyHomeImpl mhi = new MyHomeImpl();
		JoinImpl ji = new JoinImpl();
		MySweetDreamHouseMain sweet = new MySweetDreamHouseMain();
		MyHomeException my = new MyHomeException();
		String id="";
		String pw="";
		
		String ch;
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
			
			boolean check=true;
			
			try {
				
				do {
					System.out.print("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□\n");
					System.out.print("□1. 매물 등록        2. 매물 검색        3. 부동산 상담예약       4. 상담 예약 확인  □\n");
					System.out.print("□5. 인기 매몰        6. 계약 체결 등록   7. 로그아웃              8. 가입회원 열람   □\n");
					System.out.print("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□\n");
					System.out.print("▶입력 ");
					ch = sc.next();
					
					my.n(ch);
					check = false;
					System.out.println();
					
				} while (check);

				switch (ch) {

				case "1":
					mhi.iteminput(id);
					break;
				case "2":
					mhi.search();
					break;
				case "3":
					mhi.reserve(id);
					break;
				case "4":
					mhi.readingReserve(id);
					break;
				case "5":
					mhi.popRanking();
					break;
				case "6":
					mhi.contract(id);
					break;
				case "7":
					sweet.main(args);
				case "8":
					if(id.equals("admin123")){
						System.out.println("***********************회원 가입 내역***********************\n");
						System.out.println("   구분              아이디      이름     핸드폰 번호");
						System.out.println("-----------------------------------------------------------");
						ji.print(); 
						System.out.println();
					}else{
						System.out.println("관리자 계정이 아니므로 열람이 불가능합니다.");
					}
					break;
				default:
					System.exit(0);
				}
				
			} catch (IOException e) {
				System.out.println(e.toString());
			} catch (AuthenException e) {
				System.out.println(e.toString());
			}

		}

	}

}
