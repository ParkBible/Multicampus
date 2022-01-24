class Temp{
	// uniq 변수는 jvm 안에서 유일해진다.
	private static Temp uniq = null;
	
	// static initializer 안에서 uniq로 인스턴스를 가리키게 한다.
	static{
		uniq = new Temp();
	}
	
	// public static synchronized 하게 uniq를 제공하는 getInstance 함수를 선언한다.
	public static synchronized Temp getInstance(){    // synchronized는 붙어야 한다.
		return uniq;
	}
	
	// private이므로 Temp 밖에서는 생성자를 호출할 수 없다. 즉 인스턴스를 못 만든다.
	private Temp(){
	}
}

public class Test139{
	public static void main(String[] args){
		// new Temp(); // 에러
		
		Temp a = Temp.getInstance();
		Temp b = Temp.getInstance();
		System.out.println(a==b);  // true라는 결과가 나온다. a와 b가 가리키는 인스턴스는 7번째 줄의 인스턴스로 둘다 동일.
								   // 인스턴스가 재활용, 공유되고 있다는 걸 알 수 있다.
	}
}    // 이런 설계패턴을 Singletone Pattern 이라고 한다. (자바 인스턴스를 딱 하나만 jvm상에서 존재하게)

/*
	C언어의 함수는 프로그램이 동작하는 동안 유일하게 존재한다.
	이것처럼 java의 인스턴스도 딱 하나만 jvm상에서 존재하게 만드는 거 static을 이용하면 만들 수 있다.
*/