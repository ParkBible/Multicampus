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

// 216���� synchronized ���ְ� ����� ���̺� �ȿ��� �ϴ� �ڵ�� �ٲ��.
/*
	wait()�� notify()�� ������� ���� ������ ������Ʈ�� ����Լ��̴�. (���ǵ� ���ߴµ� ����)
	���̺� ���忡�� ���ð� 5�� �Ѱ� �׿����� shampoo�� ��� ���缼���� �ϰ�,
	���ð� ������ wash�� ��� ���� ������ �Ѵ�.
*/
class Table {
	private List<String> dishes = null;
	public Table() {
		dishes = new LinkedList<String>();
	}
	
	// ����ο� synchronized�� ����ϸ� �Լ��� ȣ���� �� this�� ��װ� ȣ���� ������ Ǯ���ش�.
	// ������ 217�� �ڵ�� ���� ���̰� ����.
	public synchronized void on( String dish ) { 	// synchronized�� ���� �ø� �� ����.
		while(dishes.size() == 5){
			try{
				wait();    // try, catch�� �ʿ�. �� �Լ� ȣ���ϴ� ������(��Ǫ)�� �� ����
							// ��Ǫ�� ���߸� ������� ���ð� �ٽ� �����.
							// ������ off()������ ���ð� 0�̸� �����.
			}
			catch(InterruptedException e){}
		}			
		System.out.println( dish + " : on the table" );
		dishes.add( dish ); 
		
		notify();	// �ڽ��� ���� �����带 �ٽ� ���ϵ��� �Ѵ�.
	}
	
	/*
		�� if�� �ƴϰ� while�ΰ�? : ���� ���鰳�� �����尡 ���ÿ� �۾��ϰ� �Ǹ� wait �Ǿ��ٰ� ����µ�
		�ٽ� �� ��� �ְ� �Ǹ� �ٽ� wait�Ǿ�� �Ѵ�. ��� �����ϴ� �� �����Ƿ� while ���.
		���� �� �����ߴµ��� 5�� wait�Ѵ�.
		
		wait()�� notify()�� �̿��Ͽ� ��ü�� �غ�� ��Ȳ������ �����尡 ��ü�� �Լ��� ȣ���� �� �ֵ���
		��Ʈ���ϴµ� �̸� ����� ����̶�� �Ѵ�.
		
		notify() - �ϳ��� �����, notifyAll() - �� �����.
	*/
	public synchronized String off() {
		while(dishes.size() == 0){    
			try{
				wait();    // try, catch�� �ʿ�. �� �Լ� ȣ���ϴ� ������(����)�� �� ����		
			}
			catch(InterruptedException e){}
		}
		
		int sz = dishes.size();
		String d = dishes.remove( sz - 1 );
		System.out.println( d + " : off the table" );
			
		notify();    // �ڽ��� ���� ������(��Ǫ)�� �ٽ� ���ϵ��� �Ѵ�. �Ⱦ��� �������.
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
	5�� �̻��� �� �ö󰣴�.
*/

/*
	�ϴ� ���̺� �ν��Ͻ��� ������. �׷����� ��Ǫ, ���� ������ �� ���� �����ϰ� ��ŸƮ�� �Ѵ�.
	��Ǫ�� ���ô� run()�� ȣ���ϸ�(���ο��� start()�ϸ� �˾Ƽ� ȣ���)
	���� ���̺��� ����Լ��� on(), off()�� 300�� ����Ǵ� ����...
	on()�� ���� ���� ���ð� 5����� ��Ǫ�� ����(wait), off()�� 0����� ���ø� �����.
	on()�� wait()�� �ؼ� ��Ǫ�� ���߸� ���ð� ��� off()�� ����, ���ø� ó���ϰ� �ȴ�(���� ������ ���δ�).
	�׷��� off�� ������ �κп��� ��Ǫ�� �ٽ� Ȱ��ȭ(notify)��Ų��.
*/