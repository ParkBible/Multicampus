class Node <T> {    // 클래스 선언할때
	T name = null;    // 참조형 변수 선언할때. 0 대신 null 넣는다.
	Node<T> next = null;    // 인스턴스 선언할 때
	
	Node( T i, Node<T> j ) {
		this.name = i;		
		this.next = j;
	}
}

public class Test122 {
	public static void main( String[] args ) 
	{
		Node<Integer> head = new Node<Integer>( 0, null );
		Node<Integer> tail = head;
		
		tail.next = new Node<Integer>( 10, null );
		tail = tail.next;
	
		tail.next = new Node<Integer>( 20, null );
		tail = tail.next;

		for( Node<Integer> t = head.next ; t != null ; t = t.next ) {
			System.out.println( t.name );
		}
		
		Node<Integer> post = head;
		Node<Integer> pre = head.next;
		while( pre != null ) {
			post.next = null;
			
			post = pre;
			pre = pre.next;
		}
		
		for( Node<Integer> t = head.next ; t != null ; t = t.next ) {
			System.out.println( "- " + t.name );
		}
	}
}

/*
	제너릭으로 고쳐보자.
	
	
	class Node {
	int name = 0;
	Node next = null;
	
	Node( int i, Node j ) {
		this.name = i;		
		this.next = j;
	}
}

public class Test122 {
	public static void main( String[] args ) 
	{
		Node head = new Node( 0, null );
		Node tail = head;
		
		tail.next = new Node( 10, null );
		tail = tail.next;
	
		tail.next = new Node( 20, null );
		tail = tail.next;

		for( Node t = head.next ; t != null ; t = t.next ) {
			System.out.println( t.name );
		}
		
		Node post = head;
		Node pre = head.next;
		while( pre != null ) {
			post.next = null;
			
			post = pre;
			pre = pre.next;
		}
		
		for( Node t = head.next ; t != null ; t = t.next ) {
			System.out.println( "- " + t.name );
		}
	}
}

*/