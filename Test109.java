
interface ICalc{
	public int execute(int i);   // ���� ��� �κ�
}

class Plus implements ICalc{
	private int data = 0;    // �������̽��� ��ӹ޾Ҵ��� �����͸� �޾ƿ��� ���� ��������� �����ڴ� ���� ����.
	Plus(int k){    // �����ڴ� �ٱ��ʿ�
		this.data = k;
	}
	public int execute(int i){
		return data + i;
	}
}

class Minus implements ICalc{
	private int data = 0;
	Minus(int k){    // �����ڴ� �ٱ��ʿ�
		this.data = k;
	}
	public int execute(int i){
		return i - data;
	}
}

public class Test109{
	public static void main(String[] args){
		ICalc ic = new Plus(5);
		System.out.println(ic.execute(3));    // 8
		ICalc ic2 = new Minus(2);
		System.out.println(ic2.execute(3));    // 1
		
		// "����"�� �ν��Ͻ��� ���� �迭�� ����ְ� ���������� �����ϰ� �� �� �ִ�. ��ũ�ο��� ����.
		// �̷� ����� command pattern�̶�� �Ѵ�. (������ ��ü���� ������)
		ICalc[] l = new ICalc[4];
		l[0] = new Plus(3);
		l[1] = new Minus(1);
		l[2] = new Plus(4);
		l[3] = new Minus(3);
		
		int start = 10;
		for(int i=0; i<l.length; i++){
			start = l[i].execute(start);
		}
		System.out.println(": " + start);
	}
}

/*
	��ü���� ���α׷��ֿ� �뷫���� �̷��� ������ ������ ����.
	Ŭ������ ���赵, �ν��Ͻ��� ��ü, ��ü�� ���´� ��� ����, ��ü�� ������ ��� �Լ���... -> �ᱹ ����
	������ �ٴ� �ƴϰ�, �� ����� ��ʵ� ����.
	
	���� ���� �ϳ��� �ϳ��� �Լ��� ����. ���� �ϳ��� �ν��Ͻ��� ���� ���� �ִ�.
*/