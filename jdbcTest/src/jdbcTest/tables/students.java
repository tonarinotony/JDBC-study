package jdbcTest.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class students {
	public static void getStudents(ResultSet rs) throws SQLException {
		
		while(rs.next()) {
			StringBuffer buffer = new StringBuffer();
			
			buffer.append(" Students ID " + rs.getInt("id") + " ");
			buffer.append(rs.getString("first_name")+ " ");
			buffer.append(rs.getString("last_name")+ " ");
			buffer.append(rs.getDate("dob"));
			
			System.out.println(buffer.toString());
		}
	}
		
}
