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
		
		Node found = apple(root, 4);    // 4를 찾아보자
		if(found != null){
			System.out.println(found.data);
		}
		else{
			System.out.println("없다");
		}
	}
}

// 찾는 값이 트리 내에 있으면 해당 값을 출력한다. 이건 그냥 외우는게 낫다.
class Logic{
	public static Node apple(Node n, int d){
		Node found = null;
		if(n!=null){
			if(n.data == d)		// 찾는다. 찾던값(d)과 data가 맞으면 내가 찾던 노드.
				found = n;
			if(found == null && n.data > d)    // 없으면 왼쪽으로 가서 찾는다
				found = apple(n.left, d);
			if(found == null && n.data < d)    // 없으면 오른쪽으로 가서 찾는다
				found = apple(n.right, d);
		}
		return found;
	}
}

/*
	1 3 4 5 8
	개선안 : 3에 가서 보니까 찾는 값이 4면, 왼쪽은 볼 필요 없다.(3보다 작은 값이 왼쪽이므로)
	그리고 5에 가서 보니까 찾는 값이 4면, 오른쪽은 볼 필요 없다.
*/