
class Temp{
	int add(int i, int j){
		return 100;
	}
	static int add2(int i, int j){
		return 100;
	}
}

public class Test136{
	public static void main(String[] args){
		Temp t = new Temp();    // �ν��Ͻ� �����Ͽ� ���۷����� ����
		int r = t.add(10,20);    // ���۷����� ���� �Լ� ȣ��
		System.out.println(r);
		
		int a = Temp.add2(10,20);    // �׳� �ٷ� Ŭ���� �̸��� ���� �Լ� ȣ��
		System.out.println(a);
	}
}

/*
	static�� ���� ����Լ���? �ν��Ͻ� ���� Ŭ������, �Լ������� ȣ���� �����ϴ�.
	������ ������ ���ʿ���.
	C���� ���� �����Լ��� ���� �����̴�.
	C++�� Ŭ���� �ۿ��� �Լ������� ���������� java�� �Ұ����ϱ� ������ static�̶� Ű���带 ����Ѵ�.
*/