class Temp{
	int data = 100;
	int add(int i){
		return i * 10 + this.data;
	}
}

public class Test067{
	public static void main(String[] args){
		Temp t = new Temp();
		t.data = t.add(20);
		System.out.println(t.data);
	}
}

// Test066을 자바로 옮긴 꼴.

/*
	t.add(20); 이것과 같이 호출하였을 때,
	함수 안에서는 this라는 포인터를 쓸 수 있다.
	
	this는 현재 호출되는 함수가 소속된 인스턴스
	(t를 통해서 함수가 호출된다면 t가 가리키는 대상)를 가리키게 된다
	this를 통해서 data와 add 함수에 접근할 수 있다.
	
	this가 가리키는 대상은 어느 참조형 변수를 통해 호출하느냐에 따라 달라진다.
	이를 통해 같은 함수의 실체를 호출하더라도 각각 다른 결과를 만들어냄.
	
	java의 모든 클래스 안에서 선언된 함수는 this를 쓸 수 있고, 이것이 가리키는 대상은
	호출시에 사용했던 포인터가 가리키는 대상, 즉 함수가 소속된 인스턴스를 가리키게 된다.
*/