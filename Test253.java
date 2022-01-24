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

class Logic{
	public static void print(Node n, int depth){
		if(n!= null){
			print(n.left, depth+1);    // 재귀!
			
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<depth; i++){
				sb.append(" ");    // 깊이 만큼 공백넣음
			}
			sb.append("{").append(n.data).append("}");
			
			if(n.left != null)
				sb.append("L:{").append(n.left.data).append("}");
			if(n.right != null)
				sb.append("R:{").append(n.right.data).append("}");
			
			System.out.println(sb.toString());
			print(n.right, depth+1);
			
		}
	}
	
	public static Node add(Node n, int data){
		if(n == null){
			n = new Node(data);
		}
		else{
			if(n.data > data){
				n.left = add(n.left, data);
			}
			else if(n.data < data){
				n.right = add(n.right, data);
			}
			else{
				throw new RuntimeException("Data Duplication");
			}
		}
		return n;
	}
	
	public static Node find(Node n, int data){
		Node found = null;
		if(n != null){
			if(n.data == data){
				found = n;
			}
			if(found == null && n.data > data){
				found = find(n.left,data);
			}
			if(found == null && n.data < data){
				found = find(n.right,data);
			}
		}
		return found;
	}
	
	public static Node rotationR(Node a){
		if(a.left != null){
			Node b =  a.left;
			a.left = b.right;
			b.right = a;
			return b;
		} else{
			return a;
		}
	}

	public static Node rotationL(Node a){
		if(a.right != null){
			Node b = a.right;
			a.right = b.left;
			b.left = a;
			return b;
		}else{
			return a;
		}
		
	}
	
	// root = delete(root,1);
	// 왼쪽이 비었으면 오른쪽을 올리면 되고, 오른쪽이 비었으면 왼쪽을 올리면 된다.
	public static Node delete(Node n, int data){
		if(n!= null){
			if(n.data > data){
				n.left = delete(n.left, data);
			}
			else if(n.data < data){
				n.right = delete(n.right, data);
			}
			else{    // (n.data == data)
				System.out.println("삭제대상포착 " + n.data);
				if(n.left == null){
					return n.right;
				}
			}
		}
		return n;
	}

}

public class Test253 {
	public static void main( String[] args ) {
		Node root = null;
		
		root = add(root, 5);
		root = add(root, 3);
		root = add(root, 8);
		root = add(root, 1);
		root = add(root, 4);
		
		root = add(root, 2);
		
		// 트리의 임의의 위치에서 로테이션이 두번 일어나도 원래 모양으로 돌아온다.
		root.left = rotationR(root.left);
		root.left = rotationL(root.left);
		print( root, 0 );
	}
}

/*
		Node root = new Node(5);
		Node a = root.left = new Node(3);
		Node b = root.right = new Node(8);
		a.left = new Node(1);
		a.right = new Node(4);
		
		print(root, 0);
*/