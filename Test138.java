class Temp{
	
	static{
		Temp t = new Temp();
		t.print();
	}
	
	static void print2() {
	// print();
	}
	
	void print(){
		print2();
	}
}

/*
	�̰� �������̵��� ������ �ϴ� �Լ����� �ϰ� �������̵��� �Լ������� ���·� ���Ǿ�� �Ѵ�.
	�׷����� �ν��Ͻ��� �Լ������Ͱ� �־�� �ϰ�, �׷����� non-static�ؾ� �Ѵ�.
	�������̽� �ȿ����� non-static�� �޼ҵ带 ����.
*/
interface ITemp{
	// public static void print();

}
public class Test138{
	public static void main(String[] args){
	}
}

/*
	static �ȿ��� non-static�� ���(print())�� �����ϱ� ���̶� �� ���� ����.
	�ٵ� static �ȿ����� �ν��Ͻ� �Ἥ ȣ���ϴ� �� ����
*/