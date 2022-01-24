package banana;

public class Test264 {
	public static void main( String[] args ){
		int[][] map = {
			{0,1,1,0,1},
			{1,0,1,0,0},
			{1,1,0,1,1},
			{0,0,1,0,1},
			{1,0,1,1,0},
		};
		map[0][1] = map[1][0] = 1;
		map[0][2] = map[2][0] = 1;
		map[0][4] = map[4][0] = 1;
		
		map[1][2] = map[2][1] = 1;
		
		map[2][3] = map[3][2] = 1;
		map[2][4] = map[4][2] = 1;
		
		map[3][4] = map[4][3] = 1;
		
		/*
			로컬변수라도 배열로 선언하면 내부는 초기값이 자동으로 들어감 : 
			int는 0, boolean은 false, 포인터는 null
		*/
		boolean[] visited = new boolean[5];
		System.out.println(visited[0]);
		
		// 0에서 출발
		visit(0,visited,map);
	}
}

// 트리처럼 모든 노드를 방문해보자.
class Logic{
	/*
	
	*/
	public static void visit(int spot, boolean[] visited, int[][] map){
		visited[spot] = true;
		System.out.println("visit : " + spot);
		
		/*
			{0,1,1,0,1}, // 0 입장에서 연결되어 있는 데이터. 그것의 length만큼 돌아간다.
			0 입장에서 봤을 때 방문가능하고 방문한 적 없는 데어터를 재귀호출한다.
		*/
		
		for(int i=0; i<map[spot].length; i++){
			if(map[spot][i] != 0 && visited[i] == false){    // 1이고(관계가 있고), false인 것(방문한 적 없는 것)
				visit(i, visited, map);
			}
		}
	}
}