import java.util.*;

class Table{
	private List<String> dishes = null;
	
	public Table(){
		dishes = new LinkedList<String>();    // 접시 쌓아놓을 용도
	}
	
	public void on(String dish){
		dishes.add(dish);
	}
	
	public String off(){    // 맨 나중에 쌓아놓은 것부터 빼야된다.
		int sz = dishes.size();
		if(sz > 0){
			String d = dishes.remove(sz-1);
			return d;
		} else{    // 맨 마지막에는 null이 출력되게 한다.
			return null;
		}
	}
}

class ShampooAI extends Thread{
	private Table tbl = null;
	public ShampooAI(Table t){
		this.tbl = t;
	}
	
	public void run(){
		for(int i=0; i<300; i++){
			String d = "dish "  + i;
			
			synchronized(tbl){
				System.out.println(d + " : on the table");
				tbl.on(d);
			}
		}
	}
}

class WashAI extends Thread{
	private Table tbl = null;
	public WashAI(Table t){
		this.tbl = t;
	}
	
	public void run(){
		for(int i=0; i<300; i++){
			// 지금 이 사이에 shampoo()가 접시를 놓고 기록한 상황. 접시뺀걸 기록 하려고 하는 순간 샴푸가 기록함
			//System.out.println(d + " : off the table");
			synchronized(tbl){
				String d = tbl.off();
				System.out.println(d + " : off the table");
			}
		}
	}
}

public class Test214{
	public static void main(String[] args){
		Table table = new Table();
		
		// 이렇게 하면 하나의 테이블을 두 개의 쓰레드에서 공유.
		Thread s = new ShampooAI(table);   
		Thread w = new WashAI(table);

		table.on("apple");
		table.on("banana");
		table.on("orange");
		
		for(int i=0; i<4; i++){
			System.out.println(table.off());
		}
		
		s.start();
		w.start();
	}
}

/*
	동기화는? 여러 쓰레드가 하나의 인스턴스를 사용하게 될 때 벌어지는 일이다 (화장실)
	쓰레드마다 다 하나씩 인스턴스 나눠 주면 저런 일 안생기잖아요? 맞는얘긴데...
	
	동시에 사용을 해도 되는 일과 안되는 일을 구분하여 적절히 설계하지 않으면
	웹 사이트를 만들어도 효율이 안난다.
	
	코드를 짜봤는데...
	dish 4 : on the table
	dish 3 : off the table
	왜 4번 접시가 올라갔는데 3번 접시가 빠지지?
	-> 동기화를 이용해 한 쓰레드가 처리하고 있을 때는 도중에 접근하지 못하도록 한다.
*/