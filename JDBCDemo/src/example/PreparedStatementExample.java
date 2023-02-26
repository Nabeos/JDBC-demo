package example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Customer;

public class PreparedStatementExample {
  Connection conn = null;
  PreparedStatement st = null;
  CallableStatement callableStatement = null;
  ResultSet rs = null;

  public List<Customer> getCustomers() {
    List<Customer> customers = new ArrayList<>();
    String sql = "SELECT CustomerName, Address, ContactName FROM customer_info";
    conn = DBContext.getConnection();
    try {
      st = conn.prepareStatement(sql);
      rs = st.executeQuery();
      while (rs.next()) {
        customers.add(new Customer(rs.getString("CustomerName"), rs.getString(1), rs.getString("ContactName")));
      }
      return customers;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
      if (st != null) {
        try {
          st.close();
        } catch (SQLException e) {
        }
      }
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
    }
    return null;
  }

  public Customer addNewCustomer(String name, String address, String contactName) {
    String sql = "INSERT INTO customer_info VALUES(?, ?, ?);";
    conn = DBContext.getConnection();
    try (PreparedStatement st = conn.prepareStatement(sql)) {
      // st = conn.prepareStatement(sql);
      st.setString(1, name);
      st.setString(2, address);
      st.setString(3, contactName);
      int status = st.executeUpdate();
      if (status != 0)
        return new Customer(name, address, contactName);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
      if (st != null) {
        try {
          st.close();
        } catch (SQLException e) {
        }
      }
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
    }
    return null;
  }
}
