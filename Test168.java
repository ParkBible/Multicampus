
interface IFuelObs{
	public void onFuelChange(int fuel);
}

// 관찰 대상 클래스
class Car{
	// 유연한 교체를 위한 코드
	private IFuelObs obs = null;
	public void setFuelObs(IFuelObs o){
		obs = o;    // 메인에서 함수를 호출하면 obs에 값이 대입됨. (원래 null)
	}
	// 유연한 교체를 위한 코드 ----
	private int fuel = 3;
	
	public void drive(){
		fuel--;
		
		// 유연한 교체를 위한 코드
		if(obs != null){
			obs.onFuelChange(fuel);
		}
		// 유연한 교체를 위한 코드 ----
		
		System.out.println("연료 1L 소모");
	}
}

// 연료의 변화가 생기면 잔량을 찍어주는 클래스(관찰자)
// >>2
class FuelGauge implements IFuelObs{
	public void onFuelChange(int fuel){    // 오버라이딩
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

// 교체 예시
// 이 클래스도 IFuelObs를 상속받았으므로 FuelGauge
class FuelBomb implements IFuelObs{
	public void onFuelChange(int fuel){    // 오버라이딩
		System.out.println("폭탄터짐");
		System.exit(0);    // 코드 끝남
	}
}

/*
	연료의 상황을 체크하는 코드를 넣되, 유연하게 교체가능하도록 만들 수 있을까?
	
	연료계 역할의 클래스(계속 모니터링하다가 필요없을 경우 빼거나 교체.)
	>>2
	연료 1L 소모
	>>1
	연료 1L 소모
	연료 1L 소모

	Car과 FuelGauge는 별도의 클래스로 만들었다.
	둘 다 IFuelObs를 이용하는데 Car의 상태가 변경되는 것을 Gauge에 통보하고 있다.
	이러한 설계 기법을 관찰자 패턴이라고 한다.
	관찰 대상의 변화를 관찰자에게 통보하는데 이 둘은 별도로 분리되고 교체가능하게 연결된다.
	관찰자는 교체가능하고, 상황에 맞는 코드는 쉽게 변경될 수 있다.
*/