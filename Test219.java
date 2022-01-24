import java.util.*;

class ShampooAI extends Thread {
	private Table tbl = null;
	public ShampooAI( Table t ) {
		this.tbl = t;
	}
	
	public void run() {
		for( int i = 0 ; i < 300 ; i++ ) {
			String d = "dish " + i;
			tbl.on( d );
		}
	}
}

class WashAI extends Thread {
	private Table tbl = null;
	public WashAI( Table t ) {
		this.tbl = t;
	}
	
	public void run() {
		for( int i = 0 ; i < 300 ; i++ ) {
			String d = tbl.off();
		}
	}
}

// 216에서 synchronized 없애고 기록을 테이블 안에서 하는 코드로 바꿨다.
/*
	wait()와 notify()는 쓰레드와 관련 있지만 오브젝트의 멤버함수이다. (정의도 안했는데 걍씀)
	테이블 입장에서 접시가 5장 넘게 쌓였으면 shampoo는 잠시 멈춰세워야 하고,
	접시가 없으면 wash는 잠시 멈춰 세워야 한다.
*/
class Table {
	private List<String> dishes = null;
	public Table() {
		dishes = new LinkedList<String>();
	}
	
	// 선언부에 synchronized를 명시하면 함수가 호출할 때 this를 잠그고 호출이 끝나면 풀어준다.
	// 동작은 217번 코드와 거의 차이가 없다.
	public synchronized void on( String dish ) { 	// synchronized를 위로 올릴 수 있음.
		while(dishes.size() == 5){
			try{
				wait();    // try, catch문 필요. 이 함수 호출하는 쓰레드(샴푸)야 너 멈춰
							// 샴푸가 멈추면 멈춰놓은 워시가 다시 깨어난다.
							// 워시의 off()에서는 접시가 0이면 멈춘다.
			}
			catch(InterruptedException e){}
		}			
		System.out.println( dish + " : on the table" );
		dishes.add( dish ); 
		
		notify();	// 자신이 멈춘 쓰레드를 다시 일하도록 한다.
	}
	
	/*
		왜 if가 아니고 while인가? : 만일 수백개의 쓰레드가 동시에 작업하게 되면 wait 되었다가 깨어났는데
		다시 텅 비어 있게 되면 다시 wait되어야 한다. 계속 점검하는 게 나으므로 while 사용.
		만약 또 점검했는데도 5면 wait한다.
		
		wait()와 notify()를 이용하여 객체가 준비된 상황에서만 쓰레드가 객체의 함수를 호출할 수 있도록
		컨트롤하는데 이를 모니터 기법이라고 한다.
		
		notify() - 하나만 깨우고, notifyAll() - 다 깨운다.
	*/
	public synchronized String off() {
		while(dishes.size() == 0){    
			try{
				wait();    // try, catch문 필요. 이 함수 호출하는 쓰레드(워시)야 너 멈춰		
			}
			catch(InterruptedException e){}
		}
		
		int sz = dishes.size();
		String d = dishes.remove( sz - 1 );
		System.out.println( d + " : off the table" );
			
		notify();    // 자신이 멈춘 쓰레드(샴푸)를 다시 일하도록 한다. 안쓰면 멈춰버림.
		return d;
	}
}

public class Test219 {
	public static void main( String[] args ) {
		Table table = new Table();

		Thread s = new ShampooAI( table );
		Thread w = new WashAI( table );
		s.start();
		w.start();
	}
}

/*
	5장 이상은 안 올라간다.
*/

/*
	일단 테이블 인스턴스를 생성함. 그런다음 샴푸, 워시 쓰레드 두 개를 생성하고 스타트를 한다.
	샴푸와 워시는 run()을 호출하면(메인에서 start()하면 알아서 호출됨)
	각각 테이블의 멤버함수인 on(), off()가 300번 실행되는 형태...
	on()은 만약 쌓인 접시가 5개라면 샴푸를 멈춤(wait), off()는 0개라면 워시를 멈춘다.
	on()이 wait()를 해서 샴푸를 멈추면 워시가 깨어나 off()를 실행, 접시를 처리하게 된다(접시 개수를 줄인다).
	그러면 off의 마지막 부분에서 샴푸를 다시 활성화(notify)시킨다.
*/