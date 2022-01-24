class 배째기 extends RuntimeException{}
class 등따기 extends RuntimeException{}

class 신입{
	public void 일(int 시간당){
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


public class Test175{
	public static void main(String[] args){
		신입 kim = new 신입();
		kim.일(4);
		System.out.println("수고했습니다");
	}
}

// try ~ catch 없어도 컴파일은 되더라. 물론 실행하다 에러나면 프로그램은 죽지만
// 예외가 발생하면 그 이하의 코드는 수행하지 않는다.(거기서 프로그램 끝난다) - 끝났습니다, 수고했습니다 안수행함
// try ~ catch 하면 그 이하의 코드(수고했습니다)도 수행한다.
