
class Node <T>{
	T data = null;
	Node<T> next = null;
	Node(T i, Node<T> j){
		this.data = i;
		this.next = j;
	}
}

interface IList <Z>{
	public void add(Z i);
	//public void deleteAll();
	//public void printAll();
}	

class XList <X> implements IList<X>{
	Node<X> head = null;
	Node<X> tail = null;
	
	XList(){
		head = new Node<X>(null, null);
		tail = head;
	}
	
	public void add(X i){    // add�� �Ű������� ��� �ؾ�����? ���� int i   // �տ� public �ٿ��ߵ� ������ �ٿ��
		//tail.next = new Node<X>(null, null);
		//tail = tail.next;
		System.out.println(i);
	}
	
	
}


public class Test121{    // ���ʸ��� �������̽� ������� XList �����ֱ�. IList�� �������̽��Դϴ�.
	public static void main(String[] args){
		/*
		IList<String> l = new XList<String>();
		
		l.add("apple");
		l.add("banana");
		l.add("orange");
		l.add("kiwi");
		
		l.printAll();
		
		l.deleteAll();
		l.printAll();
		
		*/
		IList<Integer> t = new XList<Integer>();
		
		t.add(10);
		t.add(20);
		t.add(30);
		t.add(40);
		/*
		t.printAll();
		
		t.deleteAll();
		t.printAll();
		*/
		
		
	}
}

/*
	void printAll(){
		for( Node t=this.head; t!=null; t=t.next){
			System.out.println(t.name);
		}
	}
	
	void deleteAll(){
		Node post = head;
		Node pre = post.next;
		while(pre!=null){
			post.next = null;
			post = pre;
			pre = pre.next;
		}
	}
	
	������� 20�� ���Ͽ�
	1. �⺻���信 �������. ���� �̷� �ڵ� �� �ܿ��� �������� ��Դ´�.
	2. ���������� �ϴ� �� ���ƹ����� �ϳ����� Ǭ��.
	3. �Ѳ����� �������� �̷� �������� ���� �ѹ��� �ϳ�����
	4. Ȯ���� �ڽ��� ���涧���� ����� �ſ��� ������ ����.
	
	���ͳݻ��� ������ �ַ� �ڱ� �ڶ����� ��찡 ����. (������ ���Ƽ�)
	������ �������� �ϳ��� ������ �����ϸ鼭 ������ �ڵ嵵 ���� ��찡 ����ϴ�.
	jdk 1.8 ���� �߰��� ����� �Ű� ����.(1.5���� �߿��� ��ȭ)
*/