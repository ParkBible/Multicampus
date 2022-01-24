package banana;

import java.util.Scanner;

interface ICar{
	public void turnRight();
	public void turnLeft();
}

class Spark implements ICar {
	public void turnRight(){System.out.println("tR");}
	public void turnLeft(){System.out.println("tL");}

}

class Colorado implements ICar {
	public void turnRight(){System.out.println("turnR");}
	public void turnLeft(){System.out.println("turnL");}

}

public class Test142{
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		boolean alive = true;
		while(alive){
			String l = sc.nextLine();    // ����ڰ� �Է��� ������ l�� ����.
			// System.out.println(l);
			
			if(l.equals("quit")){
				alive = false;    // quit�� �Է��ϸ� ����.
			}
			else{
				Class<?> cls = Class.forName(l);
				ICar car = (ICar)cls.newInstance();    // cls �̸��� �ν��Ͻ� ����
				
				car.turnRight();
				car.turnLeft();
			}
			
			//alive = false;    // �ѹ� �Է��Ҷ����� ���α׷� ����.
		}
	}
}
/*
	Scanner : �ֿܼ��� ������� �Է��� �޾Ƶ��� �뵵�� ������� Ŭ����(jdk 1.5����)
	�� �������������� BufferedReader ���� �ȴ�. �Ȱ���
	
	int add();
	
	int main(){    // ������. �÷������� ����ϴ� ��
		int r;
		r = add();
		return 0;
	}
	
	int add(){    // �÷�����
		return 100;
	}
	
	�������� �÷����� -> �������� ���信���� �÷������� ���� ��������� ���߿� �������� ���ߵǾ�� ������
					���������� �װ� �Ұ����ϴ�. �׷��� �پ��� �ű���� �������.
	
	activeX -> ��ȭ��ȣ��(�Լ� ���)�� ���Ϲ޾Ƽ� �� �Լ��� ��ġ�� ȣ���ϰ� �Ѵ�. 
				ms���� add�� ȣ���� �� �ִ� ��� ������ ������ �� �ִ� Ư���� �Լ��� �������.(Iunknown)
	
	������ -> exe�� �÷����� ����
	Dynamic Linked Library(DLL) = exe���� �÷������� �ڵ带 �ε����Ѽ� �������� �����.(.dll)
	
	�ٵ� �ڹٴ� �̷� �ʿ� ����, �����Ǵ� �Լ� newInstance�� �̿��ؼ� �ٷ� ������ �� ����.
	Temp t = new Temp()�� �޸� ���� �������� �ʴ� Ŭ�����鵵 ������ �� �ִ� ������ �ڵ��̴�.
	�� ���⼭�� ICar��� �������̽��� ��ӹ��� ��쿡 ���Ѵ�.
	Test142���� ���߿� ���ߵ� Grandure�� �����Ǿ���.
	
	JDK 1.5���� �̷� ������ ���� �ݿ��Ǿ���.
	
	Class<?> cls = Class.forName("banana.Grandure")
	Object obj = cls.newInstance();    // �̰� ���� object������ �����������, ICar�� ĳ�����Ѵ�.
	ICar obj = new Spark()
*/