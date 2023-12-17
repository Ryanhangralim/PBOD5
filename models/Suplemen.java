package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import config.MySQLConn;

public class Suplemen extends Produk {
  private LocalDate tanggal_kadaluwarsa;
  private String dosis;
  private String jenis_suplemen;
  private String informasi_nutrisi;

  public void set_tanggalkadaluwarsa(LocalDate tanggal_kadaluwarsa) {
    this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
  }

  public LocalDate get_tanggalkadaluwarsa() {
    return this.tanggal_kadaluwarsa;
  }

  public void set_dosis(String dosis) {
    this.dosis = dosis;
  }

  public String get_dosis() {
    return this.dosis;
  }

  public void set_jenissuplemen(String jenis_suplemen) {
    this.jenis_suplemen = jenis_suplemen;
  }

  public String get_jenissuplemen() {
    return this.jenis_suplemen;
  }

  public void set_informasinutrisi(String informasi_nutrisi) {
    this.informasi_nutrisi = informasi_nutrisi;
  }

  public String get_informasinutrisi() {
    return this.informasi_nutrisi;
  }

  public int save() {
    int newSupplement = 0;

    try {
      Connection conn = MySQLConn.getConnection();

      // Insert kalau obat baru
      if (this.get_id() == null) {
        String sql = "INSERT INTO supplements(name, brand, pharma, production_date, price, stock, expired_date, dose, category, nutrition) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertNewSupplement = conn.prepareStatement(sql);

        insertNewSupplement.setString(1, this.get_nama());
        insertNewSupplement.setString(2, this.get_merek());
        insertNewSupplement.setString(3, this.get_produsen());
        insertNewSupplement.setDate(4, Date.valueOf(this.get_tanggalproduksi()));
        insertNewSupplement.setInt(5, this.get_harga());
        insertNewSupplement.setInt(6, this.get_stok());
        insertNewSupplement.setDate(7, Date.valueOf(this.get_tanggalkadaluwarsa()));
        insertNewSupplement.setString(8, this.get_dosis());
        insertNewSupplement.setString(9, this.get_jenissuplemen());
        insertNewSupplement.setString(10, this.get_informasinutrisi());

        newSupplement = insertNewSupplement.executeUpdate();
      }
      // Update kalau obat sudah ada
      else {
        String sql = "UPDATE supplements(name, brand, pharma, production_date, price, stock, category, expired_date, dose, category, nutrition) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE ID = ?";
        PreparedStatement updateSupplement = conn.prepareStatement(sql);

        updateSupplement.setString(1, this.get_nama());
        updateSupplement.setString(2, this.get_merek());
        updateSupplement.setString(3, this.get_produsen());
        updateSupplement.setDate(4, Date.valueOf(this.get_tanggalproduksi()));
        updateSupplement.setInt(5, this.get_harga());
        updateSupplement.setInt(6, this.get_stok());
        updateSupplement.setDate(7, Date.valueOf(this.get_tanggalkadaluwarsa()));
        updateSupplement.setString(8, this.get_dosis());
        updateSupplement.setString(9, this.get_jenissuplemen());
        updateSupplement.setString(10, this.get_informasinutrisi());

        newSupplement = updateSupplement.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    return newSupplement;
  }

  public static void delete(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "DELETE FROM supplements WHERE ID = ?";
      PreparedStatement deleteSupplement = conn.prepareStatement(sql);

      deleteSupplement.setInt(1, ID);

      deleteSupplement.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static ResultSet getAll() {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM supplements";
      Statement getAllSupplement = conn.createStatement();

      ResultSet supplements = getAllSupplement.executeQuery(sql);

      return supplements;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public static ResultSet getByID(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM supplements WHERE ID = ?";
      PreparedStatement getSupplementByID = conn.prepareStatement(sql);

      getSupplementByID.setInt(1, ID);

      ResultSet supplement = getSupplementByID.executeQuery();
      return supplement;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public static void updateStock(int id, int qty) {
    // Get MySQL connection
    Connection conn = MySQLConn.getConnection();
    // Query
    String sql = "UPDATE supplements SET stock = stock + ? WHERE id = ?";

    try (PreparedStatement updateSupplement = conn.prepareStatement(sql)) {
      updateSupplement.setInt(1, qty);
      updateSupplement.setInt(2, id);

      updateSupplement.executeUpdate();

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Failed to update supplement stock" + e);
    }
  }
}
