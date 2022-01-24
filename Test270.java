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
		[ - X X X X ] 0�� �湮�� ����
		[ 0 ] 
		
		[ - - - X - ]
		[ 1 2 4 ]
	*/
	public static void visit( int spot, int[][] map ) {
		boolean[] visited = new boolean[5];
		List<Integer> queue = new LinkedList<Integer>();
		
		visited[spot] = true;
		queue.add(spot);
		
		while(queue.size() != 0){    // ť�� ���� �ʴ� �� �ݺ��Ѵ�.
			int v = queue.remove(0);    // ť���� ������ ������ �湮 ������
			System.out.println("visited : " + v);
			
			/*
				�� ó�� spot�� ť�� ����. ���� ť�� [0], visited: [- X X X X]
				queue ������ �ϸ� 0�� ���´�. 0�������� ���� ����.
				0,0�� 0�̱� ������ �湮���� �ʴ´�.
				1,0�� 1�̴�. visited�� ����鼭 ť�� 1�� ����. ���� ť�� [1]
				2,0�� 1�̴�. ���� ť�� [1, 2]
				while 1ȸ(visited[0]) : queue:[1, 2, 4], visited:[- - - X -]
				
				queue ������ �ϸ� 1�� ���´�. 1�������� ���� ����.
				while 2ȸ(visited[1]) : queue:[2, 4], visited: [- - - X -]
				
				queue ������ �ϸ� 2�� ���´�. 2�������� ���� ����.
				2�� ���������� 3�� ���� ���´�.
				while 3ȸ (visited[2]) : queue: [4, 3], visited: [- - - - -]
				
				queue ������ �ϸ� 4�� ���´�. 4�������� ���� ����.
				while 4ȸ (visited[4]) : queue: [3], visited: [- - - - -]
				
				queue ������ �ϸ� 3�� ���´�. 3�������� ���� ����.
				while 5ȸ (visited[3]) : queue: [], visited: [- - - - -]
			*/
			for(int i=0; i<map.length; i++){     // ���� �������� �湮.
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
	�������� �̿��� �湮 �˰����� DFS(Depth First Search) �˰����̶�� �մϴ�.
	�̵��ϰ� �̵��� �������� �ٽ� �̵��ϴ� ������ �˻��̶� ��θ� ����� ���� ��쿡 ����ȴ�.
	
	�װͰ��� ���ǰ� ���� ����� �������� ���� ��� �湮�ϴ� ������ �湮 �˰����� �ִµ� �̰��� BFS �˰����̶�� �Ѵ�.
	
	�湮 �˰����� ũ�� �� ���� �⺻�� �ȴ�.
*/