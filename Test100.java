
class A{
	private int drug = 0;
	protected int vijagum = 1;
	public int budongsan = 2;
	
	void picnic(){
		System.out.println(this.drug);
		System.out.println(this.vijagum);
		System.out.println(this.budongsan);    // 접근지정자에 상관없이 나는 내 재산 얼마든지 접근 가능.
	}
}

class B extends A{
	void print(){
		System.out.println(this.drug);    // 마약은 자식도 손 못댄다.
		System.out.println(this.vijagum);    // 부동산이랑 비자금은 가능하다.
		System.out.println(this.budongsan);
	}
}

public class Test100{
	public static void main(String[] args){
		private int i = 0;    // 로컬변수 앞에는 붙을 수 없다.
		
		A t = new A();
		System.out.println(t.budongsan);    // 파파라치가 부동산 찍어보니까 나오더라.
		System.out.println(t.drug);    // 근데 마약은 접근이 안된다.
		System.out.println(t.vijagum);   // 비자금은 외부인이 손 못대야되는데 자바에선 package개념때문에 찍으면 나올수도 있다.
										// 같은 패키지일땐 가능하지만 다른 패키지는 접근할 수 없음.
	}
}

/*
	private, protected, public : 멤버변수와 멤버함수 앞에 붙을 수 있구나.
	클래스의 재산은 멤버변수와 멤버 함수밖에 없다...
	
	재산정리는 3가지로 분류
	1. 무덤까지 가져갈 거.(공개x, 상속x) 어떤사람이 약쟁이인데 마약(drug)을 숨기고 물려주지도 않을거다. - private
	2. 물려주기만 할 거(공개x, 상속o) 남들이 비자금(vijagum)에 대해 물어보면 잡아땔거지만 물려주긴 할거다. - protected
	3. 공개하면서 물려주기도 할 것 (공개o, 상속o) 부동산(budongsan)은 공개되어 있고 물려주기도 할거다. - public
*/