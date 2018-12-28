package com.day11;

interface Test{
	
	public int total();
	public void write();
	
}

class TestImpl implements Test{
	private String hak;	
	private String name;
	
	private int kor;
	private int eng;
	
	public TestImpl(){}	
	public TestImpl(String hak, String name, int kor, int eng){
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
/*	
	public void set(String hak, String name, int kor, int eng){
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
*/
	@Override
	public boolean equals(Object ob){//매개변수가 Object로 upcast됨. ob2는 TestImpl 클래스지만 오브젝트로 들어감
		
		boolean flag = false;
		
		if(ob instanceof TestImpl){//object가 껍데기를 빼면 무슨타입이냐
			
			TestImpl t = (TestImpl)ob;//downcast. TestImpl로 형변환시켜서 t에 저장
			
			if(this.hak.equals(t.hak) && this.name.equals(t.name)){	//여기에서의 equals는 String의 메소드. hak과 name이 String 타입이니까. this-ob1, t-ob2
				flag = true;
			}
		
		}	
		return flag;
	
	}
	
	@Override
	public int total() {
		return kor+eng;
	}

	@Override
	public void write() {
	
		System.out.println(hak + "," + name + "," + total());
	}
	
}

public class Test6 {

	public static void main(String[] args) {
		
		Test ob1 = new TestImpl("111","배수지",80,90); //자식클래스로 객체 생성 & 초기화
		//인터페이스    인터페이스를구현한클래스
		Test ob2 = new TestImpl("111", "배수지", 100, 100);
		//자식의 메소드 사용안됨
		
		TestImpl ob3 = new TestImpl();
		//자식의 메소드 가능
		
		if(ob1.equals(ob2)){ //Override된 메소드가 없다면 Object의 equals 사용 - 주소비교
			System.out.println("ob1과 ob2는 동일 인물");
		}else{
			System.out.println("ob1과 ob2는 다른 인물");
		}
		
		ob1.write();
		ob2.write();
		ob3.write();
		
	}

}
