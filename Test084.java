
class Node{
	int name = 0;
	Node next = null;
	Node(int i, Node j){
		name = i;
		next = j;
	}
}

class XList{
		Node head = null;
		Node tail = null;
	XList(){
		head = new Node(0, null);
		tail = head;
	}
	
	void add(int i){
		tail.next = new Node(i, null);
		tail = tail.next;
	}
}


public class Test084{
	public static void main(String[] args){
		XList l;
		l = new XList();
		l.add(10);
	}
}


/*
	Ŭ���� �ν��Ͻ� ���������� �ڷ��� ���ú��� ������� ����Լ� new �������ݷ��� �������Լ� null
	
	��ü���� ����� 3�� Ư¡
	1. ��Ӽ� - Ŭ������ ��ӹ޾� Ŭ������ �����.
	2. ���м� - ���߰��� �ϴ� �͵��� ���� �� �־�� �Ѵ�.(���������� ������ �� ����)
	3. ������ - �ϳ��� �ɺ�(�̸� - ������ �Լ���) �� �پ��� ��� ������ �� �־�� �Ѵ�.
*/