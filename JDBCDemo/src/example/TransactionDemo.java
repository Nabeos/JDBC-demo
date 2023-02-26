package example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import context.DBContext;

public class TransactionDemo {
  public static void main(String[] args) throws SQLException{
    try (
      Connection con = DBContext.getConnection();
      Statement st = con.createStatement();) {
        con.setAutoCommit(false);
        String sqlInsert1 = "insert into customer_info values('duyanh', 'hanoi', 'nabeos')";
        String sqlInsert2 = "insert into customer_info2 values('duyanh', 'hanoi', 1)";
        try {
          st.executeUpdate(sqlInsert1);
          st.executeUpdate(sqlInsert2);
          System.out.println("thanh cong");
          con.commit();
        } catch (Exception e) {
          e.printStackTrace();
          con.rollback();
          System.out.println("roll back");
        }
      }
  }
}
