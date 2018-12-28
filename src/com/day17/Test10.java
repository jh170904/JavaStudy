package com.day17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

//그래픽 단위로 되어있는 것은 이벤트 단위로 진행된다는 것 기억
public class Test10 extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	private JTextField tf[] = new JTextField[4];
	private JButton btn1,btn2;
	private JTable table;

	public Test10(){
		getContentPane().setLayout(null);
		String[] title = {"이름","국어","수학","영어"};
		
		//레이블,텍스트필드 생성
		for(int i=0;i<title.length;i++){
			JLabel lbl = new JLabel(title[i]);
			lbl.setBounds(10, (i+1)*30, 50, 20);
			getContentPane().add(lbl);
			
			tf[i] = new JTextField();
			tf[i].setBounds(80,(i+1)*30, 70, 20);
			getContentPane().add(tf[i]);
		}
		
		//버튼생성
		btn1 = new JButton("추가");
		btn1.setBounds(10, 160, 60, 20);
		btn1.addActionListener(this);
		getContentPane().add(btn1);
		
		btn2 = new JButton("종료");
		btn2.setBounds(90, 160, 60, 20);
		btn2.addActionListener(this);
		getContentPane().add(btn2);
		
		//JTable배치
		addTable();
		
		//종료이벤트
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//윈도우창 설정
		setTitle("성적처리");
		setSize(550,250);
		setVisible(true);
	}
	
	//테이블배치 메소드
	private void addTable(){
		
		String title[] = {"이름","국어","수학","영어","총점","평균"};		
		MyTableModel model = new MyTableModel(title);
		table = new JTable(model);//컬럼의 개수, 이름을 모델로 할당
		
		//스크롤바 
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(160,30,355,150);
		getContentPane().add(sp);
		
		//컬럼크기 자동변경 off
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//컬럼 폭 수동 지정
		for(int i=0;i<title.length;i++){
			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(55);//타이틀의 갯수만큼 가져와서 간격이 55로 줄어듦
		}
	}
	
	//테이블모델 클래스
	class MyTableModel extends DefaultTableModel{//타이틀을 넘겨줘서 타이틀의 이름과 갯수를 반환
		private static final long serialVersionUID = 1L;
		private String[] title;
		public MyTableModel(String[] title){
			this.title = title;
		}
		
		@Override
		public int getColumnCount() {//갯수반환
			if(title==null||title.length==0){
				return 0;
			}
			return title.length;
		}
		
		@Override
		public String getColumnName(int column) {//컬럼의이름반환
			if(title==null||title.length==0){
				return null;
			}
			return title[column];
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob instanceof JButton){
			JButton b = (JButton)ob;//downcast
			if(b==btn1){
				process();
			}else if(b==btn2){
				System.exit(0);
			}
		}
	}

	private void process(){
		String[] data = new String[6];
		int tot=0;
		try {
			data[0]=tf[0].getText();					//이름
			for(int i=1;i<=3;i++){
				tot+=Integer.parseInt(tf[i].getText());	//총점 누적
				data[i] = tf[i].getText();				//국,영,수 점수 받아냄
			}
			data[4] = Integer.toString(tot);			//총점
			data[5] = Integer.toString(tot/3);			//평균
			
			//테이블 입력
			((MyTableModel)table.getModel()).addRow(data);//downcast. JTable->MyTableModel
			
			//초기화
			for(int i=0;i<tf.length;i++){
				tf[i].setText("");
			}
			
			tf[0].requestFocus();//포커스 다시 이름 텍스트 필드로 가져옴
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		new Test10();
	}

}
