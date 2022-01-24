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
				
				Class<?> cls = Class.forName( c );  // 문자열에 주어진 이름의 클래스를 강제로 로딩시킨다.(banana 패키지의 Temp 클래스)
				Object obj = cls.newInstance();  // cls에 해당하는 클래스의 인스턴스를 생성시킨다. 확인하려면 생성자가 호출되는지 본다.
				System.out.println( obj.getClass().getName() );    // 패키지.클래스명 이 출력된다.
				
				
				Method mtd = cls.getMethod(s);  // print라는 이름의 cls 메소드를 호출할 수 있는 포인터 mtd 제공
				mtd.invoke(obj);
			}
		}
	}
}
/*
	Q1.
	javac -classpath C:\classes -d C:\classes Test144.java
	java -classpath C:\classes banana.Test144
	라고 치고
	banana.Colorado2 turnL
	이라고 입력하면 그 함수만 호출이 되어야 한다.
	
	Q2.
	Map<String,Object>를 이용해서 여러번 돌려도 해당 자동차의 인스턴스가 단 한번만 생성되고,
	재이용시 Map에 저장되어 있는 것을 이용하도록 한다.
*/