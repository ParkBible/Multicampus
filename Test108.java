// 사장이 이걸 정해서 각 팀에게 나눠주면, 자율적으로 알아서 메소드를 추가할 수 없다.

interface ICar{
	public void turnRight();
	public void turnLeft();
}

class Spark implements ICar{
	public void turnRight() {System.out.println("tR");}
	public void turnLeft() {System.out.println("tL");}
}

class Colorado implements ICar{
	public void turnRight() {System.out.println("turnR");}
	public void turnLeft() {System.out.println("turnL");}
}

public class Test108{
	public static void main(String[] args){
		ICar car = new Colorado();    // colorado 대신 spark를 넣어도 정상작동. -> 호환성
		car.turnRight();
		car.turnLeft();
	}
}

/*
	인터페이스는 클래스간의 호환성을 만드는 용도. 인스턴스만 바꾸면 나머지는 바꿀 필요 없음.
	그래서 인터페이스는 모든 자동차에서 구현가능한 형태로 선언해야 한다.
	인터페이스에서 빠진 기능은 시스템에서도 빠지게 된다. spark에 자폭 기능을 넣는다 해도 사용하지 못함.
	한번 정해지면 고치기 어렵다. 상속받은 모든 자동차가 다 고쳐야 하기 때문.
	"코드 도사 아니면 손댈 게 못되더라"
*/