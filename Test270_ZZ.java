package banana;

import static banana.Logic.*;
import java.util.*;

public class Test270_ZZ {
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
		
		while( queue.size() != 0 )	//	queue �� ���� �ʴ� �� �ݺ��Ѵ�.
		{
			int v = queue.remove(0);
			System.out.println( "visited : " + v );
			
/*            0  1  2  3  4
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 }
			
		//	[ - - - - - ]
		//	[ ]
		
		visited:0 
		visited:1
		visited:2
		visited:4
		visited:3
		
		while 1ȸ : [ 1 2 4 ] [ - - - X - ]
		while 2ȸ : [ 2 4 ]   [ - - - X - ]  -- �ű�����X
		while 3ȸ : [ 4 3 ]   [ - - - - - ]
		while 4ȸ : [ 3 ]     [ - - - - - ] -- �ű�����X
		while 5ȸ : [ ]       [ - - - - - ] -- �ű�����X
*/			
			for( int i = 0 ; i < map[v].length ; i++ ) // ���ι��� -> ���ι������� ����
			{
				if( map[v][i] != 0 ) {		//	map[i][v] -> map[v][i] �� ����
					if( visited[i] == false ) {
						visited[i] = true;
						queue.add( i );
					}
				}
			}
		}
	}
}

/*	�������� ���ȣ���� �̿��� �湮 �˰����� "DFS - Depth First Search" �˰����̶� �մϴ�.
	�̵��ϰ� �̵��� �������� �ٽ� �̵��ϴ� ������ �˻��̶� ��θ� ����� ���� ��쿡 ����ȴ�.
	
	�װͰ��� ���ǰ� '���� ����� �������� ���� ��� �湮�ϴ� ������ �湮 �˰����� �ִµ�
	�̸� BFS �˰����̶�� �Ѵ�.
	
	�湮 �˰����� ũ�� �� ���� �⺻�� �ȴ�.
	
	'BFS�� �����ϱ� ���� �ľ��ϰ� �ܿ�� ... ������ �ΰ� ������. ���ȣ�� �Ⱦ��⿡ �ڵ尡 �� �����ϴ�.'
*/