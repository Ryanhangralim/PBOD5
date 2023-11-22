import java.time.LocalDate;

import models.Obat;

public class app {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    Obat obat = new Obat();

    obat.set_id("1");
    obat.set_nama("Paracetamol");
    obat.set_merek("Paramex");
    obat.set_produsen("Kalbe");
    obat.set_tanggalproduksi(LocalDate.of(2021, 6, 16));
    obat.set_harga(10000);
    obat.set_stok(100);
    obat.set_jenis("Pil");
    obat.set_tanggalkadaluwarsa(LocalDate.of(2025, 6, 16));
    obat.set_efeksamping("Mual, pusing");
    obat.set_dosis("3x1");

    obat.save();
  }
}