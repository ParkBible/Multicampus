
class Bank{
	Object t = null;
}

class Bank2{
	String t = null;
}

public class Test114{
	public static void main(String[] args){
		Bank b = new Bank();
		b.t = "HelloWorld";
		//String b2 = b.t;    // b2�� ū�ڽ��� ����ų �� �ִ� �����̰� b.t�� �����ڽ�
							// �ڼ��� ������ ������ �ν��Ͻ��� ����ų ���� ����.
		String b2 = (String)b.t;    // Object���̶� ���� �ν��Ͻ��� ����ų �� ������ ������� ���� �� ĳ������ �ʿ��ϴ�.
		
		Bank2 c = new Bank2();
		c.t = "HelloWorld";
		String c2 = c.t;     // �̰� ���� �ڽ��� ����Ű�� �����Ƿ� ����.
		// Bank2�� String�� ��������� �̿��Ͽ� ����ų �� ������, ������� ���� �� ĳ������ �ʿ� ����.
	}
}