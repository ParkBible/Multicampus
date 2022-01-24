import java.util.*;

// 대기열에 들어가는 작업은 이 인터페이스를 상속하여 만들도록 하자.
interface IWork{
	public void doIt( String threadName ) throws Throwable;
}

// 작업대기열을 큐 형태로 만든다.
class WorkQueue{
	private LinkedList<IWork> queue = null;
	
	public synchronized void WorkQueue(){
		queue = new LinkedList<IWork>();
	}
	
	// 들어가는 함수
	// 실행되는 동안에는 꺼내는 함수가 멈춰 있어야 한다.
	public synchronized void enqueue(IWork iw){
		queue.add(iw);
		notifyAll();
	}
	
	// 꺼내는 함수
	public synchronized IWork dequeue(){
		while(queue.size() == 0){
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		return queue.remove(0);
	}
}

// 은행원 : 대기열을 공유하는 사이. 따라서 내부적으로 
class WorkThread extends Thread{
	// 그냥 찍어보고 구별하기 위함
	private String name = null;
	private WorkQueue queue = null;
	
	public WorkThread(WorkQueue q, String n){
		this.queue = q;
		this.name = n;
	}
	
	public void run(){
		boolean alive = true;
		while(alive){
			IWork iw = queue.dequeue();    // dequeue를 호출하여 먼저 들어온 사람부터 추출한다.
			
			// iw는 IWork 형이므로, 
			try{
				iw.doIt(name);
			}
			catch(Throwable e){
				e.printStackTrace();
			}
		}
	}
}

public class Test224{
	public static void main(String[] args){
	}
}

/*
	ThreadPool을 만들어서 실제 프로그램에 응용해보자
	은행을 생각해보자. 은행 직원이 쓰레드라고 하면 대기열을 공유하여 일을 하나씩 처리하고,
	그 쓰레드는 버리지 않고 재활용해서 다음일을 처리한다.
*/