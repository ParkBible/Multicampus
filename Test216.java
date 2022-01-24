import java.util.*;

class ShampooAI extends Thread {
	private Table tbl = null;
	public ShampooAI( Table t ) {
		this.tbl = t;
	}
	
	public void run() {
		for( int i = 0 ; i < 300 ; i++ ) {
			String d = "dish " + i;
			
			synchronized( tbl ) {
				System.out.println( d + " : on the table" );
				tbl.on( d );
			}
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
			
			synchronized( tbl ) {
				String d = tbl.off();
				System.out.println( d + " : off the table" );
			}
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

public class Test216 {
	public static void main( String[] args ) {
		Table table = new Table();

		Thread s = new ShampooAI( table );
		Thread w = new WashAI( table );
		s.start();
		w.start();
	}
}/*
215 는 이상한 결과 만들어 내고
216 은 개선판(synchronized 사용하여 처리 도중에 끼어들지 못하게 하였다)

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
dish 21 : on the table
dish 21 : off the table
dish 20 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 22 : on the table
dish 22 : off the table
null : off the table
dish 23 : on the table
dish 23 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 24 : on the table
dish 24 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 25 : on the table
dish 25 : off the table
dish 26 : on the table
dish 26 : off the table
null : off the table
dish 27 : on the table
dish 27 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 28 : on the table
dish 29 : on the table
dish 29 : off the table
dish 28 : off the table
dish 30 : on the table
dish 31 : on the table
dish 31 : off the table
dish 30 : off the table
null : off the table
dish 32 : on the table
dish 32 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 33 : on the table
dish 34 : on the table
dish 34 : off the table
dish 33 : off the table
dish 35 : on the table
dish 35 : off the table
dish 36 : on the table
dish 36 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 37 : on the table
dish 37 : off the table
null : off the table
null : off the table
null : off the table
null : off the table
dish 38 : on the table
dish 39 : on the table
dish 39 : off the table
dish 38 : off the table
null : off the table
dish 40 : on the table
dish 40 : off the table
null : off the table
null : off the table
dish 41 : on the table
dish 41 : off the table
null : off the table
null : off the table
null : off the table
dish 42 : on the table
dish 42 : off the table
null : off the table
null : off the table
null : off the table
dish 43 : on the table
dish 44 : on the table
dish 44 : off the table
dish 43 : off the table
dish 45 : on the table
dish 45 : off the table
null : off the table
null : off the table
null : off the table
dish 46 : on the table
dish 47 : on the table
dish 47 : off the table
dish 46 : off the table
dish 48 : on the table
dish 48 : off the table
null : off the table
null : off the table
null : off the table
dish 49 : on the table
dish 49 : off the table
null : off the table
null : off the table
dish 50 : on the table
dish 50 : off the table
null : off the table
dish 51 : on the table
dish 52 : on the table
dish 52 : off the table
dish 51 : off the table
dish 53 : on the table
dish 54 : on the table
dish 54 : off the table
dish 53 : off the table
null : off the table
dish 55 : on the table
dish 55 : off the table
null : off the table
dish 56 : on the table
dish 57 : on the table
dish 57 : off the table
dish 56 : off the table
null : off the table
dish 58 : on the table
dish 59 : on the table
dish 59 : off the table



*/