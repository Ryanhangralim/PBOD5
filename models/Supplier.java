package models;

public class Supplier {
  private String nama;
  private String nomor_telepon;
  private String alamat;

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
}
