package banana;

import static banana.Logic.*;

class Logic{
}

class Node{
	int data = 0;
	Node left = null;
	Node right = null;
	
	public Node(int data){
		this.data = data;
	}
}

public class Test240{
	public static void main(String[] args){
		Node root = new Node(5);
		//root.left = new Node(3);
		//root.right = new Node(8);
		
		//root.left.left = new Node(1);
		//root.left.right = new Node(4);
		
		Node a = root.left = new Node(3);    // �̻��� ����??
		Node b = root.right = new Node(8);	// �̰� b�� ����Ű�� �Ͱ� root.right�� ����Ű�� ���� Node(3)���� ����.
		System.out.println(a == root.left);
		System.out.println(a == root.right);
		
		a.left = new Node(1);
		a.right = new Node(4);
	}
}

/*
	������ �ΰ��� ������ �̾���̴� ������ �ڷᱸ�� : ����Ʈ��
*/