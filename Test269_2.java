package banana;

import static banana.Logic.*;

// 가중치 주기
public class Test269_2 {
	public static void main( String[] args ) {
		int[][] map = {
			{ 0, 1, 1, 0, 1 },	//	0
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
		};
		
		map[0][1] = map[1][0] = 3;
		map[0][2] = map[2][0] = 2;
		map[0][4] = map[4][0] = 5;
		
		map[1][2] = map[2][1] = 2;
		
		map[2][3] = map[3][2] = 1;
		map[2][4] = map[4][2] = 1;
		
		map[3][4] = map[4][3] = 1;
		
		boolean[] visited = new boolean[5];

		visit( 0, visited, map );    // 3번에서 시작
	}
}

class Logic {
	public static void visit( int spot, boolean[] visited, int[][] map ) {
		visited[spot] = true;
		System.out.println( "visit : " + spot );
		/*
			이 알고리즘은 갈 수 있는 spot 중 spot의 숫자가 작은 순으로 방문하게 되어 있다.
			가중치가 주어지면 가장 가중치가 작거나 큰 순으로 방문하는 것이 필요하다.
			
			이 알고리즘은 약점이 있음 : 더 이상 직접 방문이 불가능하게 되면 돌아가서 방문하는 개념이 없다.
			그래서 멈춰버린다. 
			처음에는 가장 거리가 짧은 곳으로만 가면 될 줄 알았는데 아니었다.
			최단 거리 알고리즘(데익스트라 알고리즘)이 필요할 때가 있다.
		
		for( int i = 0 ; i < map[spot].length ; i++ ) {
			if( map[spot][i] != 0 && visited[i] == false ) {
				visit( i, visited, map );
			}
		}
		*/
		
		// 0,3,2,0,5
		
		int min_value = 100000;
		int min_index = -1;
		for( int i = 0 ; i < map[spot].length ; i++ ) {
			if( map[spot][i] != 0 && visited[i] == false ) {
				if(min_value > map[spot][i])
				{
					min_value = map[spot][i];
					min_index = i;
				}
			}
		}
		
		if(min_index != -1){
			visit( min_index, visited, map );
		}
		
		
		
	}
}