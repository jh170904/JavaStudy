package com;

import java.util.EmptyStackException;

class Stack<T>{
	class Node<T>{ //같은 타입을 받는 노드 선언
		private T data;
		private Node<T> next;
		public Node(T data){ //생성자를 통해 내부변수에 저장
			this.data = data;
		}
	}
	
	private Node<T> top;//포인터
	
	public T pop(){//맨위에 있는 데이터를 반환하는 메소드
		if (top == null){
			throw new EmptyStackException();
		}
		T item = top.data; //맨위에있는 데이터를 반환하기전에 그다음 데이터를 top으로 옮겨줌
		top = top.next;
		return item;
	}
	
	public void push(T item){//데이터입력
		Node<T> t = new Node<T>(item);
		t.next = top;
		top = t;
	}
	
	public T peek(){//맨위에 있는 데이터를 반환하는 메소드. 단 데이터가 사라지지 않음
		if (top == null){
			throw new EmptyStackException();
		}
		return top.data;
	}
}

public class Test1 {
	public static void main(String[] args){
	Stack<Integer> st = new Stack<Integer>();
	st.push(1);
	st.push(2);
	st.push(3);
	st.push(4);
	System.out.println(st.pop());
	System.out.println(st.pop());
	System.out.println(st.peek());
	System.out.println(st.pop());
	System.out.println(st.peek());
	System.out.println(st.pop());
	System.out.println(st.pop());

	}
}