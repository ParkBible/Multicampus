public class Test061{
	public static void main(String[] args){
		System.out.println("HelloWorld");
	}
}

/* 에러 : 클래스를 만들고 그 안에 변수와 함수를 선언하는 것만 가능하다.(c와 다른 점인듯?)
int add2(int i, int j){
	return 100;
}
*/

Class Sample{
	int i = 0;
	// i = 1000;
	
	int add(int i, int j){
		return 100;
	}
	
	// add(10, 20);  //에러
}

/*
	public class에서 class란??
	class는 사실 "구조체"다...
	class는 이름이 붙는다
	class 안에는 변수를 선언할 수 있다. 밖에서는 선언 못함.
	class 안에서 변수에 값을 대입할 순 없다.
	class 안에서 함수를 선언할 수 있지만 호출할 수 없다.
*/