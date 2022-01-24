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
			conn�� ����Ű�� �ν��Ͻ��� org.mariadb.jdbc.MariaDbConnection �� �ν��Ͻ�.
			��Ű���� ����? org.mariadb.jdbc ������ ����.
			
			Connection�� ���� �������̽��̴�(�Լ� ���� �ִ�)
			�װ��� ��ӹ޾� mariadb�� ������ �����ϴ� Ŭ������ MariaDbConnection.
			183.111.242.21:3306 - ������ �̿��Ѵ�.
			
			Connection�� ��ӹ����鼭 MariaDbConnection�� �����ϵ��� �� ���۾��� �� �ִ� �ڵ尡
			Class.forName("org.mariadb.jdbc.Driver"); �̰� "Driver�� �ε��ߴ� ��� �̾߱��Ѵ�."
			
			�� �̷��� �ؾ��ϳ�?
			�ҽ��� ���� �׷��� ī�� ��ü�� �޵� ���ٴ� �����̴�..
			IBM PC�� MS window�� �����鼭 �ô밡 ���ϴ���.
			
			�����쿡���� �׷��� ī�� ��ü�ϸ� ����̹��� ��ġ�ϰ� ������ �ȱ�Ƶ� �ȴ�.
			
			���ſ��� ���ø����̼��� ���� HW �ڵ带 ȣ���ؼ� ����Ϳ� �׷����� ������.
			�� ��� HW ��ü�� �޵����۴�. �ϵ����� �ٲ���µ� ȣ���� ���� �ϸ�? ���� ���ҰŴ�.
			
			�� ������ MS������ ����̹���� �������� �ذ��� �ߴ�. �������̽��� �̿��Ѵ�
			�������̽��� ����ϰ� �ϵ��� �����ϴ� Ŭ������ ����̹���� �Ѵ�/
			�ϵ��� ����Ǹ� �׿� �´� ����̹��� OS�� ��ġ�ϸ� ���ø����̼��� �״�� �ξ ���� ������ �����ְ� �ȴ�.
			�ϵ��� ���ø����̼��� ���� �ǵ帮�� �Ϳ� ���� �ӵ��� �����ٴ� ����
			��â�� �����쿡 ���ð����� ���� ������ ����ã�Ⱑ �ְ� �� ���� : �׷��� �ӵ��� ������.
			������� �����ϴ� �ϵ��� �°� �������̽� ������ �� ���� : DirectX
			�����Ϸ��� �̰� ��ġ�϶�� ��Ⱑ ���η��ϰ� ���ðŴ�...
			
			���ø����̼��� �������̽��� ���� ���α׷����ϰ�, ������ �����ϴ� �� ����̹��� �Ѵ�.
			����̹� ������ �����ͺ��̽��� ������ �� ODBC. ������ �̷����� ������ ���� ����
			
			ODBC > DAO (Data Access Object) > RDO
			���� �׸��� �������� MS ������ ���� ����� ADO�̴�.(ADO.NET�� �װ�)
			
			ADO�� JDBC�� ���ٰ� ���� �ȴ�.
			���ø����̼� �����ڴ� �������̽��� ���� �ڵ��Ѵ�.(Connection ������)
			������ ������ ���ϴ� ���� Driver �̴�. �� ����̹��� mariadb-java-client-2.5.1.jar �����̴�.
			
			��!!
			����Ŭ�� DB�� ����Ǿ ���� �ٽ� © �ʿ䰡 ����. �������̽��� ���� �ڵ�������...
			DB�� ����ŵ� ����̹��� �ٲٸ� ���ø����̼��� �ٲ� �ʿ䰡 ���� ����.
			���� ���� ����� �ϴ°��� ����̹� �ε��̴�. �װ� ������ �����⸸ ���� �ڵ�¥�� ���� �ȴ�.
		*/
		conn.close();
		
	
	}
}

/*
	Class.forName("..."); -- �ش� �̸��� Ŭ������ �޸𸮿� �ε�
	org.mariadb.jdbc.Driver -- Ŭ������ ��� ������.
	
	javac -d c:\classes Test285.java
	java -classpath c:\classes;c:\jars\mariadb-java-client-2.5.1.jar banana.Test285
*/