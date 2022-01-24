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
		System.out.println("연료 1리터 소모: gogo");
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
	fuelexception : 연료가 1리터 남았을때 발생, breakexception : stopper가 false일때 발생
	예외발생에 대한 처리를 하나의 catch에서 하도록 코드 짜기.
	
	
	연료 1리터 소모: gogo
	연료 1리터 소모: gogo
	연료 1리터 소모: gogo
	FuelException
*/