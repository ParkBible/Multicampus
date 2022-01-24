package banana;

import static banana.Logic.*;
// ���� import ����� Ŭ�����ε� import static�� static�ϰ� ����� �Լ��� ������� �Ѵ�.

class Node{
	int data = 0;
	Node next = null;
	
	public Node(int data, Node n){
		this.data = data;    // this.data�� ���� �ִ°�, data�� �Ű�����
		next = n;    // �̰� ���� this �Ⱥٿ����ȴ�.
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
		
		// �Ʒ��� �ڵ尡 ���� �ݺ����� ���� ����� �����. ���ȣ���� ���� �����ϼ���.
		
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
	��������� ���ú����� �̸��� ���� ��, ��������?
	this.data�� ������� data�� �ǹ��ϰ� �׳� data�� ���ú�����.
	
	���ȣ�� : �ڵ�� ª���� �޸� �Ҹ�� ����.
*/