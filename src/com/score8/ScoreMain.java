package com.score8;

import java.util.Scanner;

import com.db.DBConn;

public class ScoreMain {
	
	public static void main(String[] args) {
	
		Scanner sc= new Scanner(System.in);
		int ch;
		Score ob = new Score();
		
		try {
			
			while(true){
				
				do{
					System.out.print("1.입력, 2.수정, 3.삭제, 4.전체출력, 5.이름검색, 6. 학번검색, 7.종료: ");
					ch = sc.nextInt();
				}while(ch<1||ch>6);
				
				switch(ch){
				
				case 1:
					ob.insert(); break; 
				case 2:
					ob.update(); break;
				case 3:
					ob.delete(); break;
				case 4:
					ob.selectAll(); break;
				case 5:
					ob.searchName(); break;
				case 6:
					ob.searchHak(); break;
					
				case 7:
					DBConn.close();
					System.exit(0);
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
	}

}
