package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/*
	test01_T는 Test01DTO로 매핑 : Data, Transfer, Object데이터를 담아 나르는 용도로만 쓴다.
*/

class Test01DTO{
	// no 필드와 매핑되는 property
	private Integer no = null;
	public Integer getNo(){return no;}
	public void setNo(Integer i){this.no = i;}
	
	// data 필드와 매핑되는 property
	private String data = null;
	public String getData(){return data;}
	public void setData(String i){this.data = i;}
}



public class Test291{
	public static void main(String[] args) throws Exception{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17", "pukyung00!!1");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM test01_T");
		List<Test01DTO> ls = new ArrayList<Test01DTO>();
		
		
		while(rs.next()){
			// 레코드 하나마다 인스턴스 생성(레코드는 인스턴스에 매핑된다)
			Test01DTO dto = new Test01DTO();
			dto.setNo(rs.getInt("no"));
			dto.setData(rs.getString("data"));
			
			ls.add(dto);
		}
		
		rs.close();
		
		stmt.close();
		conn.close();
		
		/*
			close() 이전에 데이터를 미리 ArrayList에 옮겨 놓았으니
			이제는 느긋하게 써도 된다.
		*/
		
		for(Test01DTO dto : ls){
			System.out.println(dto.getNo() + "," + dto.getData());
		}
	}
}

/*
	O-R Mapping 이라는 개념이 있다.
	데이터베이스의 개념을 Programming의 개념으로 매핑하는 규칙.
	
	Table은 class로 매핑.(VO, DTO)
	Record는 instance로
	Field는 property로.
	
	왜이런 복잡한 일을 하나?
	-conn은 비싸서 빨리 쓰고 빨리 끊어야 한다.
	-Select 결과를 가져다 쓰는 것은 웹디자인같은것도 붙여서 느긋하게 스고 싶다.
	-즉 select 결과를 어딘가에 옮기고 conn을 끊자.
	매번 달리지면 곤란하니까 O-R 프레임을 사용.
*/