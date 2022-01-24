
class Temp{
	int data = 100;
	int add(int i){
		return i * 10;
	}
}

public class Test062{
	public static void main(String[] args){
		Temp t = new Temp();
		t.data = 20;
		t.data = t.add(20);    // 함수를 호출하는 법. t.data에는 200이 대입된다
		System.out.println(t.data);
	}
}

/*
	new Temp(); 를 먼저 만들어 주어야 한다.(인스턴스라고 한다)
	Temp t = ... , 클래스 이름으로 변수를 선언하고 거기다가 인스턴스를 대입한다.
	
*/