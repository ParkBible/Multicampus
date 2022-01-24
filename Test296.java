package banana;

import java.sql.*;
import java.util.*;


class Bang01VO 
{
	private Integer no = null;
	public Integer getNo(){ return this.no; }
	public void setNo( Integer i ){ this.no = i; }
	
	private String content = null;
	public String getContent(){ return this.content; }
	public void setContent( String i ){ this.content = i; }
	
	private String theTime = null;
	public String getTheTime(){ return this.theTime; }
	public void setTheTime( String i ){ this.theTime = i; }
	
	private String author = null;
	public String getAuthor(){ return this.author; }
	public void setAuthor( String i ){ this.author = i; }
}

/*
	���������� �����͸� �а�/����/����/�����ϴ� ���Ҥ��� �ϴ� �Լ��� DAO ��� Ŭ������ ��Ƽ� �Լ� ���·� �����.
	(Data Access Object) -- DAO �����̶�� �Ѵ�.
	��Ģ
	1. DAO �ȿ��� DB �Ǵ� �����Ϳ� ���õ� �ڵ�θ� ä����
	2. ö���ϰ� O-R ���� ������ �����Ѵ�.(���̺�:Ŭ����, �ʵ�:������Ƽ, ���ڵ� : �ν��Ͻ�)
	3. ����ó���� �Ĳ��ϰ� �ϰ�, �߻��ÿ� �ٽ� �����ش�.
	4. SELECT ���� find / select / sel ���� ���ξ �ٿ��� �� �ǹ̸� �˼� �ְ� �Ѵ�.
	(�� : findByPK, findByOrderNo)
	5. INSERT�� add / insert / ins ���� ���ξ�
	6. DELETE�� del / remove ��
	7. UPDATE�� mod / update / up ��
	(�� : modNickNameByPK)
*/

class BangDAO{
	public List<Bang01VO> findAll() throws Exception
	{
		List<Bang01VO> ls = new ArrayList<Bang01VO>();
			//	� ��Ȳ������ close() �� ����ǵ��� ����ó�� & ������ ���� �ް� �ٽ� ������ ���� ����
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
				"jdbc:mariadb://183.111.242.21:3306/pukyung17",
				"pukyung17","pukyung00!!1");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM bang01_T");
			while( rs.next() ) {
				Bang01VO vo = new Bang01VO();
				vo.setNo( rs.getInt("no") );
				vo.setContent( rs.getString("content") );
				vo.setTheTime( rs.getString("the_time") );
				vo.setAuthor( rs.getString("author") );
				ls.add( vo );
			}
		}
		catch( Exception e ) {
			throw e;
		}
		finally {
			if( rs != null ) rs.close();
			if( stmt != null ) stmt.close();
			if( conn != null ) conn.close();
		}
		
		for( Bang01VO vo : ls ) {
			System.out.println( vo.getNo() + "," + vo.getContent() );
		}
			
			
		return ls;
	}
	public void add(Bang01VO pvo) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			stmt = conn.createStatement();
			
			// �������� putty���� �׽�Ʈ�� ���� �Ѵ�.
			// INSERT INTO bang01_T VALUES (default, 'Gozila', NOW(), 'gozila')
			String sql = "INSERT INTO bang01_T VALUES (default, '" + pvo.getContent() + "', NOW(), '" + pvo.getAuthor() +"')";
			stmt.executeUpdate(sql);
		}
		
		catch(Exception e){
			throw e;
		}
		
		finally{
			stmt.close();
			conn.close();
		}
		
	}
}

public class Test296 {
	public static void main( String[] args )
	{
		BangDAO dao = new BangDAO();
		try {
			Bang01VO pvo = new Bang01VO();
			pvo.setContent("DAO Content");
			pvo.setAuthor("daoAuthor");
			
			dao.add(pvo);    // ���̺��� �Էµǰ� �������� ¥����
			// select ����� List<Bang01VO>�� ��Ƽ� �����ϴ� ���·� �����ϴ� �Լ�
			
			List<Bang01VO> ls = dao.findAll();
			
		}
		catch( Exception e ) {
			System.out.println( e.toString() );
		}
	}
}
/*
			List<Bang01VO> ls = new ArrayList<Bang01VO>();
			
			//	� ��Ȳ������ close() �� ����ǵ��� ����ó�� & ������ ���� �ް� �ٽ� ������ ���� ����
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection(
					"jdbc:mariadb://183.111.242.21:3306/pukyung17",
					"pukyung17","pukyung00!!1");
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM bang01_T");
				while( rs.next() ) {
					Bang01VO vo = new Bang01VO();
					vo.setNo( rs.getInt("no") );
					vo.setContent( rs.getString("content") );
					vo.setTheTime( rs.getString("the_time") );
					vo.setAuthor( rs.getString("author") );
					ls.add( vo );
				}
			}
			catch( Exception e ) {
				throw e;
			}
			finally {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			}
			
			for( Bang01VO vo : ls ) {
				System.out.println( vo.getNo() + "," + vo.getContent() );
			}
*/