package banana;

import static banana.Logic.*;
import java.util.*;

public class Test271 {
	public static void main( String[] args ) {
		int[][] map = {
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
		};
		
		visit( 0, map );
	}
}

class Logic {
	public static void visit( int spot, int[][] map ) 
	{
		boolean[] visited = new boolean[5];
		List<Integer> queue = new LinkedList<Integer>();
		
		visited[spot] = true;
		queue.add( spot );
		
		// [2,4][X X - - -], v:3, visited:3
		
		while( queue.size() != 0 )	//	queue 가 비지 않는 한 반복한다.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
			// 하나만 표시하려면? v를 3으로 고정한다.
			
			for( int i = 0 ; i < map.length ; i++ ) // 세로방향
			{
				if( map[i][v] != 0 ) {
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
			
			/*
				향상된 for 문으로 밑의 코드를 바꿔보자.
				for(int i : l){
				}
			*/
			
			
			// 큐에 있는 값들을 찍어보자.
			StringBuffer sb = new StringBuffer();
			Iterator<Integer> it = queue.iterator();
			
			sb.append("[ ");
			/*
			while(it.hasNext()){
				int q = it.next();
				sb.append(q).append(" ");
			}
			*/
			// 향상된 for문으로 바로 위의 코드를 바꾼거.
			for(int i : queue){
				sb.append(i).append(" ");
			}
			sb.append("] ").append(" ");
			
			
			// visited에 있는 값들을 찍어보자.
			sb.append("[ ");
			/*
			for(int i=0; i<visited.length; i++){
				if(visited[i]){
					sb.append("-").append(" ");
				}else{
					sb.append("X").append(" ");
				}
			}
			*/
			// 향상된 for문으로 바로 위의 코드를 바꾼거.
			for(boolean i : visited){
				if(i == true){
					sb.append("-").append(" ");
				}else{
					sb.append("X").append(" ");
				}
			}
			
			sb.append("] ");
			
			
			System.out.println(sb.toString());
		}
			
			
	}
}


/*	
	visited : 0
	[ 1 2 4 ]  [ - - - X - ]
	visited : 1
	[ 2 4 ]  [ - - - X - ]
	visited : 2
	[ 4 3 ]  [ - - - - - ]
	visited : 4
	[ 3 ]  [ - - - - - ]
	visited : 3
	[ ]  [ - - - - - ]
	
	[0 1][- - - - -], v:4, visited:3 2 4
	3, 2 4, 0 1   --- 본인, 친구, 친구의 친구
*/