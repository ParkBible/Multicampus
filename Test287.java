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
				
				
				// 10�ڸ� �Ѱ� �ԷµǾ �������� close()�� �ȵȴ�. �״��� ���� �׾�� ��!
				// connection���� try catch finally ���� ����Ѵ�.
				
				Connection conn = null;
				Statement stmt = null;
				
				try{
					conn = DriverManager.getConnection(
						"jdbc:mariadb://183.111.242.21:3306/pukyung17",
						"pukyung17", "pukyung00!!1");
					stmt = conn.createStatement();
					//stmt.executeUpdate("INSERT INTO test01_T VALUES (10101,'Apple')");
					// ���ڿ��� �յڿ� ''�� �ٿ���� �Ѵ�
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
	Connection ������ �������ӿ� ������ �ִ� ���� �� �� �ִ�. ������ ��������� �Ѵ�.
	�׷��� �ݵ�� Connection�� ����Ŀ� close() ���־�� �Ѵ�.
	
	�ֳ�! Connection�� ������ ��� �۾��̴�.
	11���� �ݼ��Ϳ� ��ȭ�� �ؼ� 8�ð��� �λ� �ϼҿ��ϴ� ���� �ִٸ� ���ذ� �����ϴ�.
	������ ���ְ� ����ߴµ�...
	�׷��� ���� ������� ���� ���´�!
	
	11���� �ݼ��Ϳ� ��ȭ�ؼ� ����Ǹ� �װ� connection�� �̷���� �Ϳ� ������ �� �ְ�,
	��ȭ�� ���°� conn.close()�� �ش��Ѵ�. -> ����� �������� ���� ���� �� �ְ��!
	
	statement�� �������̽��̴�. (Driver�� �Ʒ����� �˾Ƽ� �� ���ְ� ����)
	statement �� conn�� Ÿ�� SQL���� �Ǿ� ������ �ٱ��϶�� ���� �ȴ�.
	SQL ������ �Ǿ� ������ > DB�� ������ > ���� ����� �޾Ƽ� > ���ƿ´�.
	�ϳ��� SQL ������ �ϳ��� Statement�� �����Ѵ� ��� �� �� �ִ�.


CREATE TABLE test01_T(
			no INT,
			data VARCHAR(10)
);

10101,Apple
10102,Banana
�̶�� ġ��
�̰͵��� test01_T�� �Էµǵ��� �ؾ� �Ѵ�.
	
*/