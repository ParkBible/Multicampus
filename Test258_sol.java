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
		//	LinkedList 처럼 더미노트 하나 끼고 시작한다. 보통 document 노드라고 할때가 많다. ( javascript 영향 )
		Node root = new Node( null );
		Node document = new Node("[document]");
		root.child = document;
		
		Node a = new Node("상품");
		
		Node b = new Node("공산품");
		b.addChild( new Node("IT기기") );
		b.addChild( new Node("가전*") );
		b.addChild( new Node("주방기기") );
		a.addChild( b );
		
		Node c = new Node("수산품");
		c.addChild( new Node("젖갈류") );
		c.addChild( new Node("생물") );
		c.addChild( new Node("건어물*") );
		a.addChild( c );
		
		Node d = new Node("농산품");
		d.addChild( new Node("채소*") );
		d.addChild( new Node("곡물") );
		a.addChild( d );	//	채소 곡물 2개 붙이려면??
		
		document.addChild( a );
		
		Node f = find( document, "IT기기" );
		f.addChild( new Node("스마트폰*") );
		f.addChild( new Node("노트북") );
		
		List<Node> list = new ArrayList<Node>();
		travel( document, list );
		for( Node t: list ) {
			System.out.println( t.name );
		}
		
		
		//	공산품 카테고리 아래의 모든 하위 카테고리만 List 에 담아서 출력하려면??
		/*
		print( [IT기기] );
			-- "IT기기"
			print( [스마트폰] )
				-- "스마트폰"
				print( null )
				print( [노트북] )
					-- "노트북"
					print( null )
					print( null )
			print( [가전] )
				-- "가전"
				print( null )
				print( [주방] )
					-- "주방"
					print( null )
					print( null )
		*/
		
		/*
		print( [IT기기] )
			-- "IT기기"
			print( [스마트폰])
				-- "스마트폰"
				print( null );
				print( [노트북] );
					-- "노트북"
					print( null );
					print( null );
			print( [가전])
				-- "가전"
				print( null );
				print( [주방기기] );
					-- "주방기기"
					print( null );
					print( null );
					
			IT기기 - 스마트폰 - 노트북 - 가전 - 주방기기 : 공산품 아래 다 찍었다!!!
		*/
		Node cate = find( document, "공산품" );
		List<Node> list2 = new LinkedList<Node>();
		list2.add( cate );
		
		orange( cate.child, list2 );
		
		Itearator<Node> it = list2.iterator();
		while( it.hasNext() ) {
			Node nd = it.next();
			System.out.println( "++ " + nd.name );
		}
		
		/*	jdk 1.5 부터 아래코드를 위의 코드로 자동으로 바꿔주는 게 생겼음
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
	
	//	* 가 들어있는 것들을 검색하려면?? . 일단 모든 노드를 방문하는 코드를 짜자
	/*
		유일한 인스턴스를 만들고 매번 재귀호출 할 때 마다 포인터를 넘기면 인스턴스가 여럿 생기는 건 아니니까
		하나의 인스턴스에 조건에 맞는 Node 의 포인터를 담을 수 있다.
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

	
	/*	재귀호출 분석 
	
	find( document, "IT기기" ) [IT기기]
		found = find( "상품" , "IT기기" ) [IT기기]
			found = find( "공산품" , "IT기기" ) : [IT기기]
				found = find( "IT기기" , "IT기기" );
				return [IT기기]
			isNull( found ) ? found = find( null , name )
			return found [IT기기]
		isNull( found ) ? found = find( null , IT기기 )
		return [IT기기]
	*/
	
	//	포인터 두개로 재귀호출 이용해서 검색하는 기본 개념은 트리의 종류에 상관없이 거의 유사하다
	//	이 알고리즘은 처음으로 찾아진 것을 리턴하고 끝내기에 여러개를 모아서 리턴하는 기능은 수행 안한다.
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
