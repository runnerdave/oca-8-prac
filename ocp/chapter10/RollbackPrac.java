
import java.sql.*;

public class RollbackPrac {
	
	public static void main(String... args) {
		String url = "jdbc:derby:sample;create=true";

		//Given the following code:

        //orig try (Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");) {
		try (Connection c = DriverManager.getConnection(url);) {
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            int a1 = stmt.executeUpdate("insert into STUDENT2 values (1, 'aaa', 1.1)");
            Savepoint sp1 = c.setSavepoint("1");
            int a2 = stmt.executeUpdate("insert into STUDENT2 values (2, 'bbb', 2.1)");
            Savepoint sp2 = c.setSavepoint("2");
            int a3 = stmt.executeUpdate("insert into STUDENT2 values (3, 'ccc', 3.1)");

            boolean someCondition = true;
            boolean anotherCondition = true;
            if(someCondition){
                //don't let second and third inserts commit
            }else if (anotherCondition){
                //don't let third insert commit
            }
            // continue with existing transaction

        } catch (SQLException e) {
            e.printStackTrace();
        }

		//What should be put in the if-else blocks so that it will work as expected?

		/*
		a. 	c.save(sp1); in if and 
		   	c.save(sp2); in else.

		b. 	c.commit(sp1); in if and 
			c.commit(sp2); in else.

		c. 	c.rollback(); in if and 
			c.rollback(sp1); in else.

		d. 	c.rollback(sp1); in if and 
			c.rollback(sp2); in else.

		e. 	c.rollback(sp1); in if and 
			c.rollback(); in else.

		answer:

		d.

		explanation:
		connection.rollback(savepoint) ensures that any statements executed after that save 
		point was created will not be commited. Any statement executed before the save point 
		will be committed as and when commit is called.
		*/
	}
}