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
		
		Node found = find( root, 4 );
		if( found != null ) {
			System.out.println( found.data );
		}
	}	
}

class Logic 
{
	//	���� ������ �ܿ��� ¥ ���ϴ�.
	
	public static Node find( Node n, int d ) {
		Node found = null;
		if( n != null )
		{
			if( n.data == d )
				found = n;
			
			/*	���� [5] �湮�� ã�� �� 4
				[5] �� ���ʿ��� 5���� ���� ���� ������ ������ �� �ʿ䰡 �ִ�. �������� ����.
				���� 4 �� ã�� ���� [3]�� �湮���̶�� 
				[3] �� ������ 3 ���� ���� ���� ������ �� �ʿ䰡 ���� �������� �� �ʿ䰡 �ִ�.
			*/
			if( found == null && n.data > d ) // n.data[5] , d[4] -- �������� ����.
				found = find( n.left , d );
			
			if( found == null && n.data < d ) // n.data[3] , d[4] -- ���������� ����.
				found = find( n.right , d );
		}			
		return found;
	}
}

/*
	----------------------------------------------------------
	�տ��� ��ã���� ��� ���ȣ��� �Ʒ��� �������� ã���� ���� 
	public static Node find( Node n, int d ) {
		Node found = null;
		if( n != null )
		{
			if( n.data == d )
				found = n;
			
			if( found == null )
				found = find( n.left , d );
			
			if( found == null )
				found = find( n.right , d );
		}			
		return found;
	
	----------------------------------------------------------
	
	�̷��� �ϸ� ã�°� ��° ġ�� �湮�� �� �ȴ�.
	
	public static Node find( Node n, int d ) {
		Node found = null;
		if( n != null )
		{
			if( n.data == d ) {
				found = n;
			}
			
			System.out.println( "-" + n.data );
			find( n.left , d );
			find( n.right , d );
		}			
		return found;
	}
}

	8 3 1 4 �� ��ã���� �̷��� �ϸ� 5�� ã�´�.
	
	public static Node find( Node n, int d ) {
		Node found = null;
		if( n != null )
		{
			if( n.data == d ) {
				found = n;
			}
		}			
		return found;
	}


	----------------------------------------

	public static Node find( Node n, int d ) {
		return null;
	}
}

*/
