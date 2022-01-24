package banana;

import java.sql.DriverManager;
import java.sql.Connection;

public class Test285{
	public static void main(String[] args) throws Exception{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17", "pukyung00!!1");
		
		System.out.println(conn.toString());
		
		/*
			conn이 가리키는 인스턴스는 org.mariadb.jdbc.MariaDbConnection 의 인스턴스.
			패키지가 보면? org.mariadb.jdbc 위에랑 같다.
			
			Connection은 실은 인터페이스이다(함수 선언만 있다)
			그것을 상속받아 mariadb에 접속을 수행하는 클래스가 MariaDbConnection.
			183.111.242.21:3306 - 소켓을 이용한다.
			
			Connection을 상속받으면서 MariaDbConnection을 제공하도록 그 밑작업을 해 주는 코드가
			Class.forName("org.mariadb.jdbc.Driver"); 이고 "Driver를 로딩했다 라고 이야기한다."
			
			왜 이렇게 해야하나?
			소싯적 컴은 그래픽 카드 교체는 꿈도 못꾸던 시절이다..
			IBM PC와 MS window가 나오면서 시대가 변하더라.
			
			윈도우에서는 그래픽 카드 교체하면 드라이버를 설치하고 윈도우 안깔아도 된다.
			
			과거에는 애플리케이션이 직접 HW 코드를 호출해서 모니터에 그래픽을 보였다.
			이 경우 HW 교체는 꿈도못꾼다. 하드웨어는 바뀌었는데 호출은 같이 하면? 동작 안할거다.
			
			이 개념을 MS에서는 드라이버라는 개념으로 해결을 했다. 인터페이스를 이용한다
			인터페이스를 상속하고 하드웨어에 접속하는 클래스를 드라이버라고 한다/
			하드웨어가 변경되면 그에 맞는 드라이버만 OS에 설치하면 애플리케이션은 그대로 두어도 같은 동작을 보여주게 된다.
			하드웨어를 애플리케이션이 직접 건드리는 것에 비해 속도가 느리다는 단점
			초창기 윈도우에 슈팅게임이 없고 프리셀 지뢰찾기가 있게 된 이유 : 그래픽 속도가 느려서.
			고속으로 동작하는 하드웨어에 맞게 인터페이스 구조를 재 설계 : DirectX
			게임하려면 이거 설치하라는 얘기가 수두룩하게 나올거다...
			
			어플리케이션은 인터페이스만 보고 프로그래밍하고, 실제로 접속하는 건 드라이버가 한다.
			드라이버 개념을 데이터베이스에 적용한 게 ODBC. 하지만 이런저런 이유로 거의 실패
			
			ODBC > DAO (Data Access Object) > RDO
			현재 그리고 앞으로의 MS 데이터 접속 기술은 ADO이다.(ADO.NET이 그거)
			
			ADO와 JDBC가 같다고 보면 된다.
			어플리케이션 개발자는 인터페이스만 보고 코딩한다.(Connection 같은거)
			실제로 접속을 행하는 것은 Driver 이다. 그 드라이버가 mariadb-java-client-2.5.1.jar 파일이다.
			
			즉!!
			오라클로 DB가 변경되어도 많이 다시 짤 필요가 없다. 인터페이스만 보고 코딩했으니...
			DB가 변경돼도 드라이버만 바꾸면 애플리케이션은 바꿀 필요가 별로 없다.
			제일 먼저 해줘아 하는것이 드라이버 로딩이다. 그게 없으면 껍데기만 보고 코드짜는 셈이 된다.
		*/
		conn.close();
		
	
	}
}

/*
	Class.forName("..."); -- 해당 이름의 클래스를 메모리에 로딩
	org.mariadb.jdbc.Driver -- 클래스가 없어서 에러남.
	
	javac -d c:\classes Test285.java
	java -classpath c:\classes;c:\jars\mariadb-java-client-2.5.1.jar banana.Test285
*/