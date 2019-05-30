package com.day17;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test6 extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private TextField[] tf = new TextField[4];//텍스트 필드가 100개 필요하면 100개 만들어야함. 그래서 배열 이용
	private Button btn1, btn2;
	private Label result = new Label("", Label.CENTER);
	
	public Test6(){//기본생성자
		
		String[] title = {"이름","국어","영어","수학","총점"};
		setTitle("성적처리");
		
		setLayout(null);//수동으로 배치하겠다
		
		for(int i=0;i<5;i++){
			
			Label lbl = new Label();//반복문 사용하므로 배열 쓸 필요없음
			lbl.setText(title[i]);
			lbl.setBounds(10, (i+1)*30, 50, 20);//좌표(x,y)에 50*20크기의 박스를 생성
			add(lbl);

			if(i!=4){
				tf[i] = new TextField();//배열에 객체생성후 할당
				tf[i].setBounds(80, (i+1)*30, 70, 20);//좌표(x,y)에 70*20크기의 텍스트필드 생성
				tf[i].addKeyListener(new KeyHandler());
				add(tf[i]);
			}else{
				result.setBounds(80,(i+1)*30, 70, 20);
				add(result);
			}
		}
		
		btn1 = new Button("결과");
		btn1.setBounds(180,30,60,20);
		add(btn1);
		btn1.addActionListener(this);
		btn1.addKeyListener(new KeyHandler());
		
		btn2 = new Button("종료");
		btn2.setBounds(180,60,60,20);
		add(btn2);
		btn2.addActionListener(this);
		btn2.addKeyListener(new KeyHandler());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setSize(260, 180);
		setResizable(false);//크기변환불가
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test6();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if(ob instanceof Button){
			
			Button b = (Button)ob;//downcast Object->Button
			
			if(b==btn1){
				process();//메소드 호출
			}else if(b==btn2){
				System.exit(0);
			}
			
		}
		
	}
	
	private void process(){
		
		int tot=0;
		try {
			
			for(int i=1; i<=3; i++){//배열0은 이름. tf[1]~tf[3]을 누적해서 더해야 함
				tot+=Integer.parseInt(tf[i].getText());
				result.setText(Integer.toString(tot));
				//result.setText(""+tot);//정수와 null 이 더해지면 String으로 자동으로 바뀜
			}
			
		} catch (Exception e2) {
			result.setText("입력 오류!!");
		}
		
	}
	
	class KeyHandler extends KeyAdapter{//추상클래스

		@Override
		public void keyPressed(KeyEvent evt) {//추상메소드 오버라이드
											  //리스너가 키보드를 입력했을때를 이벤트로 감지해서 keyPressed메소드 실행
			Object ob = evt.getSource();
			
			if(evt.getKeyCode()!=KeyEvent.VK_ENTER){//VK:가지고있는 키보드 입력값을 보여줌
				return;
			}
			
			if(ob instanceof Button){
				Button b = (Button)ob; 	//downcast
				if(b==btn1){
					process();//국영수 총점을 구하는 메소드
					btn2.requestFocus();	////버튼1->버튼2로 포커스를 옮겨라
				}
				return;
			}
			
			if(ob instanceof TextField){
				TextField t = (TextField)ob; //downcast

				for(int i=0;i<tf.length;i++){
					if(i!=3&&tf[i]==t){//i가3이 아니면서 & tf[i]가 t 자기자신이 맞다면 실행
						tf[i+1].requestFocus();//다음번 텍스트필드에 포커스를 옮겨라
						return;
					}else if(tf[3]==t){
						btn1.requestFocus();//버튼1로 포커스를 옮겨라
						return;
					}
				
				}
			}
		}
		
	}//end-KeyHandler
	
}//end-class
