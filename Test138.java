class Temp{
	
	static{
		Temp t = new Temp();
		t.print();
	}
	
	static void print2() {
	// print();
	}
	
	void print(){
		print2();
	}
}

/*
	이건 오버라이딩을 전제로 하는 함수여야 하고 오버라이딩은 함수포인터 형태로 운용되어야 한다.
	그러려면 인스턴스에 함수포인터가 있어야 하고, 그러려면 non-static해야 한다.
	인터페이스 안에서는 non-static한 메소드를 쓴다.
*/
interface ITemp{
	// public static void print();

}
public class Test138{
	public static void main(String[] args){
	}
}

/*
	static 안에서 non-static한 멤버(print())는 존재하기 전이라 쓸 수가 없다.
	근데 static 안에서도 인스턴스 써서 호출하는 건 가능
*/