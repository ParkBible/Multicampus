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
		// ��ũ�� ����Ʈó�� ���̳�� �ϳ� ���� �����Ѵ�. ���� document ����� �� ���� ����.(js����)
		Node root = new Node(null);
		Node document = new Node("[document]");
		root.child = document;
		
		document.addChild(new Node("��ǰ"));
		print(document, 0);
	}
}