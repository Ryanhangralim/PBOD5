package config;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

public class MySQLConn {
  private static Dotenv dotenv = Dotenv.load();
  private static Connection conn;

  static {

    String url = "jdbc:mysql://localhost:3306/kimaifarma";
    String username = dotenv.get("DB_USER");
    String password = dotenv.get("DB_PASS");

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
