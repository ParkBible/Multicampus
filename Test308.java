package banana;

import java.sql.*;

/*
	Ʈ�������� �Ѳ����� ��Ƽ� �����ϴ� �����ΰ���?
	-- �Ѳ����� �ݿ��ϰų� ����ϴ� ������ �´µ� ��Ƽ� �����Ѵ� ������� �� �Ÿ��� �ִ�.
	   ��Ƽ� �����ϴ� ���� : BatchUpdate ����.
	   
*/

public class Test308 {
	public static void main( String[] args ) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			stmt = conn.createStatement();
			
			String sql1 = "UPDATE Text_HT SET recom = recom + 1 WHERE no = 2";
			String sql2 = "INSERT Recom_HT VALUES (3, 'Apple')";
			// �ݿ��� �ȵǰ��ִ�. �����ϴ� ����� �ƴ϶� �������� �״� ����̱� ����.
			stmt.addBatch(sql1);    
			stmt.addBatch(sql2);
			
			// ���� �����ϰ� ��Ƽ� ���ƿ���� ���. (������ �Ѳ����� �����Ѵ�.)
			stmt.executeBatch();
		}
		catch(Exception e){
			throw e;
		}
		finally{
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
	}
}
/*


*/