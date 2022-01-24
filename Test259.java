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
		//	LinkedList 처럼 더미노트 하나 끼고 시작한다. 보통 document 노드라고 할때가 많다. ( javascript 영향 )
		Node root = new Node( null );
		Node document = new Node("[document]");
		root.child = document;
		
		Node a = document.addChild( new Node("상품") );
		
		Node b = a.addChild(new Node("공산품"));    // 이렇게 바로 넣어본다.
		// 이게 가능한 이유는 return n; 때문. 줄바꿔도 돌아간다.
		b.addChild( new Node("IT기기") )
			.addSibling( new Node("가전*") )
			.addSibling( new Node("주방기기") );
		
		Node c = a.addChild(new Node("수산품"));
		c.addChild( new Node("젖갈류") );
		c.addChild( new Node("생물") );
		c.addChild( new Node("건어물*") );
		
		Node d = a.addChild(new Node("농산품"));
		d.addChild( new Node("채소*") );
		d.addChild( new Node("곡물") );
		
		Node f = find( document, "IT기기" );
		f.addChild( new Node("스마트폰*") );
		f.addChild( new Node("노트북") );
		
		print( document, 0 );
		/*
			상품 > 공산품 > IT기기 > 노트북
			이런 식으로 특정 노드의 상위 카테고리부터 차례로 출력 가능하게 하려면?
			결과를 List에 담아서 출력하는 코드로 만들기.
			재귀호출 안 쓰면 못푼다.
		*/
		
		Node f2 = find( document, "노트북" );
		print( document, 0 );
		
		List<Node> stack = new LinkedList<Node>();
		Node f2 = banana(document, "IT기기", stack);
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

	// 찾기만 하면 바로 멈춘다. 끝까지 돌아가지 않음.
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
	
	// 일단 find하면서 스택에 넣고, null이면 뺌.
	public static Node banana( Node n, String name, List<Node> stack ) {
		Node found = null;
		if( n != null ) {
			if( name.equals( n.name ) ) {
				stack.add(n);
				found = n;
			}
			if( found == null ) {    // 없으면 밑으로 넘어감
				stack.add(n);
				found = banana( n.child , name, stack );    // 자식이 더이상 없으면 바로 밑의 if문으로 감.
			}
			if( found == null ) {    // 이전 sibling의 자식에 없으면 옆으로 넘어가는데 이전 sibling을 삭제함.
				stack.remove(stack.size()-1);
				found = banana( n.sibling , name, stack );
			}
		}
		return found;
	}
	
	/*
		일단 find하면서 스택에 넣고, null이면 뺌.
		찾는 대상은 [곡물]
		[상품] [농산품] [곡물]
		[document] [상품] [공산품] [IT기기] [스마트폰] 
		banana([document])
			stack.in & found = banana([상품])
				stack.in & found = banana([공산품])
					stack.in & found = banana([IT기기])	
						stack.in & found = banana([스마트폰])
							isnull(found)? stack.pop & found = banana([노트북])    // 스마트폰에 자식이 없고 found도 null이므로 노트북으로 넘어감
								stack.in & found = banana([노트북])
									isnull(found)? stack.pop & found = banana(null)
					isnull(found)? stack.pop & found = banana([가전])
						stack.in & found = banana([가전])
								isnull(found)? stack.pop & found = banana(null)
					isnull(found)? stack.pop & found = banana([주방기기])
						stack.in & found = banana([주방기기])
								isnull(found)? stack.pop & found = banana(null)
				isnull(found)? stack.pop & found = banana([수산품])
					stack.in & found = banana([젓갈류])
						isnull(found)? stack.pop & found = banana([null])
					stack.in & found = banana([생물])
						isnull(found)? stack.pop & found = banana([null])
					stack.in & found = banana([건어물])
						isnull(found)? stack.pop & found = banana([null])
					isnull(found)? stack.pop & found = banana(null)
				stack.in & found = banana([농산품])
					stack.in & found = banana([채소])
						stack.in & found = banana([곡물])
	
				
	*/
}


/*
		banana([document])
			stack.in & found = banana([상품])
				stack.in & found = banana([공산품])
					stack.in & found = banana([IT기기])	
						stack.in & found = banana([스마트폰])
						...
						isnull(found)? stack.pop & found = banana([가전])
					isnull(found)? stack.pop & found = banana([수산품])
				isnull(found)? stack.pop & found = banana(null)
			isnull(found)? stack.pop & found = banana(null)
*/