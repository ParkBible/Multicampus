class FuelException extends Exception{}
class BreakException extends Exception{}

class Car{
	private int fuel = 5;
	public void drive(boolean stopper) throws FuelException, BreakException{
		fuel--;
		
		if(fuel == 1){
			throw new FuelException();
		}
		else if(stopper == false){
			throw new BreakException();
		}
		System.out.println("���� 1���� �Ҹ�: gogo");
	}
}

public class Test178{
	public static void main(String[] args){
		Car car = new Car();
		try{
			car.drive(true);
			car.drive(true);
			car.drive(true);
			car.drive(true);
			car.drive(true);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
	}

}

/*
	fuelexception : ���ᰡ 1���� �������� �߻�, breakexception : stopper�� false�϶� �߻�
	���ܹ߻��� ���� ó���� �ϳ��� catch���� �ϵ��� �ڵ� ¥��.
	
	
	���� 1���� �Ҹ�: gogo
	���� 1���� �Ҹ�: gogo
	���� 1���� �Ҹ�: gogo
	FuelException
*/