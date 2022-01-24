package banana;

import static banana.Logic.*;
import java.util.*;

public class Test271_sol {
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
		
		if( queue.size() != 0 )	//	queue �� ���� �ʴ� �� �ݺ��Ѵ�.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
			//	[ 2 4 ][ X X - - - ] , v:3 , visited:3 
			// 3�� ģ�������� �̾ƺ���.
			/*
			           v
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
			*/
			for( int i = 0 ; i < map.length ; i++ ) // ���ι���
			{
				if( map[i][v] != 0 ) {
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
			
			//	�̷� �ڵ带 ¥���� ��¥���Ĵ� ������ �߿��ϴ��� ...
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
		
		if( queue.size() != 0 )	//	queue �� ���� �ʴ� �� �ݺ��Ѵ�.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
			
			/*
			        v
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
			*/
			
			for( int i = 0 ; i < map.length ; i++ ) // ���ι���
			{
				if( map[i][v] != 0 ) {
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
			
			//	�̷� �ڵ带 ¥���� ��¥���Ĵ� ������ �߿��ϴ��� ...
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
		
		if( queue.size() != 0 )	//	queue �� ���� �ʴ� �� �ݺ��Ѵ�.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			/*
			              v
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
			*/

			for( int i = 0 ; i < map.length ; i++ ) // ���ι���
			{
				if( map[i][v] != 0 ) {
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
			
			//	�̷� �ڵ带 ¥���� ��¥���Ĵ� ������ �߿��ϴ��� ...
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

		//	3 , 2 4 , 0 1  -- facebook �� ���� ģ , ģģ ������ ���� ������ ... 
	}
}

/*	

*/


			/*
				for( int i : l ) {
					...
				}
				-- ��� : �迭 Set List
				
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
