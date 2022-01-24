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
	
	public void addChild( Node n ) {
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
	}
}

public class Test258_sol {
	public static void main( String[] args ) 
	{
		//	LinkedList ó�� ���̳�Ʈ �ϳ� ���� �����Ѵ�. ���� document ����� �Ҷ��� ����. ( javascript ���� )
		Node root = new Node( null );
		Node document = new Node("[document]");
		root.child = document;
		
		Node a = new Node("��ǰ");
		
		Node b = new Node("����ǰ");
		b.addChild( new Node("IT���") );
		b.addChild( new Node("����*") );
		b.addChild( new Node("�ֹ���") );
		a.addChild( b );
		
		Node c = new Node("����ǰ");
		c.addChild( new Node("������") );
		c.addChild( new Node("����") );
		c.addChild( new Node("�Ǿ*") );
		a.addChild( c );
		
		Node d = new Node("���ǰ");
		d.addChild( new Node("ä��*") );
		d.addChild( new Node("�") );
		a.addChild( d );	//	ä�� � 2�� ���̷���??
		
		document.addChild( a );
		
		Node f = find( document, "IT���" );
		f.addChild( new Node("����Ʈ��*") );
		f.addChild( new Node("��Ʈ��") );
		
		List<Node> list = new ArrayList<Node>();
		travel( document, list );
		for( Node t: list ) {
			System.out.println( t.name );
		}
		
		
		//	����ǰ ī�װ� �Ʒ��� ��� ���� ī�װ��� List �� ��Ƽ� ����Ϸ���??
		/*
		print( [IT���] );
			-- "IT���"
			print( [����Ʈ��] )
				-- "����Ʈ��"
				print( null )
				print( [��Ʈ��] )
					-- "��Ʈ��"
					print( null )
					print( null )
			print( [����] )
				-- "����"
				print( null )
				print( [�ֹ�] )
					-- "�ֹ�"
					print( null )
					print( null )
		*/
		
		/*
		print( [IT���] )
			-- "IT���"
			print( [����Ʈ��])
				-- "����Ʈ��"
				print( null );
				print( [��Ʈ��] );
					-- "��Ʈ��"
					print( null );
					print( null );
			print( [����])
				-- "����"
				print( null );
				print( [�ֹ���] );
					-- "�ֹ���"
					print( null );
					print( null );
					
			IT��� - ����Ʈ�� - ��Ʈ�� - ���� - �ֹ��� : ����ǰ �Ʒ� �� �����!!!
		*/
		Node cate = find( document, "����ǰ" );
		List<Node> list2 = new LinkedList<Node>();
		list2.add( cate );
		
		orange( cate.child, list2 );
		
		Itearator<Node> it = list2.iterator();
		while( it.hasNext() ) {
			Node nd = it.next();
			System.out.println( "++ " + nd.name );
		}
		
		/*	jdk 1.5 ���� �Ʒ��ڵ带 ���� �ڵ�� �ڵ����� �ٲ��ִ� �� ������
		for( Node nd : list2 ) {
			System.out.println( "++ " + nd.name );
		}
		*/
		
		//	print( document, 0 );
	}
}

class Logic 
{
	public static void orange( Node n, List<Node> list ) {
		if( n != null ) {
			list.add( n );
			orange( n.child, list );
			orange( n.sibling, list );
		}
	}	
	
	
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
	
	//	* �� ����ִ� �͵��� �˻��Ϸ���?? . �ϴ� ��� ��带 �湮�ϴ� �ڵ带 ¥��
	/*
		������ �ν��Ͻ��� ����� �Ź� ���ȣ�� �� �� ���� �����͸� �ѱ�� �ν��Ͻ��� ���� ����� �� �ƴϴϱ�
		�ϳ��� �ν��Ͻ��� ���ǿ� �´� Node �� �����͸� ���� �� �ִ�.
	*/
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

	
	/*	���ȣ�� �м� 
	
	find( document, "IT���" ) [IT���]
		found = find( "��ǰ" , "IT���" ) [IT���]
			found = find( "����ǰ" , "IT���" ) : [IT���]
				found = find( "IT���" , "IT���" );
				return [IT���]
			isNull( found ) ? found = find( null , name )
			return found [IT���]
		isNull( found ) ? found = find( null , IT��� )
		return [IT���]
	*/
	
	//	������ �ΰ��� ���ȣ�� �̿��ؼ� �˻��ϴ� �⺻ ������ Ʈ���� ������ ������� ���� �����ϴ�
	//	�� �˰����� ó������ ã���� ���� �����ϰ� �����⿡ �������� ��Ƽ� �����ϴ� ����� ���� ���Ѵ�.
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
