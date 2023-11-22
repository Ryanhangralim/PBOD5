package models;

import java.time.LocalDate;

abstract class Produk {
  private String id;
  private String nama;
  private String merek;
  private String produsen;
  private LocalDate tanggal_produksi;
  private int harga;
  private int stok;

  public void set_id(String id) {
    this.id = id;
  }

  public String get_id() {
    return this.id;
  }

  public void set_nama(String nama) {
    this.nama = nama;
  }

  public String get_nama() {
    return this.nama;
  }

  public void set_merek(String merek) {
    this.merek = merek;
  }

  public String get_merek() {
    return this.merek;
  }

  public void set_produsen(String produsen) {
    this.produsen = produsen;
  }

  public String get_produsen() {
    return this.produsen;
  }

  public void set_tanggalproduksi(LocalDate tanggal_produksi) {
    this.tanggal_produksi = tanggal_produksi;
  }

  public LocalDate get_tanggalproduksi() {
    return this.tanggal_produksi;
  }

  public void set_harga(int harga) {
    this.harga = harga;
  }

  public int get_harga() {
    return this.harga;
  }

  public void set_stok(int stok) {
    this.stok = stok;
  }

  public int get_stok() {
    return this.stok;
  }

  public void tambah_stok(int stok) {
    this.stok = this.stok + stok;
  }

  public void kurang_stok(int stok) {
    this.stok = this.stok - stok;
  }
}