package banana;

import java.util.*;

import static banana.Logic.*;

public class Test270 {
	public static void main( String[] args ) {
		int[][] map = {
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
		};
		
		boolean[] visited = new boolean[5];

		visit( 0, map );
	}
}

class Logic {
	/*
		[ - X X X X ] 0만 방문한 상태
		[ 0 ] 
		
		[ - - - X - ]
		[ 1 2 4 ]
	*/
	public static void visit( int spot, int[][] map ) {
		boolean[] visited = new boolean[5];
		List<Integer> queue = new LinkedList<Integer>();
		
		visited[spot] = true;
		queue.add(spot);
		
		while(queue.size() != 0){    // 큐가 비지 않는 한 반복한다.
			int v = queue.remove(0);    // 큐에서 꺼내는 시점이 방문 시점임
			System.out.println("visited : " + v);
			
			/*
				맨 처음 spot이 큐에 들어간다. 현재 큐는 [0], visited: [- X X X X]
				queue 리무브 하면 0이 나온다. 0에서부터 돌기 시작.
				0,0은 0이기 때문에 방문하지 않는다.
				1,0은 1이다. visited를 만들면서 큐에 1이 들어간다. 현재 큐는 [1]
				2,0은 1이다. 현재 큐는 [1, 2]
				while 1회(visited[0]) : queue:[1, 2, 4], visited:[- - - X -]
				
				queue 리무브 하면 1이 나온다. 1에서부터 돌기 시작.
				while 2회(visited[1]) : queue:[2, 4], visited: [- - - X -]
				
				queue 리무브 하면 2가 나온다. 2에서부터 돌기 시작.
				2가 빠져나가고 3이 새로 들어온다.
				while 3회 (visited[2]) : queue: [4, 3], visited: [- - - - -]
				
				queue 리무브 하면 4가 나온다. 4에서부터 돌기 시작.
				while 4회 (visited[4]) : queue: [3], visited: [- - - - -]
				
				queue 리무브 하면 3이 나온다. 3에서부터 돌기 시작.
				while 5회 (visited[3]) : queue: [], visited: [- - - - -]
			*/
			for(int i=0; i<map.length; i++){     // 세로 방향으로 방문.
				if(map[i][v] != 0){				
					if(visited[i] == false) {
						visited[i] = true;
						queue.add(i);
					}
				}
			}
		}
	}
}

/*
	이전에서 이용한 방문 알고리즘을 DFS(Depth First Search) 알고리즘이라고 합니다.
	이동하고 이동된 지점에서 다시 이동하는 형태의 검색이라 경로를 만들어 내는 경우에 응용된다.
	
	그것과는 대비되게 나와 가까운 지점부터 먼저 모두 방문하는 형태의 방문 알고리즘이 있는데 이것을 BFS 알고리즘이라고 한다.
	
	방문 알고리즘은 크게 이 둘이 기본이 된다.
*/