package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Test287 {
	public static void main( String[] args ) throws Exception 
	{
		Class.forName("org.mariadb.jdbc.Driver");
		
		Scanner sc = new Scanner( System.in );
		boolean alive = true;
		
		while( alive ) {
			String line = sc.nextLine();
			if( line.equals("quit") ) {
				alive = false;
			} else {
				int idx = line.indexOf(",");
				String no   = line.substring(0,idx);
				String data = line.substring(idx+1);
				
				//	10�ڸ� �Ѱ� �ԷµǾ ��������? close() �ȵȴ�. �״��� ���� �׾��!!!
				Connection conn = null;
				Statement stmt = null;
				try {
					conn = DriverManager.getConnection(
						"jdbc:mariadb://183.111.242.21:3306/pukyung00",
						"pukyung00","pukyung00!!1");
					stmt = conn.createStatement();
					stmt.executeUpdate("INSERT INTO test01_T VALUES ("+no+",'"+data+"')");
				}
				catch( Exception e ) {
					throw e;
				}
				finally {
					if( stmt != null ) stmt.close();
					if( conn != null ) conn.close();										
				}
			}
		}
	}
}
/*	
C:\JavaWork>java -classpath c:\classes;c:\jars\mariadb-java-client-2.5.1.jar banana.Test287
10101,Apple
10202,Banana

-> �̰͵��� test01_T �� �Էµǵ��� �� ����ϴµ� ... 

STEP 1 : �¿찣 ���� 

			else {
				int idx = line.indexOf(",");
				String no   = line.substring(0,idx);
				String data = line.substring(idx+1);
				
				System.out.println( no );
				System.out.println( data );
				
				Class.forName("org.mariadb.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
					"jdbc:mariadb://183.111.242.21:3306/pukyung00",
					"pukyung00","pukyung00!!1");
		
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO test01_T VALUES ("+no+",'"+data+"')");
				stmt.close();
				conn.close();				
			}
			
			
STEP 2 : �� ... ( conn.close() �� �����ؼ� - �̰� ���� ���� ... )

		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung00",
			"pukyung00","pukyung00!!1");
		
		while( alive ) {
			String line = sc.nextLine();
			if( line.equals("quit") ) {
				alive = false;
			} else {
				int idx = line.indexOf(",");
				String no   = line.substring(0,idx);
				String data = line.substring(idx+1);
				
				System.out.println( no );
				System.out.println( data );
				
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO test01_T VALUES ("+no+",'"+data+"')");
				stmt.close();
			}
		}
		
		conn.close();		
		
		���� �ڵ�� ���� �ɱ�???? -- �ƴ�
		
		while( alive ) {
			String line = sc.nextLine();
			if( line.equals("quit") ) {
				alive = false;
			} else {
				int idx = line.indexOf(",");
				String no   = line.substring(0,idx);
				String data = line.substring(idx+1);
				
				//	�� ���� ���ư��� �ξ� ���� �ڵ��!!
				Connection conn = DriverManager.getConnection(
					"jdbc:mariadb://183.111.242.21:3306/pukyung00",
					"pukyung00","pukyung00!!1");
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO test01_T VALUES ("+no+",'"+data+"')");
				stmt.close();
				conn.close();										
			}
		}		
*/

