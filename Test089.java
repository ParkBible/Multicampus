class A{
	int data = 100;
}

class B extends A{
	int data = 200;
}

public class Test089{
	public static void main(String[] args){
		A t = new B();
		System.out.println(t.data);    // 100이 나온다. 오버라이딩 됐을텐데 200이 안나옴!
		// 조상에서 선언된것만 접근할 수 있기 때문에 100이 나오는것.
		
		B t2 = (B)t;					// 같은 포인터를 B로 캐스팅(자료형 변경)을 해본다.
		// 같은 이름의 변수가 2개 있으면 자신안에서 선언된 것을 호출한다.
		System.out.println(t2.data);    // 200이 나온다.
		
		// 이런 건 절대로 바람직하지 않다. 조상에서 선언된 이름의 변수를 자손에서 쓰지마라!!
		// 버그유발함.
		// 상속된 인스턴스 생성시 벌어지는 일.
	}
}