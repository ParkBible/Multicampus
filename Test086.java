class A{
	int data = 100;
	void print(){
		System.out.println("A print");
		
	}
}

class B extends A{ 
   int data = 200;
	void print(){
		System.out.println("B print");
	}
}

/*
	조상에서 선언된 함수를 자손에서 그대로 재정의하면 갈아엎어짐. 기존의 포인터가 가리키는 방향을 자손이 정의한 것을
	가리키게 바꾼다.
	이것을 method overriding 이라고 한다.
	조상에서 상속받은걸 없앨 수는 없지만, 이런 식으로 변경할 수는 있다. (조상의 데이터 자체에는 영향 없음)
	그래서 상속받은 클래스에서는 함수 포인터를 만들지 않는다.
*/

public class Test086{
	public static void main(String[] args){
		B t = new B();
		t.print();    // B print
		
		A t2 = new A();
		t2.print();    // A print
	}
}