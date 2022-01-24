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
		Class<?> cls = Class.forName("banana.Temp");    // ���ڿ��� �־��� �̸��� Ŭ������ ������ �ε���Ų��.(banana ��Ű���� Temp Ŭ����)
		Object obj = cls.newInstance();    // cls�� �ش��ϴ� Ŭ������ �ν��Ͻ��� ������Ų��. Ȯ���Ϸ��� �����ڰ� ȣ��Ǵ��� ����.
		
		System.out.println(obj.getClass().getName());
	}
}
/*
	javac -d C:\classes Test141.java
	java -classpath C:\classes banana.Test141     // -classpath : Ŭ������ �ִ� ��ġ
	
	Class.forName("") : ���ڿ��� ���Ե� Ŭ������ ������ �ε���Ų��.
	Class<?> cls : �׳� �׷����� �ϰ� ����.
	cls.newInstance() : cls�� �ش��ϴ� Ŭ������ �ν��Ͻ��� �����.(new ���� �ν��Ͻ� ��������)
*/