import java.util.*;

class Table{
	private List<String> dishes = null;
	
	public Table(){
		dishes = new LinkedList<String>();    // ���� �׾Ƴ��� �뵵
	}
	
	public void on(String dish){
		dishes.add(dish);
	}
	
	public String off(){    // �� ���߿� �׾Ƴ��� �ͺ��� ���ߵȴ�.
		int sz = dishes.size();
		if(sz > 0){
			String d = dishes.remove(sz-1);
			return d;
		} else{    // �� ���������� null�� ��µǰ� �Ѵ�.
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
			// ���� �� ���̿� shampoo()�� ���ø� ���� ����� ��Ȳ. ���û��� ��� �Ϸ��� �ϴ� ���� ��Ǫ�� �����
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
		
		// �̷��� �ϸ� �ϳ��� ���̺��� �� ���� �����忡�� ����.
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
	����ȭ��? ���� �����尡 �ϳ��� �ν��Ͻ��� ����ϰ� �� �� �������� ���̴� (ȭ���)
	�����帶�� �� �ϳ��� �ν��Ͻ� ���� �ָ� ���� �� �Ȼ����ݾƿ�? �´¾�䵥...
	
	���ÿ� ����� �ص� �Ǵ� �ϰ� �ȵǴ� ���� �����Ͽ� ������ �������� ������
	�� ����Ʈ�� ���� ȿ���� �ȳ���.
	
	�ڵ带 ¥�ôµ�...
	dish 4 : on the table
	dish 3 : off the table
	�� 4�� ���ð� �ö󰬴µ� 3�� ���ð� ������?
	-> ����ȭ�� �̿��� �� �����尡 ó���ϰ� ���� ���� ���߿� �������� ���ϵ��� �Ѵ�.
*/