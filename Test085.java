class A{
	int data = 0;
	void print(){
		System.out.println("print" + this.data);   // 당연히 data 라고만 써도 됨
	}
}

class B extends A{    // 이 코드만 있어도 r.data = 100이 에러안뜸. "클래스의 상속" 개념.
	// 보이지는 않지만 A 클래스에서 선언된 함수와 변수를 옮겨오는 효과를 얻는다.
	// class B는 A로부터 상속받았다. A는 B의 조상클래스, B는 A의 자손클래스.
	void print2(){
		System.out.println("print2" + this.data);    // 조상님것도 내꺼, 내껏도 내꺼
	}
}

public class Test085{
	public static void main(String[] args){
		A t = new A();
		t.data = 100;
		//t.print();
		
		B r = new B();
		r.data = 200;
		r.print2();
		r.print();
	}
}

/*

*/