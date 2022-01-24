
interface IFuelObs{
	public void onFuelChange(int fuel);
}

// ���� ��� Ŭ����
class Car{
	// ������ ��ü�� ���� �ڵ�
	private IFuelObs obs = null;
	public void setFuelObs(IFuelObs o){
		obs = o;    // ���ο��� �Լ��� ȣ���ϸ� obs�� ���� ���Ե�. (���� null)
	}
	// ������ ��ü�� ���� �ڵ� ----
	private int fuel = 3;
	
	public void drive(){
		fuel--;
		
		// ������ ��ü�� ���� �ڵ�
		if(obs != null){
			obs.onFuelChange(fuel);
		}
		// ������ ��ü�� ���� �ڵ� ----
		
		System.out.println("���� 1L �Ҹ�");
	}
}

// ������ ��ȭ�� ����� �ܷ��� ����ִ� Ŭ����(������)
// >>2
class FuelGauge implements IFuelObs{
	public void onFuelChange(int fuel){    // �������̵�
		System.out.println(">>" + fuel);
	}
}

public class Test168{
	public static void main( String[] args ) {
		Car car = new Car();
		car.setFuelObs(new FuelGauge());
		car.drive();
		car.drive();
		
		car.setFuelObs(null);
		car.drive();
	}
}

// ��ü ����
// �� Ŭ������ IFuelObs�� ��ӹ޾����Ƿ� FuelGauge
class FuelBomb implements IFuelObs{
	public void onFuelChange(int fuel){    // �������̵�
		System.out.println("��ź����");
		System.exit(0);    // �ڵ� ����
	}
}

/*
	������ ��Ȳ�� üũ�ϴ� �ڵ带 �ֵ�, �����ϰ� ��ü�����ϵ��� ���� �� ������?
	
	����� ������ Ŭ����(��� ����͸��ϴٰ� �ʿ���� ��� ���ų� ��ü.)
	>>2
	���� 1L �Ҹ�
	>>1
	���� 1L �Ҹ�
	���� 1L �Ҹ�

	Car�� FuelGauge�� ������ Ŭ������ �������.
	�� �� IFuelObs�� �̿��ϴµ� Car�� ���°� ����Ǵ� ���� Gauge�� �뺸�ϰ� �ִ�.
	�̷��� ���� ����� ������ �����̶�� �Ѵ�.
	���� ����� ��ȭ�� �����ڿ��� �뺸�ϴµ� �� ���� ������ �и��ǰ� ��ü�����ϰ� ����ȴ�.
	�����ڴ� ��ü�����ϰ�, ��Ȳ�� �´� �ڵ�� ���� ����� �� �ִ�.
*/