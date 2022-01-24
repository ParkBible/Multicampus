package banana;

import static banana.Logic.*;

class Node {
	int data = 0;
	Node left = null;
	Node right = null;
	
	public Node( int data ) {
		this.data = data;
	}
}

class Logic {
	public static void print( Node n, int depth ) {
		if( n != null ) {
			print( n.left, depth+1 );
			
			StringBuffer sb = new StringBuffer();
			for( int i = 0 ; i < depth ; i++ ) {
				sb.append("  ");
			}
			sb.append("{").append(n.data).append("}");
			
			if( n.left != null )
				sb.append(" L:{").append(n.left.data).append("}");
			if( n.right != null )
				sb.append(" R:{").append(n.right.data).append("}");
			
			System.out.println( sb.toString() );
			
			print( n.right, depth+1 );
		}
	}
	
	//	root.left = delete( root.left );
	public static Node delete( Node n ) {
		/*
			������ ������� ������ �ø���
			�������� ������� ������ �ø���
			������ ������� �ƹ��ų� ...

			-- ������ �� ���� ���� ?
			Ʈ���� �ִ밪 �Ǵ� �ּҰ��� ����� ���� �Ǵ� ������ �� �� �ϳ��� �ݵ�� null �̴�.
			���� �̳��� �Ʒ��� �������� ���� �� �ִ� 
			if( n.left == null ) {
				return n.right;
			}
			
			���� Ʈ������ �ִ밪�� ����&�����ϰ� �ش� �ִ밪 ��带 ������ ��� �Ǵ�
			������ Ʈ������ �ּҰ��� ����&���� �ϰ� �ش� �ּҰ� ��带 ������ ���
		*/
		if( n.left == null ) {
			return n.right;
		}
		else if( n.right == null ) {
			return n.left;
		}
		else {
			System.out.println( n.data + " ���� �� �ִ�.");
			
			if( false ) {
				Node max = findMax( n.left );
				n.data = max.data;
				n.left = delete( n.left, max.data );
			} else {
				Node min = findMin( n.right );
				System.out.println( "->" + min.data );
				n.data = min.data;
				n.right = delete( n.right, min.data );
			}
		}
		return n;
	}
	
	public static Node findMin( Node n ) {
		while( n.left != null ) {
			n = n.left;
		}
		return n;
	}	
	
	public static Node findMax( Node n ) {
		while( n.right != null ) {
			n = n.right;
		}
		return n;
	}
}

public class Test254 {
	public static void main( String[] args ) 
	{
		Node root = null;
		root = new Node( 5 );
		
		Node a = root.left = new Node( 3 );
		Node b = root.right = new Node( 8 );
		
		Node c = a.left  = new Node( 1 );
		a.right = new Node( 4 );
		c.right = new Node( 2 );

/*		
		a.left    = delete( a.left );		//	���� null
		a.right   = delete( a.right );		//	���� null
		root.left = delete( root.left );	//	������ null
*/		
		root = delete( root );
		print( root, 0 );
	}
}	

/*

*/