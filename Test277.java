package banana;

import static banana.Logic.*;
import java.util.*;

/*	지점과의 연결을 표현하기 위한 클래스. 쌍방향 연결을 생각해 보면 ( 그림참조 )
	Vertex 에 달린 리스트라고 생각하면 spot 은 도착지점, distance 는 가중치로 생각할 수 있다
*/
class Edge {
	int spot = 0;		//  연결의 도착지점
	int distance = 1;	//	지점까지의 거리
	
	public Edge( int i ) { spot = i; }
	public Edge( int i, int d ) { spot = i; distance = d; }
}

class Vertex {
	int spot = 0;	//	지점 일련번호
	List<Edge> list = null;		// 하나의 Vertex 에서 출발하는 Edge 는 여러개 일 수 있다.
	
	public Vertex( int i ) {
		this.spot = i;
		list = new ArrayList<Edge>();
	}
}

/*
	ArrayList : 기억공간 적게쓰고 속도 빠르다. 중간중간에 들어가고 나가는 것에 약하다. ( 땡기고 밀고 )
	LinkedList : 속도 느리고 공간도 많이 쓴다. 중간중간에 들어가고 나가는 것에 강하다.
*/
class RelatedList {
	private List<Vertex> list = null;
	
	public RelatedList() {
		list = new ArrayList<Vertex>();	 // 속도문제!!
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
		
		/*	각 Vertex 는 edge 의 list 를 가지고 있다
			거기에 edge 를 신규등록해 주면
			연결이 표현이 된다 ( 그림참조 )
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
							재귀호출X
							
		막혀서 돌아가는게 있으면 좀 더 생각을 해야 하더라
	
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
	각 지점 : vertex
	지점 고유명 : spot ( int )
	각 연결 : edge ( from , to , distance ) ... 하나의 vertex 에 여러개 존재한다.


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