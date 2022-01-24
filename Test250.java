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

public class Test250 {
	public static void main( String[] args ) {
		Node root = new Node( 5 );
		Node a = root.left = new Node( 3 );
		Node b = root.right = new Node( 8 );		
		a.left = new Node( 1 );
		a.right = new Node( 4 );
		
		root = rotationR(root);
		print( root , 0 );
	}	
}

class Logic 
{
	/*
		Ʈ�� �����̼��� ���� : ������ ����, ū�� �����ʿ� ��ġ�ȴٴ� ��Ģ�� �״�� ��Ű�鼭
		Ʈ���� ������ �ٲٴ� �ڵ���.(��û�� ����)
	*/
	public static void rotationR(Node a){
		Node b = a.left;    // b�� 3��. 5�� ����Ű�� �ϱػ�.
		a.left = b.right;    // b�� ����Ű�� right �ٸ��� ���.
		b.right = a;
		return b;
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