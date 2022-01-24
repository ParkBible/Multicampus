import java.util.*;

// 대기열에 들어가는 작업은 이 인터페이스를 상속하여 만들도록 하자.
interface IWork{
	public void doIt( String threadName ) throws Throwable;
}

// 작업대기열을 큐 형태로 만든다.
class WorkQueue{
	private LinkedList<IWork> queue = null;
	
	public WorkQueue(){
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

// 대기열에 넣기 위한 가상의 작업
class TestWork implements IWork{
	private String name = null;
	
	public TestWork(String n){
		this.name = n;
	}
	public void doIt(String threadName) throws Throwable{
		// 일은 3단계로 진행된다.
		for(int i=0; i<3; i++){
			System.out.println("testwork " + name + " [" + threadName + "] (" + i + ")" );
			try{
				Thread.sleep(500 + (int)(Math.random()*500));
			}
			catch(InterruptedException e){}
		}
	}
}

public class Test225{
	public static void main(String[] args){
		
		List<Thread> bankers = new ArrayList<>();    // 은행원
		WorkQueue queue = new WorkQueue();     // 대기열
		
		String[] names = {"apple", "banana", "orange"};    // 은행원들 이름
		for(String name : names){
			bankers.add(new WorkThread(queue, name));    // 이렇게 하면 queue와 name을 공유할 수 있게 됨.
		}
		
		for(Thread banker : bankers){
			banker.start();    // 지금은 대기열이 하나도 없으므로 그냥 계속 멈춰있다.
		}
		
		for(int i=0; i<30; i++){
			queue.enqueue(new TestWork("work" + i));
		}
	}
}

/*
	ThreadPool을 만들어서 실제 프로그램에 응용해보자
	은행을 생각해보자. 은행 직원이 쓰레드라고 하면 대기열을 공유하여 일을 하나씩 처리하고,
	그 쓰레드는 버리지 않고 재활용해서 다음일을 처리한다.
	
	testwork work0 [orange] (0)
	testwork work2 [apple] (0)
	testwork work1 [banana] (0)
	testwork work0 [orange] (1)
	testwork work1 [banana] (1)
	testwork work2 [apple] (1)
	testwork work0 [orange] (2)
	
*/