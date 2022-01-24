abstract class Temp{
	abstract public void print();
}

class Temp2 extends Temp {
	public void print(){
		System.out.println("HelloWorld");
	}
}

public class Test102{
	public static void main(String[] args){
		// Temp t = new Temp(); 에러.
		Temp t = new Temp2();    // 조상형으로 선언해서 오버라이딩된 함수를 호출하는 경우가 많다!
		t.print();
	}
}

/*
	abstract : 인스턴스를 만들 수 없는 클래스
	(클래스로 하는 일 : 참조형 변수선언, 인스턴스 생성, 상속받아 클래스 선언)
	이중 인스턴스생성 빼고 나머지는 다 된다.
	
	abstract method : 선언되었지만 정의되지 않은 메소드.(뒤에 세미콜론)
	만약 클래스 안에 abstract method가 하나라도 포함되어있다면 그 클래스는 abstract method가 되어야 한다.
	또한 abstract 클래스를 상속받은 클래스도 abstract가 되어야 한다.
	하지만! 만약 자손 클래스에서 오버라이딩했다면 abstract가 떨어져 나간다. 그럼 자손 클래스 자체도 abstract를 뗄 수 있다.
	
	abstract class를 활용할 때 [A t = new B()]를 사용하는 경우가 많다!
	
	자바의 경우 실은 내부적으로 함수포인터를 이용한 호출을 사용하고 있는데
	abstract method는 함수포인터에 null값이 들어있는 함수에 해당한다. 그래서 인스턴스가 존재 못함.
	null값 들어있는데 함수포인터로 함수 호출하면 뻑나기 때문에 abstract로 인스턴스 아예 못생성하게 막아놨다.
	
	오버라이딩의 정체는 ? 조상에서 선언된 함수포인터가 자손에서 선언한 함수 실체를 가리키는 것.
	abstract method를 오버라이딩 하면, null값이 들어간 함수포인터가 새로운 실체를 가리키게 된다.
	null값은 날아간다 -> 그럼 abstract한 성질이 없어진다. 또한 인스턴스 생성도 가능해진다.
*/