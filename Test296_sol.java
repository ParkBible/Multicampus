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
	실전에서는 data 를 읽고/쓰고/수정/삭제 하는 역할을 하는 함수는 DAO 라는 클래스에 모아서
		함수 형태로 만들어 준다. ( Data Access Object ) -- DAO Pattern 이라고 한다.
		
	DAO 패턴의 원칙 
	1. DAO 안에는 DB 또는 데이터와 관련된 코드로만 채운다
	2. 철저하게 O-R Mapping 개념을 적용한다 ( 테이블:클래스 필드:프로퍼티 레코드:인스턴스 )
	3. 예외처리를 꼼꼼하게 하고, 발생시에 다시 던져주는 형태로 구현 ( 에러가 나도 close() 필수 )
	
	4. SELECT 문은 find / select / sel 등의 접두어를 붙여서 그 의미를 알수 있게 하고 
	   ( 예 : findByPK , findByOrderNo , findByClassName ... ) : 이름만 보고 알 수 있어야 한다.
	5. INSERT 는 add / insert / ins 등의 접두어
	6. DELETE 는 del / remove 등의 접두어
	   (  예 : delByPK , removeByName , delByOrderNo ... )
	7. UPDATE 는 mod / update / up 등의 접두어
	   ( 예 : modNickNameByPK , modTheTimeByPK ... )
	8. 그 이외의 경우는 원칙은 없지만 "이름만 보고서 뭐 하는 함수인지 알 수 있을 정도"로 만들어 준다.

*/
class BangDAO {
	public List<Bang01VO> findAll() throws Exception 
	{
		List<Bang01VO> ls = new ArrayList<Bang01VO>();

		//	어떤 상황에서도 close() 가 실행되도록 예외처리 & 에러가 나면 받고 다시 던지는 형태 포함
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
	
	
	//	여기서는?? 
	/*
		Driver loading > conn 생성 > stmt 생성 > executeQuery / executeUpdate ( 이전에 SQL 테스트 )
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
			
			dao.add( pvo );	//	테이블에 입력되게 나머지를 짜세요
			
			//	SELECT 결과를 List<Bang01VO> 담아서 리턴하는 형태로 동작하는 함수
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