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
			���ú����� �迭�� �����ϸ� ���δ� �ʱⰪ�� �ڵ����� �� : 
			int�� 0, boolean�� false, �����ʹ� null
		*/
		boolean[] visited = new boolean[5];
		System.out.println(visited[0]);
		
		// 0���� ���
		visit(0,visited,map);
	}
}

// Ʈ��ó�� ��� ��带 �湮�غ���.
class Logic{
	/*
	
	*/
	public static void visit(int spot, boolean[] visited, int[][] map){
		visited[spot] = true;
		System.out.println("visit : " + spot);
		
		/*
			{0,1,1,0,1}, // 0 ���忡�� ����Ǿ� �ִ� ������. �װ��� length��ŭ ���ư���.
			0 ���忡�� ���� �� �湮�����ϰ� �湮�� �� ���� �����͸� ���ȣ���Ѵ�.
		*/
		
		for(int i=0; i<map[spot].length; i++){
			if(map[spot][i] != 0 && visited[i] == false){    // 1�̰�(���谡 �ְ�), false�� ��(�湮�� �� ���� ��)
				visit(i, visited, map);
			}
		}
	}
}