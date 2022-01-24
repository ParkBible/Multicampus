import java.io.*;

class Node {
	int id = 0;
	int score = 0;
	Node next = null;
	
	public Node( int i, int j, Node n ) {
		this.id    = i;
		this.score = j;
		this.next  = n;
	}
}

class XList2 {
	private Node head = null;
	private Node tail = null;
	private size = 0;
	
	public XList2( ) {
		head = new Node( 0, 0, null );
		tail = head;
	}
	
	public void add( int i, int j  ) {
		tail.next = new Node( i, j, null );
		tail = tail.next;
		
		size++;
	}
	
	public void printAll() {
		for( Node t = head.next ; t != null ; t = t.next ) {
			System.out.println( t.id + "\t" + t.score );
		}
	}

	boolean save( String fn ) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream( 
				new FileOutputStream("C:\\JavaWork\\score.dat") );
			out.writeInt( size );
			for( Node t = head.next ; t != null ; t = t.next ) {
				out.writeInt( t.id );
				out.write( t.score );
			}
		}
		catch( IOException e ) {
			return false;
		}
		finally {
			if( out != null) {
				try {
					out.close();	
				} catch( IOException e ){}
			}
		}
		return true;
	}
	
	public void deleteAll() {
		Node post = head;
		Node pre = head.next;
		while( pre != null ) 
		{
			post.next = null;
			post = pre;
			pre = pre.next;
		}
		tail = head;
		post = null;
		
		size = 0;
	}
	
	/*
		함수에 throws IOException ... 이렇게 선언되어 있으면??
		close() throws IOException ... 
	*/
	public void open( String fn ) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream( new FileInputStream("X:\\JavaWork\\score.dat") ) ;
			int len = in.readInt();	
			for( int i = 0 ; i < len ; i++ ) {
				int id = in.readInt();
				int score = in.read();
				
				add( id, score );
			}
		}
		catch( IOException e ) {}
		finally {
			if( in != null ) {
				try {
					in.close();
				}
				catch( IOException e ){}
			}
		}
	}
}

//	public class Test202 {
public class Test262 {
	public static void main( String[] args ) {
		XList2 l = new XList2();
		l.add( 10101, 70 );
		l.add( 10102, 85 );
		l.add( 10103, 95 );
		l.add( 10104, 80 );
		//	l.printAll();		//	학번 , 성적 출력된다.

		boolean b = l.save("score.dat");
		System.out.println( b );
		
		l.deleteAll();		//	다 지우고 초기로 돌아간다.
		//	l.printAll();

		l.open("score.dat");
		l.printAll();		//	파일에 저장된 내역이 불려져서 출력된다.
	}
}
//	예전에 과제로 냈었던 성적처리 프로그램에 대한 해설 . 일단 save 까지만 만들고 다음파일에서 ...
/*

*/