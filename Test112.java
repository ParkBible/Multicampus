
class A {
	private int value = 0;
	
	public A( int i ){ value = i; }
	public int intValue() {
		return this.value;
	}	
}
public class Test112{
	public static void main( String[] args ) {
	A t = new A(100);
	
	//int j = t;   ���� �� ��.  �ؿ����� ���� ����ε��� �ȵ�.
	int j = t.intValue();
	
	Integer t2 = new Integer(100);
	// ������ ���� �ȵ����� �����Ϸ��� t2.intValue()�� �ڵ带 �ٲ� �� �������Ѵ�.
	int j2 = t2;
	
	Object t3 = 200;
	// int j3 = t3;
	// Object Ÿ���� ������ ��ڽ��� �ȵȴ�. intValue�� Object���� ����� �Լ��� �ƴϱ� ����.
	}
}

/*
	t2�� ����Ű�� �ν��Ͻ����� ���� ���ͼ� �����Ѵٰ� �ؼ� ��ڽ��̶�� �Ѵ�.
	
	A�� Wrapper Ŭ������� �����ϸ�
	Object t3 = new A(100);
	int j3 = t3.intValue(); -- intValue() �Լ��� ȣ��� �� ����. ���� Ŭ������ ���� �Լ��� ȣ���� �� ���� ����.
*/