class TempVO {
	public int data = 100;
	public int getData(){ return data; }
}

class Temp2VO extends TempVO {
	public int data = 200;
	public int getData(){ return data; }
}

public class Test292 {
	public static void main( String[] args ) {
		TempVO t = new Temp2VO();
		System.out.println( t.data );
		System.out.println( t.getData() );
		
		Temp2VO t2 = (Temp2VO)t;
		System.out.println( t2.data );
	}
}


/*
	변수에 조상? 함수는 자손?
	거기에 캐스팅을 하고나니까 값이 변한다.
	
	멤버변수는 절대로 public하게 접근하도록 하지 않는다.
	그래서 멤버변수는 private / protected하게 선언한다.
	그럼 어떻게 값을 읽고 쓰지?
	getter함수를 써서 읽고 setter 함수를 써서 쓴다.
	
	public String getData()[return data;}    // getter
	public void setData(String i){return this.data = i;}    // setter
	
	getter는 get+멤버변수명(첫글자 대문자) + 변수와 같은 자료형 리턴타입 + 매개변수 없음
	setter는 set+멤버변수명(첫글자 대문자) + void 리턴타입 + 매개변수는 변수와 같은 자료형
	멤버변수 + getter + setter를 흔히 property 라고 부르기도 한다.
	
	DTO : Data Transfer Object
	VO : Value Object
	둘다 데이터를 담는 용도로 사용한다. 뭘 쓰든지 상관없는데 강의에서는 VO를 쓴다고 한다.
	VO에서는 int 말고 Integer를 사용한다.
	DB에는 int형 필드에 NULL 값이 들어갈 수 있는데 int r = null; 이건 불가능하지만
	Integer r = null; 이건 가능하다. 따라서 DB와 연동되는 VO에는 int double 안쓰고
	Integer, Double을 사용하는 것을 기본으로 한다.
*/