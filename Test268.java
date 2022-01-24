package banana;

import static banana.Logic.*;

public class Test268 {
	public static void main( String[] args ) {
		
		// ��ٸ��� ����� ����.
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

		visit( 0, visited, map );    // 3������ ����
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
							���ȣ�� �� �� ����. ���� ���� �ö�����, break�� ����.(��)
	*/
	public static void visit(int spot, boolean[] visited, int[][] map){
		visited[spot] = true;
		System.out.println("visit :" + spot);
		
		for(int i=0; i<map[spot].length; i++){
			if(map[spot][i] != 0){
				if(visited[i] == false){
					visit(i, visited, map);
					break;    // �̷��� �������� 4�� �ߴ��� �� ���.
				}
			}
		}
	}

}