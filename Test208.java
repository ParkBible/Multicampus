
/*
	���Ⱑ ���������̰� ���࿡ ���õ� ��� ������ ���⼭ �Լ����·� �����ǰ� �ִٰ� �����Ѵ�.
	�׷��� 100���� �����尡 �� �ν��Ͻ��� �����ϰ� �ִٰ� �����Ѵ�.
	bigWork - �����Ա�
	sleep - �������� ��� �����غ���.
	���ÿ� �Ͼ�� �Ǵ°�? �ƴϸ� ����� ���ÿ� �Ͼ���� �� �Ǵ°�?
	���ÿ� �Ͼ�� �Ǵ� ����̶��?
	�׷� ����� ����ó�� �����ߴٸ�... ���ÿ� �Ͼ�� �ȵǴ� ��ó�� ���踦 �� ����
	�� ����� �����Ա� �ϰ� ������ �ٸ������ �ƹ��͵� ���Ѵ�.
	�̰��� hanging �����̶�� �ϰ� �� �Ⱓ cpu�� �Ҹ�� ������ �ʴ´�.
	�ذ�� : �����ڴ� ���� ȭ����� �и��ϰ� ȭ��ǿ��� ������ ���ڰ� �����.
	
	Toilet�� sleep�� ���� ���� BedRoom�� ���� ���� �װ� �����ϰ� �ϸ� �ȴ�.
	�����尡 ��� �װ� �� ���̴�. �ؼ� �ִ��� �� ��� ���踦 �Ѵ�.
	�װ��� ���ؼ��� � �ϵ��� � ��ü�� ��ġ�Ǿ�� �ϰ� ���ÿ� ���� ���������� ����� ������ �Ѵ�.
	�ٵ� �׽�Ʈ�Ҷ� �̻� �ִ��� �𸥴�. ���忡 �������� ������ ����.
*/
class Toilet{
	public void bigWork(String by){
		System.out.println("BW STEP 1 : " + by);    // ū���� 5�ܰ�� �̷������.
		System.out.println("BW STEP 2 : " + by);
		System.out.println("BW STEP 3 : " + by);
		System.out.println("BW STEP 4 : " + by);
		System.out.println("BW STEP 5 : " + by);
	}
	
	public void sleep(String by){
		System.out.println("zzz... begin : " + by);
		try{
			Thread.sleep(1000);
		}
		catch(Throwable e){}
		System.out.println("zzz... end : " + by);    // �ڰ������� �ٸ� ����� ��� ���Ѵ�.
	}
}

class Kim extends Thread{
	private Toilet toi = null;
	public Kim(Toilet t) {this.toi = t;}    // ������
	public void run(){
		for(int i=0; i<10; i++){
			synchronized(toi){
				if(i % 3 == 2){
					toi.sleep("kim");
				} else{
					toi.bigWork("kim");
				}
				
			}

		}
	}
}

class Park extends Thread{
	private Toilet toi = null;
	public Park(Toilet t) {this.toi = t;}
	public void run(){
		for(int i=0; i<10; i++){
			synchronized(toi){
				if(i % 3 == 2){
					toi.sleep("park");
				} else{
					toi.bigWork("park");
				}
			}
		}

	}
}

public class Test208{
	public static void main(String[] args){
		Toilet toilet = new Toilet();
		
		Thread k = new Kim(toilet);
		Thread p = new Park(toilet);
		
		k.start();    // ������� �̰� ����� ���ư���.
		p.start();
	}
}

/*
	������, ���ÿ� ����Ǵ� �ڵ�� �������,
	�� ��������� �̿��ϴ� Ŭ������ ���� Ŭ������ §��.
	
	���� ����ĭ�� ���� ���ÿ� ���� ���ڴٰ� ������ �Ͼ ��Ȳ�̴�.
	BW STEP 1 : kim
	BW STEP 1 : park
	BW STEP 2 : park
	BW STEP 2 : kim
	���� �����尡 ���ÿ� �ϳ��� �ν��Ͻ��� ����ϴ� ��쿡 �ݵ�� ó���ؾ� �ϴ� ���� �ȴ�.
	
	��ΰ� ���� �ڽ��� ���� ȭ����� ������ ������ �̷� ���� �� ���� - ���������� �Ұ���
	�̷� ��쿡�� ���� ����ϴ� �����尡 ���� ��װ� ���� �� ���� ������� ��ٷ��� �Ѵ�.
	�� ������ ����ȭ ������ �ǰ� �̴� java ����� Ű����� �����ǰ� �ִ�.
	
		try{
			Thread.sleep(100);
		}
		catch(InterruptedException e){}
		
	synchronized(toi){
		...
	}
	{...}�� ������ ���� ���ؼ� toi�� ����Ű�� �ν��Ͻ��� ���� key�� ȹ���ؾ� �Ѵ�.
	��� �ν��Ͻ��� �ϳ��� Ű�� ������ �ִ�.
	
	kim�� park�� ���� ���ÿ� toilet�� ���Ծ kim�� ��¦ ���� ���踦 ���� ���� park�� ���谡 �ݳ��� ������
	��ٷ��� �Ѵ�.
	
	���踦 �����߸� '{' �� ����� �� �ְ�, '}' << �� �������� ����� �ν��Ͻ����� �ݳ��ȴ�.
	
	synchronized�� java Ű�����̴�. �̸� ���ؼ� ���ÿ� �ν��Ͻ��� �̿��ϴ� �����忡 ���ؼ�
	������ �� �ִ� ��Ȳ(�ϳ��� ��ü�� ���� �����尡 ���ÿ� �̿��ϸ� �ȵǴ� ��)�� ���� �� �ִ�.
*/