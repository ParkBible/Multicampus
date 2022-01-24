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
	
	public void connect( int from, int to, int dist ) {
		Vertex found = find( from );
		if( found != null ) {
			found.list.add( new Edge( to, dist ) );	
		}
	}
	
	//	이 함수를 이용하면 두 지점이 연결되어 있는지 아닌지 판별한다.
	public boolean isConnected( int from, int to ) {
		Vertex found = find( from );
		if( found != null ) {
			for( Edge e : found.list ) {
				if( e.spot == to ) {
					return true;
				}
			}
		}
		return false;
	}
	
	//	두 지점사이의 거리를 찾아서 리턴하는 함수 
	public int distance( int from, int to ) {
		Vertex found = find( from );
		if( found != null ) {
			for( Edge e : found.list ) {
				if( e.spot == to ) {
					return e.distance;
				}
			}
		}
		return 1000000;
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
		
		// vertex를 출력한다.( 0 ~ 5 )
		for( Vertex v : list ) {
			sb.append("[").append( v.spot ).append("] ");
			
			// Edge를 출력한다. ( 스팟명.떨어진 거리 )
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
	
	public RelatedList connect2( int a, int b, int dist ) {
		connect( a, b, dist );
		connect( b, a, dist );
		return this;
	}
	
	public RelatedList connect2( int a, int b ) {
		connect( a, b );
		connect( b, a );
		return this;
	}
	
	public boolean[] newVisited() {
		return new boolean[ list.size() ];
	}

/*
		int[] distance = new int[6];
		for( int i = 0 ; i < distance.length ; i++ ) {
			if( i == start ) {
				distance[i] = 0;
			} 
			else if( map[start][i] == 0 ) {
				//	직접 연결 안된 스폿과의 거리는 매우 큰 값으로 놓는다.
				distance[i] = 1000000;
			}
			else {
				//	직접 연결된 스폿과의 거리는 그 거리를 그대로 입력한다.
				distance[i] = map[start][i];
			}
		}		
		return distance;
*/	
	
	/*	데익스트라 알고리즘의 경우 최초의 distance 배열은 어떻게 되어 있다??
		[1] [0.3][2.5]
		
		출발점 0 , 연결안된 곳은 X , 그 이외는 출발점에서의 거리
		-> [ 3 0 5 X X X ]
	*/
	public int[] newDistances( int start ) 
	{
		int[] distance = new int[ list.size() ];
		for( int i = 0 ; i < distance.length ; i++ ){
			if( i == start ) {
				distance[i] = 0;
			} else {
				distance[i] = 1000000;
			}
		}
		
		Vertex v = find( start );
		for( Edge e : v.list ) {
			distance[e.spot] = e.distance;
		}
		return distance;
	}
}

public class Test281 {
	public static void main( String[] args ) {
		RelatedList rList = new RelatedList();
		
		rList.add( 0 ).add( 1 ).add( 2 ).add( 3 ).add( 4 ).add( 5 );
		
		/*    0  1  2  3  4  5
		0	{ 0, 2, 5, 1, 0, 0 },
		1	{ 2, 0, 3, 2, 0, 0 },
		2   { 5, 3, 0, 3, 1, 5 },
		3	{ 1, 2, 3, 0, 1, 0 },
		4	{ 0, 0, 1, 1, 0, 2 },
		5	{ 0, 0, 5, 0, 2, 0 }
		*/
		rList.connect2(0,1,2).connect2(0,2,5).connect2(0,3,1)
			.connect2(1,2,3).connect2(1,3,2)
			.connect2(2,3,3).connect2(2,4,1).connect2(2,5,5)
			.connect2(3,4,1)
			.connect2(4,5,2);
		
		rList.print( false );

		int start = 0;
		
		int[] dist = rList.newDistances( start );
		boolean[] visited = rList.newVisited();
		
		visited[start] = true;
		System.out.println( "visited : " + start );
		
		printDist( dist );
		printVisited( visited );
		
		while( allVisited( visited ) == false ) 
		{
			//	방문하지 않은 spot 중에서 최소거리에 있는 spot 을 리턴한다. 0
			int v = minDistSpot_NotVisited( dist, visited );
			visited[v] = true;
			System.out.println( "visited : " + v );
			
			for( int i = 0 ; i < dist.length ; i++ ) 
			{
				/*	거리수정 대상 : 0 과 연결되어져 있는 spot 
					즉 방문되지 않았으면서 0과 연결되어 있는 spot
					
					isConnected : 해당 두 지점이 연결되어 있는지 점검
				*/
				
				/*	v 가 방문지점 , i 가 연결되고 방문가능한 지점 
				    dist2 - 방문지점을 거쳐서 i 에 이르게 되는 거리 
				    dist2 가 기존에 내가 알던 거리보다 작으면? 그때는 업데이트 
				*/
				if( visited[i] == false && rList.isConnected( v, i ) ) {
					int dist2 = dist[v] + rList.distance( v, i );
					if( dist2 < dist[i] ) {
						dist[i] = dist2;
					}
				}
			}
			
			printDist( dist );
			printVisited( visited );
		}
	}
}

class Logic {
	public static int minDistSpot_NotVisited( int[] distance, boolean[] visited ) {
		int min_dist = 1000000;
		int idx = -1;
		
		for( int i = 0 ; i < distance.length; i++ ) {
			if( distance[i] != 0 ) {
				if( visited[i] == false ) {
					if( min_dist > distance[i] ) {
						min_dist = distance[i];
						idx = i;
					}
				}
			}
		}
		return idx;
	}
	
	public static boolean allVisited ( boolean[] visited ) {
		for( boolean b : visited ) {
			if( b == false ) {
				return false;
			}
		}
		return true;
	}
	
	public static void printVisited( boolean[] visit ) {
		StringBuffer sb = new StringBuffer();
		sb.append(" visited [ ");
		for( boolean i : visit ) {
			if( i == true ) {
				sb.append("O ");
			} else {
				sb.append("X ");
			}
		}
		sb.append("]");
		System.out.println( sb.toString() );
	}
	
	public static void printDist( int[] distance ) {
		StringBuffer sb = new StringBuffer();
		sb.append("distance [ ");
		for( int i : distance ) {
			if( i == 1000000 ) {
				sb.append("X ");
			} else {
				sb.append( i ).append(" ");
			}
		}
		sb.append("]");
		System.out.println( sb.toString() );
	}

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
/*
visited : 3
distance [ 1 2 3 0 1 X ]    -> 가장 짧은 거리 0. 0으로 간다
 visited [ X X X O X X ]
visited : 0
distance [ 1 2 3 0 1 X ]    -> 가장 짧은 거리 4. 4로 간다
 visited [ O X X O X X ]
visited : 4
distance [ 1 2 2 0 1 3 ]    -> 기존의 3~2 거리가 3이었는데 4를 거쳐 2로 가는 게 2로 더 짧으므로, 2로 업데이트됨
 visited [ O X X O O X ]
visited : 1
distance [ 1 2 2 0 1 3 ]
 visited [ O O X O O X ]
visited : 2
distance [ 1 2 2 0 1 3 ]
 visited [ O O O O O X ]
visited : 5
distance [ 1 2 2 0 1 3 ]
 visited [ O O O O O O ]
 
 
 스타트가 0일때
 visited : 0
distance [ 0 2 5 1 X X ]    -> 가장 짧은 거리는 3. 3으로 간다
 visited [ O X X X X X ]
visited : 3
distance [ 0 2 4 1 2 X ]    -> 0~3~2까지의 거리가 0~2까지의 거리보다 짧아서 업데이트된다. 가장 짧은 거리는 1. 1로 간다
 visited [ O X X O X X ]
visited : 1
distance [ 0 2 4 1 2 X ]
 visited [ O O X O X X ]
visited : 4
distance [ 0 2 3 1 2 4 ]
 visited [ O O X O O X ]
visited : 2
distance [ 0 2 3 1 2 4 ]
 visited [ O O O O O X ]
visited : 5
distance [ 0 2 3 1 2 4 ]
 visited [ O O O O O O ]
*/