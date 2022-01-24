
interface ICalc{
	public int execute(int i, int j);
}

class Add implements ICalc, NoPrint{
	public int execute(int i, int j){return i+j;}
}

class Minus implements ICalc{
	public int execute(int i, int j){return i-j;}
}

public class Test153{
	public static void main(String[] args){
		ICalc ic = new Add();
		int r = ic.execute(10, 20);
		if(ic instanceof NoPrint){
		}
		else{
			System.out.println(r);
		}
		
	}
}
interface NoPrint {}

/*
	���ſ��� command pattern(�ѵ����� �ϳ��� �ν��Ͻ���)�� ������ ���̾���...
	Annotation ������ ������ �� �������� ���� �ߴ�.
	�ϳ��� ������ �ϳ��� �ν��Ͻ�ȭ �ϴ� ��������.
	
	Ŭ������ ���� ����� ���� ����� �ٸ� ��찡 ����
	���� ����� Ŭ�������ٰ� �̰� �� ���� �̷��� ������ ���ڴ� ��� ������ �ɾ��ְ� ���� ��(�������� x)
	-> ����ִ� �������̽��� �̿��Ѵ�.
	
	�ش� �������̽��� ��ӹ��� Ŀ�ǵ带 ������ �� instanceof�� �̿��ؼ�
	�ش� �������̽��� ��ӹ������� ���캸�� �ű⿡ �°� ������ ����� �ǵ��� ��Ƹ� �ڵ带 �������� �� �ְ� �ȴ�.
	
	�̷� ������ ü��ȭ �ؼ� �� ���� ���� Annotation �����̴�. ������̼��� interface�� �����.
	�ֱ��� framework ����� annotation�� ���������� ���� �ڵ带 ����ϴ� ������ ����.
	¥�� ����� ��ġ���µ� ����ϴ� ���忡���� �ڵ��� ���� ���� ���̰� �ȴ�.
	noPrint�� � ������ �ϴ����� ���� �����س���, noPrint��� ������ �Ǿ������� �������Ŵϱ� �� �κп� ���� �ڵ�� ��� �ȴ�.
*/