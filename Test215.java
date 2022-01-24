import java.util.*;

class ShampooAI extends Thread {
	private Table tbl = null;
	public ShampooAI( Table t ) {
		this.tbl = t;
	}
	
	public void run() {
		for( int i = 0 ; i < 300 ; i++ ) {
			String d = "dish " + i;
			
			System.out.println( d + " : on the table" );
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
			//	이 사이에 다른 쓰레드가 끼어들 수 있나??
			System.out.println( d + " : off the table" );
		}
	}
}

class Table {
	private List<String> dishes = null;
	public Table() {
		dishes = new LinkedList<String>();
	}
	
	public void on( String dish ) {  dishes.add( dish ); }
	
	public String off() {
		int sz = dishes.size();
		if( sz > 0 ) {
			return dishes.remove( sz - 1 );
		} else {
			return null;
		}
	}
}

public class Test215 {
	public static void main( String[] args ) {
		Table table = new Table();

		Thread s = new ShampooAI( table );
		Thread w = new WashAI( table );
		s.start();
		w.start();
	}
}/*
이거 결과가 이상하다 ....

C:\JavaWork>java Test215
null : off the table
dish 0 : on the table
null : off the table
dish 0 : off the table
dish 1 : on the table
null : off the table
dish 2 : on the table
dish 3 : on the table
dish 4 : on the table
dish 5 : on the table
dish 6 : on the table
dish 1 : off the table
dish 7 : on the table
dish 6 : off the table
dish 8 : on the table
dish 9 : on the table
dish 7 : off the table
dish 10 : on the table
dish 9 : off the table
dish 11 : on the table
dish 10 : off the table
dish 12 : on the table
dish 11 : off the table
dish 13 : on the table
dish 12 : off the table
dish 14 : on the table
dish 13 : off the table
dish 15 : on the table
dish 16 : on the table
dish 14 : off the table
dish 16 : off the table
dish 17 : on the table
dish 15 : off the table
dish 18 : on the table
dish 17 : off the table
dish 19 : on the table
dish 18 : off the table
dish 20 : on the table
dish 19 : off the table
dish 21 : on the table
dish 20 : off the table
dish 22 : on the table
dish 21 : off the table
dish 23 : on the table
dish 22 : off the table
dish 24 : on the table
dish 23 : off the table


dish 0 : on the table
dish 0 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 1 : on the table
dish 1 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 2 : on the table
dish 3 : on the table
dish 3 : off the table
dish 4 : on the table
dish 4 : off the table
dish 2 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 5 : on the table
dish 6 : on the table
dish 6 : off the table
dish 5 : off the table
dish 7 : on the table
dish 8 : on the table
dish 9 : on the table
dish 9 : off the table
dish 8 : off the table
dish 10 : on the table
dish 10 : off the table
dish 11 : on the table
dish 11 : off the table
dish 7 : off the table
dish 12 : on the table
dish 12 : off the table
null : off the table
null : off the table
dish 13 : on the table
dish 13 : off the table
dish 14 : on the table
dish 15 : on the table
dish 15 : off the table
dish 16 : on the table
dish 17 : on the table
dish 17 : off the table
dish 18 : on the table
dish 19 : on the table
dish 19 : off the table
dish 18 : off the table
dish 16 : off the table
dish 14 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 20 : on the table
*/