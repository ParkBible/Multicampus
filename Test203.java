
/*
	Thread�� �����ϴ� ���
	1. Runnable �������̽� ��ӹ��� Ŭ������ �ν��Ͻ��� �����Ѵ�.(��ϸӽ� Ŭ������ �̿�)
	2. public void run()�� �������̵� �Ѵ�.
	3. ���� �ν��Ͻ��� Thread�� �����ڿ� �־��ش�. ( Thread ���� )
	4. start() ȣ���ϸ� > OS�� ��û�Ͽ� Thread�� �Ҵ�ް�(�Ⱥ���) > �װ��� run()�� ����.
	�ܿ��
*/


public class Test203{
	public static void main(String[] args){
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("hello");
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}

/*
	Thread��? : a light-weight process
	Process��? : a running program
	Program�̶�? : executable file
	
	Thread�� Process �ȿ����� ������ �� �ִ�.
	��� Thread�� ����� �������� Process�� ����ȴ�.(main�� �����ϴ� �͵� Thread�̴�)
*/

/*
public class Test203{
	public static void main(String[] args){
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("HelloThread");
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}
*/