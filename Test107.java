class A {}
class B {}

class D extends A {}
class E extends D {}  // 대를 거쳐가며 상속받는 것은 다중상속이 아니다. (A->D->E)

interface IA {}
interface IB {}

// 인터페이스 상속해서 인터페이스 선언시 다중상속 가능
interface IC extends IA, IB {}

// 인터페이스 상속해서 클래스 선언시에도 다중상속 가능!
class F implements IA, IB{}
class G extends B implements IA, IB {}

public class Test107{
	public static void main(String[] args){
	}
}

/*
	인터페이스는 다중상속을 지원한다.
	class C extends A, B {} : 2개 이상의 클래스로부터 동시에 상속받는 것.
	java에서 이것은 허용되지 않는다.
	각각 다른 자손에서 다르게 오버라이딩을 해서 한 포인터가 두 개를 가리키게 되는 말도 안되는 상황, '다이아몬드 문제'를
	발생시키지 않도록 주의한다. C++은 차이는 있지만 이런 문제가 발생치 않는 한 제약은 안한다. 자바는 함.
*/