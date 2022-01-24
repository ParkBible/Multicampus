import java.net.*;
import java.io.*;
import java.util.*;

// 226 -----

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
			
			try{
				iw.doIt(name);    // �������̵��� doIt ȣ��
			}
			catch(Throwable e){
				e.printStackTrace();
			}
		}
	}
}

// 226 -----

public class Test228S {
	public static void main( String[] args ) throws Exception {
		ServerSocket svr = new ServerSocket( 7890 );
		
		boolean alive = true;
		while( alive ) {
			Socket skt = svr.accept();
			System.out.println( skt.toString() );
			
			InputStream fin = new FileInputStream("C:\\movie\\movie.zip");	// 1.4G
			OutputStream out = skt.getOutputStream();
			
			int len = 0;
			byte[] buf = new byte[1024*64];
			
			while( ( len = fin.read( buf ) ) != -1 ) {
				out.write( buf, 0, len );
				out.flush();
			}
			
			List<Thread> bankers = new ArrayList<>();    // �����
			WorkQueue queue = new WorkQueue();     // ��⿭
			
			String[] names = {"apple", "banana", "orange"};    // ������� �̸�
			for(String name : names){
				bankers.add(new WorkThread(queue, name));    // �̷��� �ϸ� queue�� name�� ������ �� �ְ� ��.
			}
			
			for(Thread banker : bankers){
				banker.start();    // ������ ��⿭�� �ϳ��� �����Ƿ� �׳� ��� �����ִ�.
			}
			
			out.close();
			fin.close();
			
			skt.close();
		}
		svr.close();
	}
}
/*


*/