package banana;

import static banana.Logic.*;
import java.util.*;


/*
	�������� ������ ǥ���ϱ� ���� Ŭ����(Edge). �ֹ��� ������ ������ ����
	Vertex�� �޸� ����Ʈ��� �����ϸ� spot�� ��������, distance�� ����ġ�� ������ �� �ִ�.
	�ϳ��� Vertex���� ���� Edge�� ���� �ʿ䰡 �ִ�.
	�ϳ��� Vertex���� ����ϴ� Edge�� ���� ���� ���� �� �ֱ� ����.
*/
class Edge{
	int spot = 0;		// ������ ��������
	int distance = 1;	// ���������� �Ÿ�
	
	public Edge( int i ) { spot = i; }
	public Edge(int i, int d){spot = i; distance = d;}
}

class Vertex{
	int spot = 0;    // ���� �Ϸù�ȣ
	List<Edge> list = null;
	
	public Vertex(int i){
		this.spot = i;
		list = new ArrayList<Edge>();    // ������� �ʱ�ȭ. Edge���� ����Ʈ�� �ִ�.
	}
	
}

/*
	ArrayList : ������ ���Ծ��� �ӵ� ����. �߰��߰��� ���� ������ �Ϳ� ���ϴ�.
	LinkedList : �ӵ��� ������ ������ ���� ������ �߰��߰��� ���� ������ �Ϳ� ���ϴ�.
*/
class RelatedList{
	private List<Vertex> list = null;
	
	public RelatedList(){
		list = new ArrayList<Vertex>();
	}
	
	public void add(int spot){
		list.add(new Vertex(spot));
	}
	
	// rList.connect(0,1);
	public void connect(int from, int to){
		Vertex found = null;
		
		for(Vertex v : list){
			if(v.spot == from){
				found = v;
				break;
			}
		}
		// �� vertex�� edge�� list�� ������ �ִ�. �ű⿡ edge�� �űԵ�����ָ� edge�� ǥ���ȴ�.
		if(found != null){
			found.list.add(new Edge(to));
		}
	}
	
	public void print(){
		StringBuffer sb = new StringBuffer();
		
		for(Vertex v : list){
			sb.append("[").append(v.spot).append("]");
			
			for(Edge e : v.list){
				sb.append("[")
					.append(e.spot)
					.append(".").append(e.distance)
					.append("]");
			}
			sb.append("[").append("]\r\n");
		}
		System.out.println(sb.toString());
	}
	
	public void connect2(int a, int b){
		connect(a, b);
		connect(b, a);
	}
}

class Logic{
}

public class Test275 {
	public static void main( String[] args ) {
		RelatedList rList = new RelatedList();
		rList.add(0);
		rList.add(1);
		rList.add(2);
		rList.add(3);
		rList.add(4);
		
		rList.connect(0,1);
		
		rList.print();
	}
}

/*
	1000�� �������� ���� ���̽��Ͻ����� �Խ��� ������µ�
	�׵��� �ΰ����踦 Graph�� �ߴ�? �迭�� ǥ���� ������ �ϴ� 1000 * 1000���� �迭�� �ʿ��ϴ�.
	ģ���� 30���̶�� �ϸ� (0�� 970�� 1�� 30��) * 1000  -> ��κ��� 0�̴�.
	�̷� ���̸� �����Ұ� ����ȴٴ� ������ �ִ�.
	���������� �������� ������ ������ �迭 ��� "���� ����Ʈ"��� ���� ���� ����.
	
	�� ���� : vertex
	���� ������ : spot(int��)
	�� ���� : edge(from, to, distance) ... �ϳ��� vertex�� ���� �� �����Ѵ�.
*/