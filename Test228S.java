import java.net.*;
import java.io.*;
import java.util.*;

// 226 -----

interface IWork{
	public void doIt( String threadName ) throws Throwable;
}

// 작업대기열을 큐 형태로 만든다.
class WorkQueue{
	private LinkedList<IWork> queue = null;
	
	public WorkQueue(){
		queue = new LinkedList<IWork>();
	}
	
	// 대기열에 들어가는 함수
	// 실행되는 동안에는 꺼내는 함수가 멈춰 있어야 한다.
	public synchronized void enqueue(IWork iw){
		queue.add(iw);
		notifyAll();
	}
	
	// 대기열에서 꺼내는 함수
	public synchronized IWork dequeue(){
		while(queue.size() == 0){
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		return queue.remove(0);    // 먼저 온 사람들을 처리하기 위해 
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
	
	/*
		A t = new B();
		System.out.println(t instanceof B);    // 변수 t를 클래스 B로 캐스팅할 수 있으면 true.
	*/
	
	public void run(){
		boolean alive = true;
		while(alive){
			IWork iw = queue.dequeue();    // dequeue를 호출하여 먼저 들어온 사람부터 추출한다.
			
			/*
				아래의 코드를 이용해서 이 쓰레드를 무사히 종료시킬 수 있는 방법을 찾는다.
				은행으로 따지면 5시에 셔터를 내린 후 들어온 손님들은 다 처리해주고 문닫음
			*/
			
			try{
				iw.doIt(name);    // 오버라이딩된 doIt 호출
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
			
			List<Thread> bankers = new ArrayList<>();    // 은행원
			WorkQueue queue = new WorkQueue();     // 대기열
			
			String[] names = {"apple", "banana", "orange"};    // 은행원들 이름
			for(String name : names){
				bankers.add(new WorkThread(queue, name));    // 이렇게 하면 queue와 name을 공유할 수 있게 됨.
			}
			
			for(Thread banker : bankers){
				banker.start();    // 지금은 대기열이 하나도 없으므로 그냥 계속 멈춰있다.
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