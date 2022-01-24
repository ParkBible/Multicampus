
/*
	함수와 서브루틴에 대해
	서브루틴을 선언하고 void 뺀다! 클래스 이름과 함수명을 동일하게. 적당히 매개변수 준다 : 생성자 함수
	
	생성자 함수는 인스턴스가 생성되는 시점에 호출된다. 참조형 변수 선언시 호출되지 않는다. Temp t; 하면 글자 안뜸.
	참조형 변수로는 호출도 안됨. t.Temp(100); 이래도 안된다.
	
	클래스 안에서 선언하는 변수와 함수 : 멤버 변수(프러퍼티), 멤버 함수(메서드)
	
	생성자 함수를 호출할 수 있는 함수포인터는 인스턴스 안에 없다. 즉 생성자 함수는 멤버함수가 아니다.
	리턴 타입을 void라고 입력하면 멤버함수가 된다.
	
	생성자 안에서는 this 라는 포인터를 사용할 수 있고, 이것을 이용해 주로 멤버변수를 초기화 한다.
*/
class Temp{
	Temp(int i){
		System.out.println("뗌푸");
		this.data = i;
	}
	
	int data = 100;
	int add(int i, int j){
		return 300;
	}
}

public class Test071{
	public static void main(String[] args){
		//new Temp(100);  // 인스턴스 생성. 이걸 변수에 담으면 그건 참조형 변수
		Temp t = new Temp(100);   // 레퍼런스는 포인터 변수임!!!
		//t.Temp(100);  -- 멤버함수라면 호출하겠지만 생성자함수는 멤버함수가 아니다.
		
		t.data = t.add(0,0);
		System.out.println(t.data);
	}
}