import java.util.*;

// ��⿭�� ���� �۾��� �� �������̽��� ����Ͽ� ���鵵�� ����.
interface IWork{
	public void doIt( String threadName ) throws Throwable;
}

// �۾���⿭�� ť ���·� �����.
class WorkQueue{
	private LinkedList<IWork> queue = null;
	
	public WorkQueue(){
		queue = new LinkedList<IWork>();
	}
	
	// ���� �Լ�
	// ����Ǵ� ���ȿ��� ������ �Լ��� ���� �־�� �Ѵ�.
	public synchronized void enqueue(IWork iw){
		queue.add(iw);
		notifyAll();
	}
	
	// ������ �Լ�
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

// ����� : ��⿭�� �����ϴ� ����. ���� ���������� 
class WorkThread extends Thread{
	// �׳� ���� �����ϱ� ����
	private String name = null;
	private WorkQueue queue = null;
	
	public WorkThread(WorkQueue q, String n){
		this.queue = q;
		this.name = n;
	}
	
	public void run(){
		boolean alive = true;
		while(alive){
			IWork iw = queue.dequeue();    // dequeue�� ȣ���Ͽ� ���� ���� ������� �����Ѵ�.
			
			// iw�� IWork ���̹Ƿ�, 
			try{
				iw.doIt(name);
			}
			catch(Throwable e){
				e.printStackTrace();
			}
		}
	}
}

// ��⿭�� �ֱ� ���� ������ �۾�
class TestWork implements IWork{
	private String name = null;
	
	public TestWork(String n){
		this.name = n;
	}
	public void doIt(String threadName) throws Throwable{
		// ���� 3�ܰ�� ����ȴ�.
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
		
		List<Thread> bankers = new ArrayList<>();    // �����
		WorkQueue queue = new WorkQueue();     // ��⿭
		
		String[] names = {"apple", "banana", "orange"};    // ������� �̸�
		for(String name : names){
			bankers.add(new WorkThread(queue, name));    // �̷��� �ϸ� queue�� name�� ������ �� �ְ� ��.
		}
		
		for(Thread banker : bankers){
			banker.start();    // ������ ��⿭�� �ϳ��� �����Ƿ� �׳� ��� �����ִ�.
		}
		
		for(int i=0; i<30; i++){
			queue.enqueue(new TestWork("work" + i));
		}
	}
}

/*
	ThreadPool�� ���� ���� ���α׷��� �����غ���
	������ �����غ���. ���� ������ �������� �ϸ� ��⿭�� �����Ͽ� ���� �ϳ��� ó���ϰ�,
	�� ������� ������ �ʰ� ��Ȱ���ؼ� �������� ó���Ѵ�.
	
	testwork work0 [orange] (0)
	testwork work2 [apple] (0)
	testwork work1 [banana] (0)
	testwork work0 [orange] (1)
	testwork work1 [banana] (1)
	testwork work2 [apple] (1)
	testwork work0 [orange] (2)
	
*/