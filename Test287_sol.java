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
				
				//	10자리 넘게 입력되어서 에러나면? close() 안된다. 죽더라도 끊고 죽어라!!!
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

-> 이것들이 test01_T 에 입력되도록 해 줘야하는데 ... 

STEP 1 : 좌우간 들어가게 

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
			
			
STEP 2 : 잘 ... ( conn.close() 에 주의해서 - 이게 무슨 얘길까 ... )

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
		
		위의 코드는 잘한 걸까???? -- 아뇽
		
		while( alive ) {
			String line = sc.nextLine();
			if( line.equals("quit") ) {
				alive = false;
			} else {
				int idx = line.indexOf(",");
				String no   = line.substring(0,idx);
				String data = line.substring(idx+1);
				
				//	이 쪽이 돌아가도 훨씬 좋은 코드다!!
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

