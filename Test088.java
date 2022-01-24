/*
class A{
	void print(){ System.out.println("print");}
}

class B extends A{
	void print2(){ System.out.println("print2");}
}

public class Test088{
	public static void main(String[] args){
		A t = new B();
		// B t = new A();
		// t.print2();
	}
}
/*

/*
	조상형 변수로 자손 클래스의 인스턴스를 가리킬 수 있다.
	하지만 이때는 조상에서 선언된 멤버만 호출 가능하다.
	근데 오버라이딩 된 경우에는 오버라이딩 된 함수가 호출된다.(이거 쌉중요함)
	
*/


class A{ 
	void print(){
		System.out.println("a");
		}
	}

class B extends A{
	void print(){
		System.out.println("b");
	}
	void print2(){ 
		System.out.println("print2");
	}
}

public class Test088{
	public static void main(String[] args){
		A t = new B();
		t.print();
	}
}

