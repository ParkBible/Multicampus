package banana;

import static banana.Logic.*;
import java.util.*;

public class Test274_ZZ {
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
		
		while( allVisited( visited ) == false ) 
		{
			int min_dist = 1000000;
			int v = -1;
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( distance[i] != 0 && visited[i] == false ) {
					if( min_dist > distance[i] ) {
						min_dist = distance[i];
						v = i;
					}
				}
			}
			
			visited[v] = true;
			System.out.println( "visited : " + v );
			
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( map[v][i] != 0  && visited[i] == false ) {
					int dist2 = distance[v] + map[v][i];
					if( distance[i] > dist2 ) {
						distance[i] = dist2;
					}
				}
			}
			
			print( distance, visited );
		}
	}
	
	public static boolean allVisited( boolean[] visited ) {
		for( boolean b : visited ) {
			if( b ==  false ) {
				return false;
			}
		}
		return true;
	}
}

/*
	정리된 데익스트라 알고리즘 
*/