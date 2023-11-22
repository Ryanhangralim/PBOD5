package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConn {
  private static Connection conn;

  static {

    String url = "jdbc:mysql://localhost:3306/kimaifarma";
    String username = "root";
    String password = "Mismag0203i9";

    try {
      conn = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      System.out.println("Error establishing database connection" + e);
    }
  }

  public static Connection getConnection() {
    return conn;
  }

  public static void closeConnection() {
    try {
      conn.close();
    } catch (Exception e) {
      System.out.println("Error closing database connection" + e);
    }
  }
}
