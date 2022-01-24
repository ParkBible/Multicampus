package banana;

import java.sql.*;

public class Test305 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
		
		CallableStatement stmt = conn.prepareCall("CALL proc_orange(?,?)");
		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.registerOutParameter(2, Types.INTEGER);
		
		stmt.execute();
		
		int ab = stmt.getInt(1);
		int cd = stmt.getInt(2);
		System.out.println(ab + " " + cd);
		
		stmt.close();
		conn.close();
	}
}
/*
DROP PROCEDURE IF EXISTS proc_orange;

DELIMITER //
CREATE PROCEDURE proc_orange( OUT v_uc INT, OUT v_ai INT )
BEGIN
    INSERT INTO temp12_T VALUES ( default, 'Orange' );
	SET v_uc = ROW_COUNT();
	SET v_ai = LAST_INSERT_ID();
END;
//   
DELIMITER ;

CALL proc_orange(@ab,@cd);
SELECT @ab, @cd;

CREATE TABLE temp12_T (
	no INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
	data VARCHAR(10) NULL
);

INSERT INTO temp12_T VALUES ( default, 'Orange' );
*/