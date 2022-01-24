package banana;

import static banana.Logic.*;
import java.util.*;

class Node {
	String name = null;
	Node child = null;
	Node sibling = null;
	
	public Node( String n ) {
		this.name = n;
	}
	
	/*	여기를 좀 손 볼거다 ... sb.append("{").append( data ).append("}") 
	
	*/
	public Node addChild( Node n ) {
		if( child == null ) {
			child = n;
		}
		else {
			Node t = child;
			while( t.sibling != null ) {
				t = t.sibling;
			}
			t.sibling = n;
		}
		return n;
	}
	
	/*	그림으로 파악하자
		LinkedList 의 맨 뒤에 붙는 듯한!!
	*/
	public Node addSibling( Node n ) {
		Node t = this;
		while( t.sibling != null ) {
			t = t.sibling;
		}
		t.sibling = n;
		return n;
	}
}

public class Test259 {
	public static void main( String[] args ) 
	{
		//	LinkedList 처럼 더미노트 하나 끼고 시작한다. 보통 document 노드라고 할때가 많다. ( javascript 영향 )
		Node root = new Node( null );
		Node document = new Node("[document]");
		root.child = document;
		
		Node a = document.addChild( new Node("상품") );
		
		Node b = a.addChild( new Node("공산품") );
		
		//	이런 코딩이 가능한 이유는 위의 return n 에 있다. . 앞에서 줄 바꿔도 되더라
		b.addChild( new Node("IT기기") )
			.addSibling( new Node("가전*") )
			.addSibling( new Node("주방기기") );
		
		Node c = a.addChild( new Node("수산품") );
		c.addChild( new Node("젖갈류") );
		c.addChild( new Node("생물") );
		c.addChild( new Node("건어물*") );
		
		Node d = a.addChild( new Node("농산품") );
		d.addChild( new Node("채소*") );
		d.addChild( new Node("곡물") );
		
		Node f = find( document, "IT기기" );
		f.addChild( new Node("스마트폰*") );
		f.addChild( new Node("노트북") );
		
		print( document, 0 );
	}
}

class Logic 
{
	public static void print( Node n, int depth ) {
		if( n != null ) {
			StringBuffer sb = new StringBuffer();
			for( int i = 0 ; i < depth ; i++ ) {
				sb.append("   ");
			}
			sb.append("{").append(n.name).append("}");
			System.out.println( sb.toString() );
			
			print( n.child, depth+1 );
			print( n.sibling, depth );
		}
	}
	
	public static void travel( Node n, List<Node> lst ) {
		if( n != null ) 
		{
			if( n.name.endsWith("*") ) {
				//	System.out.println( n.name + " " + lst.hashCode() );
				lst.add( n );
			}
			travel( n.child , lst );
			travel( n.sibling , lst );
		}
	}

	public static Node find( Node n, String name ) {
		Node found = null;
		if( n != null ) {
			if( name.equals( n.name ) ) {
				found = n;
			}
			if( found == null ) {
				found = find( n.child , name );
			}
			if( found == null ) {
				found = find( n.sibling , name );
			}
		}
		return found;
	}
}
