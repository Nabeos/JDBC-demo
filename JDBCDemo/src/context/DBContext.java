package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
  private static String userName = "root";
  private static String pass = "123456";
  private static String url = "jdbc:mysql://localhost:3306/northwind";

  public static Connection getConnection() {
    try {
      // Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection(url, userName, pass);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // } catch (ClassNotFoundException e) {
    //   e.printStackTrace();
    // }
    return null;
  }

}
