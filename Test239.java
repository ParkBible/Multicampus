package banana;

import static banana.Logic.*;
// 보통 import 대상은 클래스인데 import static은 static하게 선언된 함수를 대상으로 한다.

class Node{
	int data = 0;
	Node next = null;
	
	public Node(int data, Node n){
		this.data = data;    // this.data는 위에 있는거, data는 매개변수
		next = n;    // 이건 굳이 this 안붙여도된다.
	}
}


public class Test239{
	public static void main(String[] args){
		Node head = new Node(0,null);
		Node tail = head;
		
		tail.next = new Node(10, null);
		tail = tail.next;
		
		tail.next = new Node(20, null);
		tail = tail.next;
		
		tail.next = new Node(30, null);
		tail = tail.next;
		
		/*
		for(Node t=head.next; t!=null; t=t.next){
			System.out.println(t.data);
		}
		*/
		
		// 아래의 코드가 위의 반복문과 동일 결과를 만든다. 재귀호출을 통해 구현하세요.
		
		print(head.next);
	}
}

class Logic{
	public static void print(Node t){
		if(t!=null){
			System.out.println(t.data);
			print(t.next);
		}
	}
}

/*
	멤버변수와 로컬변수가 이름이 같을 때, 구별법은?
	this.data는 멤버변수 data를 의미하고 그냥 data는 로컬변수다.
	
	재귀호출 : 코드는 짧지만 메모리 소모는 많다.
*/