/*
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
	XList(){   // ������ �� Ŭ���� �̸��� ���� ����� �Ѵ�. �ȱ׷��� ����Ÿ�� �Է��϶�� �������. Xlist��� �߸��Ἥ ������̴�;;
		head = new Node(0, null);
		tail = head;
	}
	
	void add(int i){
		tail.next = new Node(i, null);
		tail = tail.next;
	}
	
}

public class Test080{
	public static void main(String[] args){
		XList l = new XList();
		l.add(10);
		
	}
}
*/



// �ɿ��� ��ü������ ����... �����̶� �𸣸� �ƹ��͵� ���Ѵ�.
/*
class Node{
	int name = 0;   // �̰Ŷ� ������ ���� �ڷ��� ���Ǹ� ����. �������� ���� �κ��� Node�Լ�.
	Node next = null;
	
	Node(int i, Node j){    // Node�� ������! �̸��� ��!! Ŭ������ ���� ���־�� �Ѵ�!
		name = i;
		next = this;  // head ��� ��ü�� ����Ų��.
	}
}

class XList{
	Node head = null;
	Node tail = null;
	
	XList(){    // XList�� ������!
		head = new Node(0, null);   // next�� �ν��Ͻ� �����Ҷ� ���Ծ��ϰ� ���߿� �����ϵ���..
		tail = head;
	}
	
	void add(int i){
		tail.next = new Node(i, null);
		tail = tail.next;
	}
}

public class Test080{
	public static void main(String[] args){
		XList l = new XList();
		l.add(10);
	}
}

*/


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
	
	void printAll(){
		for(Node t=head.next;t!=null; t=t.next){
			System.out.println(t.name);
		}
	}
	
	void deleteAll(){
		Node pre = head.next;
		Node post = head;
		
		while(pre!=null){
			post.next = null;
			post = pre;
			pre = pre.next;
		}
		
	}
	
	int removeLikeQueue(){
		// ����������� �����ϸ� �ȵȴ�.
		if(head.next == null){
			return -1;
		}
		
		
		Node post = head;
		Node pre = head.next;
		
		// �ʱ� 1ȸ ���� : 
		post.next = pre.next;    // ���� ��带 ����Ű�� �ִ� post.next�� ����Ű�� ���� �ǳʶٰ� �Ѵ�. ���� pre ��ĭ �� ��带 ����Ŵ.
		//pre.next = null;    // pre.next�� ����Ű�� ���� null�� �Ѵ�(���ش�).
	
		// �������� ==�� ���� ����� ����Ű�� true. �̷� ������ �߻��� ���� ��尡 �ϳ��϶��ۿ� ����.
		if(tail==pre){
			tail = head;
		}
		
		return pre.name;
		// �� ������ ������ post.next = pre.next; �ڵ忡 ���� pre�� ����Ű�� �ִ� ���� �������.
	}
}

/*
	���� & ť : ������ �ʰ� ���¼���� ����, ť�� �������°� ��������.
*/


public class Test080{
	public static void main(String[] args){
		XList l = new XList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		
		int n = l.removeLikeQueue();
		System.out.println(n);
		System.out.println(l.removeLikeQueue());
		
		l.printAll();
		l.deleteAll();
	}
}