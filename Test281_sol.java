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
	
	//	return this; �� ����� ȿ�� : rList.add( 0 ).add( 1 ).add( 2 ).add( 3 ).add( 4 );
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
	
	//	�� �Լ��� �̿��ϸ� �� ������ ����Ǿ� �ִ��� �ƴ��� �Ǻ��Ѵ�.
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
	
	//	�� ���������� �Ÿ��� ã�Ƽ� �����ϴ� �Լ� 
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
				//	���� ���� �ȵ� �������� �Ÿ��� �ſ� ū ������ ���´�.
				distance[i] = 1000000;
			}
			else {
				//	���� ����� �������� �Ÿ��� �� �Ÿ��� �״�� �Է��Ѵ�.
				distance[i] = map[start][i];
			}
		}		
		return distance;
*/	
	
	/*	���ͽ�Ʈ�� �˰����� ��� ������ distance �迭�� ��� �Ǿ� �ִ�??
		[1] [0.3][2.5]
		
		����� 0 , ����ȵ� ���� X , �� �ܴ̿� ����������� �Ÿ�
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
			//	�湮���� ���� spot �߿��� �ּҰŸ��� �ִ� spot �� �����Ѵ�. 0
			int v = minDistSpot_NotVisited( dist, visited );
			visited[v] = true;
			System.out.println( "visited : " + v );
			
			for( int i = 0 ; i < dist.length ; i++ ) 
			{
				/*	�Ÿ����� ��� : 0 �� ����Ǿ��� �ִ� spot 
					�� �湮���� �ʾ����鼭 0�� ����Ǿ� �ִ� spot
					
					isConnected : �ش� �� ������ ����Ǿ� �ִ��� ����
				*/
				
				/*	v �� �湮���� , i �� ����ǰ� �湮������ ���� 
				    dist2 - �湮������ ���ļ� i �� �̸��� �Ǵ� �Ÿ� 
				    dist2 �� ������ ���� �˴� �Ÿ����� ������? �׶��� ������Ʈ 
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
			
			//	���� ��� 3�� �湮������ 3�� ���� ����� & �̹湮 ������ ��� ť�� �־������. 
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

visited : 0
distance [ 0 2 5 1 X X ]
 visited [ O X X X X X ]

visited : 3
distance [ 0 2 4 1 2 X ]
 visited [ O X X O X X ]
 
 ������ 0-2 �Ÿ��� 5, 0-3-2 �Ÿ��� 4 : 2������ �Ÿ��� 4�� ����
 ������ 0-4 �Ÿ��� X, 0-3-4 �Ÿ��� 2 : 4������ �Ÿ��� 2�� ����
 3�� �湮

 - �湮 ���Ѱ� �߿� ���� ª�� �Ÿ� ���� ? 1 
visited : 1
distance [ 0 2 4 1 2 X ]
 visited [ O O X O X X ]
 
 1�� ���ļ� �� �� �ִ� ���� + �̹湮 ���� 
 0-5 �� �״�� ���� 1�� ���ļ� 2�� ���� �Ÿ��� 5�� �����ϴ� : �������� �ȵ� 
 
 - �湮 ���Ѱ� �߿� ���� ª�� �Ÿ� ���� ? 4
visited : 4
distance [ 0 2 3 1 2 4 ]
 visited [ O O X O O X ] 
 
 ������ 0-5 �Ÿ��� X, �嵥 0-4 ������ �Ÿ��� 2 , �ű⿡ 4-5 ���� �Ÿ��� 2 : 4 ����
 ������ 0-2 �Ÿ��� 4 ( 0-3-2 ) , �嵥 0-4 ������ �Ÿ��� 2 , 4-2 �Ÿ��� 1 : 3���� ����
 
 - �湮 ���Ѱ� �߿� ���� ª�� �Ÿ� ���� ? 2
visited : 2
distance [ 0 2 3 1 2 4 ]
 visited [ O O O O O X ] 
 
  - �湮 ���Ѱ� �߿� ���� ª�� �Ÿ� ���� ? 2
visited : 5
distance [ 0 2 3 1 2 4 ]
 visited [ O O O O O O ] 
 
"���������δ� ������������ ���� �ش� ���������� �ִܰŸ��� ���ϴ� �˰���" 
*/