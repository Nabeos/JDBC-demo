package example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import context.DBContext;

public class CallableDemo {
  public static void main(String[] args) throws SQLException {
    String sql = "{call pro_example1(?)}"; // find customer by name
    try (
      Connection con = DBContext.getConnection();
      CallableStatement callableStatement = con.prepareCall(sql)) {
        callableStatement.setString(1, "duy anh vu");
        callableStatement.executeQuery();
        ResultSet rs = callableStatement.executeQuery();
        while(rs.next()){
          System.out.println(rs.getString(1)+" || "+rs.getString(3));
          System.out.println();
          System.out.println("--------");
        }
    }
  }
}
