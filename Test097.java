
/*
	�ڹٴ� ������� ������ extends Object�� �ڵ����� ���δ�. ��,
	Object�� ��� Ŭ������ ������ �ȴ�.
	
	�׷� Object Ÿ���� ������ ��� �ν��Ͻ��� ����ų �� �ֳ�? -> �´�.
	�׷� void*�� ���� �����ΰ�? -> �ڹٿ��� int* ���� �ڷ����� ����.
	
	toString()�� Object���� ��ӹ޾Ҵ�.
*/
class Temp{
	public String toString(){    // �������̵�. ���� Object�� ���Ե� toString()�� Ŭ������@�ν��Ͻ�������ȣ�� ���.
		return "HelloWorld";
	}
}

public class Test097{
	public static void main(String[] args){
		Object t = null;    // Object : �ڹ� ���� Ŭ����
		t = new Temp();
		
		// void println(String x)
		System.out.println(t.toString()); // 12~14�� ������; Temp@2a139a55   Ŭ������@�ν��Ͻ�������ȣ
										  // ������; HelloWorld
		System.out.println(t);    // void println(Object x)
	}
}

/*
	�������̵�, �����ε��� [A t = new B()] �� �������� ���̴� �ֿ� ���.
	
	// �����ε��� �κ�
	void println(Object x){
		// x.toString()�� ȣ���ؼ� ��� ����.
	}
	void println(String x){
		// t�� ���ڿ��� �׳� ����.
	}
	
	�������̽��� �̿��ؼ� �ڵ带 ¥�� ������ �ִ���?
*/