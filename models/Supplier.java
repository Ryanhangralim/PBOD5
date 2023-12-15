package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import config.MySQLConn;

public class Supplier {
  private Integer id;
  private String nama;
  private String nomor_telepon;
  private String alamat;

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

  public int save(){
    int newSupplier = 0;

    try{
      Connection conn = MySQLConn.getConnection();

      //insert kalau ada supplier baru
      if(this.get_id() == null){
        String sql = "INSERT INTO supplier(name, telephone_number, address) VALUES(?, ?, ?)";
        PreparedStatement insertNewSupplier = conn.prepareStatement(sql);

        insertNewSupplier.setString(1, this.get_nama());
        insertNewSupplier.setString(2, this.get_nomortelepon());
        insertNewSupplier.setString(3, this.get_alamat());

        newSupplier = insertNewSupplier.executeUpdate();
      }
      // update kalau supplier sudah ada
      else{
        String sql = "UPDATE supplier(name, telephone_number, address) VALUES(?, ?, ?) WHERE id = ?";
        PreparedStatement updateSupplier = conn.prepareStatement(sql);

        updateSupplier.setString(1, this.get_nama());
        updateSupplier.setString(2, this.get_nomortelepon());
        updateSupplier.setString(3, this.get_alamat());

        newSupplier = updateSupplier.executeUpdate();
      }
    } catch (Exception e){
      System.out.println(e);
    }

    return newSupplier;
  }

  public static void delete(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "DELETE FROM supplier WHERE ID = ?";
      PreparedStatement deleteSupplier = conn.prepareStatement(sql);

      deleteSupplier.setInt(1, ID);

      deleteSupplier.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static ResultSet getAll() {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM supplier";
      Statement getAllSupplier = conn.createStatement();

      ResultSet supplier = getAllSupplier.executeQuery(sql);

      return supplier;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public static ResultSet getByID(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM supplier WHERE ID = ?";
      PreparedStatement getSupplierByID = conn.prepareStatement(sql);

      getSupplierByID.setInt(1, ID);

      ResultSet Supplier = getSupplierByID.executeQuery();
      return Supplier;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
