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
	���������� data �� �а�/����/����/���� �ϴ� ������ �ϴ� �Լ��� DAO ��� Ŭ������ ��Ƽ�
		�Լ� ���·� ����� �ش�. ( Data Access Object ) -- DAO Pattern �̶�� �Ѵ�.
		
	DAO ������ ��Ģ 
	1. DAO �ȿ��� DB �Ǵ� �����Ϳ� ���õ� �ڵ�θ� ä���
	2. ö���ϰ� O-R Mapping ������ �����Ѵ� ( ���̺�:Ŭ���� �ʵ�:������Ƽ ���ڵ�:�ν��Ͻ� )
	3. ����ó���� �Ĳ��ϰ� �ϰ�, �߻��ÿ� �ٽ� �����ִ� ���·� ���� ( ������ ���� close() �ʼ� )
	
	4. SELECT ���� find / select / sel ���� ���ξ �ٿ��� �� �ǹ̸� �˼� �ְ� �ϰ� 
	   ( �� : findByPK , findByOrderNo , findByClassName ... ) : �̸��� ���� �� �� �־�� �Ѵ�.
	5. INSERT �� add / insert / ins ���� ���ξ�
	6. DELETE �� del / remove ���� ���ξ�
	   (  �� : delByPK , removeByName , delByOrderNo ... )
	7. UPDATE �� mod / update / up ���� ���ξ�
	   ( �� : modNickNameByPK , modTheTimeByPK ... )
	8. �� �̿��� ���� ��Ģ�� ������ "�̸��� ���� �� �ϴ� �Լ����� �� �� ���� ����"�� ����� �ش�.

*/
class BangDAO {
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
				"jdbc:mariadb://183.111.242.21:3306/pukyung00",
				"pukyung00","pukyung00!!1");
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
		
		return ls;
	}
	
	
	//	���⼭��?? 
	/*
		Driver loading > conn ���� > stmt ���� > executeQuery / executeUpdate ( ������ SQL �׽�Ʈ )
		> stmt.close() > conn.close()
	*/

	public void add( Bang01VO pvo ) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung00",
				"pukyung00","pukyung00!!1");
			stmt = conn.createStatement();

			String sql = "INSERT INTO bang01_T VALUES ( default, '"+
				pvo.getContent() + "', NOW() , '" + pvo.getAuthor() + "')";
			stmt.executeUpdate( sql );
		}
		catch ( Exception e ) {
			throw e;			
		}
		finally {
			if( stmt != null ) stmt.close();
			if( conn != null ) conn.close();
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
			
			dao.add( pvo );	//	���̺� �Էµǰ� �������� ¥����
			
			//	SELECT ����� List<Bang01VO> ��Ƽ� �����ϴ� ���·� �����ϴ� �Լ�
			List<Bang01VO> ls = dao.findAll();
			
			for( Bang01VO vo : ls ) {
				System.out.println( vo.getNo() + "," + vo.getContent() );
			}
		}
		catch( Exception e ) {
			System.out.println( e.toString() );
		}
	}
}
/*
			List<Bang01VO> ls = new ArrayList<Bang01VO>();
			

*/