package banana;

import static banana.Logic.*;
import java.util.*;

class Node{
	String name = null;
	Node child = null;
	Node sibling = null;
	
	public Node(String n){
		this.name = n;
	}
	
	public void addChild(Node n){
		if(child == null){
			child = n;
		}
		else{
			Node t = child;
			while(t.sibling != null){
				t = t.sibling;
			}
			t.sibling = n;
		}
	}
}

class Logic{
	public static void travel(Node n, List<Node> lst){
		// * 가 들어있는 것들을 검색하려면? 일단 모든 노드를 방문하는 코드를 짜자.
		if(n != null){
			if(n.name.endsWith("*")){
				//System.out.println(n.name + " " + lst.hashCode());
				lst.add(n);
			}
			travel(n.child, lst);
			travel(n.sibling, lst);
		}
	}
	
	public static void print(Node n, int depth){
		if(n != null){
			StringBuffer sb = new StringBuffer();
			
			for(int i=0; i<depth; i++){
				sb.append("  ");
			}
			sb.append("{").append(n.name).append("}");
			System.out.println(sb.toString());
			
			print(n.child, depth+1);
			print(n.sibling, depth);
		}
	}
	
	// 검색 기능 : 전과 같이 포인터 2개로 찾는 건 같다.
	public static Node find(Node n, String name){
		Node found = null;
		if(n != null){
			if(name.equals(n.name)){
				found = n;
			}
			if(found == null){
				found = find(n.child, name);
			}
			if(found == null){
				found = find(n.sibling, name);
			}
		}
		return found;
	}
	
	public static void orange( Node n, List<Node> list ) {
		if( n != null ) {
			list.add( n );
			orange( n.child, list );
			orange( n.sibling, list );
		}
	}	
}

public class Test258{
	public static void main(String[] args){
		// 링크드 리스트처럼 더미노드 하나 끼고 시작한다. 보통 document 노드라고 할 때가 많다.(js영향)
		Node root = new Node(null);
		Node document = new Node("[document]");
		root.child = document;
		
		//document.addChild(new Node("상품"));
		Node a = new Node("상품");
		
		Node b = new Node("공산품");
		b.addChild(new Node("IT기기"));
		b.addChild(new Node("가전"));
		b.addChild(new Node("주방기기"));
		a.addChild(b);
		
		Node c = new Node("수산품");
		c.addChild(new Node("젓갈류"));
		c.addChild(new Node("생물"));
		c.addChild(new Node("건어물"));
		a.addChild(c);
		
		Node d = new Node("농산품");
		d.addChild(new Node("채소*"));
		d.addChild(new Node("곡물"));
		a.addChild(d);
		
		document.addChild(a);
		
		// 직접 넣는게 아닌, IT기기 위치를 찾아서 그 밑에 스마트폰과 노트북을 넣고 싶다.
		Node f = find(document, "IT기기");
		f.addChild(new Node("스마트폰*"));
		f.addChild(new Node("노트북"));
		
		List<Node> list = new ArrayList<Node>();
		// 「전 부 출 력」ㅡ!
		travel(document, list);
		for(Node t: list){
			System.out.println(t.name);
		}
		
		print(document, 0);
		// 공산품 카테고리 아래의 모든 하위 카테고리만 출력하려면 어떻게 해야 할까?
		Node cate = find(document, "공산품");
		//System.out.println(cate.name);
		/*
		print([IT기기])
			-- "IT기기"
			print([스마트폰])
				-- "스마트폰"
				-- null(child)
				print([노트북])    // 스마트폰의 sibling
				-- "노트북"
					-- null(child)
		print([가전])
			-- "가전"
			-- null(child)
			print([주방기기])    // 가전의 sibling
				-- "주방기기"
				-- null(child)
				-- null(sibling)
		*/
		print(cate.child, 0);
		
		List<Node> list2 = new LinkedList<Node>();
		list2.add(cate);
		
		orange(cate.child, list2);
		
		for(Node nd : list2){
			System.out.println("++ " + nd.name);
		}
	}
}