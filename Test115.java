Class Bank <X extends Object> {
	X t = null;
}

public class Test115{
	public static void main(String[] args){
		Bank<Object> bank = new Bank<Object>();    // �̷��� 2��°���� t�� �ڷ����� Object�� �ȴ�.
		bank.t = "HelloWorld";
		String t2 = (String)bank.t;    // ĳ������ �ʿ��ϴ�.
		
		Bank<String> bank2 = new Bank<String>();   // �̷��� 2��°���� t�� �ڷ����� String�� �ȴ�.
		String t3 = bank2.t;    // ĳ������ �ʿ����.
		// �Ʊ�� Bank�� Object��, Bank2�� String�� ���� ���� �Ѱ����� ��µ�
		//  ���ʸ� ���� �ϳ��� ���� �� �Ը���� �������� �ڷ��� �ٲ� �� �ִ�.
		
		// �̷������� ����ڽ� ��ڽ��� �̿��ϴ� �ڵ尡 ���������.
		Bank<Integer> bank3 = new Bank<Integer>();
		bank3.t = 100;    // ����ڽ�. t�� int���̹Ƿ� Integer() �ȿ� bank3.t�� �ִ´�.
		int j = bank3.t;     // ��ڽ�. intValue() �� ����Ͽ� j�� ����.
	}
}

/*
	�ν��Ͻ��� ���� �� �ִ� ������ Ÿ���� Object��, String�̳Ŀ� ���� Ȯ���� ������� ������.
	Object�� �� ��� �ñ� �� ������ ã�ư��� ĳ����
	String�� String�� �ñ� �� ������ ã�ư��� ĳ���� �ʿ����
	
	Ŭ���� �ȿ��� ��޵Ǵ� ������ Ÿ���� <>�ȿ� �����Ǵ� Ÿ������ �������� ������ �� �ִ�.
	�̸� ���ʸ�(Generic)�̶�� �Ѵ�.
	C++�� template�� ����ѵ� ���ʸ��� ������������ �����ϰ� �ڷ����� �Ұ����ϴ�. �׷��� extends Object
	
*/