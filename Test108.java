// ������ �̰� ���ؼ� �� ������ �����ָ�, ���������� �˾Ƽ� �޼ҵ带 �߰��� �� ����.

interface ICar{
	public void turnRight();
	public void turnLeft();
}

class Spark implements ICar{
	public void turnRight() {System.out.println("tR");}
	public void turnLeft() {System.out.println("tL");}
}

class Colorado implements ICar{
	public void turnRight() {System.out.println("turnR");}
	public void turnLeft() {System.out.println("turnL");}
}

public class Test108{
	public static void main(String[] args){
		ICar car = new Colorado();    // colorado ��� spark�� �־ �����۵�. -> ȣȯ��
		car.turnRight();
		car.turnLeft();
	}
}

/*
	�������̽��� Ŭ�������� ȣȯ���� ����� �뵵. �ν��Ͻ��� �ٲٸ� �������� �ٲ� �ʿ� ����.
	�׷��� �������̽��� ��� �ڵ������� ���������� ���·� �����ؾ� �Ѵ�.
	�������̽����� ���� ����� �ý��ۿ����� ������ �ȴ�. spark�� ���� ����� �ִ´� �ص� ������� ����.
	�ѹ� �������� ��ġ�� ��ƴ�. ��ӹ��� ��� �ڵ����� �� ���ľ� �ϱ� ����.
	"�ڵ� ���� �ƴϸ� �մ� �� ���Ǵ���"
*/