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


public class Test176{
	public static void main(String[] args){
		���� kim = new ����();
		
		try{
			kim.��(4);
			System.out.println("�����߽��ϴ�");
		}
		catch(��°�� e){
			System.out.println("����");
		}
		catch(����� e){
			System.out.println("119");
		}
		System.out.println("���� ���� ��");
	}
}

/*
	RuntimeException : ���������� �γ��ϴ�.
	Exception : �����ϴ�.
	
	Exception�� ��ӹ��� ���ܸ� �߻��� �� �ִ� �Լ��� ����ο� �ݵ�� �� ����� ����ؾ� �Ѵ�.
	�ٵ� RuntimeException�� �ص� �ǰ� ���ص� �ȴ�. : throws ��°��, throws �����
	����ο� ���ܹ߻� ���ɼ��� ��õ� �Լ��� �ݵ�� �ش� ������ ó���� �� �ִ�
	try ~ catch ���� �ȿ��� ȣ���ؾ� �Ѵ�.
	
	�̷� ������ �� �����ϰ� ������ ����� �ڵ带 �ۼ��� �� �ֱ��� �ϴ� �� �� �� �ִ�.
	�����߽��ϴ�, ���� ���� �� �� ���� ��µǴ��� �����Ѵ�.
	>>
	�߳�
	�������ϴ�
	�����߽��ϴ�
	���� ���� ��
	
	>>
	�߳�
	����
	���� ���� ��
*/