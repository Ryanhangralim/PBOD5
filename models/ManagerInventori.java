package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

  public int save(){
    int newManager = 0;

    try {
      Connection conn = MySQLConn.getConnection();

      // Insert kalau manager baru    
      if (this.get_id() == null) {
        String sql = "INSERT INTO inventory_managers(username, password, name, telephone_number, address VALUES(?, ?, ?, ?, ?)";
        PreparedStatement insertNewManager = conn.prepareStatement(sql);

        insertNewManager.setString(1, get_username());
        insertNewManager.setString(2, get_password());
        insertNewManager.setString(3, get_nama());
        insertNewManager.setString(4, get_nomortelepon());
        insertNewManager.setString(5, get_alamat());

        newManager = insertNewManager.executeUpdate();
      }
      // Update kalau manager sudah ada
      else {
        String sql = "UPDATE INTO inventory_managers(username, password, name, telephone_number, address VALUES(?, ?, ?, ?, ?) WHERE ID = ?";
        PreparedStatement updateManager = conn.prepareStatement(sql);

        updateManager.setString(1, get_username());
        updateManager.setString(2, get_password());
        updateManager.setString(3, get_nama());
        updateManager.setString(4, get_nomortelepon());
        updateManager.setString(5, get_alamat());

        newManager = updateManager.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    return newManager;
  }

  public static void delete(int ID){
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
}
