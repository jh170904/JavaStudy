package com.day07;

//static : 자신이 알아서 로딩만 하게 되면 메모리에 올라가 있다.
//new를 통해서 객체를 생성하면 메모리에 올라감. static은 new를 쓰지않아도 알아서 올라감
//1. 자동으로 메모리 할당을 받는다.
//2. 객체를 100번 생성해도 메모리공간은 하나만 생성된다. 모든 사람이 공동으로 사용한다라고 생각

public class Test3 {
	
	//static을 줌으로써 클레스가 로딩되는 순간 메모리상에 이미 올라가있음 int a 와 print()
	//논리적으로 같은 클래스안에서 선언해뒀지만 
	//int b와 write()는 메모리상에 올리지 않아서 실행 불가
	
	public static int a = 10; 
	//class변수. 자신이 알아서 메모리에 올라감
	//static 변수의 특징
	//클래스가 로딩되는 순간 메모리에 할당 되어진다.
	//접근방법 : [클래스이름.변수명] 으로 접근한다
	//즉, new를 통해서 메모리 할당을 받지 않아도 사용이 가능하다.
	
	private int b = 20;
	//instance변수. 메모리에 올라가야만 사용할 수 있다.
	//메모리에 올라가기 위해서는 내가 객체 생성을 해주어야 함 
	//반드시 new를 통해서 메모리 할당을 받아야 사용 가능하다
	//동일 클래스 메소드에서 접근이 가능하다 
	//-> write();가 실행시켜지기 위해서는 메모리에 로딩을 하게되는데 그때 동시에 int b도 같이 로딩되므로 가능
	//클래스메소드에서는 접근이 불가능하다.
	//-> 메모리상에 이미 올라가 있는 class 메소드에서 instance변수를 찾게되면 아직 메모리에 로딩되지 않아 찾지 못하기 때문
	
	
	public void write(){//instance메소드. 클래스변수와 인스턴스변수를 모두 사용가능. 
		
		System.out.println("class 변수 a: " + a);
		System.out.println("instance 변수 b: "+ b);
		
	}
	
	public static void print(){//class메소드. 이미 메모리상에 올라가 있기 때문에 static변수만 사용할 수 있음  
		
		System.out.println("class 변수 a: " + a);
		//System.out.println("instance 변수 b: "+ b);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("main...");
		System.out.println("class 변수 a: " + a); //class변수는 객체를 생성하기 전에 올라가므로 ob.a로 호출하지 않음 클래스의 이름으로 붙여줌
		System.out.println("class 변수 a: " + Test3.a); //여기다가 this 쓰면 안됨. 이건 class변수.
		
		//System.out.println("instance 변수 b: "+ ob.b); 객체생성이 먼저 일어난 후에 메소드 실행 가능
		
		//write(); 오류
		print(); //static이므로 가능
		Test3.print(); //이렇게 호출해주는게 좋음. class메소드
		
		Test3 ob = new Test3(); //객체생성. 이렇게 되는 순간 instance메소드와 instance변수가 메모리상에 올라감
		
		System.out.println("instance 변수 b: "+ ob.b);
		ob.write();
		System.out.println("class 변수 a: " + ob.a); // 에러는 아니지만 클래스변수를 객체변수로 쓴 것...	
		ob.print();
		
		Test3 ob1 = new Test3();
		ob1.a = 100; // 10 -> 100
		ob1.b = 200; // 따로 만들어지므로 ob.b 와 ob1.b 메모리는 다름
				
		System.out.println("------------------------");
		
		System.out.println("ob1.a:"+ ob1.a);
		System.out.println("ob1.b:"+ ob1.b);

		System.out.println("------------------------");
		
		System.out.println("ob.a:"+ ob.a);//100  static은 오로지 같은 공간이기 때문에 같이 사용함. 10에서 100으로 바뀌어져 있음
		System.out.println("ob.b:"+ ob.b);//20		

		System.out.println("------------------------");
		ob.a=500;
		System.out.println("ob1.a:"+ ob1.a); //ob1.a 와 ob.a의 저장공간은 같다. 같이 사용한다. static이기 때문
		System.out.println("ob.a:"+ ob.a);
		
		
	}

}
