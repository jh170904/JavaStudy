package com.day17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test8 extends Frame {

	private int x,y;
	private Label lbl = new Label("",Label.CENTER);
	
	public Test8(){
		
		add(lbl,BorderLayout.SOUTH);//가운데 하단에 lbl라벨 추가
		
		addMouseListener(new MouseHandler());//마우스가 움직였을때 감지
		addMouseMotionListener(new MouseMotionHandler());
		
		setBackground(new Color(150,150,150));//배경색 설정
		setForeground(new Color(0,0,255));//글자색 설정
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("좌표출력");
		setSize(400,400);
		setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g) {
		String str;
		str= "(" + x +"," + y +")"; 
		g.drawString(str, x, y);//좌표출력
	}

	@Override
	public void update(Graphics g) {//좌표 정보가 매개 변수
		paint(g);//이벤트가 발생하면 paint호출
	}
	
	class MouseHandler extends MouseAdapter{//클릭, 더블클릭, 클릭후 뗄때 등의 event
		
		@Override
		public void mousePressed(MouseEvent evt) {

			x = evt.getX();
			y = evt.getY();
			
			repaint();//update호출
			
		}
	}

	class MouseMotionHandler extends MouseMotionAdapter{

		@Override
		public void mouseDragged(MouseEvent evt) {//마우스를 누른 상태로 움직일떄

			x = evt.getX();
			y = evt.getY();
			repaint();
		
		}

		@Override
		public void mouseMoved(MouseEvent e) {//마우스가 움직일 때

			String str = String.format("(%d,%d)", e.getX(), e.getY());
			lbl.setText(str);
		
		}
		
	}
	
	public static void main(String[] args) {
		new Test8();
	}

}
