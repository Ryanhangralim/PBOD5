package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import config.MySQLConn;

public class AlatKesehatan extends Produk {
  private String jenis_alat;
  private int berat;

  public void set_jenisalat(String jenis_alat) {
    this.jenis_alat = jenis_alat;
  }

  public String get_jenisalat() {
    return this.jenis_alat;
  }

  public void set_berat(int berat) {
    this.berat = berat;
  }

  public int get_berat() {
    return this.berat;
  }

  public int save() {
    int newEquipment = 0;

    try {
      Connection conn = MySQLConn.getConnection();

      // Insert kalau obat baru
      if (this.get_id() == null) {
        String sql = "INSERT INTO medical_equipments(name, brand, pharma, production_date, price, stock, category, weight) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertNewEquipment = conn.prepareStatement(sql);

        insertNewEquipment.setString(1, this.get_nama());
        insertNewEquipment.setString(2, this.get_merek());
        insertNewEquipment.setString(3, this.get_produsen());
        insertNewEquipment.setDate(4, Date.valueOf(this.get_tanggalproduksi()));
        insertNewEquipment.setInt(5, this.get_harga());
        insertNewEquipment.setInt(6, this.get_stok());
        insertNewEquipment.setString(7, this.get_jenisalat());
        insertNewEquipment.setInt(8, this.get_berat());

        newEquipment = insertNewEquipment.executeUpdate();
      }
      // Update kalau obat sudah ada
      else {
        String sql = "UPDATE medical_equipments(name, brand, pharma, production_date, price, stock, category, weight) VALUES(?, ?, ?, ?, ?, ?, ?, ?) WHERE ID = ?";
        PreparedStatement updateEquipment = conn.prepareStatement(sql);

        updateEquipment.setString(1, this.get_nama());
        updateEquipment.setString(2, this.get_merek());
        updateEquipment.setString(3, this.get_produsen());
        updateEquipment.setDate(4, Date.valueOf(this.get_tanggalproduksi()));
        updateEquipment.setInt(5, this.get_harga());
        updateEquipment.setInt(6, this.get_stok());
        updateEquipment.setString(7, this.get_jenisalat());
        updateEquipment.setInt(8, this.get_berat());


        newEquipment = updateEquipment.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    return newEquipment;
  }

  public static void delete(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "DELETE FROM medical_equipments WHERE ID = ?";
      PreparedStatement deleteEquipment = conn.prepareStatement(sql);

      deleteEquipment.setInt(1, ID);

      deleteEquipment.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static ResultSet getAll() {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM medical_equipments";
      Statement getAllEquipments = conn.createStatement();

      ResultSet equiments = getAllEquipments.executeQuery(sql);

      return equiments;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public static ResultSet getByID(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM medical_equipments WHERE ID = ?";
      PreparedStatement getEquipmentByID = conn.prepareStatement(sql);

      getEquipmentByID.setInt(1, ID);

      ResultSet equipment = getEquipmentByID.executeQuery();
      return equipment;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
