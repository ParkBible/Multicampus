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

public class Test243{
	public static void main(String[] args){
		Node root = new Node(5);

		Node a = root.left = new Node(3);
		Node b = root.right = new Node(8);
		
		Node c = a.left = new Node(1);
		a.right = new Node(4);
		
		// ��Ģ�� ���� �߰��� ����.
		c.right = new Node(2);
		b.left = new Node(7);
		b.right = new Node(9);
		
		print(root);
		int res = min(root);
		System.out.println(res);
	}
}

// ��Ģ��� ��尡 ��ġ�Ǹ� �Ʒ� �ڵ�� ���ĵ� ������� ��µȴ�.
class Logic{
	private static int minnum = 100;
	public static void print(Node n){
		if(n!=null){
			print(n.left);
			System.out.println(n.data);
			print(n.right);
		}
	}
	
	// �ּҰ��� ���ϴ� �Լ��� §��. �����Ͱ� �ƹ��͵� ������ -1�� ��µȴ�.
	public static int min(Node t){
		if(t==null){
			return -1;
		}
		else if(t.left!=null){
			return min(t.left);
		}
		else{
			return t.data;
		}
	}
}

/*
	1 3 4 5 8
	
	ũ�� ���� 1,3,4�κ��� left, 5�� n, 8�� right
	
	print(n=5)
		print(n=3)
			print(n=1)
				print(null)
				System.out.println(1)
				print(null)
			System.out.println(3)
			print(n=4)
			print(null)
			System.out.println(4)
			print(null)
	System.out.println(5)
		print(n=8)
			print(null)
			System.out.println(8)
			print(null)
	
	����Ʈ������ ��带 ��ġ�ϴ� ��Ģ
	1. �ߺ��� ������� �ʴ´�. (�׷��� TreeSet)
	2. ������ �������� ������.
	3. ũ�� ���������� ������.
	4. null�� ������ �ű⿡ ���δ�.
	
	
	// �ּҰ��� ���ϴ� �Լ��� §��. �����Ͱ� �ƹ��͵� ������ -1�� ��µȴ�.
	public static int min(Node n){
		if(n!=null){
			min(n.left);
			if(n.data < minnum){
				minnum = n.data;
			}
			min(n.right);
		}
		else{
			return -1;
		}
		return minnum;
	}
	
	// ���ȣ�� ���� �ּҰ� ã��
	public static int min2(Node t){
		if(t==null)
			return -1;
		while(t.left!=null){
			t = t.left;
	}
	return t.data;
	}
	
		
*/