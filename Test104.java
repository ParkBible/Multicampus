
interface ITemp{
	abstract public void print();    // abstract public�̶� public abstract�� �Ȱ���.
	public void print(int i);		// abstract �Ⱥپ��µ� interface �ȿ��� �̰͵� abstract�� ����Ѵ�.
}

class Temp implements ITemp{
	public void print() {System.out.println("print");}
	public void print(int i) {System.out.println("print2");}
}

public class Test104{
	public static void main(String[] args){
		ITemp t = new Temp();
		t.print();
		t.print(234);
	}
}

/*
	interface : �� �̻��� Ŭ����. �����⸸ �ִ�.
	- public abstract�� �޼ҵ常 ���� �� �ִ�.
	- ��� �޼ҵ忡 abstract �Ⱥپ �ڵ����� �ٴ´�.
	- �翬�� �ν��Ͻ� �������.
	- ����ؼ� Ŭ������ ������ �� implements, ��� �޼ҵ带 �� �������̵� �ؾ� �Ѵ�. (�����ָ� �ڼ��� abstract class ��.)
*/