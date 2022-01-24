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
			print(n.left, depth+1);    // Àç±Í!
			
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<depth; i++){
				sb.append(" ");    // ±íÀÌ ¸¸Å­ °ø¹é³ÖÀ½
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
}

public class Test251 {
	public static void main( String[] args ) {
		Node root = null;
		
		root = add(root, 5);
		root = add(root, 3);
		root = add(root, 8);
		root = add(root, 1);
		root = add(root, 4);
		
		Node f = find(root, 4);
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