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
			//	&& n.data > data ��� ������ �Ѵ�. �ٸ� �� ���� ���� ���̴�.
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
	/*	�׸����� �м��� ���� ...
		������ ������� �������� �ø��� �ǰ� , �������� ������� ������ �ø��� �ȴ�.

		�� ������ ������ ���ȣ��� ��ü�� �� ���ƴٴϱ� �� ���̴� ã�°� ������ ã������ �� �Ŵ�
		if( n != null ) 
		{
			if( n.data > data ) {
				n.left = delete( n.left, data );
			}
			else if( n.data < data ) {
				n.right = delete( n.right, data );
			}
			else { // if( n.data == data ) 
				System.out.println( "����������� " + n.data );
			}
		}
		return n;
		
		�Ű����� n �� �������� �ʰ� �״�� �����ϴ� ������ ���� �̰��� root �� �����Ű�� ����
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
				System.out.println( "����������� " + n.data );
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
		
		//	Ʈ���� ������ ��ġ���� �����̼��� �ι� �Ͼ�� ���� ������� ���ƿ´�.
		/*
			Ʈ���� 1�� ã�Ƽ� 10���� �����ϴ� ���� ������ �ɱ��?? -- ���� ������ �ȵȴ�.
			: 1�� �����ϰ� 10�� ������ �־��ִ� ���·� ����ؾ� �Ѵ�.
			: '�׷��� Ʈ���� ����� �����ݾƿ�? -- �װ� ��¿ �� ����'
		*/
		root = delete( root, 5 );
		print( root, 0 );
	}
}