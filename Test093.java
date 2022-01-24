
/*
	이름은 같지만 매개변수의 형식이 다른 함수는 하나의 클래스 안에 공존할 수 있다.
	함수명이 같은것이 여러개 있을때는 매개변수 형식이 일치하는 선언을 찾아서 호출하게 된다.
	
	근데 같은 이름을 쓸 때는 리턴타입은 동일해야 한다.(매개변수의 형식이 달라질 수는 있다)
	
	매개변수의 개수가 같아도 타입이 틀리면 공존할 수 있다.
*/

class Temp {
	int add(int i, int j){
		return 100;
	}
	int add(int i){
		return 200;
	}
	//이런거 에러뜬다.
	/*
	void add(int i){
		return 100;
	}
	*/
	void print(double i){
		System.out.println("i");
	}
	void print(int i){
		System.out.println("i");
	}
}

public class Test093{
	public static void main(String[] args){
		Temp t = new Temp();
		int r = t.add(10,20);
		System.out.println(r);
		
		int j = t.add(10);
		System.out.println(j);
		
		
		t.print(100);    // 이러면 매개변수가 int인 함수를 호출함
		// 만약 매개변수가 double, float 인 함수가 있다면 float가 호출됨. 가장 가까운 자료형을 호출.
		// byte < short < int < long < float < double
	}
}