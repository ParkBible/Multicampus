class ��°�� extends Exception{}
class ����� extends Exception{}

class ����{
	
	// �ش� ���ܸ� �߻���ų �� ������ �̷� ������ ����ο� ����Ѵ�.(throws ��°��, �����)
	public void ��(int �ð���) throws ��°��, �����{
		System.out.println("�߳�");
		double i = Math.random();    // !!
		if(�ð��� < 7 && i < 0.3){
			throw new ��°��();    // !! ������ �߻��� ��.
		}
		else if(�ð��� < 5 && i < 0.3){
			throw new �����();     
		}
		System.out.println("�������ϴ�");
	}
}


public class Test177{
	public static void main(String[] args){
		���� kim = new ����();
		
		try{
			kim.��(4);
			System.out.println("�����߽��ϴ�");
		}
		catch(Exception e){    // ��°�⸦ Exception���� �ٲٸ� ��°��� ����� ��ο� ���ؼ� �����Ѵ�.
								// RuntimeException���δ� ���ٲ۴�. ��°�Ⱑ ��ӹ��� Exception�� �ڼ� Ŭ�����̱� ����(�Ųٷδ� ����)
			System.out.println("���մ�å " + e.getClass().getName());    // ���մ�å ��°�� or ���մ�å �����
		}
		System.out.println("���� ���� ��");
	}
}

/*
	Exception e = new ��°��(); �� �����ϸ� ��´�.
	�� catch�� ����� �Ű�����(?)�� ������ throw�� ���� �ν��Ͻ��� ����ų �� ������ ��´�.
	
	Exception ��� Throwable�� �� �� �ִ�. �̴� Exception�� ���� Ŭ����.
	���ܻ�Ȳ�� �ƴ� ��쿡�� try catch�� �̿��� �ڵ带 ������ �� ���� �ֱ� ������ ����.
	��� try catch�� ���� ��쿡�� Throwable�� ��ӹް� ���� ���ܻ�Ȳ�� Exception�� ��ӹ޴´�.
	RuntimeException�� Exception�� ��ӹ޴´�.
	
	Throwable(������) ��� try catch - Exception(����) ���� ���ܻ�Ȳ - RuntimeException �γ�
*/