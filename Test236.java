package banana;

// ���� import ����� Ŭ�����ε� import static�� static�ϰ� ����� �Լ��� ������� �Ѵ�.
import static banana.Logic.print;

class Logic{
	/*
	public static void print(){
		//System.out.println("HelloWorld");
		//print();    // �Լ� �ȿ��� �ڱ� �ڽ��� ȣ���ϸ� �ᱹ ���ѹݺ��ϰ� �ȴ�.(�̰� "��� ȣ��"�̶�� �Ѵ�)
					// ������ �ڵ�� ��ġ ���̷����� ���ĵǴ� ��ó�� ū ���� �� ��.
	}
	*/
	/*
		print(5);
		System.out.println("HelloWorld " + 5);
		print(4);
		System.out.println("HelloWorld " + 4);
		...
	*/
	public static void print(int i){
		System.out.println("HelloWorld " + i);
			
		try{
			Thread.sleep(800);
		}
		catch(Exception e){}
		
		if(i>0){
			print(i-1);    // i�� 0���� Ŭ���� ��� ȣ��.
		}
		
	}
	
}

public class Test236{
	public static void main(String[] args){
		System.out.println("HelloWorld");
		
		//Logic.print();
		Logic.print(5);     // �׳� print(5)�θ� �ص� �ȴ�.
	}
}

/*
	javac -d c:\classes Test236.java
	java -classpath c:\classes banana.Test236
*/