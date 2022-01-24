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
		// * �� ����ִ� �͵��� �˻��Ϸ���? �ϴ� ��� ��带 �湮�ϴ� �ڵ带 ¥��.
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
	
	// �˻� ��� : ���� ���� ������ 2���� ã�� �� ����.
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
		// ��ũ�� ����Ʈó�� ���̳�� �ϳ� ���� �����Ѵ�. ���� document ����� �� ���� ����.(js����)
		Node root = new Node(null);
		Node document = new Node("[document]");
		root.child = document;
		
		//document.addChild(new Node("��ǰ"));
		Node a = new Node("��ǰ");
		
		Node b = new Node("����ǰ");
		b.addChild(new Node("IT���"));
		b.addChild(new Node("����"));
		b.addChild(new Node("�ֹ���"));
		a.addChild(b);
		
		Node c = new Node("����ǰ");
		c.addChild(new Node("������"));
		c.addChild(new Node("����"));
		c.addChild(new Node("�Ǿ"));
		a.addChild(c);
		
		Node d = new Node("���ǰ");
		d.addChild(new Node("ä��*"));
		d.addChild(new Node("�"));
		a.addChild(d);
		
		document.addChild(a);
		
		// ���� �ִ°� �ƴ�, IT��� ��ġ�� ã�Ƽ� �� �ؿ� ����Ʈ���� ��Ʈ���� �ְ� �ʹ�.
		Node f = find(document, "IT���");
		f.addChild(new Node("����Ʈ��*"));
		f.addChild(new Node("��Ʈ��"));
		
		List<Node> list = new ArrayList<Node>();
		// ���� �� �� �¡���!
		travel(document, list);
		for(Node t: list){
			System.out.println(t.name);
		}
		
		print(document, 0);
		// ����ǰ ī�װ� �Ʒ��� ��� ���� ī�װ��� ����Ϸ��� ��� �ؾ� �ұ�?
		Node cate = find(document, "����ǰ");
		//System.out.println(cate.name);
		/*
		print([IT���])
			-- "IT���"
			print([����Ʈ��])
				-- "����Ʈ��"
				-- null(child)
				print([��Ʈ��])    // ����Ʈ���� sibling
				-- "��Ʈ��"
					-- null(child)
		print([����])
			-- "����"
			-- null(child)
			print([�ֹ���])    // ������ sibling
				-- "�ֹ���"
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