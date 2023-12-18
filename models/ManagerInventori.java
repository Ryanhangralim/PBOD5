package models;

import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import config.MySQLConn;

public class ManagerInventori {
  private Integer id;
  private String nama;
  private String nomor_telepon;
  private String alamat;
  private String username;
  private String password;

  public void set_id(Integer id) {
    this.id = id;
  }

  public Integer get_id() {
    return this.id;
  }

  public void set_nama(String nama) {
    this.nama = nama;
  }

  public String get_nama() {
    return this.nama;
  }

  public void set_nomortelepon(String nomor_telepon) {
    this.nomor_telepon = nomor_telepon;
  }

  public String get_nomortelepon() {
    return this.nomor_telepon;
  }

  public void set_alamat(String alamat) {
    this.alamat = alamat;
  }

  public String get_alamat() {
    return this.alamat;
  }

  public void set_username(String username) {
    this.username = username;
  }

  public String get_username() {
    return this.username;
  }

  public void set_password(String password) {
    this.password = password;
  }

  public String get_password() {
    return this.password;
  }

  public int save() {
    int newManager = 0;

    try {
      Connection conn = MySQLConn.getConnection();

      // Insert kalau manager baru
      if (this.get_id() == null) {
        String sql = "INSERT INTO inventory_managers(username, password, name, telephone_number, address) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement insertNewManager = conn.prepareStatement(sql);

        insertNewManager.setString(1, get_username());
        insertNewManager.setString(2, get_password());
        insertNewManager.setString(3, get_nama());
        insertNewManager.setString(4, get_nomortelepon());
        insertNewManager.setString(5, get_alamat());

        newManager = insertNewManager.executeUpdate();

        // Masukkan ke .txt
        // Mendapatkan path dari directory "models"
        Path modelsPath = Paths.get("models");

        // Mendapatkan path dari file "manager.txt" di dalam directory "data"
        Path dataFilePath = modelsPath.resolveSibling("data").resolve("manager.txt");

        // FileWriter fw = new FileWriter("C:/Users/Steven
        // Ciam/Documents/PBOD5/models");
        FileWriter fw = new FileWriter(dataFilePath.toString(), true);

        fw.write(this.nama + ";" + this.nomor_telepon + ";" + this.alamat + ";" + this.username + ";"
            + this.password + ";\n");

        fw.close();
      }
      // Update kalau manager sudah ada
      else {
        String sql = "UPDATE inventory_managers SET username = ?, password = ?, name = ?, telephone_number = ?, address = ? WHERE ID = ?";
        PreparedStatement updateManager = conn.prepareStatement(sql);

        updateManager.setString(1, get_username());
        updateManager.setString(2, get_password());
        updateManager.setString(3, get_nama());
        updateManager.setString(4, get_nomortelepon());
        updateManager.setString(5, get_alamat());
        updateManager.setInt(6, get_id());

        newManager = updateManager.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    return newManager;
  }

  public static void delete(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "DELETE FROM inventory_managers WHERE ID = ?";
      PreparedStatement deleteManagers = conn.prepareStatement(sql);

      deleteManagers.setInt(1, ID);

      deleteManagers.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static ResultSet getAll() {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM inventory_managers";
      Statement getAllManagers = conn.createStatement();

      ResultSet managers = getAllManagers.executeQuery(sql);

      return managers;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public static ResultSet getByID(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM inventory_managers WHERE ID = ?";
      PreparedStatement getManagerByID = conn.prepareStatement(sql);

      getManagerByID.setInt(1, ID);

      ResultSet manager = getManagerByID.executeQuery();
      return manager;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public static boolean checkUsername(String username) {
    int count = 0;
    PreparedStatement checkManagerusername = null;
    ResultSet valid = null;
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT COUNT(username) FROM inventory_managers WHERE username = ?";
      checkManagerusername = conn.prepareStatement(sql);

      checkManagerusername.setString(1, username);
      valid = checkManagerusername.executeQuery();
      if(valid.next()){
        count = valid.getInt(1);
      }
      if (count > 0){
        return true;
      }
      else{
        return false;
      }
    } catch(SQLException e){
      System.out.println(e);
      return false;
    }
  }

public static boolean checkPassword(String username, String password) {
  String userPassword;
  PreparedStatement checkPassword = null;
  ResultSet valid = null;
  try {
    Connection conn = MySQLConn.getConnection();
    String sql = "SELECT password FROM inventory_managers WHERE username = ?";
    checkPassword= conn.prepareStatement(sql);

    checkPassword.setString(1, username);
    valid = checkPassword.executeQuery();
    if(valid.next()){
      userPassword = valid.getString(1);
      if(userPassword.equals(password)){
        return true;
      }
      else{
        return false;
      }
    }
    return false;
  } catch(SQLException e){
    System.out.println(e);
    return false;
  }
}
}
