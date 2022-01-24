package banana;

import static banana.Logic.*;

public class Test266 {
	public static void main( String[] args ) {
		int[][] map = {
			{ 0, 1, 1, 0, 1 },	//	0
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
		};
		
		map[0][1] = map[1][0] = 1;
		map[0][2] = map[2][0] = 1;
		map[0][4] = map[4][0] = 1;
		
		map[1][2] = map[2][1] = 1;
		
		map[2][3] = map[3][2] = 1;
		map[2][4] = map[4][2] = 1;
		
		map[3][4] = map[4][3] = 1;
		
		boolean[] visited = new boolean[5];

		visit( 3, visited, map );    // 3번에서 시작
	}
}

class Logic {
	public static void visit( int spot, boolean[] visited, int[][] map ) {
		visited[spot] = true;
		System.out.println( "visit : " + spot );
		/*
			{ 0, 1, 1, 0, 1 },	//	0
			{ 1, 0, 1, 0, 0 },	//	1
			{ 1, 1, 0, 1, 1 },	//	2
			{ 0, 0, 1, 0, 1 },	//	3
			{ 1, 0, 1, 1, 0 }	//	4
			
			3에서 시작했을 때
			visit(3)
				visited : 3
				visit(2)
					visited : 2
					visit(0)
						visited : 0
						visit(1)
							visited : 1
							조건에 맞는 게 없으므로 재귀호출 X -> 0으로 다시 올라감
						visit(4)
							visited : 4
							재귀호출 X
							
			2에서 시작했을 때
			visit(2)
				visited : 2
				visit(0)
					visited : 0
					visit(1)
						visited : 1
						조건에 맞는 게 없다.
					visit(4)
						visited : 4
						visit(3)
							visited : 3
							재귀호출 X
						
				
		*/
		for( int i = 0 ; i < map[spot].length ; i++ ) {
			if( map[spot][i] != 0 && visited[i] == false ) {
				visit( i, visited, map );
			}
		}
	}
}