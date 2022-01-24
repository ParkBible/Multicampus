/*	
	178 코드에 대한 답! ( 코드와 개념은 꼭 함께 외우도록 하세요. 그게 젤 싸게 먹힙니다 )
*/

class FuelException extends Exception {}
class BreakException extends Exception {}

class Car {
	private int fuel = 5;
	public void drive( boolean stopper ) throws FuelException, BreakException {
		fuel--;
		if( fuel == 1 ) {
			throw new FuelException();
		}
		if( stopper == false ) {
			throw new BreakException();
		}
		System.out.println("연료 1리터 소모 : GOGO");
	}
}

public class Test179 {
	public static void main( String[] args ) {
		Car car =  new Car();
		
		//관리자
		try
		{
			// 사수
			try {
				// 신입
				car.drive( true );
				car.drive( true );
				car.drive( false );    // 오류 발생
			}
			catch( Exception e ) {
				System.out.println( "처리 : " + e.toString() );
				throw e;    // 사수가 처리
			}
			//System.out.println("...");    // 안찍힘
			finally {
				System.out.println("....");    // 예외가 발생하든, 안하든 무조건 실행.(finally)
			}
		}
		catch(Exception e){
			System.out.println("recoding : " + e.toString());    // 관리자(부장)는 사수의 실책을 기록
		}
	}
}