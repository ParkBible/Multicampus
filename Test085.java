class A{
	int data = 0;
	void print(){
		System.out.println("print" + this.data);   // �翬�� data ��� �ᵵ ��
	}
}

class B extends A{    // �� �ڵ常 �־ r.data = 100�� �����ȶ�. "Ŭ������ ���" ����.
	// �������� ������ A Ŭ�������� ����� �Լ��� ������ �Űܿ��� ȿ���� ��´�.
	// class B�� A�κ��� ��ӹ޾Ҵ�. A�� B�� ����Ŭ����, B�� A�� �ڼ�Ŭ����.
	void print2(){
		System.out.println("print2" + this.data);    // ����԰͵� ����, ������ ����
	}
}

public class Test085{
	public static void main(String[] args){
		A t = new A();
		t.data = 100;
		//t.print();
		
		B r = new B();
		r.data = 200;
		r.print2();
		r.print();
	}
}

/*

*/