class 배째기 extends Exception{}
class 등따기 extends Exception{}

class 신입{
	
	// 해당 예외를 발생시킬 수 있음을 이런 식으로 선언부에 명시한다.(throws 배째기, 등따기)
	public void 일(int 시간당) throws 배째기, 등따기{
		System.out.println("넹넹");
		double i = Math.random();    // !!
		if(시간당 < 7 && i < 0.3){
			throw new 배째기();    // !! 오류가 발생한 것.
		}
		else if(시간당 < 5 && i < 0.3){
			throw new 등따기();     
		}
		System.out.println("끝났습니다");
	}
}


public class Test176{
	public static void main(String[] args){
		신입 kim = new 신입();
		
		try{
			kim.일(4);
			System.out.println("수고했습니다");
		}
		catch(배째기 e){
			System.out.println("꿰멘다");
		}
		catch(등따기 e){
			System.out.println("119");
		}
		System.out.println("오늘 업무 끝");
	}
}

/*
	RuntimeException : 문법적으로 널널하다.
	Exception : 엄격하다.
	
	Exception을 상속받은 예외를 발생할 수 있는 함수는 선언부에 반드시 그 사실을 명시해야 한다.
	근데 RuntimeException은 해도 되고 안해도 된다. : throws 배째기, throws 등따기
	선언부에 예외발생 가능성이 명시된 함수는 반드시 해당 에러를 처리할 수 있는
	try ~ catch 영역 안에서 호출해야 한다.
	
	이런 식으로 꽤 정교하게 에러에 대비한 코드를 작성할 수 있구나 하는 걸 볼 수 있다.
	수고했습니다, 오늘 업무 끝 이 언제 출력되는지 점검한다.
	>>
	넹넹
	끝났습니다
	수고했습니다
	오늘 업무 끝
	
	>>
	넹넹
	꿰멘다
	오늘 업무 끝
*/