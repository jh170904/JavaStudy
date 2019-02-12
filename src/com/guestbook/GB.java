package com.guestbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GB {

	Scanner sc = new Scanner(System.in);
	GBDAO dao = new GBDAO();
	GBException ge = new GBException();

	// 방명록조회
	public void selectGB() {

		List<GBDTO> lists = dao.selectbang();
		Iterator<GBDTO> it = lists.iterator();

		// lists 출력
		while (it.hasNext()) {
			GBDTO dto = it.next();
			dto.print();
		}
	}

	// 회원탈퇴
	public void deleteMember() {

		try {
			String delid, delpwd;
			System.out.println("삭제할 정보를 입력하세요.");
			System.out.print("id: ");
			delid = sc.next();
			System.out.print("pwd: ");
			delpwd = sc.next();

			int result = dao.deletedata(delid, delpwd);

			if (result==1) {
				System.out.println("회원탈퇴가 성공적으로 진행되었습니다!");
			} else {
				System.out.println("회원탈퇴가 진행되지 못하였습니다! 회원정보를 확인해주세요.");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void insertGB(String id) {

		try {
			GBDTO dto = new GBDTO();
			// 아이디
			dto.setId(id);

			System.out.print("방명록 내용:");
			dto.setText(sc.next());

			int result = dao.insertGB(dto);

			if (result!=0) {
				System.out.println("작성 완료!!");
			} else {
				System.out.println("작성 실패!!");
			}			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void deleteGB(String id) {
		GBDTO dto = new GBDTO();

		try {

			System.out.println("삭제할 방명록 번호");
			int dn = sc.nextInt();

			int result = dao.deleteGB(dn, id);

			if (result != 0)
				System.out.println("삭제 성공!!");
			else
				System.out.println("삭제 실패!!");

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void insert() throws Exception {

		String pw2 = null;
		String str = null;
		boolean phone = true;
		boolean id = true;
		boolean pw = true;
		boolean name = true;
		boolean gender = true;

		System.out.println("             회원가입");
		System.out.println("-------------------------------------");

		try {

			GBDTO dto = new GBDTO();

			do {
				try {
					System.out.print("아이디:");
					str = (sc.next());
					ge.idFormat(str);
					id = false;
					dto.setId(str);

				} catch (Exception e) {
					System.out.println(e.toString());
				}

			} while (id);

			do {
				try {

					System.out.print("비밀번호:");
					dto.setPwd(sc.next());

					System.out.print("비밀번호 확인:");
					pw2 = sc.next();
					ge.pwCheck(dto.getPwd(), pw2);

					pw = false;

				} catch (Exception e) {
					System.out.println(e.toString());

				}

			} while (pw);

			do {
				try {
					System.out.print("이름:");
					str = sc.next();
					ge.nameCheck(str);

					name = false;
					dto.setName(str);

				} catch (Exception e) {
					System.out.println(e.toString());

				}

			} while (name);

			System.out.print("성별[남/여]:");
			str = sc.next();
			dto.setGender(str);


			System.out.print("생일[xxxx-xx-xx]:");
			dto.setBirth(sc.next());

			do {
				try {
					System.out.print("전화번호[xxx-xxxx-xxxx]:");
					str = sc.next();
					ge.phoneCheck(str);

					phone = false;
					dto.setTel(str);

				} catch (Exception e) {
					System.out.println(e.toString());

				}

			} while (phone);

			int result = dao.insertMember(dto);

			if (result != 0) {
				System.out.println();
				System.out.println("****성공적으로 가입이 되었습니다!****");
				System.out.println();

				System.out.println("-----------[회원가입 확인]-----------");
			} else
				System.out.println("회원가입에 실패했습니다");

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public String login() {

		String id;
		String pwd;
		String checkid = null;

		try {

			GBDTO dto = new GBDTO();

			System.out.print("아이디:");
			id = sc.next();

			System.out.print("비밀번호:");
			pwd = sc.next();

			checkid = dao.login(id, pwd);

		} catch (Exception e) {
			System.out.println(e.toString());
			return checkid;
		}
		return checkid;

	}

}
