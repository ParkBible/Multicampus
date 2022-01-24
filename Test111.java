

public class Test111{
	public static void main(String[] args){
		Object t = 100;
		System.out.println(t.getClass().getName()); // java.lang.Integer  : java.lang�� ��Ű����, Integer�� Ŭ������
		
		Integer t2 = 200;
		Integer t3 = t2;    // *t2 ó�� ��� ����.
		
		int j = t3;    // ������������ int�� ������ �����ϴ� ���, �����Ϸ��� �ڵ����� t3.intValue()�� ȣ����.(��ڽ�. �� �ڽ����� ������)
		System.out.println(j);
		
		// int k = t;  // �Ȱ��� ����ڽ̵ƴ��� Integer�� ���� �� ��ڽ� �Ǵµ� Object�� ������ ��ڽ� �ȵȴ�.
	}
}

/*
	�ڹٴ� int*, double* ���� �� ����. - �ڷ��������� �������� ���� ������ ������ ����.
	- �� ������� ������ ���� Wrapper Class�̴�.
	
	Wrapper Class���� �̸�
	int - Integer
	double - Double
	float - Float
	char - Character
	boolean - Boolean
	
	Object t = 100;
	t�� �ν��Ͻ��� ����Ű�� ���� �뵵�� ������ �����ε�, 100�� ������ �� �ִ�.
	
	t.getClass().getName() : t�� ����Ű�� �ν��Ͻ��� ������ Ŭ������(��� Ŭ������ �ν��Ͻ������� �˱� ���� ���)
	
	�����Ϳ� �����ϰ� �Ǹ� �ش� Ŭ������ �ν��Ͻ��� �ٲ���.
	Object t = 100;   Object t = new Integer(100); �̷��� �ٲ��ش�. ������ ������ ���� �����ؾ� �ϴ� �ڵ尡 ���̸� �׶��� ���� Wrapping�� �ش�.
	
	java.lang�� ��Ű�� �̸�
	Wrapper class�� �����͸� ����� �� ���� ������ ������ �޸𸮼Һ� ���� ���·� �����Ǿ�����
	
	Object t = 100; �̷��� �ڵ忡�� �ڵ�����  new Integer(100)�� �����ִ� �� Auto Boxing�̶�� �Ѵ�.(�ڽ� �� Ŭ������ ��)
	(����ڽ��� jdk 1.5 ������������ �������� ����)

*/