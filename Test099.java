
class A{
}

class B extends A{
	void print() {}
}

public class Test099{
	public static void main(String[] args){
		A t = new A();
		boolean b = (t instaneof B);    // t를 B로 캐스팅할 수 없으므로 false가 나온다.
		// B t2 = (B)t;    실행시 에러가 난다.
		
		A t2 = new B();
		// B t3 = (B)t2;    에러안난다.
		
		boolean b2 = (t2 instaneof B); // t를 B로 캐스팅할 수 있으므로 true가 나온다.
	}
}

/*
	컴파일할때 나는 에러가 있고, 실행할 때 나는 에러가 있다. 13번째줄은 실행에러.
	
	참조형변수 instanceof 클래스
	: 참조형변수가 가리키는 대상을 클래스로 캐스팅 가능하면 true, 아니면 false.
*/