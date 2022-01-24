
class Node{
	int name = 0;
	Node next = null;
	
	Node(int i, Node j){
		name = i;
		next = j;
	}
}

class YList{
	Node head = null;
	
	YList(){
		head = new Node(0,null);
	}
	
	// post�� tail�� ������ �Ѵ�. �� �������� pre�� null�� �Ǹ� �� �� ��忡 ��ġ�ϱ� ����.
	// �׷��� 10������ �ִٸ� �ݺ����� 10���� ���ƾ� �ϹǷ� ȿ������ ��������.
	void add(int i){
		Node post = head;
		Node pre = head.next;
		while(pre!=null && pre.name<i){    // && pre.name<i ��� ���� ������������ ���ĵǾ� ����Ѵ�. head.next�� �� ���� ��.
			//System.out.println(pre.name);    //  2. 30(pre.name)�� 40(i)�� ���ϴ� i�� ��ũ��. ��ĭ �Ѿ��.
												// 4. 40(pre.name)�� 20(i)�� ���ϴ� pre.name�� ��ũ��. �ȳѾ��
			post = pre;	
			pre = pre.next;
			
			//System.out.println(post.name);
		}
		post.next = new Node(i, pre);   // 1. �ϴ� �� ���� post ������ 30 �߰�
										// 3. post ������ 40 �߰�.
	}									// 5. post�� pre ���̿� ��� �ϳ��� �߰��ؼ� �ű⿡ 20(i)�� �ִ´�.
	
	
	void printAll(){
		for(Node t=head.next; t!=null; t=t.next){
			System.out.println(t.name);
		}
	}
}

public class Test127{
	public static void main(String[] args){
		YList l = new YList();
		l.add(30);
		l.add(40);
		l.add(20);
		l.add(30);
		l.printAll();
	}
}