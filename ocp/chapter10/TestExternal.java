import java.sql.*;
import java.util.*;

public class TestExternal {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/springtutorial?autoReconnect=true&useSSL=false",
			"udemy",
			"letmein");

        System.out.println("== Print the connection object ==");
		System.out.println(conn);

        Statement stmt = conn.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmt.executeQuery("select * from messages");
        System.out.println("== Print the ResultSet object ==");
        System.out.println(rs);

        Map<Integer, String> idToNameMap = new HashMap<>();
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            idToNameMap.put(id, name);
        }
        System.out.println("== Print results from messages forward only ==");
        System.out.println(idToNameMap); 

        System.out.println();
        System.out.println("== Print results from messages with scrolling ==");
        stmt = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery("select * from messages");
        rs.afterLast();
        System.out.println(rs.previous()); // true
        System.out.println(rs.getInt(1)); // 2        
        System.out.println(rs.previous()); // true
        System.out.println(rs.getInt(1)); // 1
        System.out.println(rs.last()); // true
        System.out.println(rs.getInt(1)); // 2
        System.out.println(rs.first()); // true
        System.out.println(rs.getInt(1)); // 1
        rs.beforeFirst();
        //System.out.println(rs.getInt(1)); // uncomment to show how it throws SQLException

        System.out.println();
        System.out.println("== Test for execute ==");
        boolean exec = stmt.execute("select * from messages");
        System.out.println(exec);

    }
}