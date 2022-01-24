
import apple.패키지;

public class Test101{
	public static void main(String[] args){
		패키지 t = new 패키지();
		//System.out.println(t.rivate); 접근안됨
		//System.out.println(t.rotected); protected도 접근안됨
		System.out.println(t.ublic);
		//System.out.println(t.riendly);  friendly도 접근안된다
	}
}



/*
	다른 패키지에 있는 클래스를 사용할때는 import 패키지를 사용한다.
	가져다 쓸 클래스가 다른데 있으면 그 위치를 컴파일/실행시 -classpath로 지정해야 한다.
	javac -classpath c:/classes Test101.java
	
	java -classpath .;c:/classes  Test101
	
	Test101.class는 JavaWork에서 찾아야 하니 . 을 경로에 추가한다.
*/