// abstract 기법을 이용한 설계의 예시

// 엔진자리를 비우고 일단 만들어 놓자. 엔진은 나중에
abstract class P51{
	abstract public int engine();
	public void fly(){
		System.out.println(engine() + "마력으로 날자");
	}
}

class P51_v1 extends P51{
	public int engine(){    // 엔진 오버라이딩
		return 1400;		// 구닥다리 엔진을 넣는다.
	}
}

class P51_v2 extends P51{
	public int engine(){    // 엔진 오버라이딩
		return 1680;		// 좀 좋은 엔진을 넣는다.
	}
}


public class Test103{
	public static void main(String[] args){
		// P51 t = new P51();   이건 에러...
		P51 t = new P51_v2();
		t.fly();
	}
}

/*
	P-51 머스탱 : 엔진 바꾸고 용된 전투기
*/