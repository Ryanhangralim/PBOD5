package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import config.MySQLConn;

//Class alat kesehatan inheritance produk
public class Suplemen extends Produk {
  private LocalDate tanggal_kadaluwarsa;
  private String dosis;
  private String jenis_suplemen;
  private String informasi_nutrisi;

  //setter
  public void set_tanggalkadaluwarsa(LocalDate tanggal_kadaluwarsa) {
    this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
  }

  //getter
  public LocalDate get_tanggalkadaluwarsa() {
    return this.tanggal_kadaluwarsa;
  }

  //setter
  public void set_dosis(String dosis) {
    this.dosis = dosis;
  }

  //getter
  public String get_dosis() {
    return this.dosis;
  }

  //setter
  public void set_jenissuplemen(String jenis_suplemen) {
    this.jenis_suplemen = jenis_suplemen;
  }

  //getter
  public String get_jenissuplemen() {
    return this.jenis_suplemen;
  }

  //setter
  public void set_informasinutrisi(String informasi_nutrisi) {
    this.informasi_nutrisi = informasi_nutrisi;
  }

  //getter
  public String get_informasinutrisi() {
    return this.informasi_nutrisi;
  }

  //method untuk menambah dan mengupdate database
  public int save() {
    int newSupplement = 0;

    try {
      Connection conn = MySQLConn.getConnection();

      // Insert kalau suplemen baru
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
      // Update kalau suplemen sudah ada
      else {
        String sql = "UPDATE supplements SET name = ?, brand = ?, pharma = ?, production_date = ?, price = ?, stock = ?, expired_date = ?, dose = ?, category = ?, nutrition = ? WHERE ID = ?";
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
        updateSupplement.setInt(11, this.get_id());

        newSupplement = updateSupplement.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    return newSupplement;
  }

  //method untuk hapus berdasarkan id
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

  //method untuk mendapatkan isi database
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

  //method untuk mendapatkan row berdasarkan id
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

  //method untuk mengupdate stock dalam database
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
      System.out.println("Failed to search name" + e);
    }
  }

  //method untuk mencari berdasarkan nama
  public static ResultSet searchByName(String name) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM supplements WHERE name LIKE ?";
      PreparedStatement search = conn.prepareStatement(sql);

      String nama = "%" + name + "%";
      search.setString(1, nama);
      ResultSet supplement = search.executeQuery();
      return supplement;
    } catch (Exception e) {
      System.out.println("Failed to search for medicine: " + e);
      return null;
    }
  }
}
