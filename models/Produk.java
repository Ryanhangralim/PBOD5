package models;

import java.time.LocalDate;

//class abstract produk
abstract class Produk {
  private Integer id;
  private String nama;
  private String merek;
  private String produsen;
  private LocalDate tanggal_produksi;
  private int harga;
  private int stok;

  //setter
  public void set_id(Integer id) {
    this.id = id;
  }

  //getter
  public Integer get_id() {
    return this.id;
  }

  //setter
  public void set_nama(String nama) {
    this.nama = nama;
  }

  //getter
  public String get_nama() {
    return this.nama;
  }

  //setter
  public void set_merek(String merek) {
    this.merek = merek;
  }

  //getter
  public String get_merek() {
    return this.merek;
  }

  //setter
  public void set_produsen(String produsen) {
    this.produsen = produsen;
  }

  //getter
  public String get_produsen() {
    return this.produsen;
  }

  //setter
  public void set_tanggalproduksi(LocalDate tanggal_produksi) {
    this.tanggal_produksi = tanggal_produksi;
  }

  //getter
  public LocalDate get_tanggalproduksi() {
    return this.tanggal_produksi;
  }

  //setter
  public void set_harga(int harga) {
    this.harga = harga;
  }

  //getter
  public int get_harga() {
    return this.harga;
  }

  //setter
  public void set_stok(int stok) {
    this.stok = stok;
  }

  //getter
  public int get_stok() {
    return this.stok;
  }

  //method tambah stock
  public void tambah_stok(int stok) {
    this.stok = this.stok + stok;
  }

  //method kurang stock
  public void kurang_stok(int stok) {
    this.stok = this.stok - stok;
  }
}