class Temp{
	// uniq ������ jvm �ȿ��� ����������.
	private static Temp uniq = null;
	
	// static initializer �ȿ��� uniq�� �ν��Ͻ��� ����Ű�� �Ѵ�.
	static{
		uniq = new Temp();
	}
	
	// public static synchronized �ϰ� uniq�� �����ϴ� getInstance �Լ��� �����Ѵ�.
	public static synchronized Temp getInstance(){    // synchronized�� �پ�� �Ѵ�.
		return uniq;
	}
	
	// private�̹Ƿ� Temp �ۿ����� �����ڸ� ȣ���� �� ����. �� �ν��Ͻ��� �� �����.
	private Temp(){
	}
}

public class Test139{
	public static void main(String[] args){
		// new Temp(); // ����
		
		Temp a = Temp.getInstance();
		Temp b = Temp.getInstance();
		System.out.println(a==b);  // true��� ����� ���´�. a�� b�� ����Ű�� �ν��Ͻ��� 7��° ���� �ν��Ͻ��� �Ѵ� ����.
								   // �ν��Ͻ��� ��Ȱ��, �����ǰ� �ִٴ� �� �� �� �ִ�.
	}
}    // �̷� ���������� Singletone Pattern �̶�� �Ѵ�. (�ڹ� �ν��Ͻ��� �� �ϳ��� jvm�󿡼� �����ϰ�)

/*
	C����� �Լ��� ���α׷��� �����ϴ� ���� �����ϰ� �����Ѵ�.
	�̰�ó�� java�� �ν��Ͻ��� �� �ϳ��� jvm�󿡼� �����ϰ� ����� �� static�� �̿��ϸ� ���� �� �ִ�.
*/