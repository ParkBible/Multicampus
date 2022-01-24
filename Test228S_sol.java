import java.net.*;
import java.io.*;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

interface IWork {
	public void doIt( String threadName ) throws Throwable;	
}

class WorkQueue {
	private LinkedList<IWork> queue = null;
	
	public WorkQueue() {
		queue = new LinkedList<IWork>();
	}
	
	public synchronized void enqueue( IWork iw ) {
		queue.add( iw );
		notifyAll();
	}
	
	public synchronized IWork dequeue() {
		while( queue.size() == 0 ) {
			try {
				wait();
			}
			catch( InterruptedException e ){}
		}
		return queue.remove( 0 );
	}
}

class WorkThread extends Thread 
{
	private String name = null;
	private WorkQueue queue = null;
	
	public WorkThread( WorkQueue q, String n ) {
		this.queue = q;
		this.name = n;
	}
	
	public void run() {
		boolean alive = true;
		while( alive ) {
			IWork iw = queue.dequeue();
			try {
				iw.doIt( name );
			}
			catch( Throwable e ) {
				e.printStackTrace();
			}
		}
	}
}

public class Test228S_sol {
	public static void main( String[] args ) throws Exception {
		ServerSocket svr = new ServerSocket( 7890 );
		
		List<Thread> bankers = new ArrayList<Thread>();
		WorkQueue queue = new WorkQueue();
		
		String[] names = {"apple","banana","orange"};
		for( String name : names ) {
			bankers.add( new WorkThread( queue, name ) );
		}
		
		for( Thread banker : bankers ) {
			banker.start();
		}		
		
		boolean alive = true;
		while( alive ) {
			Socket skt = svr.accept();
			queue.enqueue( new DownWork( skt ) );
		}
		
		// �����尡 �� ����� �Ŀ� ȣ��Ǿ�� �Ѵ�.
		// �۾� ��⿭�� �� �������, ��������� ����ǰ� �� �Ŀ� ȣ��Ǿ�� �Ѵ�.(��Ʈ�� ���� ��)
		// Thread�� join �Լ��� ȣ���ϸ� �ش� �������� ���� ���Ŀ� �� ������ �ڵ尡 ȣ��ǰ� �Ѵ�.
		
		for(Thread banker : bankers){
			try{
				banker.join();
			}
			catch(InterruptedException e)[]
		}
		svr.close();
	}
}

class DownWork implements IWork 
{
	private Socket skt = null;
	public DownWork( Socket s ) {
		this.skt = s;
	}
	
	public void doIt( String threadName ) throws Throwable
	{
		System.out.println( "["+ threadName +"]" + skt.toString() );
		
		InputStream fin = new FileInputStream("C:\\JavaWork\\01.zip");	// 1.4G
		OutputStream out = skt.getOutputStream();
		
		int len = 0;
		byte[] buf = new byte[1024*64];
		
		while( ( len = fin.read( buf ) ) != -1 ) {
			out.write( buf, 0, len );
			out.flush();
		}
		
		out.close();
		fin.close();		
		
		skt.close();
	}
}
/*

			
*/