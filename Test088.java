/*
class A{
	void print(){ System.out.println("print");}
}

class B extends A{
	void print2(){ System.out.println("print2");}
}

public class Test088{
	public static void main(String[] args){
		A t = new B();
		// B t = new A();
		// t.print2();
	}
}
/*

/*
	������ ������ �ڼ� Ŭ������ �ν��Ͻ��� ����ų �� �ִ�.
	������ �̶��� ���󿡼� ����� ����� ȣ�� �����ϴ�.
	�ٵ� �������̵� �� ��쿡�� �������̵� �� �Լ��� ȣ��ȴ�.(�̰� ���߿���)
	
*/


class A{ 
	void print(){
		System.out.println("a");
		}
	}

class B extends A{
	void print(){
		System.out.println("b");
	}
	void print2(){ 
		System.out.println("print2");
	}
}

public class Test088{
	public static void main(String[] args){
		A t = new B();
		t.print();
	}
}

