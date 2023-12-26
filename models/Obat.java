package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import config.MySQLConn;

// class obat inheritance produk
public class Obat extends Produk {
  private String jenis;
  private LocalDate tanggal_kadaluwarsa;
  private String efek_samping;
  private String dosis;
  
  //setter
  public void set_jenis(String jenis) {
    this.jenis = jenis;
  }

  //getter
  public String get_jenis() {
    return this.jenis;
  }

  //setter
  public void set_tanggalkadaluwarsa(LocalDate tanggal_kadaluwarsa) {
    this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
  }

  //getter
  public LocalDate get_tanggalkadaluwarsa() {
    return this.tanggal_kadaluwarsa;
  }

  //setter
  public void set_efeksamping(String efek_samping) {
    this.efek_samping = efek_samping;
  }

  //getter
  public String get_efeksamping() {
    return this.efek_samping;
  }

  //setter
  public void set_dosis(String dosis) {
    this.dosis = dosis;
  }

  //getter
  public String get_dosis() {
    return this.dosis;
  }

  //method untuk menambah dan mengupdate database
  public int save() {
    int newMedicine = 0;

    try {
      Connection conn = MySQLConn.getConnection();

      // Insert kalau obat baru
      if (this.get_id() == null) {
        String sql = "INSERT INTO medicines(name, brand, pharma, production_date, price, stock, category, expired_date, side_effect, dose) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertNewMedicine = conn.prepareStatement(sql);

        insertNewMedicine.setString(1, this.get_nama());
        insertNewMedicine.setString(2, this.get_merek());
        insertNewMedicine.setString(3, this.get_produsen());
        insertNewMedicine.setDate(4, Date.valueOf(this.get_tanggalproduksi()));
        insertNewMedicine.setInt(5, this.get_harga());
        insertNewMedicine.setInt(6, this.get_stok());
        insertNewMedicine.setString(7, this.get_jenis());
        insertNewMedicine.setDate(8, Date.valueOf(this.get_tanggalkadaluwarsa()));
        insertNewMedicine.setString(9, this.get_efeksamping());
        insertNewMedicine.setString(10, this.get_dosis());

        newMedicine = insertNewMedicine.executeUpdate();
      }
      // Update kalau obat sudah ada
      else {
        String sql = "UPDATE medicines SET name = ?, brand = ?, pharma = ?, production_date = ?, price = ?, stock = ?, category = ?, expired_date = ?, side_effect = ?, dose = ? WHERE ID = ?";
        PreparedStatement updateMedicine = conn.prepareStatement(sql);

        updateMedicine.setString(1, this.get_nama());
        updateMedicine.setString(2, this.get_merek());
        updateMedicine.setString(3, this.get_produsen());
        updateMedicine.setDate(4, Date.valueOf(this.get_tanggalproduksi()));
        updateMedicine.setInt(5, this.get_harga());
        updateMedicine.setInt(6, this.get_stok());
        updateMedicine.setString(7, this.get_jenis());
        updateMedicine.setDate(8, Date.valueOf(this.get_tanggalkadaluwarsa()));
        updateMedicine.setString(9, this.get_efeksamping());
        updateMedicine.setString(10, this.get_dosis());
        updateMedicine.setInt(11, this.get_id());

        newMedicine = updateMedicine.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    return newMedicine;
  }

  //method untuk hapus berdasarkan id
  public static void delete(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "DELETE FROM medicines WHERE ID = ?";
      PreparedStatement deleteMedicine = conn.prepareStatement(sql);

      deleteMedicine.setInt(1, ID);

      deleteMedicine.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  //method untuk mendapatkan isi database
  public static ResultSet getAll() {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM medicines";
      Statement getAllMedicine = conn.createStatement();

      ResultSet medicines = getAllMedicine.executeQuery(sql);

      return medicines;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  //method untuk mendapatkan row berdasarkan id
  public static ResultSet getByID(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM medicines WHERE ID = ?";
      PreparedStatement getMedicineByID = conn.prepareStatement(sql);

      getMedicineByID.setInt(1, ID);

      ResultSet medicine = getMedicineByID.executeQuery();
      return medicine;
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
    String sql = "UPDATE medicines SET stock = stock + ? WHERE id = ?";

    try (PreparedStatement updateMedicine = conn.prepareStatement(sql)) {
      updateMedicine.setInt(1, qty);
      updateMedicine.setInt(2, id);

      updateMedicine.executeUpdate();

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Failed to update medicine stock" + e);
    }
  }

  public static ResultSet searchByName(String name) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM medicines WHERE name LIKE ?";
      PreparedStatement searchMedicine = conn.prepareStatement(sql);

      String nama = "%" + name + "%";
      System.out.println(nama);
      searchMedicine.setString(1, nama);
      ResultSet medicine = searchMedicine.executeQuery();
      return medicine;
    } catch (Exception e) {
      System.out.println("Failed to search for medicine: " + e);
      return null;
    }
  }
}
