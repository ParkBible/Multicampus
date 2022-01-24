package banana;

import java.sql.*;

/*
	BatchUpdate & PreparedStatement �� ���� �� ��.
	   
*/

public class Test309 {
	public static void main( String[] args ) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			
			/*
				���⼭ ������ stmt�� �� �Ѱ���
				stmt.addBatch();�� �� 5�� �ߴ�. �̰� 5���� SQL���� ž��Ǿ��ٴ� �ǹ��ε�
				�ϳ��� Statement �ν��Ͻ��� 5���� SQL ������ �����Ű�°� ���� �ǳ�?
				
				���� ���ڵ带 �Ѳ����� �����ϴ� ��쿡 �Ѳ����� ��Ƽ� ó���ϴ°� ������ ����.
			*/
			//stmt = conn.createStatement();
			String sql2 = "INSERT temp14_T VALUES (?, 'K')";
			stmt = conn.prepareStatement(sql2);    // �ν��Ͻ��� �ϳ� ����
			for(int i=10; i<15; i++){    // 5�� ����?
				stmt.setInt(1, i);  //����
				stmt.addBatch();     //�ױ�
				stmt.clearParameters();    // �տ��� �����ߴ� setInt ���� ���� ���Ӱ� ���� �޵��� ������.
			}
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