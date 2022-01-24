
class Toilet{
	public void bigWork(String by){
		System.out.println("BW STEP 1 : " + by);    // ū���� 5�ܰ�� �̷������.
		System.out.println("BW STEP 2 : " + by);
		System.out.println("BW STEP 3 : " + by);
		System.out.println("BW STEP 4 : " + by);
		System.out.println("BW STEP 5 : " + by);
	}
}

class Kim extends Thread{
	private Toilet toi = null;
	public Kim(Toilet t) {this.toi = t;}    // ������
	public void run(){
		for(int i=0; i<10; i++){
			toi.bigWork("kim");
		}
	}
}

class Park extends Thread{
	private Toilet toi = null;
	public Park(Toilet t) {this.toi = t;}
	public void run(){
		for(int i=0; i<10; i++){
			toi.bigWork("park");
		}
	}
}

public class Test206{
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
	
	���� ����ĭ�� ���� ���ÿ� ���� ���ڴٰ� ������ �Ͼ ��Ȳ�̴�. (�ѹ��� 1 2 3 4 5�� �ؾ� �Ǵµ� �߰��� �����)
	BW STEP 1 : kim
	BW STEP 1 : park
	BW STEP 2 : park
	BW STEP 2 : kim
	���� �����尡 ���ÿ� �ϳ��� �ν��Ͻ��� ����ϴ� ��쿡 �ݵ�� ó���ؾ� �ϴ� ���� �ȴ�.
	
	��ΰ� ���� �ڽ��� ���� ȭ����� ������ ������ �̷� ���� �� ���� - ���������� �Ұ���
	�̷� ��쿡�� ���� ����ϴ� �����尡 ���� ��װ� ���� �� ���� ������� ��ٷ��� �Ѵ�.
	�� ������ ����ȭ ������ �ǰ� �̴� java ����� Ű����� �����ǰ� �ִ�.
*/