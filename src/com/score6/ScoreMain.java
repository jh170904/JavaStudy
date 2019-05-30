package com.score6;

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
					System.out.print("1.입력, 2.수정, 3.삭제, 4.전체출력, 5.이름검색, 6.종료: ");
					ch = sc.nextInt();
				}while(ch<1||ch>6);
				
				switch(ch){
				
				case 1:
					ob.insertData(); break; //insertData메소드 실행시 반환값으로 int가 나오지만 사용하지 않음. 에러안남
				case 2:
					ob.updateData(); break;
				case 3:
					if(ob.deleteData()!=0){
						System.out.println("데이터가 삭제되었습니다."); //반환값을 이용해서 결과 안내
					} 
					break;
				case 4:
					ob.selectAll(); break;
				case 5:
					ob.searchName(); break;
				case 6:
					DBConn.close();
					System.exit(0);
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}//end-main
}//end-class
