class A {
	int data = 0;
	A() { System.out.println("A Construction"); }
	void print() {
		System.out.println("print A");
	}	
}

class B extends A {
	int data = 10;
	B() { System.out.println("B Construction"); }
	void print() {
		System.out.println("print B");
	}
	void print( int i ) {
		System.out.println("print B2");
	}
}

public class Test096 {
	public static void main( String[] args ) {
		//	B t = new B();
		A t = new B();
		t.print();
		System.out.println( t.data );
		
		B t2 = (B)t;
		System.out.println( t2.data );
		t2.print( 100 );
	}
}
/*	상속 오버라이딩 오버로딩 [A t = new B()] 상속시생성자 참조형변수캐스팅 멤버변수오버라이딩??

*/