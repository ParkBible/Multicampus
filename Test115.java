Class Bank <X extends Object> {
	X t = null;
}

public class Test115{
	public static void main(String[] args){
		Bank<Object> bank = new Bank<Object>();    // 이러면 2번째줄의 t의 자료형이 Object가 된다.
		bank.t = "HelloWorld";
		String t2 = (String)bank.t;    // 캐스팅이 필요하다.
		
		Bank<String> bank2 = new Bank<String>();   // 이러면 2번째줄의 t의 자료형이 String이 된다.
		String t3 = bank2.t;    // 캐스팅이 필요없다.
		// 아까는 Bank엔 Object형, Bank2엔 String형 변수 각각 한개만들어서 썼는데
		//  제너릭 쓰면 하나만 만들어서 내 입맛대로 동적으로 자료형 바꿀 수 있다.
		
		// 이런식으로 오토박싱 언박싱을 이용하니 코드가 깔끔해졌다.
		Bank<Integer> bank3 = new Bank<Integer>();
		bank3.t = 100;    // 오토박싱. t가 int형이므로 Integer() 안에 bank3.t를 넣는다.
		int j = bank3.t;     // 언박싱. intValue() 를 사용하여 j에 대입.
	}
}

/*
	인스턴스를 받을 수 있는 변수의 타입이 Object냐, String이냐에 따라 확연히 장단점이 갈린다.
	Object는 다 잠시 맡길 순 있지만 찾아갈때 캐스팅
	String은 String만 맡길 수 있지만 찾아갈때 캐스팅 필요없음
	
	클래스 안에서 언급되는 변수의 타입을 <>안에 지정되는 타입으로 동적으로 결정할 수 있다.
	이를 제너릭(Generic)이라고 한다.
	C++의 template와 비슷한데 제너릭은 참조형변수만 가능하고 자료형은 불가능하다. 그래서 extends Object
	
*/