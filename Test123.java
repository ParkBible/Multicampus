class Node <T>{
	T name = null;
	Node<T> next = null;
	
	Node(T i, Node<T> j){
		this.name = i;
		this.next = j;
	}
}

class XList <X>{    // �̸��� �ٸ��� �ִ°� ����.
	private Node<X> head = null;
	private Node<X> tail = null;
	XList(){
		head = new Node<X>(null, null);     // 0�� null��
		tail = head;
	}
}

public class Test123{
	public static void main(String[] args){
		XList<Integer> l = new XList<Integer>();
	}
}

/*
class Node{
	int name = 0;
	Node next = null;
	
	Node(int i, int j){
		this.name = i;
		this.next = j;
	}
}

class XList{
	private Node head = null;
	private Node tail = null;
	XList(){
		head = new Node(0,Null);
		tail = head;
	]
}

public class Test123{
	public static void main(String[] args){
		XList l = new XList();
	}
}
*/