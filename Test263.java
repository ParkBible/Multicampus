


public class Test263 {
	public static void main( String[] args ){
		// 배열을 요소로 가지고 있는 배열 = 4x4 이차원 배열
		/*
		int[][] map = new int[4][4];
		{
			// 관계를 표현한다. 친구이면 1로 표시.
			// 0과 1이 관계가 있다면 (0,1), (1,0)은 1.
			// 2와 3이 관계가 있다면 (2,3), (3,2)는 1.
			{0,1,0,0},    // 0 입장 에서 1이 친구이므로 1.
			{1,0,0,0},	  // 1 입장 에서 0이 친구이므로 1.
			{0,0,0,0},	  // 2 입장
			{0,0,0,0},	  // 3 입장
		};
		*/
		// int[][] map = new int[4][4];
		// 배열을 선언하면 그 내부는 쓰레기값이 아닌, 0으로 초기화 된다.
		
		int[][] map2 = new int[4][4];
		map2[0][1] = map2[1][0] = 1;
		map2[0][3] = map2[3][0] = 1;
		
		
		// print 해보기
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
		
		// 위와 같은 결과
		for(int i=0; i<map2.length; i++){
			StringBuffer sb = null;    // 길이가 4이므로 4번 만들어진다.
			for(int j=0; j<map2[i].length; j++){
				// 더 줄이기(터널링 오퍼레이터)
				// sb = (sb == null ? new StringBuffer() : sb.append(' ')); (조건 ? 참일때 대입 : 거짓일때 대입)
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
	이걸 이렇게 다시 쓸 수 있다.
	map2[0][1] = 1;
	map2[0][1] = 1;
	
	// 0과 1은 친구
	map2[0][1] = map2[1][0] = 1;
	// 0과 3은 친구
	map2[0][3] = map2[3][0] = 1;
*/