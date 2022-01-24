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
	
	public static Node add( Node n, int data ) {
		if( n == null ) {
			n = new Node( data );
		}
		else {
			if( n.data > data ) {
				n.left = add( n.left, data );	
			} else if( n.data < data ) {
				n.right = add( n.right, data );	
			} else {
				throw new RuntimeException("Data Duplication");
			}
		}
		return n;
	}
	/*
		Node f = find( root, 4 );
		if( f != null ) {
			System.out.println( f.data );
		}
	*/
	
	public static Node find( Node n, int data ) {
		Node found = null;
		if( n != null ) {
			if( n.data == data ) {
				found = n;
			}
			//	&& n.data > data 없어도 동작은 한다. 다만 좀 낭비가 있을 뿐이다.
			if( found == null && n.data > data ) {
				found = find( n.left, data );
			}
			if( found == null && n.data < data ) {
				found = find( n.right, data );
			}
		}
		return found;
	}
	
	//	root = rotationR( root );
	public static Node rotationR( Node a ) {
		if( a.left != null ) {
			Node b = a.left;
			a.left = b.right;
			b.right = a;
			return b;
		} else {
			return a;
		}
	}
	
	//	root = rotationL( root );
	public static Node rotationL( Node a ) {
		if( a.right != null ) 
		{
			Node b = a.right;
			a.right = b.left;
			b.left  = a;
			return b;
		} else {
			return a;
		}
	}
	
	//	root = delete( root, 1 );
	/*	그림으로 분석해 보니 ...
		왼쪽이 비었으면 오른쪽을 올리면 되고 , 오른쪽이 비었으면 왼쪽을 올리면 된다.

		이 로직을 돌리면 재귀호출로 전체를 다 돌아다니긴 할 터이니 찾는게 있으면 찾아지긴 할 거다
		if( n != null ) 
		{
			if( n.data > data ) {
				n.left = delete( n.left, data );
			}
			else if( n.data < data ) {
				n.right = delete( n.right, data );
			}
			else { // if( n.data == data ) 
				System.out.println( "삭제대상포착 " + n.data );
			}
		}
		return n;
		
		매개변수 n 을 변경하지 않고 그대로 리턴하는 구조로 만들어서 이것이 root 를 변경시키진 않음
	*/
	public static Node delete( Node n, int data ) {
		if( n != null ) 
		{
			if( n.data > data ) {
				n.left = delete( n.left, data );
			}
			else if( n.data < data ) {
				n.right = delete( n.right, data );
			}
			else { // if( n.data == data ) 
				System.out.println( "삭제대상포착 " + n.data );
				if( n.left == null ) {
					return n.right;
				}
				else if( n.right == null ) {
					return n.left;
				}
				else {
					double rand  = Math.random();
					if( rand < 0.5 ) {
						Node max = findMax( n.left );
						n.data = max.data;
						n.left = delete( n.left, max.data );
					}
					else {
						Node min = findMin( n.right );
						n.data = min.data;
						n.right = delete( n.right, min.data );
					}
				}
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

public class Test253 {
	public static void main( String[] args ) {
		Node root = null;
		
		root = add( root, 5 );
		root = add( root, 3 );
		root = add( root, 8 );
		root = add( root, 1 );
		root = add( root, 4 );
		
		root = add( root, 2 );
		
		//	트리의 임의의 위치에서 로테이션이 두번 일어나도 원래 모양으로 돌아온다.
		/*
			트리는 1을 찾아서 10으로 수정하는 일이 있으면 될까요?? -- 절대 있으면 안된다.
			: 1을 삭제하고 10을 새로이 넣어주는 형태로 운용해야 한다.
			: '그러면 트리의 모양이 변하잖아요? -- 그건 어쩔 수 없다'
		*/
		root = delete( root, 5 );
		print( root, 0 );
	}
}