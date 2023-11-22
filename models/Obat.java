package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import config.MySQLConn;

public class Obat extends Produk {
  private String jenis;
  private LocalDate tanggal_kadaluwarsa;
  private String efek_samping;
  private String dosis;

  public void set_jenis(String jenis) {
    this.jenis = jenis;
  }

  public String get_jenis() {
    return this.jenis;
  }

  public void set_tanggalkadaluwarsa(LocalDate tanggal_kadaluwarsa) {
    this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
  }

  public LocalDate get_tanggalkadaluwarsa() {
    return this.tanggal_kadaluwarsa;
  }

  public void set_efeksamping(String efek_samping) {
    this.efek_samping = efek_samping;
  }

  public String get_efeksamping() {
    return this.efek_samping;
  }

  public void set_dosis(String dosis) {
    this.dosis = dosis;
  }

  public String get_dosis() {
    return this.dosis;
  }

  public int save() {
    String sql = "INSERT INTO medicines(name, brand, pharma, production_date, price, stock, category, expired_date, side_effect, dose) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    int newMedicine = 0;

    try {
      Connection conn = MySQLConn.getConnection();

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

    } catch (Exception e) {
      System.out.println("Error getting connection" + e);
    }

    return newMedicine;
  }
}
