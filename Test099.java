
class A{
}

class B extends A{
	void print() {}
}

public class Test099{
	public static void main(String[] args){
		A t = new A();
		boolean b = (t instaneof B);    // t�� B�� ĳ������ �� �����Ƿ� false�� ���´�.
		// B t2 = (B)t;    ����� ������ ����.
		
		A t2 = new B();
		// B t3 = (B)t2;    �����ȳ���.
		
		boolean b2 = (t2 instaneof B); // t�� B�� ĳ������ �� �����Ƿ� true�� ���´�.
	}
}

/*
	�������Ҷ� ���� ������ �ְ�, ������ �� ���� ������ �ִ�. 13��°���� ���࿡��.
	
	���������� instanceof Ŭ����
	: ������������ ����Ű�� ����� Ŭ������ ĳ���� �����ϸ� true, �ƴϸ� false.
*/