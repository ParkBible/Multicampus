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

class Logic 
{
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
	
	public static Node find( Node n, int data ) {
		Node found = null;
		if( n != null ) {
			if( n.data == data ) {
				found = n;
			}
			if( found == null && n.data > data ) {
				found = find( n.left, data );
			}
			if( found == null && n.data < data ) {
				found = find( n.right, data );
			}
		}
		return found;
	}
	
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
	
	public static Node delete( Node n, int data ) 
	{
		if( n != null ) 
		{
			if( n.data > data ) {
				n.left = delete( n.left, data );
			}
			else if( n.data < data ) {
				n.right = delete( n.right, data );
			}
			else 
			{ 
				if( n.left == null ) {
					return n.right;
				}
				else if( n.right == null ) {
					return n.left;
				}
				else {
					double rand  = Math.random();
					if( rand < 0.5 ) 
					{	
						Node max = findMax( n.left );
						n.data = max.data;
						n.left = delete( n.left, max.data );
					}
					else 
					{
						Node min = findMin( n.right );
						n.data  = min.data;
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

class Tree 
{
	private Node root = null;
	
	public Tree(){ }
	
	public void add2( int data ) {
		root = add( root, data );
	}
	
	public void print2() {
		print( root, 0 );
	}
	
	public Node find2( int data ) {
		Node f = find( root, data );
		return f;
	}
	
	public void delete2( int data ) {
		root = delete( root, data );
	}
	
	private static Family findFamily( Node p, Node n, int data ) 
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
	
	public boolean rotationR2( int data ) 
	{
		Family n = findFamily( null, root, data );
		if( n != null ) {
			if( n.parent == null ) {
				root = rotationR( root );
				return true;
			}
			else if( n.parent.left == n.child ) {
				n.parent.left = rotationR( n.parent.left );
				return true;
			}
		}
		return false;
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

public class Test255 {
	public static void main( String[] args ) {
		Tree tree = new Tree();
		
		tree.add2( 5 );
		tree.add2( 3 );
		tree.add2( 1 );
		tree.add2( 8 );
		tree.add2( 4 );
		
		Node f = tree.find2( 4 );
		if( f != null ) {
			System.out.println( f.data );
		}
		
		//	tree.delete2( 5 );
		//	tree.delete2( 3 );
		
		/*	이것들이 문제다.
		
		root.left = rotationR( root.left );
		root.left = rotationL( root.left );

		매개변수와 리턴되는 부분에 돌리고자 하는 대상의 부모의 포인터가 필요하다.
		root.left - 돌리고 싶은 대상
		root 는 그것의 부모가 되어야 하고 ...
		
		'부모를 찾아내는 함수를 만들어야 한다'
		
		tree.rotationL2( 5 );
		*/
		tree.rotationR2( 5 );
		
		tree.print2();
	}
}

/*	똑 같은 동작을 한다 하더라도 아래쪽 코드가 좀 더 객체지향적으로 보인다.

	Node root = add( root, 5 );
	tree.add( 5 );
	print( root, 0 );
*/


