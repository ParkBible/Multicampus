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
		
		Map<String,Object> fly = new HashMap<String,Object>();    // flyweight 패턴
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
/*	과제 1번 : 입력시 banana.Colorado2 turnR 이렇게 입력하면 해당 함수가 호출되도록
               Test143에서 배운 Method 를 활용해서 Spark 및 다른 함수에도 적용되도록
			   
		Object obj = cls.newInstance();    // 인스턴스에 대한 포인터
		Method mtd = cls.getMethod("tR");    // 클래스에서 선언된 함수포인터
		mtd.invoke(obj);    // 함수포인터로 함수를 호출하는데 인스턴스에 대한 포인터 동반
			   
	과제 2번 : Map<String,Object> 를 이용해서 여러번 돌려도 해당 자동차의 인스턴스가 단 한번만
	           생성되고 , 재 이용시에는 Map에 저장되어 있는 것을 이용하도록 할 것.

*/