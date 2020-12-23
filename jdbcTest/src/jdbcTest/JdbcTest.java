package jdbcTest;
// Built using this tutorial https://www.youtube.com/watch?v=379qkZTibZA
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import jdbcTest.tables.students;

public class JdbcTest {

	private static final String SQL = "SELECT * From students WHERE fee <= ?";
	public static void main(String[] args) throws SQLException {
		ResultSet rs;
		
		String read = "SELECT * FROM students";
		try (
			Connection conn = DBConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(read);)
		{
			rs = pr.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("id")+ " " + rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("email") + rs.getString("dob"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want to add Student");
		String ans = input.nextLine();
		
		if(ans.equalsIgnoreCase("yes")) {
			System.out.println("Enter ID: ");
			String id = input.nextLine();
			System.out.println("Enter fname: ");
			String fname = input.nextLine();
			System.out.println("Enter lname: ");
			String lname = input.nextLine();
			System.out.println("Enter email: ");
			String email = input.nextLine();
			System.out.println("Enter DOB: ");
			String dob = input.nextLine();
			
			addStudents create = new addStudents();
			create.add(id, fname, lname, email, dob);
		}
		else {
			System.exit(1);
		}
		
		
		
		
		
		
		
		
		
		
		
		/*
		double maxfee;
		
		try {
			maxfee = Input.getInt("Enter a maximum fee: ");
			
		} catch (Exception e) {
			System.err.println("Error invalid number");
			return;
		}
		
		ResultSet rs = null;
		
		try(
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				) 
		{
			stmt.setDouble(1, maxfee);
			
			rs = stmt.executeQuery();
			students.getStudents(rs);
			
		} catch (SQLException e) {
			System.err.println(e);
		}
		
		*/
		
		
		
		/*try(	
			Connection con =  DBConnection.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
				) 
		{
			
			students.getStudents(rs);
			
		} catch (SQLException e) {
			System.err.print(e);
		}
		*/
		
		
	}
}
