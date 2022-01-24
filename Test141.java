package banana;

class Temp{
	static{
		System.out.println("static");
	}
	public void print(){
		System.out.println("print");
	}
	Temp(){
		System.out.println("asdf");
	}
}

public class Test141{
	public static void main(String[] args) throws Exception{
		System.out.println("HelloWorld");
		Class<?> cls = Class.forName("banana.Temp");    // 문자열에 주어진 이름의 클래스를 강제로 로딩시킨다.(banana 패키지의 Temp 클래스)
		Object obj = cls.newInstance();    // cls에 해당하는 클래스의 인스턴스를 생성시킨다. 확인하려면 생성자가 호출되는지 본다.
		
		System.out.println(obj.getClass().getName());
	}
}
/*
	javac -d C:\classes Test141.java
	java -classpath C:\classes banana.Test141     // -classpath : 클래스가 있는 위치
	
	Class.forName("") : 문자열에 포함된 클래스를 강제로 로딩시킨다.
	Class<?> cls : 그냥 그러려니 하고 쓴다.
	cls.newInstance() : cls에 해당하는 클래스의 인스턴스를 만든다.(new 없이 인스턴스 생성가능)
*/