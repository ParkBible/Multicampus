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

public class Test246 {
	public static void main( String[] args ) {
		Node root = null;
		root = new Node( 5 );
		
		Node a = root.left = new Node( 3 );
		Node b = root.right = new Node( 8 );
		
		Node c = a.left  = new Node( 1 );
		a.right = new Node( 4 );
		
		Node found = find( root, 5 );
		if( found != null ) {
			System.out.println( found.data );
		}
	}	
}

class Logic 
{
	public static Node find(Node n, int d){
		Node found = null;
		if(n != null){
			if(n.data == d){
				found = n;
			}
			
			if(found == null && n.data>d ){    // n.data(5)�� d���� ũ�� �������θ� ����.
				found = find(n.left, d);
			}
			
			if((found == null) && n.data<d ){   // n.data(5)�� d���� ������ ���������θ� ����.
				found = find(n.right, d);
			}
		}
		return found;
	}
}