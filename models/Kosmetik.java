package models;

public class Kosmetik extends Produk {
  private String jenis_kosmetik;
  private String tanggal_kadaluwarsa;
  private int berat_bersih;

  public void set_jeniskosmetik(String jenis_kosmetik) {
    this.jenis_kosmetik = jenis_kosmetik;
  }

  public void set_tanggalkadaluwarsa(String tanggal_kadaluwarsa) {
    this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
  }

  public void set_beratbersih(int berat_bersih) {
    this.berat_bersih = berat_bersih;
  }

  public String get_jeniskosmetik() {
    return this.jenis_kosmetik;
  }

  public String get_tanggalkadaluwarsa() {
    return this.tanggal_kadaluwarsa;
  }

  public int get_beratbersih() {
    return this.berat_bersih;
  }
}
