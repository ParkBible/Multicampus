package banana;

import java.util.Scanner;
import java.lang.reflect.Method;

class Spark2 {
	public void tR(){ System.out.println("Spark Right"); }
	public void tL(){ System.out.println("Spark Left"); }
}

class Colorado2 {
	public void turnR(){ System.out.println("Colorado Right"); }
	public void turnL(){ System.out.println("Colorado Left"); }
}

public class Test144 {
	public static void main( String[] args ) throws Exception {
		Scanner sc = new Scanner( System.in );
		boolean alive = true;
		while( alive ) {
			String l = sc.nextLine();
			if( l.equals("quit") ) {
				alive = false;
			}
			else {
				int i = l.indexOf(" ");
				String c = l.substring(0, i);
				//System.out.println(c);
				
				String s = l.substring(i+1, l.length());
				System.out.println(s);
				
				Class<?> cls = Class.forName( c );  // ���ڿ��� �־��� �̸��� Ŭ������ ������ �ε���Ų��.(banana ��Ű���� Temp Ŭ����)
				Object obj = cls.newInstance();  // cls�� �ش��ϴ� Ŭ������ �ν��Ͻ��� ������Ų��. Ȯ���Ϸ��� �����ڰ� ȣ��Ǵ��� ����.
				System.out.println( obj.getClass().getName() );    // ��Ű��.Ŭ������ �� ��µȴ�.
				
				
				Method mtd = cls.getMethod(s);  // print��� �̸��� cls �޼ҵ带 ȣ���� �� �ִ� ������ mtd ����
				mtd.invoke(obj);
			}
		}
	}
}
/*
	Q1.
	javac -classpath C:\classes -d C:\classes Test144.java
	java -classpath C:\classes banana.Test144
	��� ġ��
	banana.Colorado2 turnL
	�̶�� �Է��ϸ� �� �Լ��� ȣ���� �Ǿ�� �Ѵ�.
	
	Q2.
	Map<String,Object>�� �̿��ؼ� ������ ������ �ش� �ڵ����� �ν��Ͻ��� �� �ѹ��� �����ǰ�,
	���̿�� Map�� ����Ǿ� �ִ� ���� �̿��ϵ��� �Ѵ�.
*/