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

public class Test283 {
	public static void main( String[] args ) {
		/*
			<, > 형태로 꺾인 트리는 회전해봐야 별 소용이 없다. 그런데 직선으로 기울어진 트리는 회전하면 균형 잡음
			꺾인 트리는 아래 코드로 일단 균형을 만들고 그 다음에 회전하면 균형이 잡힌다
			
			꺾인지 직선인지 어떻게 아나? bf로 알게 된다.
			LL case : bf=-2이고 left의 bf가 - 값일때.
			LR case : bf=-2이고 left의 bf가 + 값일때.
			RL case : bf=+2이고 right의 bf가 - 값일때.
			RR case : bf=+2이고 right의 bf가 + 값일때.
		*/
		Node root = new Node(3);
		Node t = root.left = new Node(1);
		t.right = new Node(2);
		
		root.left = rotationL(root.left);
		print( root , 0 );
		System.out.println();
		
		root = rotationR( root );
		print( root , 0 );
	}	
}

class Logic 
{
	public static Node rotationR( Node a ) {
		if(a.left != null){
			Node b = a.left;
			b.right = a;
			a.left = b.right;
			return b;
		}
		else{
			return a;
		}
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
	
	
