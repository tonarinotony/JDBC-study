package jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addStudents {
	
	public addStudents() {
		
	}
	
	public void add(String id, String fname, String lname, String email, String dob) throws SQLException {
		
		String sql = "INSERT INTO students(id, first_name, last_name, dob, class, email, fee) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (
				Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				)					
		{
			stmt.setString(1,id);
			stmt.setString(2,fname);
			stmt.setString(3,lname);
			stmt.setString(4,dob);
			stmt.setInt(5, 1);
			stmt.setString(6, email);
			stmt.setInt(7, 100);
			stmt.executeUpdate();
		}
		
	}
}
