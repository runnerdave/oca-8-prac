import java.sql.*;
import java.util.*;

public class TestExternal {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/springtutorial?autoReconnect=true&useSSL=false",
			"udemy",
			"letmein");
		System.out.println(conn);

        Statement stmt = conn.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmt.executeQuery("select * from messages");

        System.out.println(rs);

        Map<Integer, String> idToNameMap = new HashMap<>();
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            idToNameMap.put(id, name);
        }
        System.out.println(idToNameMap); 
}