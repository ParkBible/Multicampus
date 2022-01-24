package banana;

public class Test264 {
	public static void main( String[] args ){
		// 4개짜리 배열을 만들었는데 그 요소가 int[]이다. 배열 4개 요소 각각에 포인터가 들어가있다.
		// 그럼 자바의 배열은 포인터(참조형 변수)인가? 그렇다.
		// 배열을 생성할 때 new를 쓴다. 배열 만드는 걸 인스턴스 생성하듯 하고 있다.
		// 그렇다 사실 자바의 배열은 인스턴스이다. : 다른 언어와는 많이 다르다.
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