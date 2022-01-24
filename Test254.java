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
	
	// 왼쪽이 비었으면 오른쪽을 올리면 되고, 오른쪽이 비었으면 왼쪽을 올리면 된다.
	// 양쪽이 비었으면 아무거나,,
	
	// 트리의 최대값 또는 최소값은 노드의 왼쪽 또는 오른쪽이 무조건 null이다.
	public static Node delete(Node n){
		if(n.left == null){    // 왼쪽 비었다
			System.out.println(n.data + "왼쪽 비었음");
			return n.right;    // 오른쪽 올린다
		}
		else if(n.right == null){
			System.out.println(n.data + "오른쪽 비었음");
			return n.left;
		}
		else{
			Node max = findMax(n.left);
			n.data = max.data;
			n.left = delete(n.left, max.data);
		}
		return n;
	}
	public static Node findMax(Node n){
		while(n.right != null){
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
		c.right = new Node(2);
		
		a.left = delete(a.left);    // 왼쪽 null
		a.right = delete(a.right);		// 오른쪽 null
		root.left = delete(root.left);    // 양쪽 null
	
		print( root, 0 );
	}
}	
	

