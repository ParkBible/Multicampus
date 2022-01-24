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

public class Test256 {
	public static void main( String[] args ) {
		Node root = new Node( 5 );
		Node a = root.left = new Node( 3 );
		Node b = root.right = new Node( 8 );		
		a.left = new Node( 1 );
		a.right = new Node( 4 );

		//	그림대로 제대로 잘 돌아가고 있음
		Family n = findFamily( null, root, 3 );
		if( n != null ) {
			if( n.parent == null ) {
				root = rotationR( root );
			}
			else if( n.parent.left == n.child ) {
				n.parent.left = rotationR( n.parent.left );
			}
		}

		//	root.left = rotationR( root.left );
		print( root , 0 );
	}	
}

class Family {
	Node parent = null;
	Node child = null;
	
	public Family( Node p, Node c ) {
		this.parent = p;
		this.child  = c;
	}
}

class Logic 
{
	/*
		Family n = findFamily( null, root, 3 );
		System.out.println( n.parent.data );
		System.out.println( n.child.data );
	*/
	public static Family findFamily( Node p, Node n, int data ) 
	{
		Family found = null;
		if( n != null ) {
			if( n.data == data ) {
				found = new Family( p, n );
				//	System.out.println( p.data + "-" + n.data );
			}
			if( found == null ) {
				found = findFamily( n, n.left, data );
			}
			if( found == null ) {
				found = findFamily( n, n.right, data );
			}
		}
		return found;
	}
	
	public static Node rotationR( Node a ) {
		Node b = a.left;
		a.left  = b.right;
		b.right = a;
		return b;
	}
	
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
	

}