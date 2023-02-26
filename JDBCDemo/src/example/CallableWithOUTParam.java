package example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import context.DBContext;

public class CallableWithOUTParam {
  public static void main(String[] args) throws SQLException {
    String sql = "{call outParam(?,?,?)}";
    try (Connection con = DBContext.getConnection();
        CallableStatement st = con.prepareCall(sql);) {
      st.setString(1, "duy anh vu");

      // register out params
      st.registerOutParameter(2, Types.VARCHAR);
      st.registerOutParameter(3, Types.INTEGER);

      st.executeQuery();
        System.out.println("contact: " + st.getString(2));
        System.out.println("total: " + st.getInt(3));
    }
  }
}
