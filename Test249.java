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

public class Test249 {
	public static void main( String[] args ) {
		

		//�Ʒ��� ����� ��带 ��ġ�ϴ� �� �Լ�ȣ��� !!

		Node root = new Node( 5 );
		
		Node a = root.left = new Node( 3 );
		
		root = temp(root);    // �� �Լ��� �����ϸ� root�� 5 ����� left�� 3�� ����Ű�� ��.
								// �׷� root�� 3���� �ٲ��, ������ �ݷ��ǿ� ���� 5�� �����.
		print( root , 0 );
		
		root = temp2(root);
		print(root, 0);
	}	
}

class Logic 
{
	// Ʈ�� �����̼��� �⺻���� �Ϻ�
	public static Node temp2(Node n){
		Node t = n.left;
		t.left = null;
		t.right = n;
		return t;
	}
	
	public static Node temp(Node n){
		return n.left;
	}
	//	����� ���̸� ���� �������Բ� �Լ��� ®��
	public static void print( Node n, int d ) {
		if( n != null ) {
			print( n.left, d+1 );
			System.out.println( n.data + " ["+d+"]" );
			print( n.right, d+1 );
		}
	}
}

