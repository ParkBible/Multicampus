package banana;

import java.util.Scanner;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

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
		
		Map<String,Object> fly = new HashMap<String,Object>();    // flyweight ����
		while( alive ) {
			String l = sc.nextLine();
			
			int idx = l.indexOf(' ');
			String clsName = l.substring(0,idx);
			String mtdName = l.substring(idx+1);
			
			if( l.equals("quit") ) {
				alive = false;
			}
			else {
				Class<?> cls = Class.forName( clsName );
				
				Object obj = fly.get(clsName);
				if( obj == null ) {
					obj = cls.newInstance();
					fly.put( clsName, obj );
				}
				System.out.println( obj );
				
				Method mtd = cls.getMethod(mtdName);
				mtd.invoke( obj );
			}
		}
	}
}
/*	���� 1�� : �Է½� banana.Colorado2 turnR �̷��� �Է��ϸ� �ش� �Լ��� ȣ��ǵ���
               Test143���� ��� Method �� Ȱ���ؼ� Spark �� �ٸ� �Լ����� ����ǵ���
			   
		Object obj = cls.newInstance();    // �ν��Ͻ��� ���� ������
		Method mtd = cls.getMethod("tR");    // Ŭ�������� ����� �Լ�������
		mtd.invoke(obj);    // �Լ������ͷ� �Լ��� ȣ���ϴµ� �ν��Ͻ��� ���� ������ ����
			   
	���� 2�� : Map<String,Object> �� �̿��ؼ� ������ ������ �ش� �ڵ����� �ν��Ͻ��� �� �ѹ���
	           �����ǰ� , �� �̿�ÿ��� Map�� ����Ǿ� �ִ� ���� �̿��ϵ��� �� ��.

*/