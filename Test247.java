package banana;

import static banana.Logic.*;

class Node {
	int data = 0;
	Node left  = null;
	Node right = null;
	
	public Node( int data ) {
		this.data = data;
	}
}

public class Test247 {
	public static void main( String[] args ) {
		Node root = null;
		/*
		Node root = null;
		root = new Node( 5 );
		
		Node a = root.left = new Node( 3 );
		Node b = root.right = new Node( 8 );
		
		Node c = a.left  = new Node( 1 );
		a.right = new Node( 4 );
		*/
		
		root = add(root, 5);
		root = add(root, 3);
		
		print(root, 0);
	}	
}

// �̶����� ���ڵ����� ��� ��ġ�ϴ� �� �Լ�ȣ��� �غ���.
class Logic{
	// ����� ���̸� ���� �������Բ� �Լ��� ®��
	public static Node add(Node n, int d){
		if(n == null){
			n = new Node(d);
		}
		else{
			n.left = add(n.left, d);    // �� ��°�� 5�̹Ƿ�(null �ƴ�) �� �ڵ� ����.
		}
		return n;
	}
	
	// ����� ���̸� ���� �������Բ� �Լ��� ®��
	public static void print(Node n, int d){
		if(n!=null){
			print(n.left, d+1);
			System.out.println(n.data + "[" + d + "]");
			print(n.right, d+1);
		}
	}
}

/*


*/