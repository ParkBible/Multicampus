class Temp {
	public void print(String... p){    // String�̱⸸ �ϸ� ���� ������� �Ű������� �޾Ƶ���.
		System.out.println(p.length);   // �迭 ���� ���
		for(int i=0; i<p.length; i++){
			System.out.println(p[i]);
		}
		System.out.println();
	}
	
	// ���� ������ �Լ������. � �Ű������� �� �����. �Ű������� ��� �ִ��� ����ڽ� ������ �� ������ �Լ��� ��.
	public void print2(Object... p){    
		System.out.println("print2");
	}
}

public class Test113{
	public static void main( String[] args ) {
		Temp t = new Temp();
		t.print();
		t.print("apple");
		t.print("apple", "banana");
		t.print("apple", "banana", "orange");
		
		t.print2(100, 3.14, "��", "��", "Ho", "��");    // print2
	}
}

/*
	String... p : �������� �Ķ���Ͷ�� �Ѵ�. ��ü�� �迭�̴�.
	�Ű������� ���޵Ǵ� ���� String�̱⸸ �ϸ� ������ ������� ���°� �ȴ�.
	
*/

	�ּ��� 10�� �ݿ��� �ڴ°� ��õ.
	����, ���ִ� ���߿� ����.
	���ռ� ����. � �����̶� ������ �ϱ�,,,