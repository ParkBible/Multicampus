package banana;

import static banana.Logic.*;

// ����ġ �ֱ�
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

		visit( 0, visited, map );    // 3������ ����
	}
}

class Logic {
	public static void visit( int spot, boolean[] visited, int[][] map ) {
		visited[spot] = true;
		System.out.println( "visit : " + spot );
		/*
			�� �˰����� �� �� �ִ� spot �� spot�� ���ڰ� ���� ������ �湮�ϰ� �Ǿ� �ִ�.
			����ġ�� �־����� ���� ����ġ�� �۰ų� ū ������ �湮�ϴ� ���� �ʿ��ϴ�.
			
			�� �˰����� ������ ���� : �� �̻� ���� �湮�� �Ұ����ϰ� �Ǹ� ���ư��� �湮�ϴ� ������ ����.
			�׷��� ���������. 
			ó������ ���� �Ÿ��� ª�� �����θ� ���� �� �� �˾Ҵµ� �ƴϾ���.
			�ִ� �Ÿ� �˰���(���ͽ�Ʈ�� �˰���)�� �ʿ��� ���� �ִ�.
		
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