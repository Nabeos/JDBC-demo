package example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import context.DBContext;

public class StatementExecuteUpdateDemo {
  ResultSet rs = null;

  public static void main(String[] args) throws SQLException {
    try (
            Connection con = DBContext.getConnection();
            Statement st = con.createStatement();
        ) {
            // Insert
            String sqlInsert = "INSERT INTO customer_info "
                    + " VALUEs('user1', '123', 'contact1');";
            int numberRowsAffected = st.executeUpdate(sqlInsert);
            System.out.println("Affected rows after inserted: " + numberRowsAffected);

            // Update
            String sqlUpdate = "UPDATE customer_info SET address='123456' WHERE customerName = 'user1'";
            numberRowsAffected = st.executeUpdate(sqlUpdate);
            System.out.println("Affected rows after updated: " + numberRowsAffected);
            // Delete
            String sqlDelte = "DELETE FROM customer_info WHERE customerName = 'user1'";
            numberRowsAffected = st.executeUpdate(sqlDelte);
            System.out.println("Affected rows after deleted: " + numberRowsAffected);
        }
  }
}
