package banana;

import static banana.Logic.*;
import java.util.*;

class Edge {
	int spot = 0;
	int distance = 1;
	
	public Edge( int i ) { spot = i; }
	public Edge( int i, int d ) { spot = i; distance = d; }
}

class Vertex {
	int spot = 0;
	List<Edge> list = null;
	
	public Vertex( int i ) {
		this.spot = i;
		list = new ArrayList<Edge>();
	}
}

class RelatedList {
	private List<Vertex> list = null;
	
	public RelatedList() {
		list = new ArrayList<Vertex>();
	}
	
	public RelatedList add( int spot ) {
		list.add( new Vertex( spot ) );
		return this;
	}
	
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
	
	public void connect( int from, int to ) {
		Vertex found = find( from );
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

public class Test282 {
	public static void main( String[] args ) {
		RelatedList rList = new RelatedList();
		
		rList.add( 0 ).add( 1 ).add( 2 ).add( 3 ).add( 4 ).add( 5 );
		
		rList.connect2(0,1,2).connect2(0,2,5).connect2(0,3,1)
			.connect2(1,2,3).connect2(1,3,2)
			.connect2(2,3,3).connect2(2,4,1).connect2(2,5,5)
			.connect2(3,4,1)
			.connect2(4,5,2);
		
		rList.print( false );

		int start = 3;
		boolean[] visited = rList.newVisited();
		
		dijkstra( start, visited, rList );
	}
}

class Logic 
{
	public static void dijkstra ( int start, boolean[] visited, RelatedList rl ) 
	{
		int[] dist = rl.newDistances( start );
		
		visited[start] = true;
		System.out.println( "visited : " + start );
		
		printDist( dist );
		printVisited( visited );
		
		while( allVisited( visited ) == false ) 
		{
			int v = minDistSpot_NotVisited( dist, visited );
			visited[v] = true;
			System.out.println( "visited : " + v );
			
			for( int i = 0 ; i < dist.length ; i++ ) {
				if( visited[i] == false && rl.distance( v, i ) != 1000000 ) {
					int dist2 = dist[v] + rl.distance( v, i );
					if( dist2 < dist[i] ) {
						dist[i] = dist2;
					}
				}
			}
			
			printDist( dist );
			printVisited( visited );
		}
	}
	
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
			
			for( Edge e : rl.find( v ).list ) {
				if( visited[e.spot] == false ) {
					visited[e.spot] = true;
					queue.add( e.spot );
				}
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