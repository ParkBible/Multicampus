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
		

		//아래의 모양대로 노드를 배치하던 걸 함수호출로 !!

		Node root = new Node( 5 );
		
		Node a = root.left = new Node( 3 );
		
		root = temp(root);    // 이 함수를 실행하면 root는 5 노드의 left인 3을 가리키게 됨.
								// 그럼 root는 3으로 바뀌고, 가비지 콜렉션에 의해 5는 사라짐.
		print( root , 0 );
		
		root = temp2(root);
		print(root, 0);
	}	
}

class Logic 
{
	// 트리 로테이션의 기본동작 일부
	public static Node temp2(Node n){
		Node t = n.left;
		t.left = null;
		t.right = n;
		return t;
	}
	
	public static Node temp(Node n){
		return n.left;
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

