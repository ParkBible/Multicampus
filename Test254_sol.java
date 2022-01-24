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
			왼쪽이 비었으면 오른쪽 올리고
			오른쪽이 비었으면 왼쪽을 올리고
			양쪽이 비었으면 아무거나 ...

			-- 양쪽이 다 있을 경우는 ?
			트리의 최대값 또는 최소값은 노드의 왼쪽 또는 오른쪽 둘 중 하나는 반드시 null 이다.
			따라서 이넘은 아래의 로직으로 날릴 수 있다 
			if( n.left == null ) {
				return n.right;
			}
			
			왼쪽 트리에서 최대값을 복사&대입하고 해당 최대값 노드를 날리는 방법 또는
			오른쪽 트리에서 최소값을 복사&대입 하고 해당 최소값 노드를 날리는 방법
		*/
		if( n.left == null ) {
			return n.right;
		}
		else if( n.right == null ) {
			return n.left;
		}
		else {
			System.out.println( n.data + " 양쪽 다 있다.");
			
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
		a.left    = delete( a.left );		//	왼쪽 null
		a.right   = delete( a.right );		//	양쪽 null
		root.left = delete( root.left );	//	오른쪽 null
*/		
		root = delete( root );
		print( root, 0 );
	}
}	

/*

*/