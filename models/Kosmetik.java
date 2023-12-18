package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import config.MySQLConn;

public class Kosmetik extends Produk {
  private String jenis_kosmetik;
  private LocalDate tanggal_kadaluwarsa;
  private int berat_bersih;

  public void set_jeniskosmetik(String jenis_kosmetik) {
    this.jenis_kosmetik = jenis_kosmetik;
  }

  public void set_tanggalkadaluwarsa(LocalDate tanggal_kadaluwarsa) {
    this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
  }

  public void set_beratbersih(int berat_bersih) {
    this.berat_bersih = berat_bersih;
  }

  public String get_jeniskosmetik() {
    return this.jenis_kosmetik;
  }

  public LocalDate get_tanggalkadaluwarsa() {
    return this.tanggal_kadaluwarsa;
  }

  public int get_beratbersih() {
    return this.berat_bersih;
  }

  public int save() {
    int newCosmetic = 0;

    try {
      Connection conn = MySQLConn.getConnection();

      // Insert kalau obat baru
      if (this.get_id() == null) {
        String sql = "INSERT INTO cosmetic(name, brand, pharma, production_date, price, stock, expired_date, cosmetic_type, weight) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement updateCosmetic = conn.prepareStatement(sql);

        updateCosmetic.setString(1, this.get_nama());
        updateCosmetic.setString(2, this.get_merek());
        updateCosmetic.setString(3, this.get_produsen());
        updateCosmetic.setDate(4, Date.valueOf(this.get_tanggalproduksi()));
        updateCosmetic.setInt(5, this.get_harga());
        updateCosmetic.setInt(6, this.get_stok());
        updateCosmetic.setDate(7, Date.valueOf(this.get_tanggalkadaluwarsa()));
        updateCosmetic.setString(8, this.get_jeniskosmetik());
        updateCosmetic.setInt(9, this.get_beratbersih());

        newCosmetic = updateCosmetic.executeUpdate();
      }
      // Update kalau obat sudah ada
      else {
        String sql = "UPDATE cosmetic SET name = ?, brand = ?, pharma = ?, production_date = ?, price = ?, stock = ?, expired_date = ?, cosmetic_type = ?, weight = ? WHERE ID = ?";
        PreparedStatement insertnewCosmetic = conn.prepareStatement(sql);

        insertnewCosmetic.setString(1, this.get_nama());
        insertnewCosmetic.setString(2, this.get_merek());
        insertnewCosmetic.setString(3, this.get_produsen());
        insertnewCosmetic.setDate(4, Date.valueOf(this.get_tanggalproduksi()));
        insertnewCosmetic.setInt(5, this.get_harga());
        insertnewCosmetic.setInt(6, this.get_stok());
        insertnewCosmetic.setDate(7, Date.valueOf(this.get_tanggalkadaluwarsa()));
        insertnewCosmetic.setString(8, this.get_jeniskosmetik());
        insertnewCosmetic.setInt(9, this.get_beratbersih());
        insertnewCosmetic.setInt(10, this.get_id());


        newCosmetic = insertnewCosmetic.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    return newCosmetic;
  }

  public static void delete(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "DELETE FROM cosmetic WHERE ID = ?";
      PreparedStatement deleteCosmetic = conn.prepareStatement(sql);

      deleteCosmetic.setInt(1, ID);

      deleteCosmetic.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static ResultSet getAll() {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM cosmetic";
      Statement getAllCosmetic = conn.createStatement();

      ResultSet cosmetics = getAllCosmetic.executeQuery(sql);

      return cosmetics;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public static ResultSet getByID(int ID) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM cosmetic WHERE ID = ?";
      PreparedStatement getCosmeticByID = conn.prepareStatement(sql);

      getCosmeticByID.setInt(1, ID);

      ResultSet Cosmetic = getCosmeticByID.executeQuery();
      return Cosmetic;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public static void updateStock(int id, int qty) {
    // Get MySQL connection
    Connection conn = MySQLConn.getConnection();
    // Query
    String sql = "UPDATE cosmetic SET stock = stock + ? WHERE id = ?";

    try (PreparedStatement updateCosmetic = conn.prepareStatement(sql)) {
      updateCosmetic.setInt(1, qty);
      updateCosmetic.setInt(2, id);

      updateCosmetic.executeUpdate();

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Failed to update cosmetic stock" + e);
    }
  }

  public static ResultSet searchByName(String name) {
    try {
      Connection conn = MySQLConn.getConnection();
      String sql = "SELECT * FROM cosmetic WHERE name LIKE ?";
      PreparedStatement search = conn.prepareStatement(sql);

      String nama = "%" + name + "%";
      search.setString(1, nama);
      ResultSet cosmetic = search.executeQuery();
      return cosmetic;
    } catch (Exception e) {
      System.out.println("Failed to search for cosmetic: " + e);
      return null;
    }
  }
}
