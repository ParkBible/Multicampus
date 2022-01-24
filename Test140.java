class Temp{
	// uniq ������ jvm �ȿ� �����ϰ� �ȴ�.
	private static Temp uniq = null;
	
	// public static synchronized �ϰ� uniq�� �����ϴ� getInstance �Լ��� �����Ѵ�.
	// �̷��� �ϸ� ó�� ȣ��� �ν��Ͻ��� �����ǰ�, �� ���Ŀ��� �ν��Ͻ��� ��Ȱ��ȴ�. 139�� �ڵ��� static�� ��ģ ����.
	public static synchronized Temp getInstance(){    // synchronized�� �پ�� �Ѵ�.
		if(uniq == null){    // �� ó��
			uniq = new Temp(); 
		}
		return uniq;    // �ι�°���ʹ� ��ٷ� uniq
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