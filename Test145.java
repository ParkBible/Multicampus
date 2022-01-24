package banana;

import java.util.Map;
import java.util.TreeMap;
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

public class Test145 {
	public static void main( String[] args ) throws Exception {
		Map<String,Object> fly = new TreeMap<String,Object>();
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
				//System.out.println(s);
				
				Class<?> cls = Class.forName( c );  // ���ڿ��� �־��� �̸��� Ŭ������ ������ �ε���Ų��.(banana ��Ű���� Temp Ŭ����)
				//Object obj = cls.newInstance();  // cls�� �ش��ϴ� Ŭ������ �ν��Ͻ��� ������Ų��. Ȯ���Ϸ��� �����ڰ� ȣ��Ǵ��� ����.
				Object obj = fly.get(c);    // key�� c�� �ش��ϴ� �ڷḦ �����´�.
				//System.out.println( obj.getClass().getName() );    // ��Ű��.Ŭ������ �� ��µȴ�.
				
				if( obj == null ) {    // �׷� �ν��Ͻ��� ���ٰ� �ϸ� ���ο� �ν��Ͻ��� �����Ѵ�.
					obj = cls.newInstance();
					fly.put( c, obj );    // Ű���� c, obj���� ������� �ν��Ͻ��� �ִ´�.
				}
				System.out.println( obj );    // obj�� ��ġ�� Ȯ���ϸ� ��� ���� �ν��Ͻ��� ȣ��Ǵ� ���� �� �� �ִ�.
				
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