
class Temp{
	
	// 리턴타입이 없고(void라는 말을 생략함), 클래스 이름과 같은 함수. constructor(생성자)
	Temp(int i){
		this.data = i;
	}
	
	int data = 100;
	int add(int i){
		return this.data + i;
	}
}

public class Test070{
	public static void main(String[] args){
		Temp t = new Temp(0);
		// t.Temp() 생성자를 포인터로 호출하려고 하면 오류난다. 
		t.data = t.add(20);
		System.out.println(t.data);
	}
}