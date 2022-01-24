
class 개{
	int 위장;
}

public class Test073{
	public static void main(String[] args){
		개 mary = new 개();
		개 zzong = mary;    // new 개() 를 대입한것과 같음
		개 happy = mary;		// 밥줄 3개
		
		mary.위장 = mary.위장 + 200;
		zzong.위장 += 200;
		happy.위장 += 200;
		
		System.out.println(mary.위장);  // 600
		
		mary = null;   // 밥줄 하나 끊김: 밥줄 2개 남음
		zzong = null;  // 밥줄 1개 남음
		happy = null;  // 밥줄 다끊김 : 유기견 - 자신을 가리키는 포인터가 0개 되는 순간.
		// 그 시점에서 가비지콜렉션은 메모리를 회수한다. 더이상 사용이 되지 않기 때문.
		// C는 free 호출시 곧바로 메모리를 회수하는데 여기는 메모리가 부족할때 한꺼번에 회수한다.
		
		// C는 free 해야할때 안해서 숱하게 에러를 만들어서 java는 그냥 없애버리고 대체수단을 만들었다.
		// 그걸 Garbage Collection 이라고 한다.(java는 스티브잡스가 만든 Objective-C에서 베껴왔다)
		
		// java에서는 free해 줄 필요가 없고, 다만 위와 같이 회수하게 만들 수는 있다.
	}
}