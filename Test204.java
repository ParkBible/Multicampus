

public class Test204{
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer();    // �ϳ��� sb�� �����ϰ� �ִ�.
		Runnable r = new Runnable(){
			public void run(){
				for(int i=0; i<100; i++){
				try{
					Thread.sleep(350);    // ����ó�� ����� �Ѵ�.
					}
					catch(InterruptedException e){
					}
					System.out.println("run " + i);
					sb.append("*");
					}
				System.out.println("run end " + sb.toString());
			}
		};
		Thread t = new Thread(r);
		t.start();    // start ȣ�� > ������ cpu ���� > �װ��� run�� ȣ���Ѵ�.
		//r.run();     // �̰� �ؿ����� ���ÿ� ���ư��� �ʴ´�. �����尡 �����ϱ� �翬�ϴ�.
		
		for(int i=0; i<100; i++){
			try{
				Thread.sleep(500);    // ����ó�� ����� �Ѵ�.
			}
			catch(InterruptedException e){
			}
			System.out.println("main " + i);
			sb.append("#");
		}
		System.out.println("main end");
	}
}

/*
	Thread.sleep(500);    // 0.5�ʸ��� ���ư���.
	�ϳ��� ���μ��� �ȿ��� ���������� �����ϴ� ������ ���μ����� �����ϴ� ���� Thread�� �����̴�!
	(r.run()�� ������ ���� �������� ������ �Ϳ��� ��������)
	
	Thread�� �����ϰ� ������ ���α׷������� main�� �����ٰ� �ؼ� ���� �� �ƴ϶�,
	��� Thread�� ���� ���� ���α׷��� ����ȴ�.
	
	�ϳ��� ���μ��� �ȿ��� ������ Thread�� ���̿����� �޸� ������ �����ϴ�.
	���μ���(�����ϴ� ���α׷�) ���� �޸� ������ �Ұ���������
	�����̳� ��������� �̿��Ͽ� ������ ������ �����ϴ�.
	ctrl+c ctrl+v�� ������?? �װ� OS���� OLE��� ������ �����ؼ� �����ϴ�.
	
	Thread�� �����ϱ� ��ƴ� �Ф�
*/