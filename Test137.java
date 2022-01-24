
/*
		static initializer : 인스턴스 생성 이전에 딱 한번 호출된다.
		(클래스가 메모리에 로딩되는 시점)
		
		C언어보다 빠르고 메모리를 효율적으로 쓰는 프로그램을 만드는 언어는 없다.
		(자바는 객체 지향 언어의 장점을 살린 언어이지, 성능으로는 C를 못따라간다.)
		
		C언어로 만든 *.exe 파일은 독자적으로 실행이 가능하지만 *.class는 독자적으로 실행 불가능.
		*.class 파일은 JRE(자바 실행환경)이 있어야 실행 가능하다.
		
		C언어로 만든 exe는 다른 OS에서 실행 불가능.
		하지만 java로 만든 class는 jvm이 깔려있다면 어느 환경에서든 곧바로 실행 가능하다!
		
		'jvm만 깔려 있다면 컴퓨터가 아니라도 동작 가능한건가요?'
		맞다. 원래 자바는 각종 전자기기에서 동작하도록 만들어졌다.
		
		지금 이 파일을 컴파일하면 클래스파일이 몇개 생길까요?
		실행할때는 java Test137 이렇게 했다. 처음 실행시에 Temp.class도 쓸까??
		처음에는 Test137.class만 쓰지만 실행하다 보니 new Temp(); 이 시점에서 Temp.class 파일이 필요해지더라.
		Temp.class는 하드디스크에 있다.
		new Temp()를 만나면 Temp.class가 필요해지고 이때 Temp.class는 메모리에 로딩되어야 한다.
		
		이 시점에서 static initializer가 호출된다.
		만일 jvm이 한번 로딩된 클래스는 별 문제 없다면 메모리에 유지되는 정책을 쓴다면??
		
		인스턴스를 아무리 많이 만들어도 클래스는 딱 한번만 로딩된다.
		그래서 static도 딱 한번만 나오는 것.
		인스턴스를 만들 때 멤버변수와 멤버함수를 가리키는 함수포인터는 메모리를 할당받게 된다.
		클래스가 로딩되는 시점에서는 멤버변수, 멤버함수는 호출 불가능하다.(이 시점에선 존재하지 않기 때문)
	*/


class Temp{
		
	static {
		System.out.println("static");
	}
	
	Temp(){    // 생성자는 인스턴스가 호출될 때 호출된다.
		System.out.println("생성");
	}
}

public class Test137{
	public static void main(String[] args){
		new Temp();
		new Temp();
		new Temp();
	}
}