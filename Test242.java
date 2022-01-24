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

public class Test242{
	public static void main(String[] args){
		Node root = new Node(5);

		Node a = root.left = new Node(3);    // �̻��� ����??
		Node b = root.right = new Node(8);	// �̰� b�� ����Ű�� �Ͱ� root.right�� ����Ű�� ���� Node(3)���� ����.
		
		a.left = new Node(1);
		a.right = new Node(4);
		
		print(root);
	}
}

class Logic{
	public static void print(Node n){
		if(n!=null){
			print(n.left);
			System.out.println(n.data);
			print(n.right);
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
		
*/