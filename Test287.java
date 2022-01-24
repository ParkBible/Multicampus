package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Test287{
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		boolean alive = true;
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		while(alive){
			String line = sc.nextLine();
			
			if(line.equals("quit")){
				alive = false;
			} else{
				int i = line.indexOf(",");
			
				String data = line.substring(0, i);
				String name = line.substring(i+1, line.length());
				
				
				// 10자리 넘게 입력되어서 에러나면 close()가 안된다. 죽더라도 끊고 죽어야 함!
				// connection에는 try catch finally 문을 사용한다.
				
				Connection conn = null;
				Statement stmt = null;
				
				try{
					conn = DriverManager.getConnection(
						"jdbc:mariadb://183.111.242.21:3306/pukyung17",
						"pukyung17", "pukyung00!!1");
					stmt = conn.createStatement();
					//stmt.executeUpdate("INSERT INTO test01_T VALUES (10101,'Apple')");
					// 문자열은 앞뒤에 ''를 붙여줘야 한다
					stmt.executeUpdate("INSERT INTO test01_T VALUES (" + data + ",'" + name + "')");
					//System.out.println(line);
				}

				catch( Exception e ) {
					throw e;
				}
				finally {
					if( stmt != null ) stmt.close();
					if( conn != null ) conn.close();										
				}
				
				System.out.println(data);
				System.out.println(name);
	
				
				
				
				
				
				
				stmt.close();
				conn.close();
			}
			
		}
	
	}
}

/*
	Connection 생성시 소켓접속용 정보를 주는 것을 볼 수 있다. 실제로 소켓통신을 한다.
	그래서 반드시 Connection은 사용후에 close() 해주어야 한다.
	
	왜냐! Connection은 굉장히 비싼 작업이다.
	11번가 콜센터에 전화를 해서 8시간을 인생 하소연하는 고객이 있다면 손해가 막심하다.
	직원을 돈주고 고용했는데...
	그래서 빨리 끊어줘야 돈이 굳는다!
	
	11번가 콜센터에 전화해서 연결되면 그게 connection이 이루어진 것에 비유할 수 있고,
	전화를 끊는게 conn.close()에 해당한다. -> 용건이 끝났으면 빨리 끊는 게 최고다!
	
	statement도 인터페이스이다. (Driver가 아래에서 알아서 다 해주고 있음)
	statement 는 conn을 타고 SQL문을 실어 나르는 바구니라고 보면 된다.
	SQL 문장을 실어 나르고 > DB에 떨구고 > 동작 결과를 받아서 > 돌아온다.
	하나의 SQL 문장은 하나의 Statement로 실행한다 라고 볼 수 있다.


CREATE TABLE test01_T(
			no INT,
			data VARCHAR(10)
);

10101,Apple
10102,Banana
이라고 치면
이것들이 test01_T에 입력되도록 해야 한다.
	
*/