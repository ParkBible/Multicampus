

class A{
	A(){
		System.out.println("A constructor");
	}
}

class B extends A{
	B(){
		System.out.println("B constructor");
	}
}

public class Test091{
	public static void main(String[] args){
		new B();
	}
}

/*
	��� : A constructor  B constructor
	
	�ڼ��� �ν��Ͻ��� �����ϸ� ������ �����ں��� �ڼ��� �����ڰ� ���ʷ� ȣ��ȴ�.
	�׷� �����ڰ� ��ӵǴ� �����ΰ�?
	�����ڴ� �����ͷ� ȣ���� �� ���� �Լ���. ���� ����Լ��� �ƴϱ� ������ ��ӵ��� �ʴ´�.
	
	
*/