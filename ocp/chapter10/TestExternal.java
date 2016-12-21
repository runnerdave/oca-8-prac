import java.sql.*;
public class TestExternal {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/springtutorial",
			"udemy",
			"letmein");
		System.out.println(conn);
	}
}