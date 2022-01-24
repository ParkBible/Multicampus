package banana;

import static banana.Logic.*;
import java.util.*;

public class Test272 {
	public static void main( String[] args ) {
		int[][] map = {
			{ 0, 2, 5, 1, 0, 0 },    // 0은 연결이 안 되어 있는 곳이다.
			{ 2, 0, 3, 2, 0, 0 },
			{ 5, 3, 0, 3, 1, 5 },
			{ 1, 2, 3, 0, 1, 0 },
			{ 0, 0, 1, 1, 0, 2 },
			{ 0, 0, 5, 0, 2, 0 }
		};
		
		visit(0, map);
	}
}
/*
	데익스트라 알고리즘 : 시작점에서부터 각 spot 까지의 최단거리를 구하는 알고리즘
	(BFS랑 마찬가지로 이해하지 말고 파악하고 활용하기.)
*/

class Logic {
	public static void visit( int start, int[][] map ) 
	{
		// 각 spot까지의 길이를 담는 기억공간
		int[] distance = new int[6];
		for(int i=0; i<distance.length; i++){
			if(i == start){
				distance[i] = 0;    // 시작지점
			} else if(map[start][i] == 0){
				distance[i] = 1000000;    // 만약 연결이 안되어있다면(0이면) 거리는 충분히 큰 숫자로 지정한다.
			} else{
				distance[i] = map[start][i];
			}
		}
		boolean[] visited = new boolean[6];
		visited[start] = true;
		System.out.println("visited : " + start);
		
		if(true){
			// 아직 방문이 안된 spot 중에서 최단 거리에 있는 spot 찾기(아까 했던거임)
			
			int min_dist = 1000000;
			int min_idx = -1;
			for(int i=0; i<distance.length; i++){
				if(distance[i] != 0){
					if(min_dist > distance[i]){
						min_dist = distance[i];
						min_idx = i;
					}
				}
			}
			
			// 위에서 찾은 그 지점을 방문한다.
			visited[min_idx] = true;
			System.out.println("visited(min_idx) : " + min_idx);
			
			/*
				3번을 기준으로 3번을 거쳐가면 1번에 더 가까운 거리가 발견되면 업데이트 한다.
				예를들어 0에서 4까지의 거리가 X였는데 3에서 보니 0 - 3 - 4 해서 2(더 짧은 거리) 라는 걸 알게 되었다.
				그러면 4까지의 거리를 X에서 2로 바꾼다.
				이 작업을 계속 반복하는 것이 데익스트라 알고리즘의 핵심이다.
			*/
			
			// 방문되지 않았고 && 연결되어 있는 spot에 대해서 
			// distance[0 2 5 1 X X]  ->  distance[0 2 4 1 2 X]
			// distance[시작지에서 시작지까지 거리, 시작지에서 1까지 거리, 2까지 거리, 3까지 거리, ...]
			for(int i=0; i<distance.length; i++){
				if(map[min_idx][i] != 0 && visited[i] == false){
					//System.out.println(i);
					int dist2 = distance[min_idx] + map[min_idx][i];
					// 위의 식을 설명하면, 3번까지의 거리 + 3번에서 1, 2, 4까지의 거리를 더한 것.
					// 왜 3번까지냐? min_idx 즉 0과의 거리가 가장 짧은 것이 3이라서.
					
					// 기존에 알려졌던 start부터 i까지의 거리와 비교해서 짧으면?
					if(distance[i] > dist2){
						distance[i] = dist2;
					}
					
				}
			}
		}
		
		
		// StringBuffer를 써서 distance 배열의 내용을 출력 : 미 연결된 곳은 x로
		StringBuffer sb = new StringBuffer();
		sb.append("distance [ ");		
		for(int d : distance){
			if(d == 1000000){
				sb.append("X").append(" ");
			}
			else{
			sb.append(d).append(" ");
			}
		}
		
		sb.append("] \r\n");
		sb.append(" visited [ ");
		for(boolean b : visited){
			if(b){
				sb.append("O ");
			}
			else{
			sb.append("- ");
			}
		}
		sb.append("] ");
		System.out.println(sb.toString());    // 출력할때는 String으로 바꿔준다.
		
	}
}	