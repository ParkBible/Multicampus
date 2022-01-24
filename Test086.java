class A{
	int data = 100;
	void print(){
		System.out.println("A print");
		
	}
}

class B extends A{ 
   int data = 200;
	void print(){
		System.out.println("B print");
	}
}

/*
	���󿡼� ����� �Լ��� �ڼտ��� �״�� �������ϸ� ���ƾ�����. ������ �����Ͱ� ����Ű�� ������ �ڼ��� ������ ����
	����Ű�� �ٲ۴�.
	�̰��� method overriding �̶�� �Ѵ�.
	���󿡼� ��ӹ����� ���� ���� ������, �̷� ������ ������ ���� �ִ�. (������ ������ ��ü���� ���� ����)
	�׷��� ��ӹ��� Ŭ���������� �Լ� �����͸� ������ �ʴ´�.
*/

public class Test086{
	public static void main(String[] args){
		B t = new B();
		t.print();    // B print
		
		A t2 = new A();
		t2.print();    // A print
	}
}