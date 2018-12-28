package com.score5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score {

	private List<ScoreVO> lists; // new 새로운 객체를 생성하면 계속 데이터가 날라감
	private String path = System.getProperty("user.dir");
	private File f = new File(path, "\\data\\score.txt"); //d:\\java\\demo path에 들은 것

	public ScoreImpl() {// 기본생성자

		try {

			if (!f.getParentFile().exists()) {// 파일이 존재하지 않으면 파일 디렉토리 생성. //d:\\java\\demo\\data\\score				
				f.getParentFile().mkdirs();
			}

			if (f.exists()) {// 두번째 이상 실행시. 기존 파일이 존재할 경우 fis로 읽어서 lists에 데이터 할당.
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				lists = (ArrayList<ScoreVO>) ois.readObject();
				fis.close();
				ois.close();
			}

		} catch (Exception e) {
		
		}

	}
	
	@Override
	public void writeFile() {

		try {

			if (lists != null) {
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(lists);

				fos.close();
				oos.close();
				System.out.println("파일 저장 성공!!");

			}
		} catch (Exception e) {
		}

	}

	@Override
	public void input() {

		Scanner sc = new Scanner(System.in);
		ScoreVO vo = new ScoreVO();
		System.out.print("이름?: ");
		vo.setName(sc.next());
		System.out.print("생일?: ");
		vo.setBirth(sc.next());
		System.out.print("점수?: ");
		vo.setJumsu(sc.nextInt());

		if (lists == null) {// 처음실행시 lists가 생성이 안되어 있음 -> 객체 생성 진행. 생성자에서 파일이 있으면 파일을 불러오게 시킴. 
			lists = new ArrayList<ScoreVO>();
		}

		lists.add(vo);

	}

	@Override
	public void print() {

		Iterator<ScoreVO> it = lists.iterator();
		while (it.hasNext()) {
			ScoreVO vo2 = it.next();
			System.out.println(vo2.toString());

		}

	}

}
