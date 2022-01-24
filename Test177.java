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


public class Test177{
	public static void main(String[] args){
		신입 kim = new 신입();
		
		try{
			kim.일(4);
			System.out.println("수고했습니다");
		}
		catch(Exception e){    // 배째기를 Exception으로 바꾸면 배째기와 등따기 모두에 대해서 동작한다.
								// RuntimeException으로는 못바꾼다. 배째기가 상속받은 Exception의 자손 클래스이기 때문(거꾸로는 가능)
			System.out.println("통합대책 " + e.getClass().getName());    // 통합대책 배째기 or 통합대책 등따기
		}
		System.out.println("오늘 업무 끝");
	}
}

/*
	Exception e = new 배째기(); 가 가능하면 잡는다.
	즉 catch에 선언된 매개변수(?)가 위에서 throw한 예외 인스턴스를 가리킬 수 있을때 잡는다.
	
	Exception 대신 Throwable을 쓸 수 있다. 이는 Exception의 조상 클래스.
	예외상황이 아닌 경우에도 try catch를 이용한 코드를 만들어야 할 때가 있기 때문에 쓴다.
	모든 try catch를 쓰는 경우에는 Throwable로 상속받고 그중 예외상황은 Exception을 상속받는다.
	RuntimeException은 Exception을 상속받는다.
	
	Throwable(왕조상) 모든 try catch - Exception(조상) 그중 예외상황 - RuntimeException 널널
*/