package banana;

import static banana.Logic.*;
import java.util.*;

public class Test272 {
	public static void main( String[] args ) {
		int[][] map = {
			{ 0, 2, 5, 1, 0, 0 },    // 0�� ������ �� �Ǿ� �ִ� ���̴�.
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
	���ͽ�Ʈ�� �˰��� : �������������� �� spot ������ �ִܰŸ��� ���ϴ� �˰���
	(BFS�� ���������� �������� ���� �ľ��ϰ� Ȱ���ϱ�.)
*/

class Logic {
	public static void visit( int start, int[][] map ) 
	{
		// �� spot������ ���̸� ��� ������
		int[] distance = new int[6];
		for(int i=0; i<distance.length; i++){
			if(i == start){
				distance[i] = 0;    // ��������
			} else if(map[start][i] == 0){
				distance[i] = 1000000;    // ���� ������ �ȵǾ��ִٸ�(0�̸�) �Ÿ��� ����� ū ���ڷ� �����Ѵ�.
			} else{
				distance[i] = map[start][i];
			}
		}
		boolean[] visited = new boolean[6];
		visited[start] = true;
		System.out.println("visited : " + start);
		
		if(true){
			// ���� �湮�� �ȵ� spot �߿��� �ִ� �Ÿ��� �ִ� spot ã��(�Ʊ� �ߴ�����)
			
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
			
			// ������ ã�� �� ������ �湮�Ѵ�.
			visited[min_idx] = true;
			System.out.println("visited(min_idx) : " + min_idx);
			
			/*
				3���� �������� 3���� ���İ��� 1���� �� ����� �Ÿ��� �߰ߵǸ� ������Ʈ �Ѵ�.
				������� 0���� 4������ �Ÿ��� X���µ� 3���� ���� 0 - 3 - 4 �ؼ� 2(�� ª�� �Ÿ�) ��� �� �˰� �Ǿ���.
				�׷��� 4������ �Ÿ��� X���� 2�� �ٲ۴�.
				�� �۾��� ��� �ݺ��ϴ� ���� ���ͽ�Ʈ�� �˰����� �ٽ��̴�.
			*/
			
			// �湮���� �ʾҰ� && ����Ǿ� �ִ� spot�� ���ؼ� 
			// distance[0 2 5 1 X X]  ->  distance[0 2 4 1 2 X]
			// distance[���������� ���������� �Ÿ�, ���������� 1���� �Ÿ�, 2���� �Ÿ�, 3���� �Ÿ�, ...]
			for(int i=0; i<distance.length; i++){
				if(map[min_idx][i] != 0 && visited[i] == false){
					//System.out.println(i);
					int dist2 = distance[min_idx] + map[min_idx][i];
					// ���� ���� �����ϸ�, 3�������� �Ÿ� + 3������ 1, 2, 4������ �Ÿ��� ���� ��.
					// �� 3��������? min_idx �� 0���� �Ÿ��� ���� ª�� ���� 3�̶�.
					
					// ������ �˷����� start���� i������ �Ÿ��� ���ؼ� ª����?
					if(distance[i] > dist2){
						distance[i] = dist2;
					}
					
				}
			}
		}
		
		
		// StringBuffer�� �Ἥ distance �迭�� ������ ��� : �� ����� ���� x��
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
		System.out.println(sb.toString());    // ����Ҷ��� String���� �ٲ��ش�.
		
	}
}	