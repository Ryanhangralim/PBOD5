package models;

public class Pelanggan {
  private String _nama;
  private String nomor_telepon;
  private String alamat;

  public void setNama(String nama) {
    this._nama = nama;
  }

  public String getNama() {
    String nama = "Nama anda adalah: " + this._nama;
    return nama;
  }

  public void setNomorTelepon(String nomor_telepon) {
    this.nomor_telepon = nomor_telepon;
  }

  public String getNomorTelepon() {
    return this.nomor_telepon;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public String getAlamat() {
    return this.alamat;
  }
}
