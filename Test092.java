
public class Test092{
	public static void main(String[] args){
		String l = null;
		String t = "HelloWorld";
		System.out.println(t.startsWith("Apple"));
		System.out.println(t.endsWith("ld"));
		
		int i;
		i = t.indexOf("l");    // int indexOf(str) 인 클래스가 문서에 정의되어있다!
		System.out.println(i);   // 처음나온 인덱스 번호(2)
		
		int ii;
		ii = t.lastIndexOf("l");    // 마지막으로 나온 인덱스 번호(8)
		System.out.println(ii);
		
		String i3 = t.substring(2, 4);   // ll이 출력. 2~3번째 인덱스에 해당하는 문자열 출력
		System.out.println(i3);
	}
}

/*
	C:\apiDocs\docs\api\index.html 에 자바의 클래스들이 있다.
	
	<클래스로 할 수 있는 것>
	1. 참조형 변수 선언 String l = null;  // 참조형 변수는 null이 들어감.
	2. 인스턴스 생성
	3. 클래스를 상속받아 클래스를 선언(상속은 이것뿐)
	
	선언 타입에 따라 참조형 변수 아니면 자료형 변수인데 null이 들어갈 수 있는 건 참조형 변수이다.
	따라서 String 으로 선언한 함수는 참조형 변수이다.
	
	그래서 String t = "HelloWorld"; 는 사실 인스턴스이다.
	new를 안 썼는데도 인스턴스라고??? -> new를 안 써도 되는 클래스는 String이 유일함.
*/