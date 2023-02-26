package example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import context.DBContext;

public class CreateProcedure {
  public static void main(String[] args) throws SQLException {
    String sql = "create procedure outParam1(IN name varchar(50), OUT contact varchar(50), OUT total int) "
        + "Begin "
        + "SELECT contactName INTO contact FROM customer_info WHERE customerName = name limit 1; "
        + "SELECT count(*) into total FROM customer_info where customerName = name group by customerName; "
        + "End";
    try (Connection connection = DBContext.getConnection();
        CallableStatement st = connection.prepareCall(sql)) {
         int number = st.executeUpdate();
         System.out.println(number);
    }
  }
}
