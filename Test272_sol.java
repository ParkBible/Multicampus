package banana;

import static banana.Logic.*;
import java.util.*;

public class Test272 {
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

/*	데익스트라 알고리즘 : 시작점에서 부터 각 스폿 까지의 최단거리를 구하는 알고리즘 
		( BFS 개량 - 'BFS랑 마찬가지로 이해하려 하지 말고 파악하고 활용하라 ' )
*/

class Logic {
	public static void visit( int start, int[][] map ) 
	{
		//	start 에서 각 spot까지의 길이를 담는 기억공간
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
		
		boolean[] visited = new boolean[6];
		
		visited[start] = true;
		System.out.println( "visited : " + start );
		
		//	StringBuffer 를 써서 distance 배열의 내용을 출력 : 미 연결된 곳은 X 로 
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
		
		if( true ) 
		{
			//	아직 방문이 안된 spot 중에서 최단거리에 있는 spot 을 구해야 한다.
			int min_dist = 1000000;
			int min_idx = -1;
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( distance[i] != 0 ) {
					if( min_dist > distance[i] ) {
						min_dist = distance[i];
						min_idx = i;
					}
				}
			}
			
			//	그 지점을 방문한다. ( 아까 짰던거랑 비슷하네?? )
			visited[min_idx] = true;
			System.out.println( "visited : " + min_idx );
			
			/*	'3번을 기준으로 3번을 거쳐가면 1번에 더 가까운 거리가 발견되면 업데이트 한다'
				예를 들어서 0 에서 4 까지의 거리는 X 였는데 3 에서 보니 0 - 3 - 4 해서 2가 되더라 ...
				-> 그래서 4 까지의 거리를 X 에서 2 로 바꾸면 되는데
				   이 작업을 계속 반복하면 된다...
				   
				: 이거시 데익스트라 알고리즘의 핵심!!!
				: 기존에 알던 거리보다 방문지를 거쳐가는 거리가 더 가까우면 그 거리로 업뎃한다!!
			*/
			
			//	방문되지 않았고 && 연결되어 있는 스폿에 대해서 ...
			for( int i = 0 ; i < distance.length ; i++ ) {
				if( map[min_idx][i] != 0  && visited[i] == false ) {
					//	미방문 & 3번에서 갈 수 있는 대상 : [ 1 2 4 ]
					int dist2 = distance[min_idx] + map[min_idx][i];
					//	위의 식을 설명하면 3번까지의 거리 + 3번에서 [1 2 4] 까지의 거리
					
					//	기존에 알려졌던 start 부터 i 까지의 거리와 비교해서 짧으면??
					if( distance[i] > dist2 ) {
						distance[i] = dist2;
					}
				}
			}
		}
		
		//	StringBuffer 를 써서 distance 배열의 내용을 출력 : 미 연결된 곳은 X 로 
		sb = new StringBuffer();
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
}	