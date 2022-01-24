package banana;

import java.sql.*;

public class Test284 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17", "pukyung00!!1");
			
		System.out.println(conn.toString());
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT NOW()");
		
		if(rs.next()){
			String l = rs.getString(1);
			System.out.println(l);
		}
		
		rs.close();
		stmt.close();
		
		conn.close();
	}
}

/*
	컴파일 -> 배치파일 생성 -> connection -> statement -> ResultSet
	Class.forName("org.mariadb.jdbc.Driver");
	-- 문자열 이름의 클래스를 찾는다.
	
	java -d c:\classes Test284
	java -classpath c:\classes;c:\jars\mariadb-java-client-2.5.1.jar banana.Test284
	classpath에는 복수의 폴더 또는 파일을 지정할 수 있고, 구분은 윈도우은 ; 유닉스는 :
	
	*.jars는 뭔가요 ? -- *.class 파일을 체계적으로 압축한 파일.
	
	일반적으로 개발한 결과는 *.jar 형태로 배포하게 된다.
	배포된 jar 파일을 사용하기 위해서는 -classpath에서 해당 파일을 지정하면 된다.
	(컴파일시 & 실행시)
	
	
		Connection conn = DriverManager.getConnection(
		"jdbc:mariadb://183.111.242.21:3306/pukyung17",
		"pukyung17","pukyung00!!1");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT NOW()");
		
		if(rs.next()){
			String l = rs.getString(1);
			System.out.println(l);
		}
		
		rs.close();
		stmt.close();
		
		System.out.println(conn.toString());
		conn.close();
*/

/*
MySQL은 하나의 서버에 여러개의 database 둘 수 있음.
database 생성원한 없으니까 지금 있는거 쓴다.
CREATE TABLE temp_02T(
	id INT NULL,
	data VARCHAR(9) NULL
);

INSERT INTO temp_02T VALUES(100, '홍길동');
--INSERT :  가로 한 열 입력

SELECT * FROM temp_02T;
--SELECT :  내용 조회

UPDATE temp_02T SET id = 300;
--UPDATE : 입력되어 있는 데이터를 변경

DELETE FROM temp_02T;
--DELETE : 입력된 데이터를 삭제

VARCHAR(9) : UTF-8 문자셋에서는 한글1글자=영문3글자.

테이블의 세로를 Column / Field 라고 한다.
이것의 자료형은 테이블 생성시 부여하고, 변경 불가함.
가로 한줄은 Row / Record 라고 한다.
이것은 입력의 단위가 된다.

INSERT INTO temp_02T VALUES(123,'박길동');
-- 한줄을 넣는다. 입력의 기본은 한 줄이다.
하나의 대상? 에 대한 자료의 묶음이 된다.

이렇게 레코드/필드 개념이 있는 표 형태의 기억공간을 테이블이라고 한다.

엑셀 시트는 이것저것 섞여서 들어갈 수 있다

SELECT * FROM temp_02T WHERE data = '고길동';
-- WHERE는 SELECT UPDATE DELETE 명령이 수행되는 레코드를 제한한다.

SELECT * FROM temp_02T WHERE data = '고길동' OR id = 300;

DELETE FROM temp_02T WHERE id2 = 200;

UPDATE temp_02T SET id = id + 1;
-- 업데이트할 때 기존의 값을 이용하는 것도 가능하다!
UPDATE temp_02T SET id = id + 1 WHERE id = 101;
같지 않다는 !=, <> 둘다 써도 된다.
SELECT * FROM temp_02T WHERE id BETWEEN 301 AND 401;
id >= 301 and id <= 401 과 동일하다.

*/