package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/*
	test01_T�� Test01DTO�� ���� : Data, Transfer, Object�����͸� ��� ������ �뵵�θ� ����.
*/

class Test01DTO{
	// no �ʵ�� ���εǴ� property
	private Integer no = null;
	public Integer getNo(){return no;}
	public void setNo(Integer i){this.no = i;}
	
	// data �ʵ�� ���εǴ� property
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
			// ���ڵ� �ϳ����� �ν��Ͻ� ����(���ڵ�� �ν��Ͻ��� ���εȴ�)
			Test01DTO dto = new Test01DTO();
			dto.setNo(rs.getInt("no"));
			dto.setData(rs.getString("data"));
			
			ls.add(dto);
		}
		
		rs.close();
		
		stmt.close();
		conn.close();
		
		/*
			close() ������ �����͸� �̸� ArrayList�� �Ű� ��������
			������ �����ϰ� �ᵵ �ȴ�.
		*/
		
		for(Test01DTO dto : ls){
			System.out.println(dto.getNo() + "," + dto.getData());
		}
	}
}

/*
	O-R Mapping �̶�� ������ �ִ�.
	�����ͺ��̽��� ������ Programming�� �������� �����ϴ� ��Ģ.
	
	Table�� class�� ����.(VO, DTO)
	Record�� instance��
	Field�� property��.
	
	���̷� ������ ���� �ϳ�?
	-conn�� ��μ� ���� ���� ���� ����� �Ѵ�.
	-Select ����� ������ ���� ���� �������ΰ����͵� �ٿ��� �����ϰ� ���� �ʹ�.
	-�� select ����� ��򰡿� �ű�� conn�� ����.
	�Ź� �޸����� ����ϴϱ� O-R �������� ���.
*/