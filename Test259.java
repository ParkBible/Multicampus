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
		
		Node b = a.addChild(new Node("����ǰ"));    // �̷��� �ٷ� �־��.
		// �̰� ������ ������ return n; ����. �ٹٲ㵵 ���ư���.
		b.addChild( new Node("IT���") )
			.addSibling( new Node("����*") )
			.addSibling( new Node("�ֹ���") );
		
		Node c = a.addChild(new Node("����ǰ"));
		c.addChild( new Node("������") );
		c.addChild( new Node("����") );
		c.addChild( new Node("�Ǿ*") );
		
		Node d = a.addChild(new Node("���ǰ"));
		d.addChild( new Node("ä��*") );
		d.addChild( new Node("�") );
		
		Node f = find( document, "IT���" );
		f.addChild( new Node("����Ʈ��*") );
		f.addChild( new Node("��Ʈ��") );
		
		print( document, 0 );
		/*
			��ǰ > ����ǰ > IT��� > ��Ʈ��
			�̷� ������ Ư�� ����� ���� ī�װ����� ���ʷ� ��� �����ϰ� �Ϸ���?
			����� List�� ��Ƽ� ����ϴ� �ڵ�� �����.
			���ȣ�� �� ���� ��Ǭ��.
		*/
		
		Node f2 = find( document, "��Ʈ��" );
		print( document, 0 );
		
		List<Node> stack = new LinkedList<Node>();
		Node f2 = banana(document, "IT���", stack);
		for(Node t : stack){
			System.out.println(t.name);
		}
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

	// ã�⸸ �ϸ� �ٷ� �����. ������ ���ư��� ����.
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
	
	// �ϴ� find�ϸ鼭 ���ÿ� �ְ�, null�̸� ��.
	public static Node banana( Node n, String name, List<Node> stack ) {
		Node found = null;
		if( n != null ) {
			if( name.equals( n.name ) ) {
				stack.add(n);
				found = n;
			}
			if( found == null ) {    // ������ ������ �Ѿ
				stack.add(n);
				found = banana( n.child , name, stack );    // �ڽ��� ���̻� ������ �ٷ� ���� if������ ��.
			}
			if( found == null ) {    // ���� sibling�� �ڽĿ� ������ ������ �Ѿ�µ� ���� sibling�� ������.
				stack.remove(stack.size()-1);
				found = banana( n.sibling , name, stack );
			}
		}
		return found;
	}
	
	/*
		�ϴ� find�ϸ鼭 ���ÿ� �ְ�, null�̸� ��.
		ã�� ����� [�]
		[��ǰ] [���ǰ] [�]
		[document] [��ǰ] [����ǰ] [IT���] [����Ʈ��] 
		banana([document])
			stack.in & found = banana([��ǰ])
				stack.in & found = banana([����ǰ])
					stack.in & found = banana([IT���])	
						stack.in & found = banana([����Ʈ��])
							isnull(found)? stack.pop & found = banana([��Ʈ��])    // ����Ʈ���� �ڽ��� ���� found�� null�̹Ƿ� ��Ʈ������ �Ѿ
								stack.in & found = banana([��Ʈ��])
									isnull(found)? stack.pop & found = banana(null)
					isnull(found)? stack.pop & found = banana([����])
						stack.in & found = banana([����])
								isnull(found)? stack.pop & found = banana(null)
					isnull(found)? stack.pop & found = banana([�ֹ���])
						stack.in & found = banana([�ֹ���])
								isnull(found)? stack.pop & found = banana(null)
				isnull(found)? stack.pop & found = banana([����ǰ])
					stack.in & found = banana([������])
						isnull(found)? stack.pop & found = banana([null])
					stack.in & found = banana([����])
						isnull(found)? stack.pop & found = banana([null])
					stack.in & found = banana([�Ǿ])
						isnull(found)? stack.pop & found = banana([null])
					isnull(found)? stack.pop & found = banana(null)
				stack.in & found = banana([���ǰ])
					stack.in & found = banana([ä��])
						stack.in & found = banana([�])
	
				
	*/
}


/*
		banana([document])
			stack.in & found = banana([��ǰ])
				stack.in & found = banana([����ǰ])
					stack.in & found = banana([IT���])	
						stack.in & found = banana([����Ʈ��])
						...
						isnull(found)? stack.pop & found = banana([����])
					isnull(found)? stack.pop & found = banana([����ǰ])
				isnull(found)? stack.pop & found = banana(null)
			isnull(found)? stack.pop & found = banana(null)
*/