package banana;

import static banana.Logic.*;
import java.util.*;

public class Test273 {
	public static void main( String[] args ) {
		int[][] map = {
			{ 0, 2, 5, 1, 0, 0 },
			{ 2, 0, 3, 2, 0, 0 },
			{ 5, 3, 0, 3, 1, 5 },
			{ 1, 2, 3, 0, 1, 0 },
			{ 0, 0, 1, 1, 0, 2 },
			{ 0, 0, 5, 0, 2, 0 }
		};
		
		visit( 0, map );
	}
}

class Logic 
{
	public static void print( int[] distance, boolean[] visited ) {
		StringBuffer sb = new StringBuffer();
		sb.append("distance [ ");
		for( int d : distance ) {
			if( d == 1000000 ) {
				sb.append("X ");
			} else {
				sb.append( d ).append(" ");
			}
		}
		sb.append("] \r\n");
		sb.append(" visited [ ");
		for( boolean b : visited ) {
			if( b ) {
				sb.append("O ");
			} else {
				sb.append("- ");
			}
		}
		sb.append("]");
		System.out.println( sb.toString() );
	}
	
	public static void visit( int start, int[][] map ) 
	{
		int[] distance = new int[6];
		for( int i = 0 ; i < distance.length ; i++ ) {
			if( i == start ) {
				distance[i] = 0;
			} 
			else if( map[start][i] == 0 ) {
				distance[i] = 1000000;
			}
			else {
				distance[i] = map[start][i];
			}
		}
		
		boolean[] visited = new boolean[6];
		
		visited[start] = true;
		System.out.println( "visited : " + start );
		
		print( distance, visited );
		
		if( true ) 
		{
			// 방문 안한것중에 start랑 제일 가까운걸 visit 변수로 정한다.
			int min_dist = 1000000;
			int visit = -1;
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( distance[i] != 0 && visited[i] == false ) {
					if( min_dist > distance[i] ) {
						min_dist = distance[i];
						visit = i;
					}
				}
			}
			
			visited[visit] = true;
			System.out.println( "visited : " + visit );
			
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( map[visit][i] != 0  && visited[i] == false ) {
					int dist2 = distance[visit] + map[visit][i];
					if( distance[i] > dist2 ) {
						distance[i] = dist2;
					}
				}
			}
		}

		print( distance, visited );
		
		if( true ) 
		{
			int min_dist = 1000000;
			int visit = -1;
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( distance[i] != 0 && visited[i] == false ) {
					if( min_dist > distance[i] ) {
						min_dist = distance[i];
						visit = i;
					}
				}
			}
			
			visited[visit] = true;
			System.out.println( "visited : " + visit );
			
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( map[visit][i] != 0  && visited[i] == false ) {
					int dist2 = distance[visit] + map[visit][i];
					if( distance[i] > dist2 ) {
						distance[i] = dist2;
					}
				}
			}
		}

		print( distance, visited );
		
		if( true ) 
		{
			int min_dist = 1000000;
			int visit = -1;
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( distance[i] != 0 && visited[i] == false ) {
					if( min_dist > distance[i] ) {
						min_dist = distance[i];
						visit = i;
					}
				}
			}
			
			visited[visit] = true;
			System.out.println( "visited : " + visit );
			
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( map[visit][i] != 0  && visited[i] == false ) {
					int dist2 = distance[visit] + map[visit][i];
					if( distance[i] > dist2 ) {
						distance[i] = dist2;
					}
				}
			}
		}

		print( distance, visited );		
		
		if( true ) 
		{
			int min_dist = 1000000;
			int visit = -1;
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( distance[i] != 0 && visited[i] == false ) {
					if( min_dist > distance[i] ) {
						min_dist = distance[i];
						visit = i;
					}
				}
			}
			
			visited[visit] = true;
			System.out.println( "visited : " + visit );
			
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( map[visit][i] != 0  && visited[i] == false ) {
					int dist2 = distance[visit] + map[visit][i];
					if( distance[i] > dist2 ) {
						distance[i] = dist2;
					}
				}
			}
		}

		print( distance, visited );	
		
		if( true ) 
		{
			int min_dist = 1000000;
			int visit = -1;
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( distance[i] != 0 && visited[i] == false ) {
					if( min_dist > distance[i] ) {
						min_dist = distance[i];
						visit = i;
					}
				}
			}
			
			visited[visit] = true;
			System.out.println( "visited : " + visit );
			
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( map[visit][i] != 0  && visited[i] == false ) {
					int dist2 = distance[visit] + map[visit][i];
					if( distance[i] > dist2 ) {
						distance[i] = dist2;
					}
				}
			}
		}

		print( distance, visited );	
		
		
	}
}

/*
	거리가 가장 짧은 3으로 갔다가 그다음으로 1로 감.
	visited : 0
	distance [ 0 2 5 1 X X ]
	 visited [ O - - - - - ]
	visited : 3
	distance [ 0 2 4 1 2 X ]
	 visited [ O - - O - - ]
	visited : 1
	distance [ 0 2 4 1 2 X ]
	 visited [ O O - O - - ]
	visited : 4
	distance [ 0 2 3 1 2 4 ]
	 visited [ O O - O O - ]
	visited : 2
	distance [ 0 2 3 1 2 4 ]
	 visited [ O O O O O - ]
	visited : 5
	distance [ 0 2 3 1 2 4 ]
	 visited [ O O O O O O ]

	
	처음과 비교했을 때 3을 거쳐서 다른 곳에 가는 것은 2가지 메리트가 있었다.
	그러나 1을 거쳐서 3이나 다른 곳으로 가는 것은 메리트가 없다. 업데이트가 없다.
	이건 언제까지 돌아갑니까? : 전체가 모두 visited가 될 때까지.
*/