class ��°�� extends RuntimeException{}
class ����� extends RuntimeException{}

class ����{
	public void ��(int �ð���){
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


public class Test175{
	public static void main(String[] args){
		���� kim = new ����();
		kim.��(4);
		System.out.println("�����߽��ϴ�");
	}
}

// try ~ catch ��� �������� �Ǵ���. ���� �����ϴ� �������� ���α׷��� ������
// ���ܰ� �߻��ϸ� �� ������ �ڵ�� �������� �ʴ´�.(�ű⼭ ���α׷� ������) - �������ϴ�, �����߽��ϴ� �ȼ�����
// try ~ catch �ϸ� �� ������ �ڵ�(�����߽��ϴ�)�� �����Ѵ�.
