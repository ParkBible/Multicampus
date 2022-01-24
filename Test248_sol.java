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

public class Test248_sol {
	public static void main( String[] args ) {
		

/*		아래의 모양대로 노드를 배치하던 걸 함수호출로 !!

		root = new Node( 5 );
		
		Node a = root.left = new Node( 3 );
		Node b = root.right = new Node( 8 );
		
		Node c = a.left  = new Node( 1 );
		a.right = new Node( 4 );
*/		
		Node root = null;
		root = add( root, 5 );
		root = add( root, 3 );
		root = add( root, 8 );
		root = add( root, 1 );
		root = add( root, 4 );
		
		print( root , 0 );
	}	
}

class Logic 
{
/*	
	root = add( null, 5 ) : [5]
		return [5]*;
		
	root = add( [5], 3 ) : [5]
		[5].left = add( null, 3 ) : [3]
			return [3]*
		return [5]	
			
	root = add( [5], 8 ) : [5]
		[5].right = add( null, 8 ) : [8]
			return [8]*
		return [5]
		
	root = add( [5], 1 ) : [5]
		[5].left = add( [3], 1 ) : [3]
			[3].left = add( null, 1 ) : [1]
				return [1]*
			return [3]
		return [5]
		
	root = add( [5], 4 ) : [5]
		[5].left = add( [3], 4 ) : [3]
			[3].right = add( null, 4 ) : [4]
				return [4]*
			return [3]
		return [5]
*/			
	
	public static Node add( Node n, int d ) {
		if( n == null ) {
			n = new Node( d );
		}
		else {
			if( n.data > d )
				n.left = add( n.left , d );
			else if( n.data < d )
				n.right = add( n.right , d );
			else 
				throw new RuntimeException("Data Duplicated");
		}
		return n;
	}
	
	
	//	노드의 깊이를 같이 가져가게끔 함수를 짰음
	public static void print( Node n, int d ) {
		if( n != null ) {
			print( n.left, d+1 );
			System.out.println( n.data + " ["+d+"]" );
			print( n.right, d+1 );
		}
	}
}

