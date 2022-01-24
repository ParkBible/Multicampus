class Node{
	int name = 0;
	Node next = null;    // ��������Ӱ� ���ÿ�, ������ ����. �ν��Ͻ��� ����ų �� �ִ�.
}

public class Test074{
	public static void main(String[] args){
		Node head = new Node();
		Node tail = head;
		
		Node tmp = new Node();
		tmp.name = 10;
		tmp.next = null;
		
		head.next = tmp;
		tail = tmp;
		
		tmp = new Node();   // tmp ������ �̹� �����Ƿ� ���� �������� �ʰ�, ���Ը� �Ѵ�.
		tmp.name = 20;
		tmp.next = null;
		
		tail.next = tmp;
		tail = tmp;
		
		for(Node t=head; t!=null; t=t.next){    // 0 10 20
			System.out.println(t.name);
		}
		
		// �� �ڵ尡 �� 10 20�� �������� ����.
		Node post = head;
		Node pre = head.next;
		while(pre!=null){
			post.next = null;
			post = pre;
			pre = pre.next;
		}
		post = null;
		
	}
}

/*
	������ ���� : �ν��Ͻ��� ����ų �� �ִ� ����, �����ͷ� ����Ǵ� ����
	��� ������ �ν��Ͻ��� �����Ǵ� ������ �޸𸮸� �Ҵ�
	������������ ���� :
	null : ��� ������ ������ ���� ����. t=t.next�� �Ѵ��� t�� null�ΰ� Ȯ�εǸ� ����.
*/