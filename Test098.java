
class Temp{
	int data = 0;
	Temp(int i){
		data = i;
	}
	
	public boolean equals(Object b){    // t2�� ȣ���� �� �ִ°� ���ϱ� �������̵��̴�.
		if(b == null || (b instanceof Temp) == false){
			return false;    // b�� �ΰ��̰ų� Temp�� ĳ������ �� �� ���ٸ� ������ �����ϴ� �̷� �ڵ带 �ִ°� �ٶ����ϴ�.
		}
		System.out.println(this.toString());  // this�� ����, ���� ���������� Temp@��¼���� ���´�. this�� Temp�� ����Ű�� �ִ� ��.
		Temp t = (Temp)b;		// Temp�� ĳ���ý�Ų��.
		if(this.data == t.data){    // b.data�� �ϸ� ������. Object���� data�� �����Ƿ�
			return true;
		}else{
			return false;
		}    // equals()�� �������̵��Ǿ����Ƿ� equals()�� ������ �� �Լ��� ���´�.
	}
}

public class Test098{
	public static void main(String[] args){
		Temp t = new Temp(100);
		Temp l = new Temp(100);    // ���� ������ ������ �ִ��� �ν��Ͻ��� �����̴�.
		System.out.println(t == l);    // false
		System.out.println(t.data == l.data);    // ������ ���Ѵ�. �ٵ� �� �� ��ü�������̴�.
		
		Object t2 = new Temp(200);
		Object l2 = new Temp(200);
		System.out.println(t2 == l2);
		// ���� : System.out.println(t2.data == l2.data);
		//System.out.println(t2.data);    // t2�� Object���ε� data�� Temp���� �ִ� �����̱� ������ ��������.
		
		// ������Ϸ���?
		boolean b = t2.equals(l2);    // equals�� Object�� ����Ǿ� �ִ� �Լ����� �Ѵ�.
		System.out.println(b);
		
	}
}

/*
	������� �ν��Ͻ� ������ ��������ʱⰪ
	�������� �񱳴� ���� ����� ����ų�� true�� ���´�
*/