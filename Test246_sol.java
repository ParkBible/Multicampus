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
	//	차근 차근히 외워서 짜 봅니다.
	
	public static Node find( Node n, int d ) {
		Node found = null;
		if( n != null )
		{
			if( n.data == d )
				found = n;
			
			/*	현재 [5] 방문중 찾는 값 4
				[5] 의 왼쪽에는 5보다 작은 값만 있으니 왼쪽은 갈 필요가 있다. 오른쪽은 없다.
				만일 4 를 찾기 위해 [3]을 방문중이라면 
				[3] 의 왼편은 3 보다 작은 값만 있으니 갈 필요가 없고 오른편은 갈 필요가 있다.
			*/
			if( found == null && n.data > d ) // n.data[5] , d[4] -- 왼쪽으로 간다.
				found = find( n.left , d );
			
			if( found == null && n.data < d ) // n.data[3] , d[4] -- 오른쪽으로 간다.
				found = find( n.right , d );
		}			
		return found;
	}
}

/*
	----------------------------------------------------------
	앞에서 못찾았을 경우 재귀호출로 아래로 내려가며 찾도록 정리 
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
	
	이렇게 하면 찾는건 둘째 치고 방문은 다 된다.
	
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

	8 3 1 4 는 못찾지만 이렇게 하면 5는 찾는다.
	
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
