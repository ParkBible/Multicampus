package banana;

public class Test264 {
	public static void main( String[] args ){
		// 4��¥�� �迭�� ������µ� �� ��Ұ� int[]�̴�. �迭 4�� ��� ������ �����Ͱ� ���ִ�.
		// �׷� �ڹ��� �迭�� ������(������ ����)�ΰ�? �׷���.
		// �迭�� ������ �� new�� ����. �迭 ����� �� �ν��Ͻ� �����ϵ� �ϰ� �ִ�.
		// �׷��� ��� �ڹ��� �迭�� �ν��Ͻ��̴�. : �ٸ� ���ʹ� ���� �ٸ���.
		int[][] map = new int[4][];
		map[0] = new int[]{1,2};
		map[1] = new int[]{3,4,5};
		map[2] = new int[2];
		map[3] = new int[]{6};
		
		for(int i=0; i<map.length; i++){    // 0, 1, 2, 3
			for(int j=0; j<map[i].length; j++){    // {1,2} ,{3,4,5}, {0,0}, 6
				System.out.println(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}