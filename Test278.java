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
	
	//	return this; 가 만드는 효과 : rList.add( 0 ).add( 1 ).add( 2 ).add( 3 ).add( 4 );
	public RelatedList add( int spot ) {
		list.add( new Vertex( spot ) );
		return this;
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
	
	public RelatedList connect2( int a, int b ) {
		connect( a, b );
		connect( b, a );
		return this;
	}
	
	public boolean[] newVisited() {
		return new boolean[ list.size() ];
	}
}

public class Test278 {
	public static void main( String[] args ) {
		RelatedList rList = new RelatedList();
		
		// 이런게 가능하게 하려면? add함수의 리턴을 this라고 해준다.
		rList.add( 0 ).add( 1 ).add( 2 ).add( 3 ).add( 4 );
		
		rList.connect2( 0, 1 ).connect2( 0, 2 ).connect2( 0, 4 )
			.connect2( 1, 2 )
			.connect2( 2, 3 ).connect2( 2, 4 )
			.connect2( 3, 4 );
		
		rList.print( true );
		
		boolean[] visited = rList.newVisited();
		bfs( 1, visited, rList );
	}
}

class Logic {
	
	//	재귀호출 안 쓰고 + 가까이 있는 것들 우선으로 방문한다 : 친구 - 친친구 ... 이런 식으로 
	/*
		bfs(1)
			[] [ X X X X X ]
			
			[1] [ X O X X X ]
			if( size : 1 ) {
				v:1 , visited:1 
				map : [1] [0][2]
				- [0] [ O O X X X ]
				- [0 2] [ O O O X X ]
			}
			
			if( size : 2 ) {
				v:O , visited:1 0
				map :[0] [1][2][4]
				- [2 4] [ O O O X O ]
			}			
			
			if( size : 2 ) {
				v:2 , visited:1 0 2
				map :[2] [0][1][3][4]
				- [4 3] [ O O O O O ]
			}			
			
			if( size : 2 ) {
				v:4 , visited:1 0 2 4
				map : [4] [0][2][3]
				- [3] [ O O O O O ] : 모두방문
			}			
			
			if( size : 1 ) {
				v:3 , visited:1 0 2 4 3
				map : [3] [2][4]
				- [] [ O O O O O ] : 모두방문
			}

			queue 비어서 끝
	*/
	public static void bfs( int spot, boolean[] visited, RelatedList rl ) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[spot] = true;
		queue.add( spot );
		
		while( queue.size() > 0 ) {
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
			//	예를 들어 3을 방문했으면 3과 직접 연결된 & 미방문 지점을 모두 큐에 넣어버린다. 
			for( Edge e : rl.find( v ).list ) {
				if( visited[e.spot] == false ) {
					visited[e.spot] = true;
					queue.add( e.spot );
				}
				//	System.out.println( e.spot );
			}
		}
	}

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
