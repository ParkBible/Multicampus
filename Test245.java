package banana;

import static banana.Logic.*;

class Node{
	int data = 0;
	Node left = null;
	Node right = null;
	
	public Node(int data){
		this.data = data;
	}
}

public class Test245{
	public static void main(String[] args){
		Node root = new Node(5);

		Node a = root.left = new Node(3);
		Node b = root.right = new Node(8);
		
		Node c = a.left = new Node(1);
		a.right = new Node(4);
		
		Node found = apple(root, 4);    // 4�� ã�ƺ���
		if(found != null){
			System.out.println(found.data);
		}
		else{
			System.out.println("����");
		}
	}
}

// ã�� ���� Ʈ�� ���� ������ �ش� ���� ����Ѵ�. �̰� �׳� �ܿ�°� ����.
class Logic{
	public static Node apple(Node n, int d){
		Node found = null;
		if(n!=null){
			if(n.data == d)		// ã�´�. ã����(d)�� data�� ������ ���� ã�� ���.
				found = n;
			if(found == null && n.data > d)    // ������ �������� ���� ã�´�
				found = apple(n.left, d);
			if(found == null && n.data < d)    // ������ ���������� ���� ã�´�
				found = apple(n.right, d);
		}
		return found;
	}
}

/*
	1 3 4 5 8
	������ : 3�� ���� ���ϱ� ã�� ���� 4��, ������ �� �ʿ� ����.(3���� ���� ���� �����̹Ƿ�)
	�׸��� 5�� ���� ���ϱ� ã�� ���� 4��, �������� �� �ʿ� ����.
*/