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
		
		// 원칙에 따라 추가된 노드들.
		c.right = new Node(2);
		b.left = new Node(7);
		b.right = new Node(9);
		
		print(root);
		int res = min(root);
		System.out.println(res);
	}
}

// 원칙대로 노드가 배치되면 아래 코드는 정렬된 순서대로 출력된다.
class Logic{
	private static int minnum = 100;
	public static void print(Node n){
		if(n!=null){
			print(n.left);
			System.out.println(n.data);
			print(n.right);
		}
	}
	
	// 최소값을 구하는 함수를 짠다. 데이터가 아무것도 없으면 -1이 출력된다.
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
	
	크게 보면 1,3,4부분이 left, 5가 n, 8이 right
	
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
	
	이진트리에서 노드를 배치하는 원칙
	1. 중복은 허용하지 않는다. (그래서 TreeSet)
	2. 작으면 왼쪽으로 보낸다.
	3. 크면 오른쪽으로 보낸다.
	4. null을 만나면 거기에 붙인다.
	
	
	// 최소값을 구하는 함수를 짠다. 데이터가 아무것도 없으면 -1이 출력된다.
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
	
	// 재귀호출 없이 최소값 찾기
	public static int min2(Node t){
		if(t==null)
			return -1;
		while(t.left!=null){
			t = t.left;
	}
	return t.data;
	}
	
		
*/