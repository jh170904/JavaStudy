package com.MyHome;

import java.io.IOException;
import java.util.Scanner;

public class MySweetDreamHouseMain {

	public static void main(String[] args) throws AuthenException, IOException {
		
		Scanner sc = new Scanner(System.in);
		JoinImpl ji = new JoinImpl();
		Picture pi = new Picture();
		JoinException jo = new JoinException();

		String ch;
		
		
		while(true){
			
			boolean check=true;
			
			pi.city1();
			try {
				
				do {
					System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
					System.out.print("□\t\t\t서울시 내 마음에 쏙 드는 부동산 찾기\t\t\t      □\n");
					System.out.print("□1. 회 원 가 입\t\t\t2. 로 그 인\t\t\t3. 종\t료    □\n");
					System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
					System.out.print("▶입력 ");
					
					ch=sc.next();
					jo.n(ch);
					check = false;
					System.out.println();
				}while (check);
				
				switch (ch) {
				
				case "1":
					ji.sign();break;
				case "2":
					LoginMain.main(args);
				case "3":
					System.exit(0);
				case "9":
					Ending.main(args);
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
