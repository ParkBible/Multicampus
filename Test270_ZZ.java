package banana;

import static banana.Logic.*;
import java.util.*;

public class Test270_ZZ {
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
		
		while( queue.size() != 0 )	//	queue 가 비지 않는 한 반복한다.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
/*            0  1  2  3  4
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
			
		//	[ - - - - - ]
		//	[ ]
		
		visited:0 
		visited:1
		visited:2
		visited:4
		visited:3
		
		while 1회 : [ 1 2 4 ] [ - - - X - ]
		while 2회 : [ 2 4 ]   [ - - - X - ]  -- 신규유입X
		while 3회 : [ 4 3 ]   [ - - - - - ]
		while 4회 : [ 3 ]     [ - - - - - ] -- 신규유입X
		while 5회 : [ ]       [ - - - - - ] -- 신규유입X
*/			
			for( int i = 0 ; i < map[v].length ; i++ ) // 세로방향 -> 가로방향으로 정정
			{
				if( map[v][i] != 0 ) {		//	map[i][v] -> map[v][i] 로 정정
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
		}
	}
}

/*	이전에서 재귀호출을 이용한 방문 알고리즘을 "DFS - Depth First Search" 알고리즘이라 합니다.
	이동하고 이동된 지점에서 다시 이동하는 형태의 검색이라 경로를 만들어 내는 경우에 응용된다.
	
	그것과는 대비되게 '나와 가까운 지점부터 먼저 모두 방문하는 형태의 방문 알고리즘이 있는데
	이를 BFS 알고리즘이라고 한다.
	
	방문 알고리즘은 크게 이 둘이 기본이 된다.
	
	'BFS는 이해하기 보다 파악하고 외운다 ... 개념이 싸게 먹힌다. 재귀호출 안쓰기에 코드가 더 복잡하다.'
*/