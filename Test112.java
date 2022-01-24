
class A {
	private int value = 0;
	
	public A( int i ){ value = i; }
	public int intValue() {
		return this.value;
	}	
}
public class Test112{
	public static void main( String[] args ) {
	A t = new A(100);
	
	//int j = t;   말이 안 됨.  밑에꺼와 같은 기능인데도 안됨.
	int j = t.intValue();
	
	Integer t2 = new Integer(100);
	// 원래는 말이 안되지만 컴파일러가 t2.intValue()로 코드를 바꾼 뒤 컴파일한다.
	int j2 = t2;
	
	Object t3 = 200;
	// int j3 = t3;
	// Object 타입형 변수는 언박싱이 안된다. intValue는 Object에서 선언된 함수가 아니기 때문.
	}
}

/*
	t2가 가리키는 인스턴스에서 값만 빼와서 대입한다고 해서 언박싱이라고 한다.
	
	A가 Wrapper 클래스라고 가정하면
	Object t3 = new A(100);
	int j3 = t3.intValue(); -- intValue() 함수가 호출될 수 없다. 조상 클래스에 없는 함수를 호출할 수 없기 때문.
*/