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
		트리 로테이션의 장점 : 작은게 왼쪽, 큰게 오른쪽에 배치된다는 원칙을 그대로 지키면서
		트리의 구조를 바꾸는 코드임.(엄청난 것임)
	*/
	public static void rotationR(Node a){
		Node b = a.left;    // b가 3임. 5를 가리키는 하극상.
		a.left = b.right;    // b가 가리키는 right 다리를 뺏어감.
		b.right = a;
		return b;
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