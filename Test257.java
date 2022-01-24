package banana;

import static banana.Logic.*;

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
	}
}

class Logic{
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
}

public class Test257{
	public static void main(String[] args){
		// 링크드 리스트처럼 더미노드 하나 끼고 시작한다. 보통 document 노드라고 할 때가 많다.(js영향)
		Node root = new Node(null);
		Node document = new Node("[document]");
		root.child = document;
		
		document.addChild(new Node("상품"));
		print(document, 0);
	}
}