
/*
	�̸��� ������ �Ű������� ������ �ٸ� �Լ��� �ϳ��� Ŭ���� �ȿ� ������ �� �ִ�.
	�Լ����� �������� ������ �������� �Ű����� ������ ��ġ�ϴ� ������ ã�Ƽ� ȣ���ϰ� �ȴ�.
	
	�ٵ� ���� �̸��� �� ���� ����Ÿ���� �����ؾ� �Ѵ�.(�Ű������� ������ �޶��� ���� �ִ�)
	
	�Ű������� ������ ���Ƶ� Ÿ���� Ʋ���� ������ �� �ִ�.
*/

class Temp {
	int add(int i, int j){
		return 100;
	}
	int add(int i){
		return 200;
	}
	//�̷��� �������.
	/*
	void add(int i){
		return 100;
	}
	*/
	void print(double i){
		System.out.println("i");
	}
	void print(int i){
		System.out.println("i");
	}
}

public class Test093{
	public static void main(String[] args){
		Temp t = new Temp();
		int r = t.add(10,20);
		System.out.println(r);
		
		int j = t.add(10);
		System.out.println(j);
		
		
		t.print(100);    // �̷��� �Ű������� int�� �Լ��� ȣ����
		// ���� �Ű������� double, float �� �Լ��� �ִٸ� float�� ȣ���. ���� ����� �ڷ����� ȣ��.
		// byte < short < int < long < float < double
	}
}