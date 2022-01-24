class Node{
	int name = 0;
	Node next = null;
	
	Node(int i, Node j){
		this.name = i;
		this.next = j;
	}
}

class XList
{
	Node head = null;
	Node tail = null;
	
	XList(){
		head = new Node(0,null);    // head�� name�� 0, next�� null�� Node�� ����Ų��.
		tail = head;   // head�� ����Ű�� ���� tail�� ����Ų��.
	}
	
	void add(int i){
		tail.next = new Node(i, null);   // tail.next�� ����Ű�� ���ο� Node�� �����Ѵ�.
		tail = tail.next;    	// tail.next�� ����Ű�� ���� tail�� ����Ű�� �ǰ� tail�� �׻� �� �� ��带 ����Ű�� �ȴ�.
	}
	
	void printAll(){
		// �ڹٴ� �ݺ��� �տ� t ���� ���� �����൵ �ȴ�.
		for( Node t=this.head; t!=null; t=t.next){
			System.out.println(t.name);
		}
	}
	
	void deleteAll(){
		Node post = head;    // ������ 2���� �����̸鼭 �۾� �����ϴ� ���� ��~~���� �ڵ�
		Node pre = head.next;
		
		while(pre != null){
			System.out.println(pre.name); // 10 20
			
			post.next = null;
			post = pre;
			pre = pre.next;
			
			System.out.println(post.name);  // 10 20
		}
	}
}

public class Test079{
	public static void main(String[] args){
		XList l = new XList();    // �ν��Ͻ��� �����Ǿ���. �ڷ����� Xlist. ������ ȣ���.
		l.add(10);    // ���۷��� l �ȿ� �ִ� �Լ��� add�� ȣ���Ѵ�. 
		l.add(20);
		l.printAll();
		
		l.deleteAll();
		

	}
}


/*
	������ �� �� : �������, ����Լ�, �������Լ�, this
	�ڹٿ����� ���ú����� �̸��� ��ġ���� ������ ��������� ����Ҷ� ���� this�� ������ �� �ִ�.
	�� this.next�� next�� �����ִ�.
	��������� �ν��Ͻ� ������ �޸� �Ҵ�. �˾Ƽ� �Ұ�. ���ŵǴ� ������ ����Ű�� �����Ͱ� 0�� �Ǿ��� ��.
*/