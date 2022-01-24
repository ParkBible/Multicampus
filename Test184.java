package banana;

import static banana.Temp.print;

class Temp{
	public static void print(){
		System.out.println("print");
	}
}

/*
	static import는 대상이 class가 아니라 class 안에 선언된 static 함수이고
	마치 c에서 함수호출 하듯이 static한 함수를 함수명만으로 호출할 수 있다.(jdk 1.5이후)
*/

public class Test184{
	public static void main(String[] args){
		print();
	}
}

/*
	복잡한 콘솔상의 명령어를 파일로 만들어놓고 수행하는 것
	윈도우에서는 배치파일( *.bat ), 유닉스에서는 쉘 프로그래밍( *.sh )
	
	@ECHO OFF
	REM cmd창에다가 c라고만 쳐도 이 모든 명령이 수행된다.
	REM c.bat (이거는 주석임) 여기선 슬래시를 쓴다. ECHO OFF라고 치면 무슨 명령인지 안나온다. 그리고 앞에 골뱅이치면 ECHO OFF도 안나옴
	REM ECHO ON 해주면 그 밑에 줄들은 나옴.
	REM %1 : 배치파일 실행시 외부에서 전달되는 첫번째 인자값. 예를들어 c Test184 라고 하면 %1은 Test184. 

	REM 이건 변수선언.
	SET CPATH=c:/classes

	@ECHO ON
	javac -d %CPATH% %1.java
	java -classpath c:/classes banana.%1
	
*/