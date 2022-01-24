
interface ICalc{
	public int execute(int i);   // 계산과 출력 부분
}

class Plus implements ICalc{
	private int data = 0;    // 인터페이스를 상속받았더라도 데이터를 받아오기 위해 멤버변수와 생성자는 자주 쓴다.
	Plus(int k){    // 생성자는 바깥쪽에
		this.data = k;
	}
	public int execute(int i){
		return data + i;
	}
}

class Minus implements ICalc{
	private int data = 0;
	Minus(int k){    // 생성자는 바깥쪽에
		this.data = k;
	}
	public int execute(int i){
		return i - data;
	}
}

public class Test109{
	public static void main(String[] args){
		ICalc ic = new Plus(5);
		System.out.println(ic.execute(3));    // 8
		ICalc ic2 = new Minus(2);
		System.out.println(ic2.execute(3));    // 1
		
		// "동작"을 인스턴스로 만들어서 배열에 집어넣고 순차적으로 실행하게 할 수 있다. 매크로에서 쓰임.
		// 이런 기법을 command pattern이라고 한다. (유명한 객체지향 설계기법)
		ICalc[] l = new ICalc[4];
		l[0] = new Plus(3);
		l[1] = new Minus(1);
		l[2] = new Plus(4);
		l[3] = new Minus(3);
		
		int start = 10;
		for(int i=0; i<l.length; i++){
			start = l[i].execute(start);
		}
		System.out.println(": " + start);
	}
}

/*
	객체지향 프로그래밍에 대략적인 이론은 있지만 정답은 없다.
	클래스는 설계도, 인스턴스는 실체, 객체의 상태는 멤버 변수, 객체의 동작은 멤버 함수로... -> 결국 경험
	경험이 다는 아니고, 잘 설계된 사례도 존재.
	
	보통 동작 하나는 하나의 함수로 구현. 동작 하나를 인스턴스로 만들 수도 있다.
*/