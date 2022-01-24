

public class Test111{
	public static void main(String[] args){
		Object t = 100;
		System.out.println(t.getClass().getName()); // java.lang.Integer  : java.lang은 패키지명, Integer는 클래스명
		
		Integer t2 = 200;
		Integer t3 = t2;    // *t2 처럼 사용 가능.
		
		int j = t3;    // 참조형변수를 int형 변수에 대입하는 경우, 컴파일러는 자동으로 t3.intValue()를 호출함.(언박싱. 즉 박스에서 꺼낸다)
		System.out.println(j);
		
		// int k = t;  // 똑같이 오토박싱됐더라도 Integer로 받은 건 언박싱 되는데 Object로 받은건 언박싱 안된다.
	}
}

/*
	자바는 int*, double* 같은 거 없다. - 자료형변수의 기억공간에 대한 포인터 개념이 없다.
	- 그 대안으로 제시한 것이 Wrapper Class이다.
	
	Wrapper Class들의 이름
	int - Integer
	double - Double
	float - Float
	char - Character
	boolean - Boolean
	
	Object t = 100;
	t는 인스턴스를 가리키기 위한 용도의 참조형 변수인데, 100을 대입할 수 있다.
	
	t.getClass().getName() : t가 가리키는 인스턴스를 생성한 클래스명(어느 클래스의 인스턴스인지를 알기 위해 사용)
	
	포인터에 대입하게 되면 해당 클래스의 인스턴스로 바꿔줌.
	Object t = 100;   Object t = new Integer(100); 이렇게 바꿔준다. 참조형 변수에 값을 대입해야 하는 코드가 보이면 그때는 값을 Wrapping해 준다.
	
	java.lang은 패키지 이름
	Wrapper class는 포인터를 대신할 수 있을 정도로 가볍고 메모리소비가 작은 형태로 구현되어있음
	
	Object t = 100; 이러한 코드에서 자동으로  new Integer(100)를 씌워주는 걸 Auto Boxing이라고 한다.(박스 즉 클래스에 쌈)
	(오토박싱은 jdk 1.5 이전버전에선 제공되지 않음)

*/