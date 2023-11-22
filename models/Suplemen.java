package models;

public class Suplemen extends Produk {
  private String tanggal_kadaluwarsa;
  private String dosis;
  private String jenis_suplemen;
  private String informasi_nutrisi;

  public void set_tanggalkadaluwarsa(String tanggal_kadaluwarsa) {
    this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
  }

  public String get_tanggalkadaluwarsa() {
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
}
