package banana;

import static banana.Logic.*;

public class Test268 {
	public static void main( String[] args ) {
		
		// 사다리를 만들어 보자.
		int[][] map = {
			{0,0,1,0,0,0},
			{0,0,0,1,1,0},
			{0,0,0,1,0,0},
			{0,0,1,0,0,1},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
		};
		
		map[0][2] = 1;
		map[1][3] = 1;
		map[2][3] = map[3][2] = 1;
		map[2][4] = 1;
		map[3][5] = 1;
		
		boolean[] visited = new boolean[6];

		visit( 0, visited, map );    // 3번에서 시작
	}
}

class Logic {
	/*
		visit(0)
			visited : 0
			visit(2)
				visited : 2
				visit(3)
					visited : 3
					visit(6)
						visited : 6
							재귀호출 할 게 없다. 원랜 위로 올라가지만, break를 넣음.(끝)
	*/
	public static void visit(int spot, boolean[] visited, int[][] map){
		visited[spot] = true;
		System.out.println("visit :" + spot);
		
		for(int i=0; i<map[spot].length; i++){
			if(map[spot][i] != 0){
				if(visited[i] == false){
					visit(i, visited, map);
					break;    // 이러면 마지막에 4가 뜨던게 안 뜬다.
				}
			}
		}
	}

}