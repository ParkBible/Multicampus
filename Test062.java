
class Temp{
	int data = 100;
	int add(int i){
		return i * 10;
	}
}

public class Test062{
	public static void main(String[] args){
		Temp t = new Temp();
		t.data = 20;
		t.data = t.add(20);    // �Լ��� ȣ���ϴ� ��. t.data���� 200�� ���Եȴ�
		System.out.println(t.data);
	}
}

/*
	new Temp(); �� ���� ����� �־�� �Ѵ�.(�ν��Ͻ���� �Ѵ�)
	Temp t = ... , Ŭ���� �̸����� ������ �����ϰ� �ű�ٰ� �ν��Ͻ��� �����Ѵ�.
	
*/