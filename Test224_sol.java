import java.util.*;

//	대기열에 들어가는 작업은 이 인터페이스를 상속하여 만들도록 하자
interface IWork {
	public void doIt( String threadName ) throws Throwable;	
}

//	작업대기열 
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

// 은행원 - 대기열을 공유하는 사이
class WorkThread extends Thread 
{
	//	그냥 찍어보고 구별하기 위한 용도 
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

/*	ThreadPool 을 만들어서 실제 프로그램에 응용해보자!!!
	- 은행 직원이 쓰레드 , 대기열을 공유하여 일을 하나씩 처리하고는 재활용해서 다음일을 처리하는 구조.



*/