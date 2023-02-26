package example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import context.DBContext;

public class CallableWithFunction {
  public static void main(String[] args) throws SQLException {
    String sql = "{? = call find_by_name(?)}";
    try (Connection con = DBContext.getConnection();
        CallableStatement st = con.prepareCall(sql);) {
      st.setString(2, "duy anh vu");
      // register out params
      st.registerOutParameter(1, Types.VARCHAR);
      // boolean status = st.execute();
      ResultSet rs = st.executeQuery(); // try using execute query
      while(rs.next()){
        System.out.println("total: " + rs.getString(1));
      }
      // System.out.println(status);
    }
  }
}
