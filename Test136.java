
class Temp{
	int add(int i, int j){
		return 100;
	}
	static int add2(int i, int j){
		return 100;
	}
}

public class Test136{
	public static void main(String[] args){
		Temp t = new Temp();    // 인스턴스 생성하여 레퍼런스에 대입
		int r = t.add(10,20);    // 레퍼런스를 통해 함수 호출
		System.out.println(r);
		
		int a = Temp.add2(10,20);    // 그냥 바로 클래스 이름을 통해 함수 호출
		System.out.println(a);
	}
}

/*
	static이 붙은 멤버함수는? 인스턴스 없이 클래스명, 함수명으로 호출이 가능하다.
	참조형 변수도 불필요함.
	C에서 보던 보통함수와 동일 개념이다.
	C++은 클래스 밖에서 함수선언이 가능하지만 java는 불가능하기 때문에 static이란 키워드를 사용한다.
*/