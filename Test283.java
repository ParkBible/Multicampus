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
			<, > ���·� ���� Ʈ���� ȸ���غ��� �� �ҿ��� ����. �׷��� �������� ������ Ʈ���� ȸ���ϸ� ���� ����
			���� Ʈ���� �Ʒ� �ڵ�� �ϴ� ������ ����� �� ������ ȸ���ϸ� ������ ������
			
			������ �������� ��� �Ƴ�? bf�� �˰� �ȴ�.
			LL case : bf=-2�̰� left�� bf�� - ���϶�.
			LR case : bf=-2�̰� left�� bf�� + ���϶�.
			RL case : bf=+2�̰� right�� bf�� - ���϶�.
			RR case : bf=+2�̰� right�� bf�� + ���϶�.
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
	
	
