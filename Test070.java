
class Temp{
	
	// ����Ÿ���� ����(void��� ���� ������), Ŭ���� �̸��� ���� �Լ�. constructor(������)
	Temp(int i){
		this.data = i;
	}
	
	int data = 100;
	int add(int i){
		return this.data + i;
	}
}

public class Test070{
	public static void main(String[] args){
		Temp t = new Temp(0);
		// t.Temp() �����ڸ� �����ͷ� ȣ���Ϸ��� �ϸ� ��������. 
		t.data = t.add(20);
		System.out.println(t.data);
	}
}