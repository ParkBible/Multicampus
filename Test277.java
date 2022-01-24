package banana;

import static banana.Logic.*;
import java.util.*;

/*	�������� ������ ǥ���ϱ� ���� Ŭ����. �ֹ��� ������ ������ ���� ( �׸����� )
	Vertex �� �޸� ����Ʈ��� �����ϸ� spot �� ��������, distance �� ����ġ�� ������ �� �ִ�
*/
class Edge {
	int spot = 0;		//  ������ ��������
	int distance = 1;	//	���������� �Ÿ�
	
	public Edge( int i ) { spot = i; }
	public Edge( int i, int d ) { spot = i; distance = d; }
}

class Vertex {
	int spot = 0;	//	���� �Ϸù�ȣ
	List<Edge> list = null;		// �ϳ��� Vertex ���� ����ϴ� Edge �� ������ �� �� �ִ�.
	
	public Vertex( int i ) {
		this.spot = i;
		list = new ArrayList<Edge>();
	}
}

/*
	ArrayList : ������ ���Ծ��� �ӵ� ������. �߰��߰��� ���� ������ �Ϳ� ���ϴ�. ( ����� �а� )
	LinkedList : �ӵ� ������ ������ ���� ����. �߰��߰��� ���� ������ �Ϳ� ���ϴ�.
*/
class RelatedList {
	private List<Vertex> list = null;
	
	public RelatedList() {
		list = new ArrayList<Vertex>();	 // �ӵ�����!!
	}
	
	public void add( int spot ) {
		list.add( new Vertex( spot ) );
	}
	
	//	Vertex vx = rl.find( spot );
	public Vertex find( int spot ) {
		Vertex found = null;
		for( Vertex v : list ) {
			if( v.spot == spot ) {
				found = v;
				break;
			}
		}
		return found;
	}
	
	//	rList.connect( 0, 1 );
	public void connect( int from, int to ) {
		Vertex found = find( from );
		
		/*	�� Vertex �� edge �� list �� ������ �ִ�
			�ű⿡ edge �� �űԵ���� �ָ�
			������ ǥ���� �ȴ� ( �׸����� )
		*/
		if( found != null ) {
			found.list.add( new Edge( to ) );	
		}
	}

	public void print( boolean distNot ) {
		StringBuffer sb = new StringBuffer();
		
		for( Vertex v : list ) {
			sb.append("[").append( v.spot ).append("] ");
			
			for( Edge e : v.list ) {
				sb.append("[").append(e.spot);
				if( distNot == false ){
					sb.append(".").append(e.distance);
				}
				sb.append("]");
				
			}
			sb.append("\r\n");
		}
		
		System.out.println( sb.toString() );
	}
	
	public void connect2( int a, int b ) {
		connect( a, b );
		connect( b, a );
	}
	
	public boolean[] newVisited() {
		return new boolean[ list.size() ];
	}
}

public class Test277 {
	public static void main( String[] args ) {
		RelatedList rList = new RelatedList();
		rList.add( 0 );	rList.add( 1 );	rList.add( 2 );	rList.add( 3 );	rList.add( 4 );
		
		rList.connect2( 0, 1 );	rList.connect2( 0, 2 );
		rList.connect2( 0, 4 );	rList.connect2( 1, 2 );
		rList.connect2( 2, 3 );	rList.connect2( 2, 4 );
		rList.connect2( 3, 4 );
		
		rList.print( true );
		
		boolean[] visited = rList.newVisited();
		dfs( 3, visited, rList );
	}
}

class Logic {
	/*	[ O X X X X ]
		dfs( 0 );
			visited : 0 [ O X X X X ]
			dfs( 1 );
				visited : 0 1 [ O O X X X ]
				dfs( 2 );
					visited : 0 1 2 [ O O O X X ]
					dfs( 3 );
						visited : 0 1 2 3 [ O O O O X ]
						dfs( 4 );
							visited : 0 1 2 3 4 [ O O O O O ]
							���ȣ��X
							
		������ ���ư��°� ������ �� �� ������ �ؾ� �ϴ���
	
	*/
	public static void dfs( int spot, boolean[] visited, RelatedList rl ) {
		visited[spot] = true;
		System.out.println( "visited : " + spot );
		
		Vertex vx = rl.find( spot );
		for( Edge e : vx.list ) {
			if( visited[e.spot] == false ) {
				dfs( e.spot , visited, rl );
			}
		}
	}
}

/*	
	�� ���� : vertex
	���� ������ : spot ( int )
	�� ���� : edge ( from , to , distance ) ... �ϳ��� vertex �� ������ �����Ѵ�.


[0] [1][2][4]
[1] [0][2]
[2] [0][1][3][4]
[3] [2][4]
[4] [0][2][3]

visited : 3
visited : 2
visited : 0
visited : 1
visited : 4

*/