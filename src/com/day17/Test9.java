package com.day17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//Swing.
//AWT와 80% 유사.
//OS에 영향을 받지 않는다.
public class Test9 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbl;
	
	public Test9(){
		lbl = new JLabel("메세지",JLabel.CENTER);
		getContentPane().add(lbl);
		
		JMenuBar mbar = new JMenuBar();//메뉴바는 하나, 메뉴와 메뉴아이템은 여러개 가능
		JMenu menu;					   //이클립스에서의 file, Edit, Source, Refactor와 같은 메뉴
		JMenuItem mi;				   //메뉴클릭시 세부메뉴
		
		menu = new JMenu("메세지 대화상자");//메뉴
		
		//메세지 대화상자(menu) 클릭시 메뉴안에 세개의 아이템(MenuItem) 뜸
		mi = new JMenuItem("메세지");
		menu.add(mi);
		mi.addActionListener(this);
		mi = new JMenuItem("입력");
		menu.add(mi);
		mi.addActionListener(this);
		mi = new JMenuItem("종료");
		
		menu.add(mi);
		mi.addActionListener(this);
		
		mbar.add(menu);
		setJMenuBar(mbar);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("대화상자");
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test9();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();//클릭한 메뉴의 이름을 텍스트로 가져옴
		
		if(str.equals("메세지")){
		
			JOptionPane.showMessageDialog(this,"내일은 크리스마스!!","성탄절",JOptionPane.INFORMATION_MESSAGE);//팝업 뜸. this-> 내 form위로 띄워라
		
		}else if(str.equals("입력")){
		
			String age = JOptionPane.showInputDialog(this,"당신의 나이는?","나이 입력",JOptionPane.QUESTION_MESSAGE);
			lbl.setText("당신의 나이는 " +age +"살 이군요!");
		
		}else if(str.equals("종료")){
		
			int result;
			result = JOptionPane.showConfirmDialog(this, "프로그램을 종료하시겠습니까?", "종료확인", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);//예,아니오,취소 물어봄
			
			System.out.println(result);//예0 아니오1 취소2 -> 예 선택시 System.exit(0);
			
			if(result==JOptionPane.YES_OPTION){//result==0과 동일
				System.exit(0);
			}
		}
		
	}

}
