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
	
	/*	���⸦ �� �� ���Ŵ� ... sb.append("{").append( data ).append("}") 
	
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
	
	/*	�׸����� �ľ�����
		LinkedList �� �� �ڿ� �ٴ� ����!!
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
		//	LinkedList ó�� ���̳�Ʈ �ϳ� ���� �����Ѵ�. ���� document ����� �Ҷ��� ����. ( javascript ���� )
		Node root = new Node( null );
		Node document = new Node("[document]");
		root.child = document;
		
		Node a = document.addChild( new Node("��ǰ") );
		
		Node b = a.addChild( new Node("����ǰ") );
		
		//	�̷� �ڵ��� ������ ������ ���� return n �� �ִ�. . �տ��� �� �ٲ㵵 �Ǵ���
		b.addChild( new Node("IT���") )
			.addSibling( new Node("����*") )
			.addSibling( new Node("�ֹ���") );
		
		Node c = a.addChild( new Node("����ǰ") );
		c.addChild( new Node("������") );
		c.addChild( new Node("����") );
		c.addChild( new Node("�Ǿ*") );
		
		Node d = a.addChild( new Node("���ǰ") );
		d.addChild( new Node("ä��*") );
		d.addChild( new Node("�") );
		
		Node f = find( document, "IT���" );
		f.addChild( new Node("����Ʈ��*") );
		f.addChild( new Node("��Ʈ��") );
		
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
