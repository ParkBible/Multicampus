import java.util.*;

//	��⿭�� ���� �۾��� �� �������̽��� ����Ͽ� ���鵵�� ����
interface IWork {
	public void doIt( String threadName ) throws Throwable;	
}

//	�۾���⿭ 
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

// ����� - ��⿭�� �����ϴ� ����
class WorkThread extends Thread 
{
	//	�׳� ���� �����ϱ� ���� �뵵 
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

public class Test224 {
	public static void main( String[] args ) {
	
	}
}

/*	ThreadPool �� ���� ���� ���α׷��� �����غ���!!!
	- ���� ������ ������ , ��⿭�� �����Ͽ� ���� �ϳ��� ó���ϰ�� ��Ȱ���ؼ� �������� ó���ϴ� ����.



*/