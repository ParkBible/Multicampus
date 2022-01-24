import java.util.*;

// ��⿭�� ���� �۾��� �� �������̽��� ����Ͽ� ���鵵�� ����.
interface IWork{
	public void doIt( String threadName ) throws Throwable;
}

// �۾���⿭�� ť ���·� �����.
class WorkQueue{
	private LinkedList<IWork> queue = null;
	
	public synchronized void WorkQueue(){
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

public class Test224{
	public static void main(String[] args){
	}
}

/*
	ThreadPool�� ���� ���� ���α׷��� �����غ���
	������ �����غ���. ���� ������ �������� �ϸ� ��⿭�� �����Ͽ� ���� �ϳ��� ó���ϰ�,
	�� ������� ������ �ʰ� ��Ȱ���ؼ� �������� ó���Ѵ�.
*/