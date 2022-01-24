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

class QuitWork implements IWork{
	public void doIt(boolean i){
		return i = false;
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
			
			if(iw instanceof QuitWork){
				System.out.println(iw instanceof QuitWork);
				iw.QuitWork(alive);
			}
			
			try{
				iw.doIt(name);    // 오버라이딩된 doIt 호출
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

public class Test226{
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
			queue.enqueue(new TestWork("work" + i));    // enqueue에는 IWork를 implements한 클래스가 들어갈 수 있다.
		}
	}
}

/*
	Thread는 a light-weighted process : 독자적으로 수행되고 가상의 cpu에 의해 메모리를 공유 가능하다고 말했다.
	process 내의 모든 쓰레드가 종료되면 프로그램은 죽는다.
	이 프로그램은 어떻게 자연스럽게 죽일 수 있을까?
	
	java.lang.Thread 패키지를 살펴보자.
	메소드 항목을 살펴보면 Deprecated 이라고 적힌게 많다. 요즘은 안쓰이는 메소드라는 뜻. stop()처럼...
	이유는...
	1. 이런 것들이 없어도 다른걸로 충분히 구현 가능하다
	쓰레드는 OS의 개념을 java가 빌려서 쓰고 있다. OS마다 쓰레드는 다 다르다.
	정교한 쓰레드 컨트롤이 안되는 OS에서도 자바는 돌아가야 하니까
	2. 결국 모든 OS에서 지원하는 공통적인 핵심 기능만 자바의 쓰레드가 제공한다.
*/