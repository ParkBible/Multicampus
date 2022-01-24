class Temp {
	public void print(String... p){    // String이기만 하면 개수 상관없이 매개변수로 받아들임.
		System.out.println(p.length);   // 배열 개수 출력
		for(int i=0; i<p.length; i++){
			System.out.println(p[i]);
		}
		System.out.println();
	}
	
	// 정말 무식한 함수선언법. 어떤 매개변수도 다 통과됨. 매개변수를 어떻게 넣더라도 오토박싱 때문에 다 가능한 함수가 됨.
	public void print2(Object... p){    
		System.out.println("print2");
	}
}

public class Test113{
	public static void main( String[] args ) {
		Temp t = new Temp();
		t.print();
		t.print("apple");
		t.print("apple", "banana");
		t.print("apple", "banana", "orange");
		
		t.print2(100, 3.14, "끼", "야", "Ho", "우");    // print2
	}
}

/*
	String... p : 가변길이 파라미터라고 한다. 정체는 배열이다.
	매개변수에 전달되는 것이 String이기만 하면 개수는 상관없는 형태가 된다.
	
*/

	최소한 10시 반에는 자는거 추천.
	게임, 음주는 주중에 금지.
	광합성 강추. 운동 조금이라도 꾸준히 하기,,,