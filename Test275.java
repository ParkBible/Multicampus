package banana;

import static banana.Logic.*;
import java.util.*;


/*
	지점과의 연결을 표현하기 위한 클래스(Edge). 쌍방향 연결을 생각해 보면
	Vertex에 달린 리스트라고 생각하면 spot은 도착지점, distance는 가중치로 생각할 수 있다.
	하나의 Vertex에는 여러 Edge를 담을 필요가 있다.
	하나의 Vertex에서 출발하는 Edge는 여러 개가 있을 수 있기 때문.
*/
class Edge{
	int spot = 0;		// 연결의 도착지점
	int distance = 1;	// 지점까지의 거리
	
	public Edge( int i ) { spot = i; }
	public Edge(int i, int d){spot = i; distance = d;}
}

class Vertex{
	int spot = 0;    // 지점 일련번호
	List<Edge> list = null;
	
	public Vertex(int i){
		this.spot = i;
		list = new ArrayList<Edge>();    // 멤버변수 초기화. Edge들의 리스트가 있다.
	}
	
}

/*
	ArrayList : 기억공간 적게쓰고 속도 빠름. 중간중간에 들어가고 나가는 것에 약하다.
	LinkedList : 속도가 느리고 공간도 많이 쓰지만 중간중간에 들어가고 나가는 것에 강하다.
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
		// 각 vertex는 edge의 list를 가지고 있다. 거기에 edge를 신규등록해주면 edge에 표현된다.
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
	1000명 전교생에 대해 페이스북스러운 게시판 만들려는데
	그들의 인간관계를 Graph로 했다? 배열로 표현할 생각을 하니 1000 * 1000개의 배열이 필요하다.
	친구가 30명이라고 하면 (0이 970개 1이 30개) * 1000  -> 대부분이 0이다.
	이런 식이면 기억장소가 낭비된다는 느낌이 있다.
	실전에서는 데이터의 개수가 많으면 배열 대신 "연관 리스트"라는 것을 많이 쓴다.
	
	각 지점 : vertex
	지점 고유명 : spot(int형)
	각 연결 : edge(from, to, distance) ... 하나의 vertex에 여러 개 존재한다.
*/