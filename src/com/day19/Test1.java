package com.day19;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Test1 {

	public static void main(String[] args) {
		
		try {//외부파일 읽어오므로 try로 묶음
			
			//DOM Document 객체를 생성하기 위한 팩토리 생성
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance(); //newInstance static메소드. 객체생성이 되서 불러옴.
			DocumentBuilder parser = f.newDocumentBuilder();
			
			Document xmlDoc = null;
			
			String url = "bookList.xml"; 			//xml파일은 사실상 인터넷으로 연결된 원격지에 있음. 그 파일을 가져오기 위해서는 url 필요
			
			if(url.indexOf("http://")!=-1){			//원격지에 있다면 실행
				
				URL u = new URL(url);
				InputStream is = u.openStream();	//스트림연결
				xmlDoc = parser.parse(is);			//
			
			}else{
			
				xmlDoc = parser.parse(url);//로컬에 있다면 실행
				
			}
			
			//Element : xml문서의 요소를 표현하기 위해 사용
			Element root = xmlDoc.getDocumentElement();
			//System.out.println(root.getTagName()); //bookList
			
			//첫번째book
			//Node : 각 요소를 읽고 쓰기 위해 사용
			Node book1 = root.getElementsByTagName("book").item(0);
			System.out.println(((Element)book1).getAttribute("kind"));
			
			//getNextSibling() 오른쪽 형제 노드, getPreviousSibling()왼쪽 형제 노드
			
			Node title = book1.getFirstChild();//첫번째 책의 첫번째 자식노드 
			Node title1 = title.getNextSibling();
			System.out.println(title.getNodeName()); //#text
			System.out.println(title1.getNodeName());//tag > title 읽어옴
			
			Node title1_1 = title1.getFirstChild();
			System.out.println(title1_1.getNodeValue());
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
