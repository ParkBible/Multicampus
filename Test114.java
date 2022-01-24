
class Bank{
	Object t = null;
}

class Bank2{
	String t = null;
}

public class Test114{
	public static void main(String[] args){
		Bank b = new Bank();
		b.t = "HelloWorld";
		//String b2 = b.t;    // b2는 큰박스를 가리킬 수 있는 변수이고 b.t는 작은박스
							// 자손형 변수로 조상형 인스턴스를 가리킬 수는 없다.
		String b2 = (String)b.t;    // Object형이라 무슨 인스턴스든 가리킬 수 있지만 원래대로 꺼낼 때 캐스팅이 필요하다.
		
		Bank2 c = new Bank2();
		c.t = "HelloWorld";
		String c2 = c.t;     // 이건 같은 박스를 가리키고 있으므로 가능.
		// Bank2는 String만 멤버변수를 이용하여 가리킬 수 있지만, 원래대로 꺼낼 때 캐스팅은 필요 없다.
	}
}