package banana;

import static banana.Logic.*;
import java.util.*;

public class Test271_ZZ {
	public static void main( String[] args ) {
		int[][] map = {
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
		};
		
		visit( 3, map );
	}
}

class Logic {
	public static void visit( int spot, int[][] map ) 
	{
		boolean[] visited = new boolean[5];
		List<Integer> queue = new LinkedList<Integer>();
		
		visited[spot] = true;
		queue.add( spot );
		
		if( queue.size() != 0 )	//	queue 가 비지 않는 한 반복한다.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
			//	[ 2 4 ][ X X - - - ] , v:3 , visited:3 
			/*
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
		  v { 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
			*/
			
//			for( int i = 0 ; i < map[v].length ; i++ )
			for( int i = 0 ; i < map[3].length ; i++ ) // 세로방향 -> 가로방향으로 정정 ^^;;
			{
//				if( map[v][i] != 0 ) {
				if( map[3][i] != 0 ) {
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
			
			//	이런 코드를 짜느냐 못짜느냐는 굉장히 중요하더라 ...
			StringBuffer sb = new StringBuffer();
			sb.append("[ ");
			for( int q : queue ) {
				sb.append( q ).append(" ");
				
			}
			sb.append("] ");
			
			sb.append("[ ");
			for( boolean v2 : visited ) {
				if( v2 ) {
					sb.append("-").append(" ");
				} else {
					sb.append("X").append(" ");
				}
			}
			sb.append("]");
			System.out.println( sb.toString() );				
		}
		
		//	[ 2 4 ][ X X - - - ] , v:3 , visited:3 
		
		if( queue.size() != 0 )	//	queue 가 비지 않는 한 반복한다.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
			//	[ 4 ][ X X - - - ] , v:2 , visited: 3 2
			
			/*
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
		v   { 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
			*/
//			for( int i = 0 ; i < map[v].length ; i++ )			
			for( int i = 0 ; i < map[2].length ; i++ ) // 세로방향 -> 가로방향으로 정정
			{
//				if( map[v][i] != 0 ) {	v:2 이므로 아래 코드에 명시해서 가독성 향상??
				if( map[2][i] != 0 ) {
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
			
			//	[ 4 0 1 ][ - - - - - ] , v:2 , visited: 3 2
			
			//	이런 코드를 짜느냐 못짜느냐는 굉장히 중요하더라 ...
			StringBuffer sb = new StringBuffer();
			sb.append("[ ");
			for( int q : queue ) {
				sb.append( q ).append(" ");
				
			}
			sb.append("] ");
			
			sb.append("[ ");
			for( boolean v2 : visited ) {
				if( v2 ) {
					sb.append("-").append(" ");
				} else {
					sb.append("X").append(" ");
				}
			}
			sb.append("]");
			System.out.println( sb.toString() );				
		}		
		
		//	[ 4 0 1 ][ - - - - - ] , v:2 , visited: 3 2
		
		if( queue.size() != 0 )	//	queue 가 비지 않는 한 반복한다.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
			//	[ 0 1 ][ - - - - - ] , v:4 , visited: 3 2 4
			
			/*
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
		v	{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
			*/

//			for( int i = 0 ; i < map[v].length ; i++ )		
			for( int i = 0 ; i < map[4].length ; i++ ) // 세로방향 -> 가로방향으로 정정 ^^*
			{
//				if( map[v][i] != 0 ) {
				if( map[4][i] != 0 ) {
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
			
			//	이런 코드를 짜느냐 못짜느냐는 굉장히 중요하더라 ...
			StringBuffer sb = new StringBuffer();
			sb.append("[ ");
			for( int q : queue ) {
				sb.append( q ).append(" ");
				
			}
			sb.append("] ");
			
			sb.append("[ ");
			for( boolean v2 : visited ) {
				if( v2 ) {
					sb.append("-").append(" ");
				} else {
					sb.append("X").append(" ");
				}
			}
			sb.append("]");
			System.out.println( sb.toString() );				
		}		

		//	[ 0 1 ][ - - - - - ] , v:4 , visited: 3 2 4			

		//	3 , 2 4 , 0 1  -- facebook 의 열쇠 친 , 친친 까지는 정말 쉽더라 ... 
	}
}

/*	

*/


			/*
				for( int i : l ) {
					...
				}
				-- 대상 : 배열 Set List
				
				StringBuffer sb = new StringBuffer();
				Iterator<Integer> it = queue.iterator();
				sb.append("[ ");
				while( it.hasNext() ) {
					int q = it.next();
					sb.append( q ).append(" ");;
				}
				sb.append("] ");
				
				sb.append("[ ");
				for( int i = 0 ; i < visited.length ; i++ ) {
					if( visited[i] ) {
						sb.append("-").append(" ");
					} else {
						sb.append("X").append(" ");
					}
				}
				sb.append("]");
				System.out.println( sb.toString() );				
			*/
