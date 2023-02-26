package example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import context.DBContext;

public class StatementExecuteDemo {
  public static void main(String[] args) throws SQLException {
    try (
        Connection con = DBContext.getConnection();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
      // Insert
      String sqlInsert = "INSERT INTO customer_info "
          + " VALUEs('user2', '123', 'contact1');";
      boolean status = st.execute(sqlInsert);
      System.out.println(status); // false if return the number of affected rows

      String sqlSelect = "select * from customer_info limit 5;";
      status = st.execute(sqlSelect);
      System.out.println(status); // true if return result set
      ResultSet rs = st.getResultSet();
      while (rs.next()) {
        System.out.println("Customer Name: " + rs.getString(1));
        System.out.println("-----------");
      }

    }
  }
}
