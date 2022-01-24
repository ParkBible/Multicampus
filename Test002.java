public class Test002{
	public static void main( String[] args){
		System.out.println("Helloworld");
	}
}

// public static void main(String[] args)로 main을 안만들면 오류 : 기본 메소드를 정의하십시오 가 뜬다.
// 꼭!! javac 파일명.확장자 로 컴파일 한 뒤에 java 파일명 으로 실행을 한다!

/*
	dir, dir/w : 폴더 아래의 파일과 폴더 목록을 확인하기(/w는 wide로 나옴)
	del 파일명.확장자 : 파일 삭제
	javac : *.java를 읽어들여 *.class 파일을 생성하는 컴파일 작업
	
	main이 없는 클래스는 컴파일은 되어도 실행할 수 없음
	
	System.out.println("HelloWorld");
	- HelloWorld 문장을 출력한다. main 안에 들어있는 코드는 실행된다.
	
	파일이름과 public class 이름은 완전히 일치해야 한다(대소문자까지)
	
*/