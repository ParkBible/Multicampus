class A{
}

interface ITemp<X>{
	public X getData();
}

public class Test118{
	public static void main(String[] args){
		A t = new A(){};    // A 클래스를 상속받은 클래스인데, 이름이 없다.
		System.out.println(t.toString());    //  한번만 호출하고 끝남.
		
		/*
			A t = new B();
			new ITemp<Integer>(){...} : ITemp<Integer> 를 상속받으며 만든 무명의 클래스의 인스턴스 생성
			ITemp<Integer>를 상속받았으니 인터페이스라서 조상에서 선언된 메소드를 오버라이딩 해줘야하고
			X엔 Integer가 들어가야 한다
			오토박싱 고려하면 return 100;을 해도 문법에는 이상이 생기지 않는다.
		*/
		
		ITemp<Integer> it = new ITemp<Integer>(){
			public Integer getData(){return 100;}    // 상속받은거
		};
		
		int j = it.getData();
		System.out.println(j);
	}
}

/*
	Test118$1@2a139a55 가 출력된다. 클래스이름이 없다.
	
	new(a){}
		{} 안에는 변수선언과 함수선언이 가능하다. 그럼 클래스네?
		인스턴스를 만들고 있는 상황인가? 그렇다.
		
	"A 클래스를 상속받는 이름없는 클래스를 선언하면서 동시에 인스턴스를 생성하고 있다."
	조상으로부터 상속받으면서, 클래스를 선언하는데 이름이 없다.(재사용이 불가능하다. 일회용 클래스)
	한번만 사용할거라서 이름같은거 필요없다는 느낌. --> anonymous class
	
	엄밀히 말하면 이건 객체지향언어의 근간을 흔드는 개념인데 코드를 줄이는 효과가 탁월하여 눈물을 머금고 쓴다.
	안드로이드 등 GUI 관련 프로그래밍에서 탁월한 쓰임새.
*/