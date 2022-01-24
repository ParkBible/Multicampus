
/*
	자바는 명시하지 않으면 extends Object를 자동으로 붙인다. 즉,
	Object는 모든 클래스의 조상이 된다.
	
	그럼 Object 타입의 변수는 모든 인스턴스를 가리킬 수 있나? -> 맞다.
	그럼 void*랑 같은 개념인가? -> 자바에는 int* 같은 자료형이 없다.
	
	toString()은 Object에서 상속받았다.
*/
class Temp{
	public String toString(){    // 오버라이딩. 원래 Object에 포함된 toString()은 클래스명@인스턴스고유번호가 출력.
		return "HelloWorld";
	}
}

public class Test097{
	public static void main(String[] args){
		Object t = null;    // Object : 자바 제공 클래스
		t = new Temp();
		
		// void println(String x)
		System.out.println(t.toString()); // 12~14줄 없을때; Temp@2a139a55   클래스명@인스턴스고유번호
										  // 있을때; HelloWorld
		System.out.println(t);    // void println(Object x)
	}
}

/*
	오버라이딩, 오버로딩과 [A t = new B()] 가 실전에서 쓰이는 주요 사례.
	
	// 오버로딩된 부분
	void println(Object x){
		// x.toString()을 호출해서 결과 찍음.
	}
	void println(String x){
		// t의 문자열을 그냥 찍음.
	}
	
	인터페이스를 이용해서 코드를 짜본 경험이 있는지?
*/