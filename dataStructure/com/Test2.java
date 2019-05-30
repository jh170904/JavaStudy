package com;

import java.util.NoSuchElementException;

class Queue<T>{//객체를 만들때 데이터타입을 명시하도록 T 로 생성
	
	class Node<T>{//같은 타입을 받는 노드 생성
		private T data;
		private Node<T> next; //다음번 노드
	
		public Node(T data){//생성자를 통해 내부변수에 저장
			this.data = data; 
		}
	}
	
	//queue는 first in first out. 선입선출방식
	
	private Node<T> head; 	//첫번째노드는 제일 먼저 나감
	private Node<T> last;	//마지막노드는 가장 최신 입력 노드
	
	//add : last 데이터 추가
	public void add(T item){
		Node<T> t = new Node<T>(item);
		if(last != null){
			last.next = t; //마지막노드가 있을 경우 다음번 노드에 t를 추가
		}
		last = t; //마지막노드가 없을 경우 입력
		if(head == null){//첫번째 노드가 비었을 경우 당연히 마지막 노드도 데이터 존재하지 않음
			head = last;
		}
	}

	//remove : first 데이터 꺼냄
	public T remove(){
		if(head == null){
			throw new NoSuchElementException();
		}
		T data = head.data;
		head = head.next;
		if (head == null){
			last = null; //첫번째 노드에 데이터가 없을 경우 마지막노드에도 없음
		}
		return data;
	}

	//peek : first 데이터 조회
	public T peek(){
		if(head == null){
			throw new NoSuchElementException();
		}
		return head.data;
	}
}
	
public class Test2 {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}
}



	


