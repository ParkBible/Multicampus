


public class Test263 {
	public static void main( String[] args ){
		// �迭�� ��ҷ� ������ �ִ� �迭 = 4x4 ������ �迭
		/*
		int[][] map = new int[4][4];
		{
			// ���踦 ǥ���Ѵ�. ģ���̸� 1�� ǥ��.
			// 0�� 1�� ���谡 �ִٸ� (0,1), (1,0)�� 1.
			// 2�� 3�� ���谡 �ִٸ� (2,3), (3,2)�� 1.
			{0,1,0,0},    // 0 ���� ���� 1�� ģ���̹Ƿ� 1.
			{1,0,0,0},	  // 1 ���� ���� 0�� ģ���̹Ƿ� 1.
			{0,0,0,0},	  // 2 ����
			{0,0,0,0},	  // 3 ����
		};
		*/
		// int[][] map = new int[4][4];
		// �迭�� �����ϸ� �� ���δ� �����Ⱚ�� �ƴ�, 0���� �ʱ�ȭ �ȴ�.
		
		int[][] map2 = new int[4][4];
		map2[0][1] = map2[1][0] = 1;
		map2[0][3] = map2[3][0] = 1;
		
		
		// print �غ���
		/*
		for(int i=0; i<map2.length; i++){
			
			StringBuffer sb = new StringBuffer();
			sb.append(map2[i][0]).append(' ');
			sb.append(map2[i][1]).append(' ');
			sb.append(map2[i][2]).append(' ');
			sb.append(map2[i][3]);
			
			System.out.println(sb.toString());
		}
		*/
		
		// ���� ���� ���
		for(int i=0; i<map2.length; i++){
			StringBuffer sb = null;    // ���̰� 4�̹Ƿ� 4�� ���������.
			for(int j=0; j<map2[i].length; j++){
				// �� ���̱�(�ͳθ� ���۷�����)
				// sb = (sb == null ? new StringBuffer() : sb.append(' ')); (���� ? ���϶� ���� : �����϶� ����)
				if(sb == null)
					sb = new StringBuffer();
				else
					sb.append(' ');
				sb.append(map2[i][j]);
			}
			System.out.println(sb.toString());
		}
	}
}

/*
	�̰� �̷��� �ٽ� �� �� �ִ�.
	map2[0][1] = 1;
	map2[0][1] = 1;
	
	// 0�� 1�� ģ��
	map2[0][1] = map2[1][0] = 1;
	// 0�� 3�� ģ��
	map2[0][3] = map2[3][0] = 1;
*/