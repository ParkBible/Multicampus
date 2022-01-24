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
	
	// ��⿭�� ���� �Լ�
	// ����Ǵ� ���ȿ��� ������ �Լ��� ���� �־�� �Ѵ�.
	public synchronized void enqueue(IWork iw){
		queue.add(iw);
		notifyAll();
	}
	
	// ��⿭���� ������ �Լ�
	public synchronized IWork dequeue(){
		while(queue.size() == 0){
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		return queue.remove(0);    // ���� �� ������� ó���ϱ� ���� 
	}
}

class QuitWork implements IWork{
	public void doIt(boolean i){
		return i = false;
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
	
	/*
		A t = new B();
		System.out.println(t instanceof B);    // ���� t�� Ŭ���� B�� ĳ������ �� ������ true.
	*/
	
	public void run(){
		boolean alive = true;
		while(alive){
			IWork iw = queue.dequeue();    // dequeue�� ȣ���Ͽ� ���� ���� ������� �����Ѵ�.
			
			/*
				�Ʒ��� �ڵ带 �̿��ؼ� �� �����带 ������ �����ų �� �ִ� ����� ã�´�.
				�������� ������ 5�ÿ� ���͸� ���� �� ���� �մԵ��� �� ó�����ְ� ������
			*/
			
			if(iw instanceof QuitWork){
				System.out.println(iw instanceof QuitWork);
				iw.QuitWork(alive);
			}
			
			try{
				iw.doIt(name);    // �������̵��� doIt ȣ��
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

public class Test226{
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
			queue.enqueue(new TestWork("work" + i));    // enqueue���� IWork�� implements�� Ŭ������ �� �� �ִ�.
		}
	}
}

/*
	Thread�� a light-weighted process : ���������� ����ǰ� ������ cpu�� ���� �޸𸮸� ���� �����ϴٰ� ���ߴ�.
	process ���� ��� �����尡 ����Ǹ� ���α׷��� �״´�.
	�� ���α׷��� ��� �ڿ������� ���� �� ������?
	
	java.lang.Thread ��Ű���� ���캸��.
	�޼ҵ� �׸��� ���캸�� Deprecated �̶�� ������ ����. ������ �Ⱦ��̴� �޼ҵ��� ��. stop()ó��...
	������...
	1. �̷� �͵��� ��� �ٸ��ɷ� ����� ���� �����ϴ�
	������� OS�� ������ java�� ������ ���� �ִ�. OS���� ������� �� �ٸ���.
	������ ������ ��Ʈ���� �ȵǴ� OS������ �ڹٴ� ���ư��� �ϴϱ�
	2. �ᱹ ��� OS���� �����ϴ� �������� �ٽ� ��ɸ� �ڹ��� �����尡 �����Ѵ�.
*/