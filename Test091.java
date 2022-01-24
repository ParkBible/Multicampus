

class A{
	A(){
		System.out.println("A constructor");
	}
}

class B extends A{
	B(){
		System.out.println("B constructor");
	}
}

public class Test091{
	public static void main(String[] args){
		new B();
	}
}

/*
	출력 : A constructor  B constructor
	
	자손의 인스턴스를 생성하면 조상의 생성자부터 자손의 생성자가 차례로 호출된다.
	그럼 생성자가 상속되는 개념인가?
	생성자는 포인터로 호출할 수 없는 함수다. 따라서 멤버함수가 아니기 때문에 상속되지 않는다.
	
	
*/