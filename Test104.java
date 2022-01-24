
interface ITemp{
	abstract public void print();    // abstract public이랑 public abstract랑 똑같다.
	public void print(int i);		// abstract 안붙었는데 interface 안에선 이것도 abstract로 취급한다.
}

class Temp implements ITemp{
	public void print() {System.out.println("print");}
	public void print(int i) {System.out.println("print2");}
}

public class Test104{
	public static void main(String[] args){
		ITemp t = new Temp();
		t.print();
		t.print(234);
	}
}

/*
	interface : 좀 이상한 클래스. 껍데기만 있다.
	- public abstract한 메소드만 가질 수 있다.
	- 사실 메소드에 abstract 안붙어도 자동으로 붙는다.
	- 당연히 인스턴스 못만든다.
	- 상속해서 클래스를 선언할 때 implements, 모든 메소드를 다 오버라이딩 해야 한다. (안해주면 자손이 abstract class 됨.)
*/