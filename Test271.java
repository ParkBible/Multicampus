package banana;

import static banana.Logic.*;
import java.util.*;

public class Test271 {
	public static void main( String[] args ) {
		int[][] map = {
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
		};
		
		visit( 0, map );
	}
}

class Logic {
	public static void visit( int spot, int[][] map ) 
	{
		boolean[] visited = new boolean[5];
		List<Integer> queue = new LinkedList<Integer>();
		
		visited[spot] = true;
		queue.add( spot );
		
		// [2,4][X X - - -], v:3, visited:3
		
		while( queue.size() != 0 )	//	queue �� ���� �ʴ� �� �ݺ��Ѵ�.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
			// �ϳ��� ǥ���Ϸ���? v�� 3���� �����Ѵ�.
			
			for( int i = 0 ; i < map.length ; i++ ) // ���ι���
			{
				if( map[i][v] != 0 ) {
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
			
			/*
				���� for ������ ���� �ڵ带 �ٲ㺸��.
				for(int i : l){
				}
			*/
			
			
			// ť�� �ִ� ������ ����.
			StringBuffer sb = new StringBuffer();
			Iterator<Integer> it = queue.iterator();
			
			sb.append("[ ");
			/*
			while(it.hasNext()){
				int q = it.next();
				sb.append(q).append(" ");
			}
			*/
			// ���� for������ �ٷ� ���� �ڵ带 �ٲ۰�.
			for(int i : queue){
				sb.append(i).append(" ");
			}
			sb.append("] ").append(" ");
			
			
			// visited�� �ִ� ������ ����.
			sb.append("[ ");
			/*
			for(int i=0; i<visited.length; i++){
				if(visited[i]){
					sb.append("-").append(" ");
				}else{
					sb.append("X").append(" ");
				}
			}
			*/
			// ���� for������ �ٷ� ���� �ڵ带 �ٲ۰�.
			for(boolean i : visited){
				if(i == true){
					sb.append("-").append(" ");
				}else{
					sb.append("X").append(" ");
				}
			}
			
			sb.append("] ");
			
			
			System.out.println(sb.toString());
		}
			
			
	}
}


/*	
	visited : 0
	[ 1 2 4 ]  [ - - - X - ]
	visited : 1
	[ 2 4 ]  [ - - - X - ]
	visited : 2
	[ 4 3 ]  [ - - - - - ]
	visited : 4
	[ 3 ]  [ - - - - - ]
	visited : 3
	[ ]  [ - - - - - ]
	
	[0 1][- - - - -], v:4, visited:3 2 4
	3, 2 4, 0 1   --- ����, ģ��, ģ���� ģ��
*/